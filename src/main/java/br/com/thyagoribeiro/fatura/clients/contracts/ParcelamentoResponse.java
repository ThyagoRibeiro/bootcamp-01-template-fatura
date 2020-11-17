package br.com.thyagoribeiro.fatura.clients.contracts;

public class ParcelamentoResponse {

    private String resultado;

    @Deprecated
    public ParcelamentoResponse() {
    }

    public ParcelamentoResponse(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
