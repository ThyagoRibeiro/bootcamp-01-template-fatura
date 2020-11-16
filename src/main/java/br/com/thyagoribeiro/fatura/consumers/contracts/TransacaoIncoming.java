package br.com.thyagoribeiro.fatura.consumers.contracts;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import br.com.thyagoribeiro.fatura.domains.Fatura;
import br.com.thyagoribeiro.fatura.domains.Transacao;
import br.com.thyagoribeiro.fatura.repositories.CartaoRepository;
import br.com.thyagoribeiro.fatura.repositories.FaturaRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

// CDD Total - 6

public class TransacaoIncoming {

    private String id;

    private String valor;

    @JsonProperty("cartao")
    private CartaoIncoming cartaoIncoming; // CDD 1 - Classe CartaoIncoming

    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoIncoming() {
    }

    public TransacaoIncoming(String id, String valor, CartaoIncoming cartaoIncoming, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.cartaoIncoming = cartaoIncoming;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public CartaoIncoming getCartaoIncoming() {
        return cartaoIncoming;
    }

    public void setCartaoIncoming(CartaoIncoming cartaoIncoming) {
        this.cartaoIncoming = cartaoIncoming;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toModel(CartaoRepository cartaoRepository, FaturaRepository faturaRepository) { // CDD 2 - Interfaces FaturaRepository, CartaoRepository

        Cartao cartao = cartaoIncoming.toModel(cartaoRepository); // CDD 1 - Classe Cartao
        Fatura fatura = faturaRepository.findByCartaoIdAndAbertaTrue(cartao.getId()); // CDD 1 - Classe Fatura
        if(fatura == null) { // CDD 1 - branch if

            fatura = new Fatura(LocalDate.now().withDayOfMonth(cartao.getDiaVencimento()),
                                cartao,
                                Collections.emptyList(),
                                true);

        }
        return new Transacao(id, valor, fatura, efetivadaEm);
    }
}
