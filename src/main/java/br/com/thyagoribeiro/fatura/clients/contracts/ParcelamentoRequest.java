package br.com.thyagoribeiro.fatura.clients.contracts;

import br.com.thyagoribeiro.fatura.domains.Parcelamento;

import java.math.BigDecimal;

public class ParcelamentoRequest {

    private String identificadorDaFatura;
    private Integer quantidade;
    private BigDecimal valor;

    public ParcelamentoRequest(Parcelamento parcelamento) {
        this.identificadorDaFatura = parcelamento.getFatura().getId();
        this.quantidade = parcelamento.getQuantidadeParcelas();
        this.valor = parcelamento.getValor();
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
