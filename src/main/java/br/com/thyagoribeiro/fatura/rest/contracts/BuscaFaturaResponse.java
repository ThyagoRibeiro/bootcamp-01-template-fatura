package br.com.thyagoribeiro.fatura.rest.contracts;

import br.com.thyagoribeiro.fatura.domains.Fatura;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BuscaFaturaResponse {

    private String id;

    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;

    @JsonProperty("cartao")
    private CartaoResponse cartaoResponse;

    @JsonProperty("transacoes")
    private List<TransacaoResponse> transacaoList;

    @Deprecated
    public BuscaFaturaResponse() {
    }

    public BuscaFaturaResponse(Fatura fatura) {
        this.id = fatura.getId();
        this.dataVencimento = fatura.getDataVencimento();
        this.cartaoResponse = new CartaoResponse(fatura.getCartao());

        this.transacaoList = new ArrayList<>();
        fatura.getTransacaoList().forEach(transacao -> this.transacaoList.add(new TransacaoResponse(transacao)));
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
