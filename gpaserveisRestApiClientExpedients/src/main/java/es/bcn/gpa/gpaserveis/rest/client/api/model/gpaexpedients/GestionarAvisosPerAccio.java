/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 2.5.3
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GestionarAvisosPerAccio
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-07-01T12:01:08.786+02:00")
public class GestionarAvisosPerAccio {
	@JsonProperty("idAccioEstat")
	private BigDecimal idAccioEstat = null;
	@JsonProperty("idDocTramitacio")
	private BigDecimal idDocTramitacio;
	@JsonProperty("idEstatFinalDocTramitacio")
	private BigDecimal idEstatFinalDocTramitacio;
	@JsonProperty("idUsuariSignatura")
	private BigDecimal idUsuariSignatura;

	public GestionarAvisosPerAccio idAccioEstat(BigDecimal idAccioEstat) {
		this.idAccioEstat = idAccioEstat;
		return this;
	}

	/**
	 * Identificador de l&#39;acció estat
	 * 
	 * @return idAccioEstat
	 **/
	@ApiModelProperty(value = "Identificador de l'acció estat")
	public BigDecimal getIdAccioEstat() {
		return idAccioEstat;
	}

	public void setIdAccioEstat(BigDecimal idAccioEstat) {
		this.idAccioEstat = idAccioEstat;
	}

	@ApiModelProperty(value = "Identificador de el document de tramitació")
	public BigDecimal getIdDocTramitacio() {
		return idDocTramitacio;
	}

	public void setIdDocTramitacio(BigDecimal idDocTramitacio) {
		this.idDocTramitacio = idDocTramitacio;
	}

	@ApiModelProperty(value = "Identificador de l'estat final de el document de tramitació")
	public BigDecimal getIdEstatFinalDocTramitacio() {
		return idEstatFinalDocTramitacio;
	}

	public void setIdEstatFinalDocTramitacio(BigDecimal idEstatFinalDocTramitacio) {
		this.idEstatFinalDocTramitacio = idEstatFinalDocTramitacio;
	}

	@ApiModelProperty(value = "Identificador de l'usuari de signatura")
	public BigDecimal getIdUsuariSignatura() {
		return idUsuariSignatura;
	}

	public void setIdUsuariSignatura(BigDecimal idUsuariSignatura) {
		this.idUsuariSignatura = idUsuariSignatura;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GestionarAvisosPerAccio gestionarAvisosPerAccio = (GestionarAvisosPerAccio) o;
		return Objects.equals(this.idAccioEstat, gestionarAvisosPerAccio.idAccioEstat)
				&& Objects.equals(this.idDocTramitacio, gestionarAvisosPerAccio.idDocTramitacio)
				&& Objects.equals(this.idEstatFinalDocTramitacio, gestionarAvisosPerAccio.idEstatFinalDocTramitacio)
				&& Objects.equals(this.idUsuariSignatura, gestionarAvisosPerAccio.idUsuariSignatura);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAccioEstat, idDocTramitacio, idEstatFinalDocTramitacio, idUsuariSignatura);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GestionarAvisosPerAccio {\n");

		sb.append("    idAccioEstat: ").append(toIndentedString(idAccioEstat)).append("\n");
		sb.append("    idDocTramitacio: ").append(toIndentedString(idDocTramitacio)).append("\n");
		sb.append("    idEstatFinalDocTramitacio: ").append(toIndentedString(idEstatFinalDocTramitacio)).append("\n");
		sb.append("    idUsuariSignatura: ").append(toIndentedString(idUsuariSignatura)).append("\n");
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
