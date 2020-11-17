package br.com.thyagoribeiro.fatura.clients.contracts;

import java.time.LocalDateTime;

public class BloqueioCartaoResponse {

    private String id;

    private LocalDateTime bloqueadoEm;

    private String sistemaResponsavel;

    private boolean ativo;

    public BloqueioCartaoResponse(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }

}
