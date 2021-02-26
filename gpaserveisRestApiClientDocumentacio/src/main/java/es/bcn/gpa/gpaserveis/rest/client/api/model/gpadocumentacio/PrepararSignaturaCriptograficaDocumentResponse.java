/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.26.4
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
 * PrepararSignaturaCriptograficaDocumentResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-11-18T16:33:07.627+01:00")
public class PrepararSignaturaCriptograficaDocumentResponse {
  @JsonProperty("codiError")
  private Integer codiError = null;

  @JsonProperty("descError")
  private String descError = null;

  @JsonProperty("idPeticio")
  private String idPeticio = null;

  @JsonProperty("urlSignaturaBrowser")
  private String urlSignaturaBrowser = null;

  public PrepararSignaturaCriptograficaDocumentResponse codiError(Integer codiError) {
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

  public PrepararSignaturaCriptograficaDocumentResponse descError(String descError) {
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

  public PrepararSignaturaCriptograficaDocumentResponse idPeticio(String idPeticio) {
    this.idPeticio = idPeticio;
    return this;
  }

   /**
   * Identificador de la petició de signatura
   * @return idPeticio
  **/
  @ApiModelProperty(value = "Identificador de la petició de signatura")
  public String getIdPeticio() {
    return idPeticio;
  }

  public void setIdPeticio(String idPeticio) {
    this.idPeticio = idPeticio;
  }

  public PrepararSignaturaCriptograficaDocumentResponse urlSignaturaBrowser(String urlSignaturaBrowser) {
    this.urlSignaturaBrowser = urlSignaturaBrowser;
    return this;
  }

   /**
   * URL de redirecció a client per a la signatura
   * @return urlSignaturaBrowser
  **/
  @ApiModelProperty(value = "URL de redirecció a client per a la signatura")
  public String getUrlSignaturaBrowser() {
    return urlSignaturaBrowser;
  }

  public void setUrlSignaturaBrowser(String urlSignaturaBrowser) {
    this.urlSignaturaBrowser = urlSignaturaBrowser;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrepararSignaturaCriptograficaDocumentResponse prepararSignaturaCriptograficaDocumentResponse = (PrepararSignaturaCriptograficaDocumentResponse) o;
    return Objects.equals(this.codiError, prepararSignaturaCriptograficaDocumentResponse.codiError) &&
        Objects.equals(this.descError, prepararSignaturaCriptograficaDocumentResponse.descError) &&
        Objects.equals(this.idPeticio, prepararSignaturaCriptograficaDocumentResponse.idPeticio) &&
        Objects.equals(this.urlSignaturaBrowser, prepararSignaturaCriptograficaDocumentResponse.urlSignaturaBrowser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiError, descError, idPeticio, urlSignaturaBrowser);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrepararSignaturaCriptograficaDocumentResponse {\n");
    
    sb.append("    codiError: ").append(toIndentedString(codiError)).append("\n");
    sb.append("    descError: ").append(toIndentedString(descError)).append("\n");
    sb.append("    idPeticio: ").append(toIndentedString(idPeticio)).append("\n");
    sb.append("    urlSignaturaBrowser: ").append(toIndentedString(urlSignaturaBrowser)).append("\n");
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
