/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.12.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * RespostaUnitatsExpedient
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-18T17:48:56.871+02:00")
public class RespostaUnitatsExpedient {
  @JsonProperty("idUnitatGestora")
  private BigDecimal idUnitatGestora = null;

  @JsonProperty("idUnitatGestoraConvidada")
  private BigDecimal idUnitatGestoraConvidada = null;

  public RespostaUnitatsExpedient idUnitatGestora(BigDecimal idUnitatGestora) {
    this.idUnitatGestora = idUnitatGestora;
    return this;
  }

   /**
   * Unitat gestora de l&#39;expedient
   * @return idUnitatGestora
  **/
  @ApiModelProperty(value = "Unitat gestora de l'expedient")
  public BigDecimal getIdUnitatGestora() {
    return idUnitatGestora;
  }

  public void setIdUnitatGestora(BigDecimal idUnitatGestora) {
    this.idUnitatGestora = idUnitatGestora;
  }

  public RespostaUnitatsExpedient idUnitatGestoraConvidada(BigDecimal idUnitatGestoraConvidada) {
    this.idUnitatGestoraConvidada = idUnitatGestoraConvidada;
    return this;
  }

   /**
   * Unitat gestora convidada de l&#39;expedient
   * @return idUnitatGestoraConvidada
  **/
  @ApiModelProperty(value = "Unitat gestora convidada de l'expedient")
  public BigDecimal getIdUnitatGestoraConvidada() {
    return idUnitatGestoraConvidada;
  }

  public void setIdUnitatGestoraConvidada(BigDecimal idUnitatGestoraConvidada) {
    this.idUnitatGestoraConvidada = idUnitatGestoraConvidada;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespostaUnitatsExpedient respostaUnitatsExpedient = (RespostaUnitatsExpedient) o;
    return Objects.equals(this.idUnitatGestora, respostaUnitatsExpedient.idUnitatGestora) &&
        Objects.equals(this.idUnitatGestoraConvidada, respostaUnitatsExpedient.idUnitatGestoraConvidada);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idUnitatGestora, idUnitatGestoraConvidada);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespostaUnitatsExpedient {\n");
    
    sb.append("    idUnitatGestora: ").append(toIndentedString(idUnitatGestora)).append("\n");
    sb.append("    idUnitatGestoraConvidada: ").append(toIndentedString(idUnitatGestoraConvidada)).append("\n");
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

