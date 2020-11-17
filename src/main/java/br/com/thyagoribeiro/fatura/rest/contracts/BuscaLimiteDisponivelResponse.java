package br.com.thyagoribeiro.fatura.rest.contracts;

import br.com.thyagoribeiro.fatura.domains.Transacao;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// CDD Total - 4

public class BuscaLimiteDisponivelResponse {

    @JsonProperty("limite_disponivel")
    private BigDecimal limiteDisponivel;

    @JsonProperty("transacoes")
    private List<TransacaoResponse> transacaoResponseList; // CDD 1 - Classe TransacaoResponse

    public BuscaLimiteDisponivelResponse(BigDecimal limiteDisponivel, List<Transacao> transacaoList) { // CDD 1 - Classe Transacao
        this.limiteDisponivel = limiteDisponivel;
        this.transacaoResponseList = new ArrayList<>();
        transacaoList.sort((left, right) -> right.getEfetivadaEm().compareTo(left.getEfetivadaEm())); // CDD 1 - funcao de ordem superior
        transacaoList.stream().limit(10).collect(Collectors.toList()).forEach(transacao -> this.transacaoResponseList.add(new TransacaoResponse(transacao))); // CDD 1 - funcao de ordem superior
    }

    public BigDecimal getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteDisponivel(BigDecimal limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    public List<TransacaoResponse> getTransacaoResponseList() {
        return transacaoResponseList;
    }

    public void setTransacaoResponseList(List<TransacaoResponse> transacaoResponseList) {
        this.transacaoResponseList = transacaoResponseList;
    }
}
