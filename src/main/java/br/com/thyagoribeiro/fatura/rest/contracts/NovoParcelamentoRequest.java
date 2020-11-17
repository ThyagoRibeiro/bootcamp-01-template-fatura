package br.com.thyagoribeiro.fatura.rest.contracts;

import br.com.thyagoribeiro.fatura.domains.Fatura;
import br.com.thyagoribeiro.fatura.domains.Parcelamento;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovoParcelamentoRequest {

    @NotNull
    @Positive
    @JsonProperty("quantidade_parcelas")
    private Integer quantidadeParcelas;

    @NotNull
    @Positive
    private BigDecimal valor;

    @Deprecated
    public NovoParcelamentoRequest() {
    }

    public NovoParcelamentoRequest(@NotNull @Positive Integer quantidadeParcelas, @NotNull @Positive BigDecimal valor) {
        this.quantidadeParcelas = quantidadeParcelas;
        this.valor = valor;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Parcelamento toModel(Fatura fatura) {
        return new Parcelamento(quantidadeParcelas, valor);
    }

}
