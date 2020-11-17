package br.com.thyagoribeiro.fatura.rest;

import br.com.thyagoribeiro.fatura.clients.CartoesClient;
import br.com.thyagoribeiro.fatura.clients.contracts.BuscaCartaoResponse;
import br.com.thyagoribeiro.fatura.domains.Fatura;
import br.com.thyagoribeiro.fatura.handler.ErroPadronizado;
import br.com.thyagoribeiro.fatura.repositories.FaturaRepository;
import br.com.thyagoribeiro.fatura.rest.contracts.BuscaLimiteDisponivelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

// CDD Total - 4

@RestController
public class BuscaLimiteDisponivelController {

    @Autowired
    private FaturaRepository faturaRepository;

    @Autowired
    private CartoesClient cartoesClient;

    @GetMapping("/api/cartoes/{id_cartao}/limite_disponivel")
    public ResponseEntity<?> buscaLimiteDisponível(@PathVariable("id_cartao") String cartaoId) {

        Fatura fatura = faturaRepository.findByCartaoIdAndAbertaTrue(cartaoId); // CDD 1 - Classe Fatura
        if(fatura == null) // CDD 1 - branch if
            return ResponseEntity.badRequest().body(new ErroPadronizado("Não existem faturas para esse cartão"));

        ResponseEntity<BuscaCartaoResponse> response = cartoesClient.buscarCartao(fatura.getCartao().getNumeroCartao()); // CDD 1 - Classe BuscaCartaoResponse

        BigDecimal limiteDisponivel = fatura.calculaLimiteDisponivel(response.getBody().getLimite());
        BuscaLimiteDisponivelResponse buscaLimiteDisponivelResponse = new BuscaLimiteDisponivelResponse(limiteDisponivel, fatura.getTransacaoList()); // CDD 1 - Classe BuscaLimiteDisponivelResponse
        
        return ResponseEntity.ok().body(buscaLimiteDisponivelResponse);
    }

}
