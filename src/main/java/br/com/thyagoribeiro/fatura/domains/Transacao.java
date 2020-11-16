package br.com.thyagoribeiro.fatura.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

// CDD Total - 1

@Entity
public class Transacao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String idLegado;

    private String valor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Fatura fatura; // CDD 1 - Classe Fatura

    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String idLegado, String valor, Fatura fatura, LocalDateTime efetivadaEm) {
        this.idLegado = idLegado;
        this.valor = valor;
        this.fatura = fatura;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdLegado() {
        return idLegado;
    }

    public void setIdLegado(String idLegado) {
        this.idLegado = idLegado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }
}
