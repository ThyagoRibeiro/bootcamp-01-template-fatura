package br.com.thyagoribeiro.fatura.clients.contracts;

import java.time.LocalDateTime;

public class VencimentoResponse {

    private String id;

    private Long dia;

    private LocalDateTime dataDeCriacao;

    public VencimentoResponse(String id, Long dia, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

}
