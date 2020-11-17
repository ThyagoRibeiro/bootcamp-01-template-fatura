package br.com.thyagoribeiro.fatura.rest.contracts;

import br.com.thyagoribeiro.fatura.domains.Fatura;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// CDD Total - 4

public class BuscaFaturaResponse {

    private String id;

    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;

    @JsonProperty("cartao")
    private CartaoResponse cartaoResponse; // CDD 1 - Classe CartaoResponse

    @JsonProperty("transacoes")
    private List<TransacaoResponse> transacaoList; // CDD 1 - Classe TransacaoResponse

    @Deprecated
    public BuscaFaturaResponse() {
    }

    public BuscaFaturaResponse(Fatura fatura) { // CDD 1 - Classe Fatura
        this.id = fatura.getId();
        this.dataVencimento = fatura.getDataVencimento();
        this.cartaoResponse = new CartaoResponse(fatura.getCartao());

        this.transacaoList = new ArrayList<>();
        fatura.getTransacaoList().forEach(transacao -> this.transacaoList.add(new TransacaoResponse(transacao))); // CDD 1 - Funcao de ordem superior
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public CartaoResponse getCartaoResponse() {
        return cartaoResponse;
    }

    public void setCartaoResponse(CartaoResponse cartaoResponse) {
        this.cartaoResponse = cartaoResponse;
    }

    public List<TransacaoResponse> getTransacaoList() {
        return transacaoList;
    }

    public void setTransacaoList(List<TransacaoResponse> transacaoList) {
        this.transacaoList = transacaoList;
    }
}
