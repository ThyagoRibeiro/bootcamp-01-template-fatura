package br.com.thyagoribeiro.fatura.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Parcelamento {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Fatura fatura;

    private Integer quantidadeParcelas;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusParcelamento statusParcelamento;

    @Deprecated
    public Parcelamento() {
    }

    public Parcelamento(Fatura fatura, Integer quantidadeParcelas, BigDecimal valor) {
        this.fatura = fatura;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusParcelamento getStatusParcelamento() {
        return statusParcelamento;
    }

    public void setStatusParcelamento(StatusParcelamento statusParcelamento) {
        this.statusParcelamento = statusParcelamento;
    }
}
