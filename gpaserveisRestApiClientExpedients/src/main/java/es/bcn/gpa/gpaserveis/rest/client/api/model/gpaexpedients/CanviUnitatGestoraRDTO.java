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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Comentaris;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DropdownItemBDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CanviUnitatGestoraRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-02-12T16:26:20.375+01:00")
public class CanviUnitatGestoraRDTO {
  @JsonProperty("comentari")
  private Comentaris comentari = null;

  @JsonProperty("unitatGestoraActual")
  private DropdownItemBDTO unitatGestoraActual = null;

  @JsonProperty("unitatGestoraFutura")
  private DropdownItemBDTO unitatGestoraFutura = null;

  public CanviUnitatGestoraRDTO comentari(Comentaris comentari) {
    this.comentari = comentari;
    return this;
  }

   /**
   * Get comentari
   * @return comentari
  **/
  @ApiModelProperty(value = "")
  public Comentaris getComentari() {
    return comentari;
  }

  public void setComentari(Comentaris comentari) {
    this.comentari = comentari;
  }

  public CanviUnitatGestoraRDTO unitatGestoraActual(DropdownItemBDTO unitatGestoraActual) {
    this.unitatGestoraActual = unitatGestoraActual;
    return this;
  }

   /**
   * Get unitatGestoraActual
   * @return unitatGestoraActual
  **/
  @ApiModelProperty(value = "")
  public DropdownItemBDTO getUnitatGestoraActual() {
    return unitatGestoraActual;
  }

  public void setUnitatGestoraActual(DropdownItemBDTO unitatGestoraActual) {
    this.unitatGestoraActual = unitatGestoraActual;
  }

  public CanviUnitatGestoraRDTO unitatGestoraFutura(DropdownItemBDTO unitatGestoraFutura) {
    this.unitatGestoraFutura = unitatGestoraFutura;
    return this;
  }

   /**
   * Get unitatGestoraFutura
   * @return unitatGestoraFutura
  **/
  @ApiModelProperty(value = "")
  public DropdownItemBDTO getUnitatGestoraFutura() {
    return unitatGestoraFutura;
  }

  public void setUnitatGestoraFutura(DropdownItemBDTO unitatGestoraFutura) {
    this.unitatGestoraFutura = unitatGestoraFutura;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CanviUnitatGestoraRDTO canviUnitatGestoraRDTO = (CanviUnitatGestoraRDTO) o;
    return Objects.equals(this.comentari, canviUnitatGestoraRDTO.comentari) &&
        Objects.equals(this.unitatGestoraActual, canviUnitatGestoraRDTO.unitatGestoraActual) &&
        Objects.equals(this.unitatGestoraFutura, canviUnitatGestoraRDTO.unitatGestoraFutura);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comentari, unitatGestoraActual, unitatGestoraFutura);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CanviUnitatGestoraRDTO {\n");
    
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
    sb.append("    unitatGestoraActual: ").append(toIndentedString(unitatGestoraActual)).append("\n");
    sb.append("    unitatGestoraFutura: ").append(toIndentedString(unitatGestoraFutura)).append("\n");
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

