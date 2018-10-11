package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="DadesContacte")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "email",
    "telefon",
    "mobil",
    "fax",
    "tipusVia",
    "tipusVia",
    "numero",
    "escala",
    "bloc",
    "porta",
    "pis",
    "codiPostal",
    "municipi",
    "provincia",
    "comarca",
    "pais",
    "municipiEstranger",
    "provinciaEstranger"
})
public class DadesContacteRDTO {
	
	@ApiModelProperty(value="Email")
	private String email;
	@ApiModelProperty(value="Telèfon fixe")
    private String telefon;
	@ApiModelProperty(value="Telèfon mobil")
    private String mobil;
	@ApiModelProperty(value="Fax")
    private String fax;
    
	@ApiModelProperty(value="Tipus de via")
    private String tipusVia;
	@ApiModelProperty(value="Nom de la via")
    private String nomVia;
	@ApiModelProperty(value="Número")
    private String numero;
	@ApiModelProperty(value="Escala")
    private String escala;
	@ApiModelProperty(value="Bloc")
    private String bloc;
	@ApiModelProperty(value="Porta")
    private String porta;
	@ApiModelProperty(value="Pis")
    private String pis;
    
	@ApiModelProperty(value="Codi Postal")
    private String codiPostal;
	@ApiModelProperty(value="Municipi")
    private String municipi;
	@ApiModelProperty(value="Provincia")
    private String provincia;
	@ApiModelProperty(value="Comarca")
    private String comarca;
	@ApiModelProperty(value="Pais")
    private String pais;
    
	@ApiModelProperty(value="Municipi estranger")
    private String municipiEstranger;
	@ApiModelProperty(value="Provincia estrangera")
    private String provinciaEstranger;
    
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getMobil() {
		return mobil;
	}
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getTipusVia() {
		return tipusVia;
	}
	public void setTipusVia(String tipusVia) {
		this.tipusVia = tipusVia;
	}
	public String getNomVia() {
		return nomVia;
	}
	public void setNomVia(String nomVia) {
		this.nomVia = nomVia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEscala() {
		return escala;
	}
	public void setEscala(String escala) {
		this.escala = escala;
	}
	public String getBloc() {
		return bloc;
	}
	public void setBloc(String bloc) {
		this.bloc = bloc;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getPis() {
		return pis;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
	public String getCodiPostal() {
		return codiPostal;
	}
	public void setCodiPostal(String codiPostal) {
		this.codiPostal = codiPostal;
	}
	public String getMunicipi() {
		return municipi;
	}
	public void setMunicipi(String municipi) {
		this.municipi = municipi;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getComarca() {
		return comarca;
	}
	public void setComarca(String comarca) {
		this.comarca = comarca;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getMunicipiEstranger() {
		return municipiEstranger;
	}
	public void setMunicipiEstranger(String municipiEstranger) {
		this.municipiEstranger = municipiEstranger;
	}
	public String getProvinciaEstranger() {
		return provinciaEstranger;
	}
	public void setProvinciaEstranger(String provinciaEstranger) {
		this.provinciaEstranger = provinciaEstranger;
	}

}