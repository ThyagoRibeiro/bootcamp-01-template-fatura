package br.com.thyagoribeiro.fatura.rest;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import br.com.thyagoribeiro.fatura.domains.Fatura;
import br.com.thyagoribeiro.fatura.domains.Parcelamento;
import br.com.thyagoribeiro.fatura.handler.ErroPadronizado;
import br.com.thyagoribeiro.fatura.rest.contracts.NovoParcelamentoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

// CDD Total - 6

@RestController
public class NovoParcelamentoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/cartoes/{id_cartao}/faturas/{id_fatura}/parcelas")
    @Transactional
    public ResponseEntity<?> novoParcelamento(
            @PathVariable("id_cartao") String cartaoId,
            @PathVariable("id_fatura") String faturaId,
            @RequestBody @Valid NovoParcelamentoRequest novoParcelamentoRequest, // CDD 1 - Classe NovoParcelamentoRequest
            UriComponentsBuilder uriComponentsBuilder) {

        Cartao cartao = entityManager.find(Cartao.class, cartaoId); // CDD 1 - Classe Cartao
        if(cartao == null) // CDD 1 - branch if
            return ResponseEntity.badRequest().body(new ErroPadronizado("Cartão não existe"));

        Fatura fatura = entityManager.find(Fatura.class, faturaId); // CDD 1 - Classe Fatura
        if(cartao == null) // CDD 1 - branch if
            return ResponseEntity.badRequest().body(new ErroPadronizado("Não existem faturas para esse cartão"));

        Parcelamento parcelamento = novoParcelamentoRequest.toModel(fatura); // CDD 1 - Classe Parcelamento
        fatura.setParcelamento(parcelamento);
        entityManager.persist(parcelamento);

        URI uri = uriComponentsBuilder.path("/api/cartoes/{id_cartao}/faturas/{id_fatura}/parcelas/{id_parcelamento}").build(cartao.getId(), fatura.getId(), parcelamento.getId());
        return ResponseEntity.created(uri).build();
    }

}
