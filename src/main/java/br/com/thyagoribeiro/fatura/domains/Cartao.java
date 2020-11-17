package br.com.thyagoribeiro.fatura.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

// CDD Total - 1

@Entity
public class Cartao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String numeroCartao;

    private String email;

    private int diaVencimento;

    @OneToMany(mappedBy = "cartao")
    private List<Fatura> faturaList; // CDD 1 - Classe Fatura

    @OneToMany(mappedBy = "cartao")
    private List<Vencimento> solicitacaoVencimentoList = new ArrayList<>(); // CDD 1 - Classe Vencimento

    @OneToMany(mappedBy = "cartao")
    private List<CartaoVirtual> cartaoVirtualList = new ArrayList<>(); // CDD 1 - Classe CartaoVirtual

    @Deprecated
    public Cartao() {
    }

    public Cartao(String numeroCartao, String email, int diaVencimento) {
        this.numeroCartao = numeroCartao;
        this.email = email;
        this.diaVencimento = diaVencimento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Fatura> getFaturaList() {
        return faturaList;
    }

    public void setFaturaList(List<Fatura> faturaList) {
        this.faturaList = faturaList;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public List<Vencimento> getSolicitacaoVencimentoList() {
        return solicitacaoVencimentoList;
    }

    public void setSolicitacaoVencimentoList(List<Vencimento> solicitacaoVencimentoList) {
        this.solicitacaoVencimentoList = solicitacaoVencimentoList;
    }

    public List<CartaoVirtual> getCartaoVirtualList() {
        return cartaoVirtualList;
    }

    public void setCartaoVirtualList(List<CartaoVirtual> cartaoVirtualList) {
        this.cartaoVirtualList = cartaoVirtualList;
    }
    
}
