package br.com.thyagoribeiro.fatura.repositories;

import br.com.thyagoribeiro.fatura.domains.Fatura;
import org.springframework.data.repository.CrudRepository;

// CDD Total - 1

public interface FaturaRepository extends CrudRepository<Fatura, String> { // CDD 1 - Fatura

    Fatura findByCartaoIdAndAbertaTrue(String cartaoId);

}
