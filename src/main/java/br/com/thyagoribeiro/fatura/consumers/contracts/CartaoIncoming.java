package br.com.thyagoribeiro.fatura.consumers.contracts;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import br.com.thyagoribeiro.fatura.repositories.CartaoRepository;

// CDD Total - 2

public class CartaoIncoming {

    private String id;

    private String email;

    @Deprecated
    public CartaoIncoming() {
    }

    public CartaoIncoming(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao toModel(CartaoRepository cartaoRepository) { // CDD 1 - Classe Cartao

        Cartao cartao = cartaoRepository.findByNumeroCartao(id);
        if(cartao == null) // CDD - branch if
            cartao = new Cartao(id, email, 28);

        return cartao;
    }

}
