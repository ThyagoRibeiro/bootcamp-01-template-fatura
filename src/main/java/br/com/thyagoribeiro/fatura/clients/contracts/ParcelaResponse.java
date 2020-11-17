package br.com.thyagoribeiro.fatura.clients.contracts;

import java.math.BigDecimal;

public class ParcelaResponse {

    private String id;

    private Long quantidade;

    private BigDecimal valor;

    public ParcelaResponse(String id, Long quantidade, BigDecimal valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

}
