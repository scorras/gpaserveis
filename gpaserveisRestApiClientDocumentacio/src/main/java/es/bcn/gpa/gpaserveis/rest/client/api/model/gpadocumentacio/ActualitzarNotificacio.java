/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.15.2
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio;

import java.math.BigDecimal;
import java.util.Objects;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ActualitzarNotificacio
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-17T12:21:43.485+02:00")
public class ActualitzarNotificacio {
	@JsonProperty("codiError")
	private Integer codiError = null;

	@JsonProperty("dataAcusamentRebuda")
	private DateTime dataAcusamentRebuda = null;

	@JsonProperty("dataEnviament")
	private DateTime dataEnviament = null;

	@JsonProperty("dataHoraAceptacioRebuig")
	private DateTime dataHoraAceptacioRebuig = null;

	@JsonProperty("dataHoraDiposit")
	private DateTime dataHoraDiposit = null;

	@JsonProperty("dataHoraRegistre")
	private DateTime dataHoraRegistre = null;

	@JsonProperty("dataHoraVisualitzacio")
	private DateTime dataHoraVisualitzacio = null;

	@JsonProperty("dataLimit")
	private DateTime dataLimit = null;

	@JsonProperty("descripcioError")
	private String descripcioError = null;

	@JsonProperty("docEvidenciaElectronic")
	private String docEvidenciaElectronic = null;

	@JsonProperty("docEvidenciaPaper")
	private String docEvidenciaPaper = null;

	@JsonProperty("estat")
	private String estat = null;

	@JsonProperty("notificacioId")
	private BigDecimal notificacioId = null;

	@JsonProperty("numRegistre")
	private String numRegistre = null;

	public ActualitzarNotificacio codiError(Integer codiError) {
		this.codiError = codiError;
		return this;
	}

	/**
	 * Codi de l&#39;error
	 * 
	 * @return codiError
	 **/
	@ApiModelProperty(value = "Codi de l'error")
	public Integer getCodiError() {
		return codiError;
	}

	public void setCodiError(Integer codiError) {
		this.codiError = codiError;
	}

	public ActualitzarNotificacio dataAcusamentRebuda(DateTime dataAcusamentRebuda) {
		this.dataAcusamentRebuda = dataAcusamentRebuda;
		return this;
	}

	/**
	 * Data d&#39;acusament rebuda. Format: dd/MM/yyyy hh:mm:ss
	 * 
	 * @return dataAcusamentRebuda
	 **/
	@ApiModelProperty(value = "Data d'acusament rebuda. Format: dd/MM/yyyy hh:mm:ss")
	public DateTime getDataAcusamentRebuda() {
		return dataAcusamentRebuda;
	}

	public void setDataAcusamentRebuda(DateTime dataAcusamentRebuda) {
		this.dataAcusamentRebuda = dataAcusamentRebuda;
	}

	public ActualitzarNotificacio dataEnviament(DateTime dataEnviament) {
		this.dataEnviament = dataEnviament;
		return this;
	}

	/**
	 * Data d&#39;enviament. Format: dd/MM/yyyy hh:mm:ss
	 * 
	 * @return dataEnviament
	 **/
	@ApiModelProperty(value = "Data d'enviament. Format: dd/MM/yyyy hh:mm:ss")
	public DateTime getDataEnviament() {
		return dataEnviament;
	}

	public void setDataEnviament(DateTime dataEnviament) {
		this.dataEnviament = dataEnviament;
	}

	public ActualitzarNotificacio dataHoraAceptacioRebuig(DateTime dataHoraAceptacioRebuig) {
		this.dataHoraAceptacioRebuig = dataHoraAceptacioRebuig;
		return this;
	}

	/**
	 * Data i hora d&#39;aceptació o rebuig. Format: dd/MM/yyyy hh:mm:ss
	 * 
	 * @return dataHoraAceptacioRebuig
	 **/
	@ApiModelProperty(value = "Data i hora d'aceptació o rebuig. Format: dd/MM/yyyy hh:mm:ss")
	public DateTime getDataHoraAceptacioRebuig() {
		return dataHoraAceptacioRebuig;
	}

	public void setDataHoraAceptacioRebuig(DateTime dataHoraAceptacioRebuig) {
		this.dataHoraAceptacioRebuig = dataHoraAceptacioRebuig;
	}

	public ActualitzarNotificacio dataHoraDiposit(DateTime dataHoraDiposit) {
		this.dataHoraDiposit = dataHoraDiposit;
		return this;
	}

	/**
	 * Data i hora de diposit. Format: dd/MM/yyyy hh:mm:ss
	 * 
	 * @return dataHoraDiposit
	 **/
	@ApiModelProperty(value = "Data i hora de diposit. Format: dd/MM/yyyy hh:mm:ss")
	public DateTime getDataHoraDiposit() {
		return dataHoraDiposit;
	}

	public void setDataHoraDiposit(DateTime dataHoraDiposit) {
		this.dataHoraDiposit = dataHoraDiposit;
	}

	public ActualitzarNotificacio dataHoraRegistre(DateTime dataHoraRegistre) {
		this.dataHoraRegistre = dataHoraRegistre;
		return this;
	}

	/**
	 * Data en la que ha estat registrada la notificació. Format: dd/MM/yyyy
	 * hh:mm:ss
	 * 
	 * @return dataHoraRegistre
	 **/
	@ApiModelProperty(value = "Data en la que ha estat registrada la notificació. Format: dd/MM/yyyy hh:mm:ss")
	public DateTime getDataHoraRegistre() {
		return dataHoraRegistre;
	}

	public void setDataHoraRegistre(DateTime dataHoraRegistre) {
		this.dataHoraRegistre = dataHoraRegistre;
	}

	public ActualitzarNotificacio dataHoraVisualitzacio(DateTime dataHoraVisualitzacio) {
		this.dataHoraVisualitzacio = dataHoraVisualitzacio;
		return this;
	}

	/**
	 * Data i hora de visualitzacio. Format: dd/MM/yyyy hh:mm:ss
	 * 
	 * @return dataHoraVisualitzacio
	 **/
	@ApiModelProperty(value = "Data i hora de visualitzacio. Format: dd/MM/yyyy hh:mm:ss")
	public DateTime getDataHoraVisualitzacio() {
		return dataHoraVisualitzacio;
	}

	public void setDataHoraVisualitzacio(DateTime dataHoraVisualitzacio) {
		this.dataHoraVisualitzacio = dataHoraVisualitzacio;
	}

	public ActualitzarNotificacio dataLimit(DateTime dataLimit) {
		this.dataLimit = dataLimit;
		return this;
	}

	/**
	 * Data limit. Format: dd/MM/yyyy
	 * 
	 * @return dataLimit
	 **/
	@ApiModelProperty(value = "Data limit. Format: dd/MM/yyyy")
	public DateTime getDataLimit() {
		return dataLimit;
	}

	public void setDataLimit(DateTime dataLimit) {
		this.dataLimit = dataLimit;
	}

	public ActualitzarNotificacio descripcioError(String descripcioError) {
		this.descripcioError = descripcioError;
		return this;
	}

	/**
	 * Descripció de l&#39;error
	 * 
	 * @return descripcioError
	 **/
	@ApiModelProperty(value = "Descripció de l'error")
	public String getDescripcioError() {
		return descripcioError;
	}

	public void setDescripcioError(String descripcioError) {
		this.descripcioError = descripcioError;
	}

	public ActualitzarNotificacio docEvidenciaElectronic(String docEvidenciaElectronic) {
		this.docEvidenciaElectronic = docEvidenciaElectronic;
		return this;
	}

	/**
	 * Document de la evidència electrònica de la notificació
	 * 
	 * @return docEvidenciaElectronic
	 **/
	@ApiModelProperty(value = "Document de la evidència electrònica de la notificació")
	public String getDocEvidenciaElectronic() {
		return docEvidenciaElectronic;
	}

	public void setDocEvidenciaElectronic(String docEvidenciaElectronic) {
		this.docEvidenciaElectronic = docEvidenciaElectronic;
	}

	public ActualitzarNotificacio docEvidenciaPaper(String docEvidenciaPaper) {
		this.docEvidenciaPaper = docEvidenciaPaper;
		return this;
	}

	/**
	 * Document de la evidència en paper de la notificació
	 * 
	 * @return docEvidenciaPaper
	 **/
	@ApiModelProperty(value = "Document de la evidència en paper de la notificació")
	public String getDocEvidenciaPaper() {
		return docEvidenciaPaper;
	}

	public void setDocEvidenciaPaper(String docEvidenciaPaper) {
		this.docEvidenciaPaper = docEvidenciaPaper;
	}

	public ActualitzarNotificacio estat(String estat) {
		this.estat = estat;
		return this;
	}

	/**
	 * Estat de la notificació
	 * 
	 * @return estat
	 **/
	@ApiModelProperty(value = "Estat de la notificació")
	public String getEstat() {
		return estat;
	}

	public void setEstat(String estat) {
		this.estat = estat;
	}

	public ActualitzarNotificacio notificacioId(BigDecimal notificacioId) {
		this.notificacioId = notificacioId;
		return this;
	}

	/**
	 * Identificador de la notificació
	 * 
	 * @return notificacioId
	 **/
	@ApiModelProperty(value = "Identificador de la notificació")
	public BigDecimal getNotificacioId() {
		return notificacioId;
	}

	public void setNotificacioId(BigDecimal notificacioId) {
		this.notificacioId = notificacioId;
	}

	public ActualitzarNotificacio numRegistre(String numRegistre) {
		this.numRegistre = numRegistre;
		return this;
	}

	/**
	 * Número de registre de la notificació
	 * 
	 * @return numRegistre
	 **/
	@ApiModelProperty(value = "Número de registre de la notificació")
	public String getNumRegistre() {
		return numRegistre;
	}

	public void setNumRegistre(String numRegistre) {
		this.numRegistre = numRegistre;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ActualitzarNotificacio actualitzarNotificacio = (ActualitzarNotificacio) o;
		return Objects.equals(this.codiError, actualitzarNotificacio.codiError)
				&& Objects.equals(this.dataAcusamentRebuda, actualitzarNotificacio.dataAcusamentRebuda)
				&& Objects.equals(this.dataEnviament, actualitzarNotificacio.dataEnviament)
				&& Objects.equals(this.dataHoraAceptacioRebuig, actualitzarNotificacio.dataHoraAceptacioRebuig)
				&& Objects.equals(this.dataHoraDiposit, actualitzarNotificacio.dataHoraDiposit)
				&& Objects.equals(this.dataHoraRegistre, actualitzarNotificacio.dataHoraRegistre)
				&& Objects.equals(this.dataHoraVisualitzacio, actualitzarNotificacio.dataHoraVisualitzacio)
				&& Objects.equals(this.dataLimit, actualitzarNotificacio.dataLimit)
				&& Objects.equals(this.descripcioError, actualitzarNotificacio.descripcioError)
				&& Objects.equals(this.docEvidenciaElectronic, actualitzarNotificacio.docEvidenciaElectronic)
				&& Objects.equals(this.docEvidenciaPaper, actualitzarNotificacio.docEvidenciaPaper)
				&& Objects.equals(this.estat, actualitzarNotificacio.estat)
				&& Objects.equals(this.notificacioId, actualitzarNotificacio.notificacioId)
				&& Objects.equals(this.numRegistre, actualitzarNotificacio.numRegistre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiError, dataAcusamentRebuda, dataEnviament, dataHoraAceptacioRebuig, dataHoraDiposit, dataHoraRegistre,
				dataHoraVisualitzacio, dataLimit, descripcioError, docEvidenciaElectronic, docEvidenciaPaper, estat, notificacioId,
				numRegistre);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ActualitzarNotificacio {\n");

		sb.append("    codiError: ").append(toIndentedString(codiError)).append("\n");
		sb.append("    dataAcusamentRebuda: ").append(toIndentedString(dataAcusamentRebuda)).append("\n");
		sb.append("    dataEnviament: ").append(toIndentedString(dataEnviament)).append("\n");
		sb.append("    dataHoraAceptacioRebuig: ").append(toIndentedString(dataHoraAceptacioRebuig)).append("\n");
		sb.append("    dataHoraDiposit: ").append(toIndentedString(dataHoraDiposit)).append("\n");
		sb.append("    dataHoraRegistre: ").append(toIndentedString(dataHoraRegistre)).append("\n");
		sb.append("    dataHoraVisualitzacio: ").append(toIndentedString(dataHoraVisualitzacio)).append("\n");
		sb.append("    dataLimit: ").append(toIndentedString(dataLimit)).append("\n");
		sb.append("    descripcioError: ").append(toIndentedString(descripcioError)).append("\n");
		sb.append("    docEvidenciaElectronic: ").append(toIndentedString(docEvidenciaElectronic)).append("\n");
		sb.append("    docEvidenciaPaper: ").append(toIndentedString(docEvidenciaPaper)).append("\n");
		sb.append("    estat: ").append(toIndentedString(estat)).append("\n");
		sb.append("    notificacioId: ").append(toIndentedString(notificacioId)).append("\n");
		sb.append("    numRegistre: ").append(toIndentedString(numRegistre)).append("\n");
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
