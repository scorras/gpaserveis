package es.bcn.gpa.gpaserveis.integration.orm.model;

import java.math.BigDecimal;
import java.util.Date;

public class AuditServeis extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

	private Date momentExecucio;

	private String usuari;

	private String mappingAccio;

	private String valueAccio;

	private String tipusPeticio;

	private String resultat;

	private String dadesAuth;

	private String dadesEntrada;

	private String dadesResposta;

	private String detallError;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Date getMomentExecucio() {
		return momentExecucio;
	}

	public void setMomentExecucio(Date momentExecucio) {
		this.momentExecucio = momentExecucio;
	}

	public String getUsuari() {
		return usuari;
	}

	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}

	public String getMappingAccio() {
		return mappingAccio;
	}

	public void setMappingAccio(String mappingAccio) {
		this.mappingAccio = mappingAccio;
	}

	public String getValueAccio() {
		return valueAccio;
	}

	public void setValueAccio(String valueAccio) {
		this.valueAccio = valueAccio;
	}

	public String getTipusPeticio() {
		return tipusPeticio;
	}

	public void setTipusPeticio(String tipusPeticio) {
		this.tipusPeticio = tipusPeticio;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public String getDadesAuth() {
		return dadesAuth;
	}

	public void setDadesAuth(String dadesAuth) {
		this.dadesAuth = dadesAuth;
	}

	public String getDadesEntrada() {
		return dadesEntrada;
	}

	public void setDadesEntrada(String dadesEntrada) {
		this.dadesEntrada = dadesEntrada;
	}

	public String getDadesResposta() {
		return dadesResposta;
	}

	public void setDadesResposta(String dadesResposta) {
		this.dadesResposta = dadesResposta;
	}

	public String getDetallError() {
		return detallError;
	}

	public void setDetallError(String detallError) {
		this.detallError = detallError;
	}
}