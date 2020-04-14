
package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RespostaObtenirXmlExpedient
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-10T10:19:04.448+02:00")
public class RespostaObtenirXmlExpedient {
	@JsonProperty("dadesXml")
	private String dadesXml = null;

	@JsonProperty("id")
	private BigDecimal id = null;

	public RespostaObtenirXmlExpedient dadesXml(String dadesXml) {
		this.dadesXml = dadesXml;
		return this;
	}

	/**
	 * Informació de l&#39;expedient en format xml
	 * 
	 * @return dadesXml
	 **/
	@ApiModelProperty(value = "Informació de l'expedient en format xml")
	public String getDadesXml() {
		return dadesXml;
	}

	public void setDadesXml(String dadesXml) {
		this.dadesXml = dadesXml;
	}

	public RespostaObtenirXmlExpedient id(BigDecimal id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador de l&#39;expedient
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador de l'expedient")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RespostaObtenirXmlExpedient respostaObtenirXmlExpedient = (RespostaObtenirXmlExpedient) o;
		return Objects.equals(this.dadesXml, respostaObtenirXmlExpedient.dadesXml)
				&& Objects.equals(this.id, respostaObtenirXmlExpedient.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dadesXml, id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RespostaObtenirXmlExpedient {\n");

		sb.append("    dadesXml: ").append(toIndentedString(dadesXml)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
