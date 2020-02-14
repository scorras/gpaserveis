/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.16.2
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
 * SollicitudActualitzarRegistre
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-02-14T12:29:56.498+01:00")
public class SollicitudActualitzarRegistre {
  @JsonProperty("idRegistre")
  private BigDecimal idRegistre = null;

  @JsonProperty("idSollicitud")
  private BigDecimal idSollicitud = null;

  public SollicitudActualitzarRegistre idRegistre(BigDecimal idRegistre) {
    this.idRegistre = idRegistre;
    return this;
  }

   /**
   * Identificador del registre
   * @return idRegistre
  **/
  @ApiModelProperty(value = "Identificador del registre")
  public BigDecimal getIdRegistre() {
    return idRegistre;
  }

  public void setIdRegistre(BigDecimal idRegistre) {
    this.idRegistre = idRegistre;
  }

  public SollicitudActualitzarRegistre idSollicitud(BigDecimal idSollicitud) {
    this.idSollicitud = idSollicitud;
    return this;
  }

   /**
   * Identificador de la sol·licitud
   * @return idSollicitud
  **/
  @ApiModelProperty(value = "Identificador de la sol·licitud")
  public BigDecimal getIdSollicitud() {
    return idSollicitud;
  }

  public void setIdSollicitud(BigDecimal idSollicitud) {
    this.idSollicitud = idSollicitud;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SollicitudActualitzarRegistre sollicitudActualitzarRegistre = (SollicitudActualitzarRegistre) o;
    return Objects.equals(this.idRegistre, sollicitudActualitzarRegistre.idRegistre) &&
        Objects.equals(this.idSollicitud, sollicitudActualitzarRegistre.idSollicitud);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRegistre, idSollicitud);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SollicitudActualitzarRegistre {\n");
    
    sb.append("    idRegistre: ").append(toIndentedString(idRegistre)).append("\n");
    sb.append("    idSollicitud: ").append(toIndentedString(idSollicitud)).append("\n");
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

