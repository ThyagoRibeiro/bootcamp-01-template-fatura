package br.com.thyagoribeiro.fatura.clients.contracts;

import br.com.thyagoribeiro.fatura.domains.Parcelamento;
import br.com.thyagoribeiro.fatura.domains.Renegociacao;

import java.math.BigDecimal;

public class RenegociacaoRequest {

    private String identificadorDaFatura;
    private Integer quantidade;
    private BigDecimal valor;

    public RenegociacaoRequest(Renegociacao renegociacao) {
        this.identificadorDaFatura = renegociacao.getId();
        this.quantidade = renegociacao.getQuantidadeParcelas();
        this.valor = renegociacao.getValor();
    }

    public String getIdentificadorDaFatura() {
        return identificadorDaFatura;
    }

    public void setIdentificadorDaFatura(String identificadorDaFatura) {
        this.identificadorDaFatura = identificadorDaFatura;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
