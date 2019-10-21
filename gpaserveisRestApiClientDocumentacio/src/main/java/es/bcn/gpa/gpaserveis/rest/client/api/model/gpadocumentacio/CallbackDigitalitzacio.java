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
 * CallbackDigitalitzacio
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-17T12:21:43.485+02:00")
public class CallbackDigitalitzacio {
	@JsonProperty("codiError")
	private String codiError = null;

	@JsonProperty("dataDigitalitzacio")
	private DateTime dataDigitalitzacio = null;

	@JsonProperty("descripcioError")
	private String descripcioError = null;

	@JsonProperty("estat")
	private BigDecimal estat = null;

	@JsonProperty("idDocScan")
	private String idDocScan = null;

	@JsonProperty("idioma")
	private BigDecimal idioma = null;

	public CallbackDigitalitzacio codiError(String codiError) {
		this.codiError = codiError;
		return this;
	}

	/**
	 * Codi de l&#39;error si el resultat es KO
	 * 
	 * @return codiError
	 **/
	@ApiModelProperty(value = "Codi de l'error si el resultat es KO")
	public String getCodiError() {
		return codiError;
	}

	public void setCodiError(String codiError) {
		this.codiError = codiError;
	}

	public CallbackDigitalitzacio dataDigitalitzacio(DateTime dataDigitalitzacio) {
		this.dataDigitalitzacio = dataDigitalitzacio;
		return this;
	}

	/**
	 * Data i hora de digitalització del document si el resultat es OK
	 * 
	 * @return dataDigitalitzacio
	 **/
	@ApiModelProperty(value = "Data i hora de digitalització del document si el resultat es OK")
	public DateTime getDataDigitalitzacio() {
		return dataDigitalitzacio;
	}

	public void setDataDigitalitzacio(DateTime dataDigitalitzacio) {
		this.dataDigitalitzacio = dataDigitalitzacio;
	}

	public CallbackDigitalitzacio descripcioError(String descripcioError) {
		this.descripcioError = descripcioError;
		return this;
	}

	/**
	 * Descripció de l&#39;error si el resultat es KO
	 * 
	 * @return descripcioError
	 **/
	@ApiModelProperty(value = "Descripció de l'error si el resultat es KO")
	public String getDescripcioError() {
		return descripcioError;
	}

	public void setDescripcioError(String descripcioError) {
		this.descripcioError = descripcioError;
	}

	public CallbackDigitalitzacio estat(BigDecimal estat) {
		this.estat = estat;
		return this;
	}

	/**
	 * Estat del document escanejat. 2: OK, 3: KO
	 * 
	 * @return estat
	 **/
	@ApiModelProperty(value = "Estat del document escanejat. 2: OK, 3: KO")
	public BigDecimal getEstat() {
		return estat;
	}

	public void setEstat(BigDecimal estat) {
		this.estat = estat;
	}

	public CallbackDigitalitzacio idDocScan(String idDocScan) {
		this.idDocScan = idDocScan;
		return this;
	}

	/**
	 * Identificador d&#39;opentext del document
	 * 
	 * @return idDocScan
	 **/
	@ApiModelProperty(value = "Identificador d'opentext del document")
	public String getIdDocScan() {
		return idDocScan;
	}

	public void setIdDocScan(String idDocScan) {
		this.idDocScan = idDocScan;
	}

	public CallbackDigitalitzacio idioma(BigDecimal idioma) {
		this.idioma = idioma;
		return this;
	}

	/**
	 * Idioma del document escanejat
	 * 
	 * @return idioma
	 **/
	@ApiModelProperty(value = "Idioma del document escanejat")
	public BigDecimal getIdioma() {
		return idioma;
	}

	public void setIdioma(BigDecimal idioma) {
		this.idioma = idioma;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CallbackDigitalitzacio callbackDigitalitzacio = (CallbackDigitalitzacio) o;
		return Objects.equals(this.codiError, callbackDigitalitzacio.codiError)
				&& Objects.equals(this.dataDigitalitzacio, callbackDigitalitzacio.dataDigitalitzacio)
				&& Objects.equals(this.descripcioError, callbackDigitalitzacio.descripcioError)
				&& Objects.equals(this.estat, callbackDigitalitzacio.estat)
				&& Objects.equals(this.idDocScan, callbackDigitalitzacio.idDocScan)
				&& Objects.equals(this.idioma, callbackDigitalitzacio.idioma);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiError, dataDigitalitzacio, descripcioError, estat, idDocScan, idioma);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CallbackDigitalitzacio {\n");

		sb.append("    codiError: ").append(toIndentedString(codiError)).append("\n");
		sb.append("    dataDigitalitzacio: ").append(toIndentedString(dataDigitalitzacio)).append("\n");
		sb.append("    descripcioError: ").append(toIndentedString(descripcioError)).append("\n");
		sb.append("    estat: ").append(toIndentedString(estat)).append("\n");
		sb.append("    idDocScan: ").append(toIndentedString(idDocScan)).append("\n");
		sb.append("    idioma: ").append(toIndentedString(idioma)).append("\n");
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
