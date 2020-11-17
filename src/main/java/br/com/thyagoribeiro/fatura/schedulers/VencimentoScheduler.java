package br.com.thyagoribeiro.fatura.schedulers;

import br.com.thyagoribeiro.fatura.clients.CartoesClient;
import br.com.thyagoribeiro.fatura.clients.VencimentoRequest;
import br.com.thyagoribeiro.fatura.clients.VencimentoResponse;
import br.com.thyagoribeiro.fatura.domains.StatusVencimento;
import br.com.thyagoribeiro.fatura.domains.Vencimento;
import br.com.thyagoribeiro.fatura.repositories.VencimentoRepository;
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
public class VencimentoScheduler {

    @Autowired
    private VencimentoRepository vencimentoRepository; // CDD 1 - Classe VencimentoRepository

    @Autowired
    private CartoesClient cartoesClient; // CDD 1 - Classe CartoesClient

    @PersistenceContext
    private EntityManager entityManager;

    @Scheduled(fixedDelayString = "${scheduler.notifica.vencimento}")
    @Transactional
    public void notificaParcelamento() {

        List<Vencimento> vencimentoList = vencimentoRepository.findByStatusSolicitacaoVencimentoNull();

        if(vencimentoList.isEmpty()) // CDD 1 - branch if
            return;

        for(Vencimento vencimento : vencimentoList) { // CDD 1 - branch for

            ResponseEntity<VencimentoResponse> response = cartoesClient.notificacaoVencimento(vencimento.getCartao().getNumeroCartao(), new VencimentoRequest(vencimento)); // CDD 2 - Classes VencimentoResponse e VencimentoRequest
            vencimento.setStatusVencimento(StatusVencimento.getStatus(response.getStatusCode().is2xxSuccessful())); // CDD 1 - Enum StatusVencimento

            if(response.getStatusCode().is2xxSuccessful())
                vencimento.getCartao().setDiaVencimento(vencimento.getDiaVencimento());
        }

        vencimentoRepository.saveAll(vencimentoList);

    }

}
