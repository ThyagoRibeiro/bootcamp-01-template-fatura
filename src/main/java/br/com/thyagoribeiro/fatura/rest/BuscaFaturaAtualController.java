package br.com.thyagoribeiro.fatura.rest;

import br.com.thyagoribeiro.fatura.domains.Fatura;
import br.com.thyagoribeiro.fatura.handler.ErroPadronizado;
import br.com.thyagoribeiro.fatura.repositories.FaturaRepository;
import br.com.thyagoribeiro.fatura.rest.contracts.BuscaFaturaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// CDD Total - 3

@RestController
public class BuscaFaturaAtualController {

    @Autowired
    private FaturaRepository faturaRepository;

    @GetMapping("/api/cartoes/{id_cartao}/fatura_atual")
    public ResponseEntity<?> buscaFatura(@PathVariable("id_cartao") String cartaoId) {

        Fatura fatura = faturaRepository.findByCartaoIdAndAbertaTrue(cartaoId); // CDD 1 - Classe Fatura
        if(fatura == null) // CDD 1 - branch if
            return ResponseEntity.badRequest().body(new ErroPadronizado("Não existem faturas para esse cartão"));

        BuscaFaturaResponse buscaFaturaResponse = new BuscaFaturaResponse(fatura); // CDD 1 - Classe BuscaFaturaResponse
        return ResponseEntity.ok().body(buscaFaturaResponse);
    }

}
