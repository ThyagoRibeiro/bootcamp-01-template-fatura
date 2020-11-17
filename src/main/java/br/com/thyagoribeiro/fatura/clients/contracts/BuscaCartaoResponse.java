package br.com.thyagoribeiro.fatura.clients.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// CDD Total - 6

public class BuscaCartaoResponse {

    private String id;

    @JsonProperty("emitidoEm")
    private LocalDateTime dataEmissao;

    private String titular;

    @JsonProperty("bloqueios")
    private List<BloqueioCartaoResponse> bloqueioResponseList; // CDD 1 - Classe BloqueioCartaoResponse

    @JsonProperty("avisos")
    private List<AvisoCartaoResponse> avisoResponseList; // CDD 1 - Classe AvisoCartaoResponse

    @JsonProperty("carteiras")
    private List<CarteiraCartaoResponse> carteiraResponseList; // CDD 1 - Classe CarteiraCartaoResponse

    @JsonProperty("parcelas")
    private List<ParcelaResponse> parcelaResponseList; // CDD 1 - Classe ParcelaResponse

    private BigDecimal limite;

    @JsonProperty("renegociacao")
    private RenegociacaoCartaoResponse renegociacaoResponse; // CDD 1 - Classe RenegociacaoCartaoResponse

    @JsonProperty("vencimento")
    private VencimentoCartaoResponse vencimentoResponse; // CDD 1 - Classe VencimentoCartaoResponse

    private String idProposta;

    public BuscaCartaoResponse(String id, LocalDateTime dataEmissao, String titular, List<BloqueioCartaoResponse> bloqueioCartaoResponseList, List<AvisoCartaoResponse> avisoCartaoResponseList, List<CarteiraCartaoResponse> carteiraCartaoResponseList, List<ParcelaResponse> parcelaCartaoResponseList, BigDecimal limite, RenegociacaoCartaoResponse renegociacaoCartaoResponse, VencimentoCartaoResponse vencimentoCartaoResponse, String idProposta) {
        this.id = id;
        this.dataEmissao = dataEmissao;
        this.titular = titular;
        this.bloqueioResponseList = bloqueioCartaoResponseList;
        this.avisoResponseList = avisoCartaoResponseList;
        this.carteiraResponseList = carteiraCartaoResponseList;
        this.parcelaResponseList = parcelaCartaoResponseList;
        this.limite = limite;
        this.renegociacaoResponse = renegociacaoCartaoResponse;
        this.vencimentoResponse = vencimentoCartaoResponse;
        this.idProposta = idProposta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public List<BloqueioCartaoResponse> getBloqueioResponseList() {
        return bloqueioResponseList;
    }

    public void setBloqueioResponseList(List<BloqueioCartaoResponse> bloqueioResponseList) {
        this.bloqueioResponseList = bloqueioResponseList;
    }

    public List<AvisoCartaoResponse> getAvisoResponseList() {
        return avisoResponseList;
    }

    public void setAvisoResponseList(List<AvisoCartaoResponse> avisoResponseList) {
        this.avisoResponseList = avisoResponseList;
    }

    public List<CarteiraCartaoResponse> getCarteiraResponseList() {
        return carteiraResponseList;
    }

    public void setCarteiraResponseList(List<CarteiraCartaoResponse> carteiraResponseList) {
        this.carteiraResponseList = carteiraResponseList;
    }

    public List<ParcelaResponse> getParcelaResponseList() {
        return parcelaResponseList;
    }

    public void setParcelaResponseList(List<ParcelaResponse> parcelaResponseList) {
        this.parcelaResponseList = parcelaResponseList;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public RenegociacaoCartaoResponse getRenegociacaoResponse() {
        return renegociacaoResponse;
    }

    public void setRenegociacaoResponse(RenegociacaoCartaoResponse renegociacaoResponse) {
        this.renegociacaoResponse = renegociacaoResponse;
    }

    public VencimentoCartaoResponse getVencimentoResponse() {
        return vencimentoResponse;
    }

    public void setVencimentoResponse(VencimentoCartaoResponse vencimentoResponse) {
        this.vencimentoResponse = vencimentoResponse;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(String idProposta) {
        this.idProposta = idProposta;
    }
}
