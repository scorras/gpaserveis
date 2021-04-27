/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 2.0.0
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
 * IdentificacionsFamilies
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-27T15:52:38.756+02:00")
public class IdentificacionsFamilies {
  @JsonProperty("familia")
  private BigDecimal familia = null;

  @JsonProperty("identificacio")
  private BigDecimal identificacio = null;

  public IdentificacionsFamilies familia(BigDecimal familia) {
    this.familia = familia;
    return this;
  }

   /**
   * Get familia
   * @return familia
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getFamilia() {
    return familia;
  }

  public void setFamilia(BigDecimal familia) {
    this.familia = familia;
  }

  public IdentificacionsFamilies identificacio(BigDecimal identificacio) {
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
    IdentificacionsFamilies identificacionsFamilies = (IdentificacionsFamilies) o;
    return Objects.equals(this.familia, identificacionsFamilies.familia) &&
        Objects.equals(this.identificacio, identificacionsFamilies.identificacio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(familia, identificacio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentificacionsFamilies {\n");
    
    sb.append("    familia: ").append(toIndentedString(familia)).append("\n");
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

