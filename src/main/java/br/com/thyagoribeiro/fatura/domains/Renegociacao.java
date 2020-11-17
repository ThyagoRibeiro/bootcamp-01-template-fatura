package br.com.thyagoribeiro.fatura.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Renegociacao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Fatura fatura;

    private Integer quantidadeParcelas;

    private BigDecimal valor;

    private LocalDate inicioPagamento;

    @Enumerated(EnumType.STRING)
    private StatusRenegociacao statusRenegociacao;

    @Deprecated
    public Renegociacao() {
    }

    public Renegociacao(Fatura fatura, Integer quantidadeParcelas, BigDecimal valor, LocalDate inicioPagamento) {
        this.fatura = fatura;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valor = valor;
        this.inicioPagamento = inicioPagamento;
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

    public LocalDate getInicioPagamento() {
        return inicioPagamento;
    }

    public void setInicioPagamento(LocalDate inicioPagamento) {
        this.inicioPagamento = inicioPagamento;
    }

    public StatusRenegociacao getStatusRenegociacao() {
        return statusRenegociacao;
    }

    public void setStatusRenegociacao(StatusRenegociacao statusRenegociacao) {
        this.statusRenegociacao = statusRenegociacao;
    }
}
