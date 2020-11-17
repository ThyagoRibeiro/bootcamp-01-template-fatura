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
    private List<BloqueioResponse> bloqueioResponseList; // CDD 1 - Classe BloqueioResponse

    @JsonProperty("avisos")
    private List<AvisoResponse> avisoResponseList; // CDD 1 - Classe AvisoResponse

    @JsonProperty("carteiras")
    private List<CarteiraResponse> carteiraResponseList; // CDD 1 - Classe CarteiraResponse

    @JsonProperty("parcelas")
    private List<ParcelaResponse> parcelaResponseList; // CDD 1 - Classe ParcelaResponse

    private BigDecimal limite;

    @JsonProperty("renegociacao")
    private RenegociacaoResponse renegociacaoResponse; // CDD 1 - Classe RenegociacaoResponse

    @JsonProperty("vencimento")
    private VencimentoResponse vencimentoResponse; // CDD 1 - Classe VencimentoResponse

    private String idProposta;

    public BuscaCartaoResponse(String id, LocalDateTime dataEmissao, String titular, List<BloqueioResponse> bloqueioCartaoResponseList, List<AvisoResponse> avisoCartaoResponseList, List<CarteiraResponse> carteiraCartaoResponseList, List<ParcelaResponse> parcelaCartaoResponseList, BigDecimal limite, RenegociacaoResponse renegociacaoCartaoResponse, VencimentoResponse vencimentoCartaoResponse, String idProposta) {
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

    public List<BloqueioResponse> getBloqueioResponseList() {
        return bloqueioResponseList;
    }

    public void setBloqueioResponseList(List<BloqueioResponse> bloqueioResponseList) {
        this.bloqueioResponseList = bloqueioResponseList;
    }

    public List<AvisoResponse> getAvisoResponseList() {
        return avisoResponseList;
    }

    public void setAvisoResponseList(List<AvisoResponse> avisoResponseList) {
        this.avisoResponseList = avisoResponseList;
    }

    public List<CarteiraResponse> getCarteiraResponseList() {
        return carteiraResponseList;
    }

    public void setCarteiraResponseList(List<CarteiraResponse> carteiraResponseList) {
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

    public RenegociacaoResponse getRenegociacaoResponse() {
        return renegociacaoResponse;
    }

    public void setRenegociacaoResponse(RenegociacaoResponse renegociacaoResponse) {
        this.renegociacaoResponse = renegociacaoResponse;
    }

    public VencimentoResponse getVencimentoResponse() {
        return vencimentoResponse;
    }

    public void setVencimentoResponse(VencimentoResponse vencimentoResponse) {
        this.vencimentoResponse = vencimentoResponse;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(String idProposta) {
        this.idProposta = idProposta;
    }
}
