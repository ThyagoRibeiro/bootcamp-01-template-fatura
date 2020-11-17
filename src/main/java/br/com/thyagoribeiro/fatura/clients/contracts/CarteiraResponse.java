package br.com.thyagoribeiro.fatura.clients.contracts;

import java.time.LocalDateTime;

public class CarteiraResponse {

    private String id;

    private String email;

    private LocalDateTime associadaEm;

    private String emissor;

    public CarteiraResponse(String id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
    }

}
