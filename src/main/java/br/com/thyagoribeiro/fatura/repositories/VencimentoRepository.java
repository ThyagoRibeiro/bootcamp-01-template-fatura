package br.com.thyagoribeiro.fatura.repositories;

import br.com.thyagoribeiro.fatura.domains.Parcelamento;
import br.com.thyagoribeiro.fatura.domains.Vencimento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VencimentoRepository extends CrudRepository<Vencimento, String> {

    List<Vencimento> findByStatusSolicitacaoVencimentoNull();

}
