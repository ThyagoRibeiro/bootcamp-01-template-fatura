package br.com.thyagoribeiro.fatura.repositories;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import org.springframework.data.repository.CrudRepository;

// CDD Total - 1

public interface CartaoRepository extends CrudRepository<Cartao, String> { // CDD 1 - Cartao

    Cartao findByNumeroCartao(String numeroCartao);

}
