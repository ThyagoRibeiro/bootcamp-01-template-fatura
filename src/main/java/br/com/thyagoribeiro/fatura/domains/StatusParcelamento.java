package br.com.thyagoribeiro.fatura.domains;

public enum StatusParcelamento {

    APROVADO, NEGADO;

    public static StatusParcelamento getStatus(boolean aprovado) {
        if(aprovado)
            return APROVADO;
        return NEGADO;
    }

}
