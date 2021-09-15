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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * GestionarAvisosPerAccio
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-15T11:38:28.065+02:00")
public class GestionarAvisosPerAccio {
  @JsonProperty("idAccio")
  private BigDecimal idAccio = null;

  public GestionarAvisosPerAccio idAccio(BigDecimal idAccio) {
    this.idAccio = idAccio;
    return this;
  }

   /**
   * Identificador de l&#39;acció
   * @return idAccio
  **/
  @ApiModelProperty(value = "Identificador de l'acció")
  public BigDecimal getIdAccio() {
    return idAccio;
  }

  public void setIdAccio(BigDecimal idAccio) {
    this.idAccio = idAccio;
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
    return Objects.equals(this.idAccio, gestionarAvisosPerAccio.idAccio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAccio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GestionarAvisosPerAccio {\n");
    
    sb.append("    idAccio: ").append(toIndentedString(idAccio)).append("\n");
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

