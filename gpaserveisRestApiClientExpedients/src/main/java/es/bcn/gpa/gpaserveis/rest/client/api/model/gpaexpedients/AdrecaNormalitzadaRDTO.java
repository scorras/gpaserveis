/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.11.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AdrecaNormalitzadaRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-14T14:36:36.923+02:00")
public class AdrecaNormalitzadaRDTO {
	@JsonProperty("adreca")
	private String adreca = null;

	public AdrecaNormalitzadaRDTO adreca(String adreca) {
		this.adreca = adreca;
		return this;
	}

	/**
	 * Get adreca
	 * 
	 * @return adreca
	 **/
	@ApiModelProperty(value = "")
	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AdrecaNormalitzadaRDTO adrecaNormalitzadaRDTO = (AdrecaNormalitzadaRDTO) o;
		return Objects.equals(this.adreca, adrecaNormalitzadaRDTO.adreca);
	}

	@Override
	public int hashCode() {
		return Objects.hash(adreca);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AdrecaNormalitzadaRDTO {\n");

		sb.append("    adreca: ").append(toIndentedString(adreca)).append("\n");
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
