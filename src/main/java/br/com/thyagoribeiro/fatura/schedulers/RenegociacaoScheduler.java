package br.com.thyagoribeiro.fatura.schedulers;

import br.com.thyagoribeiro.fatura.clients.CartoesClient;
import br.com.thyagoribeiro.fatura.clients.contracts.RenegociacaoRequest;
import br.com.thyagoribeiro.fatura.clients.contracts.RenegociacaoResponse;
import br.com.thyagoribeiro.fatura.domains.Renegociacao;
import br.com.thyagoribeiro.fatura.domains.StatusRenegociacao;
import br.com.thyagoribeiro.fatura.repositories.RenegociacaoRepository;
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
public class RenegociacaoScheduler {

    @Autowired
    private RenegociacaoRepository renegociacaoRepository; // CDD 1 - Classe RenegociacaoRepository

    @Autowired
    private CartoesClient cartoesClient; // CDD 1 - Classe CartoesClient

    @PersistenceContext
    private EntityManager entityManager;

    @Scheduled(fixedDelayString = "${scheduler.notifica.renegociacao}")
    @Transactional
    public void notificaRenegociacao() {

        List<Renegociacao> renegociacaoList = renegociacaoRepository.findByStatusRenegociacaoNull();

        if(renegociacaoList.isEmpty()) // CDD 1 - branch if
            return;

        for(Renegociacao renegociacao : renegociacaoList) { // CDD 1 - branch for

            ResponseEntity<RenegociacaoResponse> response = cartoesClient.notificacaoRenegociacao(renegociacao.getFatura().getCartao().getNumeroCartao(), new RenegociacaoRequest(renegociacao)); // CDD 2 - Classes RenegociacaoResponse e RenegociacaoRequest
            renegociacao.setStatusRenegociacao(StatusRenegociacao.getStatus(response.getStatusCode().is2xxSuccessful())); // CDD 1 - Enum StatusParcelamento
        }

        renegociacaoRepository.saveAll(renegociacaoList);

    }

}
