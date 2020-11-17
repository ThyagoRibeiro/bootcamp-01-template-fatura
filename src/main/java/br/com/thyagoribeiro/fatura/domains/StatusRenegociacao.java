package br.com.thyagoribeiro.fatura.domains;

public enum StatusRenegociacao {

    APROVADO, NEGADO;

    public static StatusRenegociacao getStatus(boolean aprovado) {
        if(aprovado)
            return APROVADO;
        return NEGADO;
    }

}
