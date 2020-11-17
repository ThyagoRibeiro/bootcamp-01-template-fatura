package br.com.thyagoribeiro.fatura.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CartaoVirtual {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private BigDecimal limite;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao;

    @Deprecated
    public CartaoVirtual() {
    }

    public CartaoVirtual(BigDecimal limite, Cartao cartao) {
        this.limite = limite;
        this.cartao = cartao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
