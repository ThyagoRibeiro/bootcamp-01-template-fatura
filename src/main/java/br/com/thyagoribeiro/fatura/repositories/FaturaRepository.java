package br.com.thyagoribeiro.fatura.repositories;

import br.com.thyagoribeiro.fatura.domains.Fatura;
import org.springframework.data.repository.CrudRepository;

public interface FaturaRepository extends CrudRepository<Fatura, String> {

    Fatura findByCartaoIdAndAbertaTrue(String cartaoId);

}
