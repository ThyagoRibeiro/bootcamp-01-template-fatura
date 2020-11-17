package br.com.thyagoribeiro.fatura.clients;

import br.com.thyagoribeiro.fatura.clients.contracts.BuscaCartaoResponse;
import br.com.thyagoribeiro.fatura.clients.contracts.ParcelamentoRequest;
import br.com.thyagoribeiro.fatura.clients.contracts.ParcelamentoResponse;
import br.com.thyagoribeiro.fatura.handler.CartaoClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// CDD Total - 2

@FeignClient(name = "cartoes", url = "${cartao.domain}", fallbackFactory = CartaoClientFallback.class) // CDD 1 - Classe CartaoClientFallback
public interface CartoesClient {

    @GetMapping(value = "/api/cartoes/{id}")
    public ResponseEntity<BuscaCartaoResponse> buscarCartao(@PathVariable("id") String numeroCartao); // CDD 1 - Classe BuscaCartaoResponse

    @PostMapping(value = "/api/cartoes/{id}/parcelas")
    public ResponseEntity<ParcelamentoResponse> parcelamentoCartao(@PathVariable("id") String numeroCartao, // CDD 1 - Classes ParcelamentoResponse
                                                                   @RequestBody ParcelamentoRequest parcelamentoRequest); // CDD 1 - Classes ParcelamentoRequest

}
