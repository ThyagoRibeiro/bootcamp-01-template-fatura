package br.com.thyagoribeiro.fatura.schedulers;

import br.com.thyagoribeiro.fatura.clients.CartoesClient;
import br.com.thyagoribeiro.fatura.clients.contracts.ParcelamentoRequest;
import br.com.thyagoribeiro.fatura.clients.contracts.ParcelamentoResponse;
import br.com.thyagoribeiro.fatura.domains.Parcelamento;
import br.com.thyagoribeiro.fatura.domains.StatusParcelamento;
import br.com.thyagoribeiro.fatura.repositories.ParcelamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

// CDD Total - 7

@Component
public class ParcelamentoScheduler {

    @Autowired
    private ParcelamentoRepository parcelamentoRepository; // CDD 1 - Classe BloqueioRepository

    @Autowired
    private CartoesClient cartoesClient; // CDD 1 - Classe CartoesClient

    @PersistenceContext
    private EntityManager entityManager;

    @Scheduled(fixedDelayString = "${scheduler.notifica.parcelamento}")
    @Transactional
    public void notificaParcelamento() {

        List<Parcelamento> parcelamentoList = parcelamentoRepository.findByStatusParcelamentoNull();

        if(parcelamentoList.isEmpty()) // CDD 1 - branch if
            return;

        for(Parcelamento parcelamento : parcelamentoList) { // CDD 1 - branch for

            ResponseEntity<ParcelamentoResponse> response = cartoesClient.parcelamentoCartao(parcelamento.getFatura().getCartao().getNumeroCartao(), new ParcelamentoRequest(parcelamento)); // CDD 2 - Classes ParcelamentoResponse e ParcelamentoRequest
            parcelamento.setStatusParcelamento(StatusParcelamento.getStatus(response.getStatusCode().is2xxSuccessful())); // CDD 1 - Enum StatusParcelamento
        }

        parcelamentoRepository.saveAll(parcelamentoList);

    }

}
