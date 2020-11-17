package br.com.thyagoribeiro.fatura.clients.contracts;

public class RenegociacaoResponse {

    private String resultado;

    @Deprecated
    public RenegociacaoResponse() {
    }

    public RenegociacaoResponse(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
