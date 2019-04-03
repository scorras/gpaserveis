/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 1.8.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * IdentificacionsCompetencies
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-03T18:17:51.243+02:00")
public class IdentificacionsCompetencies {
  @JsonProperty("competencia")
  private BigDecimal competencia = null;

  @JsonProperty("identificacio")
  private BigDecimal identificacio = null;

  public IdentificacionsCompetencies competencia(BigDecimal competencia) {
    this.competencia = competencia;
    return this;
  }

   /**
   * Get competencia
   * @return competencia
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getCompetencia() {
    return competencia;
  }

  public void setCompetencia(BigDecimal competencia) {
    this.competencia = competencia;
  }

  public IdentificacionsCompetencies identificacio(BigDecimal identificacio) {
    this.identificacio = identificacio;
    return this;
  }

   /**
   * Get identificacio
   * @return identificacio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIdentificacio() {
    return identificacio;
  }

  public void setIdentificacio(BigDecimal identificacio) {
    this.identificacio = identificacio;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentificacionsCompetencies identificacionsCompetencies = (IdentificacionsCompetencies) o;
    return Objects.equals(this.competencia, identificacionsCompetencies.competencia) &&
        Objects.equals(this.identificacio, identificacionsCompetencies.identificacio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(competencia, identificacio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentificacionsCompetencies {\n");
    
    sb.append("    competencia: ").append(toIndentedString(competencia)).append("\n");
    sb.append("    identificacio: ").append(toIndentedString(identificacio)).append("\n");
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

