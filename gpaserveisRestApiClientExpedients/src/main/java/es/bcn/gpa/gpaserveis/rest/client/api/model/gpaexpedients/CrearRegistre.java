/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 2.1.0
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * CrearRegistre
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-08T17:57:51.146+02:00")
public class CrearRegistre {
  @JsonProperty("documents")
  private List<BigDecimal> documents = null;

  @JsonProperty("expedient")
  private ExpedientsRDTO expedient = null;

  @JsonProperty("matriculaInformador")
  private String matriculaInformador = null;

  public CrearRegistre documents(List<BigDecimal> documents) {
    this.documents = documents;
    return this;
  }

  public CrearRegistre addDocumentsItem(BigDecimal documentsItem) {
    if (this.documents == null) {
      this.documents = new ArrayList<BigDecimal>();
    }
    this.documents.add(documentsItem);
    return this;
  }

   /**
   * Identificador dels documents
   * @return documents
  **/
  @ApiModelProperty(value = "Identificador dels documents")
  public List<BigDecimal> getDocuments() {
    return documents;
  }

  public void setDocuments(List<BigDecimal> documents) {
    this.documents = documents;
  }

  public CrearRegistre expedient(ExpedientsRDTO expedient) {
    this.expedient = expedient;
    return this;
  }

   /**
   * Dades de l&#39;expedient
   * @return expedient
  **/
  @ApiModelProperty(value = "Dades de l'expedient")
  public ExpedientsRDTO getExpedient() {
    return expedient;
  }

  public void setExpedient(ExpedientsRDTO expedient) {
    this.expedient = expedient;
  }

  public CrearRegistre matriculaInformador(String matriculaInformador) {
    this.matriculaInformador = matriculaInformador;
    return this;
  }

   /**
   * Matrícula de l&#39;informador
   * @return matriculaInformador
  **/
  @ApiModelProperty(value = "Matrícula de l'informador")
  public String getMatriculaInformador() {
    return matriculaInformador;
  }

  public void setMatriculaInformador(String matriculaInformador) {
    this.matriculaInformador = matriculaInformador;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrearRegistre crearRegistre = (CrearRegistre) o;
    return Objects.equals(this.documents, crearRegistre.documents) &&
        Objects.equals(this.expedient, crearRegistre.expedient) &&
        Objects.equals(this.matriculaInformador, crearRegistre.matriculaInformador);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documents, expedient, matriculaInformador);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrearRegistre {\n");
    
    sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
    sb.append("    expedient: ").append(toIndentedString(expedient)).append("\n");
    sb.append("    matriculaInformador: ").append(toIndentedString(matriculaInformador)).append("\n");
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

