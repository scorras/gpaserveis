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
import java.math.BigDecimal;

/**
 * DocumentActualizarRegistre
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-19T16:12:57.396+02:00")
public class DocumentActualizarRegistre {
  @JsonProperty("idDoc")
  private BigDecimal idDoc = null;

  @JsonProperty("idRegistre")
  private BigDecimal idRegistre = null;

  public DocumentActualizarRegistre idDoc(BigDecimal idDoc) {
    this.idDoc = idDoc;
    return this;
  }

   /**
   * Identificador de la documentació de l&#39;expedient
   * @return idDoc
  **/
  @ApiModelProperty(value = "Identificador de la documentació de l'expedient")
  public BigDecimal getIdDoc() {
    return idDoc;
  }

  public void setIdDoc(BigDecimal idDoc) {
    this.idDoc = idDoc;
  }

  public DocumentActualizarRegistre idRegistre(BigDecimal idRegistre) {
    this.idRegistre = idRegistre;
    return this;
  }

   /**
   * Identificador del registre
   * @return idRegistre
  **/
  @ApiModelProperty(value = "Identificador del registre")
  public BigDecimal getIdRegistre() {
    return idRegistre;
  }

  public void setIdRegistre(BigDecimal idRegistre) {
    this.idRegistre = idRegistre;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentActualizarRegistre documentActualizarRegistre = (DocumentActualizarRegistre) o;
    return Objects.equals(this.idDoc, documentActualizarRegistre.idDoc) &&
        Objects.equals(this.idRegistre, documentActualizarRegistre.idRegistre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idDoc, idRegistre);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentActualizarRegistre {\n");
    
    sb.append("    idDoc: ").append(toIndentedString(idDoc)).append("\n");
    sb.append("    idRegistre: ").append(toIndentedString(idRegistre)).append("\n");
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

