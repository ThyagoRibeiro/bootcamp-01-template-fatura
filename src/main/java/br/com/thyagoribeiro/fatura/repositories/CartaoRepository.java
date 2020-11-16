package br.com.thyagoribeiro.fatura.repositories;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, String> {

    Cartao findByNumeroCartao(String numeroCartao);

}
