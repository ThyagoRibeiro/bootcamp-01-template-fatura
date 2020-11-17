package br.com.thyagoribeiro.fatura.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Vencimento {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private Integer diaVencimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao;

    @Enumerated(EnumType.STRING)
    private StatusVencimento statusSolicitacaoVencimento;

    @Deprecated
    public Vencimento() {
    }

    public Vencimento(Integer diaVencimento, Cartao cartao) {
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

    public StatusVencimento getStatusSolicitacaoVencimento() {
        return statusSolicitacaoVencimento;
    }

    public void setStatusVencimento(StatusVencimento statusSolicitacaoVencimento) {
        this.statusSolicitacaoVencimento = statusSolicitacaoVencimento;
    }
}
