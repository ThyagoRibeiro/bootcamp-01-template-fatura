package br.com.thyagoribeiro.fatura.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// CDD Total - 3

@Entity
public class Fatura {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private LocalDate dataVencimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao; // CDD 1 - Classe Cartao

    @OneToMany(mappedBy = "fatura")
    private List<Transacao> transacaoList; // CDD 1 - Classe Transacao

    @OneToOne(mappedBy = "fatura")
    private Parcelamento parcelamento;

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

    public Parcelamento getParcelamento() {
        return parcelamento;
    }

    public void setParcelamento(Parcelamento parcelamento) {
        this.parcelamento = parcelamento;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public BigDecimal calculaLimiteDisponivel(BigDecimal limite) {

        BigDecimal limiteDisponivel = limite;
        for(Transacao transacao : transacaoList) { // CDD 1 - branch for
            limiteDisponivel = limiteDisponivel.subtract(transacao.getValor());
        }

        return limiteDisponivel;
    }
}
