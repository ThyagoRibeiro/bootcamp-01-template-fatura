package br.com.thyagoribeiro.fatura.clients;

import br.com.thyagoribeiro.fatura.domains.Vencimento;

public class VencimentoRequest {

    private Integer dia;

    public VencimentoRequest(Vencimento vencimento) {
        this.dia = vencimento.getDiaVencimento();
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }
}
