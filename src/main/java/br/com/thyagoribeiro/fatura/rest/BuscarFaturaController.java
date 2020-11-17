package br.com.thyagoribeiro.fatura.rest;

import br.com.thyagoribeiro.fatura.domains.Fatura;
import br.com.thyagoribeiro.fatura.handler.ErroPadronizado;
import br.com.thyagoribeiro.fatura.repositories.FaturaRepository;
import br.com.thyagoribeiro.fatura.rest.contracts.BuscaFaturaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;
import java.time.LocalDate;

@RestController
@Validated
public class BuscarFaturaController {

    @Autowired
    private FaturaRepository faturaRepository;

    @GetMapping("/api/cartoes/{id_cartao}/fatura")
    public ResponseEntity<?> buscaFatura(@RequestParam(value = "mes", required = true) @NotNull @Min(1) @Max(12) Integer mes,
                                         @RequestParam(value = "ano", required = true) @NotNull @Min(1000) @Max(9999) Integer ano) {

        LocalDate dataVencimentoMin = LocalDate.of(ano, mes, 1);
        LocalDate dataVencimentoMax = LocalDate.of(ano, mes, 1).plusMonths(1).minusDays(1);

        Fatura fatura = faturaRepository.findByDataVencimentoGreaterThanAndDataVencimentoLessThan(dataVencimentoMin, dataVencimentoMax); // CDD 1 - Classe Fatura
        if(fatura == null) // CDD 1 - branch if
            return ResponseEntity.badRequest().body(new ErroPadronizado("Não existem faturas para esse cartão"));

        BuscaFaturaResponse buscaFaturaResponse = new BuscaFaturaResponse(fatura); // CDD 1 - Classe BuscaFaturaResponse
        return ResponseEntity.ok(buscaFaturaResponse);
    }

}
