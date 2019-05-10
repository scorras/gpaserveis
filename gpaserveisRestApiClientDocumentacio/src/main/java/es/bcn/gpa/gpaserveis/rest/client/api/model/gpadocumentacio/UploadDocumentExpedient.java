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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * UploadDocumentExpedient
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-10T10:06:30.608+02:00")
public class UploadDocumentExpedient {
  @JsonProperty("docEntrada")
  private DocsEntradaRDTO docEntrada = null;

  public UploadDocumentExpedient docEntrada(DocsEntradaRDTO docEntrada) {
    this.docEntrada = docEntrada;
    return this;
  }

   /**
   * Document a upload en l&#39;expedient
   * @return docEntrada
  **/
  @ApiModelProperty(value = "Document a upload en l'expedient")
  public DocsEntradaRDTO getDocEntrada() {
    return docEntrada;
  }

  public void setDocEntrada(DocsEntradaRDTO docEntrada) {
    this.docEntrada = docEntrada;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadDocumentExpedient uploadDocumentExpedient = (UploadDocumentExpedient) o;
    return Objects.equals(this.docEntrada, uploadDocumentExpedient.docEntrada);
  }

  @Override
  public int hashCode() {
    return Objects.hash(docEntrada);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadDocumentExpedient {\n");
    
    sb.append("    docEntrada: ").append(toIndentedString(docEntrada)).append("\n");
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

