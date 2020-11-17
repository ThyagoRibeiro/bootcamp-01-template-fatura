package br.com.thyagoribeiro.fatura.rest.contracts;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import com.fasterxml.jackson.annotation.JsonProperty;

// CDD Total - 1

public class CartaoResponse {

    private String id;

    private String email;

    @JsonProperty("dia_vencimento")
    private int diaVencimento;

    @Deprecated
    public CartaoResponse() {
    }

    public CartaoResponse(Cartao cartao) { // CDD 1 - Classe Cartao
        this.id = cartao.getId();
        this.email = cartao.getEmail();
        this.diaVencimento = cartao.getDiaVencimento();
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

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }
}
