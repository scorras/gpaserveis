/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.20.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CrearNotificacio
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-03-25T13:12:16.537+01:00")
public class CrearNotificacio {
	@JsonProperty("codiExpedient")
	private String codiExpedient = null;

	@JsonProperty("codiProcediment")
	private String codiProcediment = null;

	@JsonProperty("comunicar")
	private Boolean comunicar = null;

	@JsonProperty("idDocumentPrincipal")
	private BigDecimal idDocumentPrincipal = null;

	@JsonProperty("idExpedient")
	private BigDecimal idExpedient = null;

	@JsonProperty("idProcediment")
	private BigDecimal idProcediment = null;

	@JsonProperty("idsAnnexosList")
	private List<BigDecimal> idsAnnexosList = null;

	@JsonProperty("personaFisicaVinculada")
	private Persones personaFisicaVinculada = null;

	@JsonProperty("persones")
	private List<Persones> persones = null;

	public CrearNotificacio codiExpedient(String codiExpedient) {
		this.codiExpedient = codiExpedient;
		return this;
	}

	/**
	 * Codi Opentext de l&#39;expedient
	 * 
	 * @return codiExpedient
	 **/
	@ApiModelProperty(value = "Codi Opentext de l'expedient")
	public String getCodiExpedient() {
		return codiExpedient;
	}

	public void setCodiExpedient(String codiExpedient) {
		this.codiExpedient = codiExpedient;
	}

	public CrearNotificacio codiProcediment(String codiProcediment) {
		this.codiProcediment = codiProcediment;
		return this;
	}

	/**
	 * Codi del procediment de l&#39;expedient
	 * 
	 * @return codiProcediment
	 **/
	@ApiModelProperty(value = "Codi del procediment de l'expedient")
	public String getCodiProcediment() {
		return codiProcediment;
	}

	public void setCodiProcediment(String codiProcediment) {
		this.codiProcediment = codiProcediment;
	}

	public CrearNotificacio comunicar(Boolean comunicar) {
		this.comunicar = comunicar;
		return this;
	}

	/**
	 * Pasar a Comunicar
	 * 
	 * @return comunicar
	 **/
	@ApiModelProperty(value = "Pasar a Comunicar")
	public Boolean isComunicar() {
		return comunicar;
	}

	public void setComunicar(Boolean comunicar) {
		this.comunicar = comunicar;
	}

	public CrearNotificacio idDocumentPrincipal(BigDecimal idDocumentPrincipal) {
		this.idDocumentPrincipal = idDocumentPrincipal;
		return this;
	}

	/**
	 * Identificador del document principal de tramitació
	 * 
	 * @return idDocumentPrincipal
	 **/
	@ApiModelProperty(value = "Identificador del document principal de tramitació")
	public BigDecimal getIdDocumentPrincipal() {
		return idDocumentPrincipal;
	}

	public void setIdDocumentPrincipal(BigDecimal idDocumentPrincipal) {
		this.idDocumentPrincipal = idDocumentPrincipal;
	}

	public CrearNotificacio idExpedient(BigDecimal idExpedient) {
		this.idExpedient = idExpedient;
		return this;
	}

	/**
	 * Identificador de l&#39;expedient
	 * 
	 * @return idExpedient
	 **/
	@ApiModelProperty(value = "Identificador de l'expedient")
	public BigDecimal getIdExpedient() {
		return idExpedient;
	}

	public void setIdExpedient(BigDecimal idExpedient) {
		this.idExpedient = idExpedient;
	}

	public CrearNotificacio idProcediment(BigDecimal idProcediment) {
		this.idProcediment = idProcediment;
		return this;
	}

	/**
	 * Identificador del procediment de l&#39;expedient
	 * 
	 * @return idProcediment
	 **/
	@ApiModelProperty(value = "Identificador del procediment de l'expedient")
	public BigDecimal getIdProcediment() {
		return idProcediment;
	}

	public void setIdProcediment(BigDecimal idProcediment) {
		this.idProcediment = idProcediment;
	}

	public CrearNotificacio idsAnnexosList(List<BigDecimal> idsAnnexosList) {
		this.idsAnnexosList = idsAnnexosList;
		return this;
	}

	public CrearNotificacio addIdsAnnexosListItem(BigDecimal idsAnnexosListItem) {
		if (this.idsAnnexosList == null) {
			this.idsAnnexosList = new ArrayList<BigDecimal>();
		}
		this.idsAnnexosList.add(idsAnnexosListItem);
		return this;
	}

	/**
	 * llista d&#39;identificadors dels annexos
	 * 
	 * @return idsAnnexosList
	 **/
	@ApiModelProperty(value = "llista d'identificadors dels annexos")
	public List<BigDecimal> getIdsAnnexosList() {
		return idsAnnexosList;
	}

	public void setIdsAnnexosList(List<BigDecimal> idsAnnexosList) {
		this.idsAnnexosList = idsAnnexosList;
	}

	public CrearNotificacio personaFisicaVinculada(Persones personaFisicaVinculada) {
		this.personaFisicaVinculada = personaFisicaVinculada;
		return this;
	}

	/**
	 * Persona física vinculada
	 * 
	 * @return personaFisicaVinculada
	 **/
	@ApiModelProperty(value = "Persona física vinculada")
	public Persones getPersonaFisicaVinculada() {
		return personaFisicaVinculada;
	}

	public void setPersonaFisicaVinculada(Persones personaFisicaVinculada) {
		this.personaFisicaVinculada = personaFisicaVinculada;
	}

	public CrearNotificacio persones(List<Persones> persones) {
		this.persones = persones;
		return this;
	}

	public CrearNotificacio addPersonesItem(Persones personesItem) {
		if (this.persones == null) {
			this.persones = new ArrayList<Persones>();
		}
		this.persones.add(personesItem);
		return this;
	}

	/**
	 * Llista de persones a notificar
	 * 
	 * @return persones
	 **/
	@ApiModelProperty(value = "Llista de persones a notificar")
	public List<Persones> getPersones() {
		return persones;
	}

	public void setPersones(List<Persones> persones) {
		this.persones = persones;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CrearNotificacio crearNotificacio = (CrearNotificacio) o;
		return Objects.equals(this.codiExpedient, crearNotificacio.codiExpedient)
				&& Objects.equals(this.codiProcediment, crearNotificacio.codiProcediment)
				&& Objects.equals(this.comunicar, crearNotificacio.comunicar)
				&& Objects.equals(this.idDocumentPrincipal, crearNotificacio.idDocumentPrincipal)
				&& Objects.equals(this.idExpedient, crearNotificacio.idExpedient)
				&& Objects.equals(this.idProcediment, crearNotificacio.idProcediment)
				&& Objects.equals(this.idsAnnexosList, crearNotificacio.idsAnnexosList)
				&& Objects.equals(this.personaFisicaVinculada, crearNotificacio.personaFisicaVinculada)
				&& Objects.equals(this.persones, crearNotificacio.persones);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiExpedient, codiProcediment, comunicar, idDocumentPrincipal, idExpedient, idProcediment, idsAnnexosList,
				personaFisicaVinculada, persones);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CrearNotificacio {\n");

		sb.append("    codiExpedient: ").append(toIndentedString(codiExpedient)).append("\n");
		sb.append("    codiProcediment: ").append(toIndentedString(codiProcediment)).append("\n");
		sb.append("    comunicar: ").append(toIndentedString(comunicar)).append("\n");
		sb.append("    idDocumentPrincipal: ").append(toIndentedString(idDocumentPrincipal)).append("\n");
		sb.append("    idExpedient: ").append(toIndentedString(idExpedient)).append("\n");
		sb.append("    idProcediment: ").append(toIndentedString(idProcediment)).append("\n");
		sb.append("    idsAnnexosList: ").append(toIndentedString(idsAnnexosList)).append("\n");
		sb.append("    personaFisicaVinculada: ").append(toIndentedString(personaFisicaVinculada)).append("\n");
		sb.append("    persones: ").append(toIndentedString(persones)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
