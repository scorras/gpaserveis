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
import java.math.BigDecimal;

/**
 * TipusAvisosRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-08T14:08:13.234+02:00")
public class TipusAvisosRDTO {
  @JsonProperty("avis")
  private String avis = null;

  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  public TipusAvisosRDTO avis(String avis) {
    this.avis = avis;
    return this;
  }

   /**
   * Get avis
   * @return avis
  **/
  @ApiModelProperty(value = "")
  public String getAvis() {
    return avis;
  }

  public void setAvis(String avis) {
    this.avis = avis;
  }

  public TipusAvisosRDTO descripcio(String descripcio) {
    this.descripcio = descripcio;
    return this;
  }

   /**
   * Get descripcio
   * @return descripcio
  **/
  @ApiModelProperty(value = "")
  public String getDescripcio() {
    return descripcio;
  }

  public void setDescripcio(String descripcio) {
    this.descripcio = descripcio;
  }

  public TipusAvisosRDTO id(BigDecimal id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
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
    TipusAvisosRDTO tipusAvisosRDTO = (TipusAvisosRDTO) o;
    return Objects.equals(this.avis, tipusAvisosRDTO.avis) &&
        Objects.equals(this.descripcio, tipusAvisosRDTO.descripcio) &&
        Objects.equals(this.id, tipusAvisosRDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(avis, descripcio, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TipusAvisosRDTO {\n");
    
    sb.append("    avis: ").append(toIndentedString(avis)).append("\n");
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
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

