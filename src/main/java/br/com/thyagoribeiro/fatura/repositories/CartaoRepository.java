package br.com.thyagoribeiro.fatura.repositories;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import br.com.thyagoribeiro.fatura.domains.Transacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartaoRepository extends CrudRepository<Cartao, String> {

    Cartao findByNumeroCartao(String numeroCartao);

}
