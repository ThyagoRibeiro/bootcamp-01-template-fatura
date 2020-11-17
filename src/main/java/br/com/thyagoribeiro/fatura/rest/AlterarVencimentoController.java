package br.com.thyagoribeiro.fatura.rest;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import br.com.thyagoribeiro.fatura.domains.Vencimento;
import br.com.thyagoribeiro.fatura.handler.ErroPadronizado;
import br.com.thyagoribeiro.fatura.rest.contracts.AlterarVencimentoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

// CDD Total - 6

@RestController
public class AlterarVencimentoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PatchMapping("/api/cartoes/{id_cartao}/vencimentos")
    @Transactional
    public ResponseEntity<?> novaRenegociacao(
            @PathVariable("id_cartao") String cartaoId,
            @RequestBody @Valid AlterarVencimentoRequest alterarVencimentoRequest, // CDD 1 - Classe NovoParcelamentoRequestC
            UriComponentsBuilder uriComponentsBuilder) {

        Cartao cartao = entityManager.find(Cartao.class, cartaoId); // CDD 1 - Classe Cartao
        if(cartao == null) // CDD 1 - branch if
            return ResponseEntity.badRequest().body(new ErroPadronizado("Cartão não existe"));

        Vencimento solicitacaoVencimento = alterarVencimentoRequest.toModel(cartao); // CDD 1 - Classe Parcelamento
        cartao.getSolicitacaoVencimentoList().add(solicitacaoVencimento);
        entityManager.persist(solicitacaoVencimento);

        return ResponseEntity.ok().build();
    }

}
