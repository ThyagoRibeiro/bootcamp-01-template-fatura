package br.com.thyagoribeiro.fatura.rest.contracts;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import br.com.thyagoribeiro.fatura.domains.CartaoVirtual;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class NovoCartaoVirtualRequest {

    @NotNull
    private BigDecimal limite;

    @Deprecated
    public NovoCartaoVirtualRequest() {
    }

    public NovoCartaoVirtualRequest(BigDecimal limite) {
        this.limite = limite;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public CartaoVirtual toModel(Cartao cartao) {
        return new CartaoVirtual(limite, cartao);
    }
}
