package br.com.thyagoribeiro.fatura.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class SolicitacaoVencimento {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private Integer diaVencimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao;

    @Enumerated(EnumType.STRING)
    private StatusSolicitacaoVencimento statusSolicitacaoVencimento;

    @Deprecated
    public SolicitacaoVencimento() {
    }

    public SolicitacaoVencimento(Integer diaVencimento, Cartao cartao) {
        this.diaVencimento = diaVencimento;
        this.cartao = cartao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public StatusSolicitacaoVencimento getStatusSolicitacaoVencimento() {
        return statusSolicitacaoVencimento;
    }

    public void setStatusSolicitacaoVencimento(StatusSolicitacaoVencimento statusSolicitacaoVencimento) {
        this.statusSolicitacaoVencimento = statusSolicitacaoVencimento;
    }
}
