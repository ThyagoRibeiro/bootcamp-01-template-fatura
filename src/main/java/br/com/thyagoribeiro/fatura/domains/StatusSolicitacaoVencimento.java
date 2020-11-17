package br.com.thyagoribeiro.fatura.domains;

public enum StatusSolicitacaoVencimento {

    APROVADO, NEGADO;

    public static StatusSolicitacaoVencimento getStatus(boolean aprovado) {
        if(aprovado)
            return APROVADO;
        return NEGADO;
    }

}
