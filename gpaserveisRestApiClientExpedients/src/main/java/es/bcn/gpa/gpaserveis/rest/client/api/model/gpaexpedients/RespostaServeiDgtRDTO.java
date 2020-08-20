/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.24.4
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
 * RespostaServeiDgtRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-14T10:29:14.606+02:00")
public class RespostaServeiDgtRDTO {
  @JsonProperty("codiError")
  private String codiError = null;

  @JsonProperty("identificadorPropietari")
  private String identificadorPropietari = null;

  @JsonProperty("missatgeError")
  private String missatgeError = null;

  public RespostaServeiDgtRDTO codiError(String codiError) {
    this.codiError = codiError;
    return this;
  }

   /**
   * Get codiError
   * @return codiError
  **/
  @ApiModelProperty(value = "")
  public String getCodiError() {
    return codiError;
  }

  public void setCodiError(String codiError) {
    this.codiError = codiError;
  }

  public RespostaServeiDgtRDTO identificadorPropietari(String identificadorPropietari) {
    this.identificadorPropietari = identificadorPropietari;
    return this;
  }

   /**
   * Get identificadorPropietari
   * @return identificadorPropietari
  **/
  @ApiModelProperty(value = "")
  public String getIdentificadorPropietari() {
    return identificadorPropietari;
  }

  public void setIdentificadorPropietari(String identificadorPropietari) {
    this.identificadorPropietari = identificadorPropietari;
  }

  public RespostaServeiDgtRDTO missatgeError(String missatgeError) {
    this.missatgeError = missatgeError;
    return this;
  }

   /**
   * Get missatgeError
   * @return missatgeError
  **/
  @ApiModelProperty(value = "")
  public String getMissatgeError() {
    return missatgeError;
  }

  public void setMissatgeError(String missatgeError) {
    this.missatgeError = missatgeError;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespostaServeiDgtRDTO respostaServeiDgtRDTO = (RespostaServeiDgtRDTO) o;
    return Objects.equals(this.codiError, respostaServeiDgtRDTO.codiError) &&
        Objects.equals(this.identificadorPropietari, respostaServeiDgtRDTO.identificadorPropietari) &&
        Objects.equals(this.missatgeError, respostaServeiDgtRDTO.missatgeError);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiError, identificadorPropietari, missatgeError);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespostaServeiDgtRDTO {\n");
    
    sb.append("    codiError: ").append(toIndentedString(codiError)).append("\n");
    sb.append("    identificadorPropietari: ").append(toIndentedString(identificadorPropietari)).append("\n");
    sb.append("    missatgeError: ").append(toIndentedString(missatgeError)).append("\n");
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

