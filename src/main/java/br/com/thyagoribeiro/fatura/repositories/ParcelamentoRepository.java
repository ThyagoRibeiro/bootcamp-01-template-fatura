package br.com.thyagoribeiro.fatura.repositories;

import br.com.thyagoribeiro.fatura.domains.Parcelamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParcelamentoRepository extends CrudRepository<Parcelamento, String> {

    List<Parcelamento> findByStatusParcelamentoNull();

}
