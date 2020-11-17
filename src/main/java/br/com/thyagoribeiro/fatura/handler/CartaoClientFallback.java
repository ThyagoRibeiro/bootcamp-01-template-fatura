package br.com.thyagoribeiro.fatura.handler;

import br.com.thyagoribeiro.fatura.clients.CartoesClient;
import br.com.thyagoribeiro.fatura.clients.contracts.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

// CDD Total - 5

@Component
public class CartaoClientFallback implements FallbackFactory<CartoesClient> { // CDD 1 - Interface CartoesClient

    @Override
    public CartoesClient create(Throwable cause) {
        return new CartoesClient() {

            @Override
            public ResponseEntity<BuscaCartaoResponse> buscarCartao(String numeroCartao) { // CDD 1 - Classe BuscaCartaoResponse
                return retornaHttpStatus(BuscaCartaoResponse.class);
            }

            @Override
            public ResponseEntity<ParcelamentoResponse> parcelamentoCartao(String numeroCartao, ParcelamentoRequest parcelamentoRequest) {
                return retornaHttpStatus(ParcelamentoResponse.class);
            }

            @Override
            public ResponseEntity<RenegociacaoResponse> renegociacaoCartao(String numeroCartao, RenegociacaoRequest renegociacaoRequest) {
                return retornaHttpStatus(RenegociacaoResponse.class);
            }

            private ResponseEntity retornaHttpStatus(Class clazz) {
                if(cause instanceof FeignException) { // CDD 1 - branch if

                    FeignException feignException = (FeignException) cause;

                    if(HttpStatus.valueOf(feignException.status()).is4xxClientError() // CDD 1 - branch if
                            || HttpStatus.valueOf(feignException.status()).is5xxServerError()) {

                        ObjectMapper objectMapper = new ObjectMapper();
                        try { // CDD 1 - branch try
                            return ResponseEntity.unprocessableEntity().body(objectMapper.readValue(feignException.contentUTF8(), clazz));
                        } catch (JsonProcessingException e) {
                            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                        }

                    }
                }

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

        };
    }

}
