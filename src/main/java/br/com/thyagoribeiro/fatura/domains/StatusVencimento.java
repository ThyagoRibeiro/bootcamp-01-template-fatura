package br.com.thyagoribeiro.fatura.domains;

public enum StatusVencimento {

    APROVADO, NEGADO;

    public static StatusVencimento getStatus(boolean aprovado) {
        if(aprovado)
            return APROVADO;
        return NEGADO;
    }

}
