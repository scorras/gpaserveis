/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.11.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * RespostaSincronitzarCheckRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-13T13:50:42.299+02:00")
public class RespostaSincronitzarCheckRDTO {
  @JsonProperty("existSerieDoc")
  private Boolean existSerieDoc = null;

  @JsonProperty("serviceCatalegOK")
  private Boolean serviceCatalegOK = null;

  public RespostaSincronitzarCheckRDTO existSerieDoc(Boolean existSerieDoc) {
    this.existSerieDoc = existSerieDoc;
    return this;
  }

   /**
   * Get existSerieDoc
   * @return existSerieDoc
  **/
  @ApiModelProperty(value = "")
  public Boolean isExistSerieDoc() {
    return existSerieDoc;
  }

  public void setExistSerieDoc(Boolean existSerieDoc) {
    this.existSerieDoc = existSerieDoc;
  }

  public RespostaSincronitzarCheckRDTO serviceCatalegOK(Boolean serviceCatalegOK) {
    this.serviceCatalegOK = serviceCatalegOK;
    return this;
  }

   /**
   * Get serviceCatalegOK
   * @return serviceCatalegOK
  **/
  @ApiModelProperty(value = "")
  public Boolean isServiceCatalegOK() {
    return serviceCatalegOK;
  }

  public void setServiceCatalegOK(Boolean serviceCatalegOK) {
    this.serviceCatalegOK = serviceCatalegOK;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespostaSincronitzarCheckRDTO respostaSincronitzarCheckRDTO = (RespostaSincronitzarCheckRDTO) o;
    return Objects.equals(this.existSerieDoc, respostaSincronitzarCheckRDTO.existSerieDoc) &&
        Objects.equals(this.serviceCatalegOK, respostaSincronitzarCheckRDTO.serviceCatalegOK);
  }

  @Override
  public int hashCode() {
    return Objects.hash(existSerieDoc, serviceCatalegOK);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespostaSincronitzarCheckRDTO {\n");
    
    sb.append("    existSerieDoc: ").append(toIndentedString(existSerieDoc)).append("\n");
    sb.append("    serviceCatalegOK: ").append(toIndentedString(serviceCatalegOK)).append("\n");
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

