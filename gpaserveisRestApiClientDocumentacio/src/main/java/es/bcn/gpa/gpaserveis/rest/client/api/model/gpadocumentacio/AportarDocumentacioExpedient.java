/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.6.1
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * AportarDocumentacioExpedient
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-14T13:42:45.795+01:00")
public class AportarDocumentacioExpedient {
  @JsonProperty("docsEntrada")
  private List<DocsEntradaRDTO> docsEntrada = null;

  public AportarDocumentacioExpedient docsEntrada(List<DocsEntradaRDTO> docsEntrada) {
    this.docsEntrada = docsEntrada;
    return this;
  }

  public AportarDocumentacioExpedient addDocsEntradaItem(DocsEntradaRDTO docsEntradaItem) {
    if (this.docsEntrada == null) {
      this.docsEntrada = new ArrayList<DocsEntradaRDTO>();
    }
    this.docsEntrada.add(docsEntradaItem);
    return this;
  }

   /**
   * Documents a aportar a l&#39;expedient
   * @return docsEntrada
  **/
  @ApiModelProperty(value = "Documents a aportar a l'expedient")
  public List<DocsEntradaRDTO> getDocsEntrada() {
    return docsEntrada;
  }

  public void setDocsEntrada(List<DocsEntradaRDTO> docsEntrada) {
    this.docsEntrada = docsEntrada;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AportarDocumentacioExpedient aportarDocumentacioExpedient = (AportarDocumentacioExpedient) o;
    return Objects.equals(this.docsEntrada, aportarDocumentacioExpedient.docsEntrada);
  }

  @Override
  public int hashCode() {
    return Objects.hash(docsEntrada);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AportarDocumentacioExpedient {\n");
    
    sb.append("    docsEntrada: ").append(toIndentedString(docsEntrada)).append("\n");
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

