package br.com.thyagoribeiro.fatura.repositories;

import br.com.thyagoribeiro.fatura.domains.Parcelamento;
import br.com.thyagoribeiro.fatura.domains.Renegociacao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RenegociacaoRepository extends CrudRepository<Renegociacao, String> {

    List<Renegociacao> findByStatusRenegociacaoNull();

}
