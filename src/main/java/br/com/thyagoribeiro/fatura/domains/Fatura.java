package br.com.thyagoribeiro.fatura.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Fatura {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private LocalDate dataVencimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao;

    @OneToMany(mappedBy = "fatura")
    private List<Transacao> transacaoList;

    private boolean aberta;

    @Deprecated
    public Fatura() {
    }

    public Fatura(LocalDate dataVencimento, Cartao cartao, List<Transacao> transacaoList, boolean aberta) {
        this.dataVencimento = dataVencimento;
        this.cartao = cartao;
        this.transacaoList = transacaoList;
        this.aberta = aberta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public List<Transacao> getTransacaoList() {
        return transacaoList;
    }

    public void setTransacaoList(List<Transacao> transacaoList) {
        this.transacaoList = transacaoList;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }
}
