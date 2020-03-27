/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.20.0
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
 * SignarTabletDocumentResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-03-25T13:12:16.537+01:00")
public class SignarTabletDocumentResponse {
  @JsonProperty("codiError")
  private Integer codiError = null;

  @JsonProperty("descError")
  private String descError = null;

  public SignarTabletDocumentResponse codiError(Integer codiError) {
    this.codiError = codiError;
    return this;
  }

   /**
   * Codi de l&#39;error
   * @return codiError
  **/
  @ApiModelProperty(value = "Codi de l'error")
  public Integer getCodiError() {
    return codiError;
  }

  public void setCodiError(Integer codiError) {
    this.codiError = codiError;
  }

  public SignarTabletDocumentResponse descError(String descError) {
    this.descError = descError;
    return this;
  }

   /**
   * Descripció de l&#39;error
   * @return descError
  **/
  @ApiModelProperty(value = "Descripció de l'error")
  public String getDescError() {
    return descError;
  }

  public void setDescError(String descError) {
    this.descError = descError;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignarTabletDocumentResponse signarTabletDocumentResponse = (SignarTabletDocumentResponse) o;
    return Objects.equals(this.codiError, signarTabletDocumentResponse.codiError) &&
        Objects.equals(this.descError, signarTabletDocumentResponse.descError);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiError, descError);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignarTabletDocumentResponse {\n");
    
    sb.append("    codiError: ").append(toIndentedString(codiError)).append("\n");
    sb.append("    descError: ").append(toIndentedString(descError)).append("\n");
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

