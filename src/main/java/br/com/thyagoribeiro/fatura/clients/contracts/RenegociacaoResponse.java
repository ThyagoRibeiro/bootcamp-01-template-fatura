package br.com.thyagoribeiro.fatura.clients.contracts;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RenegociacaoResponse {

    private String id;

    private Long quantidade;

    private BigDecimal valor;

    private LocalDateTime dataDeCriacao;

    public RenegociacaoResponse(String id, Long quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }

}
