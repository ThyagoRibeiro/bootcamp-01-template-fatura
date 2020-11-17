package br.com.thyagoribeiro.fatura.rest.contracts;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import br.com.thyagoribeiro.fatura.domains.SolicitacaoVencimento;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AlterarVencimentoRequest {

    @NotNull
    @Min(1)
    @Max(31)
    @JsonProperty("dia_vencimento")
    private Integer diaVencimento;

    @Deprecated
    public AlterarVencimentoRequest() {
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public SolicitacaoVencimento toModel(Cartao cartao) {
        return new SolicitacaoVencimento(diaVencimento,cartao);
    }
}
