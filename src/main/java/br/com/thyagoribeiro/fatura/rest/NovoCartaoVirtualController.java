package br.com.thyagoribeiro.fatura.rest;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import br.com.thyagoribeiro.fatura.domains.CartaoVirtual;
import br.com.thyagoribeiro.fatura.handler.ErroPadronizado;
import br.com.thyagoribeiro.fatura.rest.contracts.NovoCartaoVirtualRequest;
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
public class NovoCartaoVirtualController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/cartoes/{id_cartao}/cartoes_virtuais")
    @Transactional
    public ResponseEntity<?> novoParcelamento(
            @PathVariable("id_cartao") String cartaoId,
            @RequestBody @Valid NovoCartaoVirtualRequest novoCartaoVirtualRequest, // CDD 1 - Classe NovoCartaoVirtualRequest
            UriComponentsBuilder uriComponentsBuilder) {

        Cartao cartao = entityManager.find(Cartao.class, cartaoId); // CDD 1 - Classe Cartao
        if(cartao == null) // CDD 1 - branch if
            return ResponseEntity.badRequest().body(new ErroPadronizado("Cartão não existe"));

        CartaoVirtual cartaoVirtual = novoCartaoVirtualRequest.toModel(cartao); // CDD 1 - Classe Parcelamento
        cartao.getCartaoVirtualList().add(cartaoVirtual);
        entityManager.persist(cartaoVirtual);

        URI uri = uriComponentsBuilder.path("/api/cartoes/{id_cartao}/cartoes_virtuais/{id_cartao_virtual}").build(cartao.getId(), cartaoVirtual.getId());
        return ResponseEntity.created(uri).build();
    }

}
