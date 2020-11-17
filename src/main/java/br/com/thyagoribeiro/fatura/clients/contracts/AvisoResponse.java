package br.com.thyagoribeiro.fatura.clients.contracts;

import java.time.LocalDate;

// CDD Total - 0

public class AvisoResponse {

    private LocalDate validoAte;

    private String destino;

    public AvisoResponse(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

}
