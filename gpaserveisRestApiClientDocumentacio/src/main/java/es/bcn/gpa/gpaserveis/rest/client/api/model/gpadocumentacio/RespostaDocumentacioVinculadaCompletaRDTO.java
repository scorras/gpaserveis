/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.12.0
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
import java.util.ArrayList;
import java.util.List;

/**
 * RespostaDocumentacioVinculadaCompletaRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-10T19:27:34.899+02:00")
public class RespostaDocumentacioVinculadaCompletaRDTO {
  @JsonProperty("completa")
  private Boolean completa = null;

  @JsonProperty("documentacioVinculadaNoExistentList")
  private List<String> documentacioVinculadaNoExistentList = null;

  public RespostaDocumentacioVinculadaCompletaRDTO completa(Boolean completa) {
    this.completa = completa;
    return this;
  }

   /**
   * Get completa
   * @return completa
  **/
  @ApiModelProperty(value = "")
  public Boolean isCompleta() {
    return completa;
  }

  public void setCompleta(Boolean completa) {
    this.completa = completa;
  }

  public RespostaDocumentacioVinculadaCompletaRDTO documentacioVinculadaNoExistentList(List<String> documentacioVinculadaNoExistentList) {
    this.documentacioVinculadaNoExistentList = documentacioVinculadaNoExistentList;
    return this;
  }

  public RespostaDocumentacioVinculadaCompletaRDTO addDocumentacioVinculadaNoExistentListItem(String documentacioVinculadaNoExistentListItem) {
    if (this.documentacioVinculadaNoExistentList == null) {
      this.documentacioVinculadaNoExistentList = new ArrayList<String>();
    }
    this.documentacioVinculadaNoExistentList.add(documentacioVinculadaNoExistentListItem);
    return this;
  }

   /**
   * Get documentacioVinculadaNoExistentList
   * @return documentacioVinculadaNoExistentList
  **/
  @ApiModelProperty(value = "")
  public List<String> getDocumentacioVinculadaNoExistentList() {
    return documentacioVinculadaNoExistentList;
  }

  public void setDocumentacioVinculadaNoExistentList(List<String> documentacioVinculadaNoExistentList) {
    this.documentacioVinculadaNoExistentList = documentacioVinculadaNoExistentList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespostaDocumentacioVinculadaCompletaRDTO respostaDocumentacioVinculadaCompletaRDTO = (RespostaDocumentacioVinculadaCompletaRDTO) o;
    return Objects.equals(this.completa, respostaDocumentacioVinculadaCompletaRDTO.completa) &&
        Objects.equals(this.documentacioVinculadaNoExistentList, respostaDocumentacioVinculadaCompletaRDTO.documentacioVinculadaNoExistentList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(completa, documentacioVinculadaNoExistentList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespostaDocumentacioVinculadaCompletaRDTO {\n");
    
    sb.append("    completa: ").append(toIndentedString(completa)).append("\n");
    sb.append("    documentacioVinculadaNoExistentList: ").append(toIndentedString(documentacioVinculadaNoExistentList)).append("\n");
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

