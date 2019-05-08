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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AvisCreacioAccio
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-08T13:33:09.050+02:00")
public class AvisCreacioAccio {
  @JsonProperty("operacio")
  private String operacio = null;

  public AvisCreacioAccio operacio(String operacio) {
    this.operacio = operacio;
    return this;
  }

   /**
   * Operació concreta en l&#39;execució de l&#39;acció
   * @return operacio
  **/
  @ApiModelProperty(value = "Operació concreta en l'execució de l'acció")
  public String getOperacio() {
    return operacio;
  }

  public void setOperacio(String operacio) {
    this.operacio = operacio;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvisCreacioAccio avisCreacioAccio = (AvisCreacioAccio) o;
    return Objects.equals(this.operacio, avisCreacioAccio.operacio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operacio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvisCreacioAccio {\n");
    
    sb.append("    operacio: ").append(toIndentedString(operacio)).append("\n");
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

