/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.20.1
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DataSignarDocument;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * SignarDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-15T11:02:22.203+02:00")
public class SignarDocument {
  @JsonProperty("accio")
  private BigDecimal accio = null;

  @JsonProperty("dataSignarDocument")
  private DataSignarDocument dataSignarDocument = null;

  @JsonProperty("idDocument")
  private BigDecimal idDocument = null;

  @JsonProperty("unitatGestoraIdext")
  private BigDecimal unitatGestoraIdext = null;

  public SignarDocument accio(BigDecimal accio) {
    this.accio = accio;
    return this;
  }

   /**
   * Acció a realitzar per l&#39;portafirmas
   * @return accio
  **/
  @ApiModelProperty(value = "Acció a realitzar per l'portafirmas")
  public BigDecimal getAccio() {
    return accio;
  }

  public void setAccio(BigDecimal accio) {
    this.accio = accio;
  }

  public SignarDocument dataSignarDocument(DataSignarDocument dataSignarDocument) {
    this.dataSignarDocument = dataSignarDocument;
    return this;
  }

   /**
   * Informació addicional per a la signatura
   * @return dataSignarDocument
  **/
  @ApiModelProperty(value = "Informació addicional per a la signatura")
  public DataSignarDocument getDataSignarDocument() {
    return dataSignarDocument;
  }

  public void setDataSignarDocument(DataSignarDocument dataSignarDocument) {
    this.dataSignarDocument = dataSignarDocument;
  }

  public SignarDocument idDocument(BigDecimal idDocument) {
    this.idDocument = idDocument;
    return this;
  }

   /**
   * identificador del document
   * @return idDocument
  **/
  @ApiModelProperty(value = "identificador del document")
  public BigDecimal getIdDocument() {
    return idDocument;
  }

  public void setIdDocument(BigDecimal idDocument) {
    this.idDocument = idDocument;
  }

  public SignarDocument unitatGestoraIdext(BigDecimal unitatGestoraIdext) {
    this.unitatGestoraIdext = unitatGestoraIdext;
    return this;
  }

   /**
   * Identificador de la unitat gestora
   * @return unitatGestoraIdext
  **/
  @ApiModelProperty(value = "Identificador de la unitat gestora")
  public BigDecimal getUnitatGestoraIdext() {
    return unitatGestoraIdext;
  }

  public void setUnitatGestoraIdext(BigDecimal unitatGestoraIdext) {
    this.unitatGestoraIdext = unitatGestoraIdext;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignarDocument signarDocument = (SignarDocument) o;
    return Objects.equals(this.accio, signarDocument.accio) &&
        Objects.equals(this.dataSignarDocument, signarDocument.dataSignarDocument) &&
        Objects.equals(this.idDocument, signarDocument.idDocument) &&
        Objects.equals(this.unitatGestoraIdext, signarDocument.unitatGestoraIdext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accio, dataSignarDocument, idDocument, unitatGestoraIdext);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignarDocument {\n");
    
    sb.append("    accio: ").append(toIndentedString(accio)).append("\n");
    sb.append("    dataSignarDocument: ").append(toIndentedString(dataSignarDocument)).append("\n");
    sb.append("    idDocument: ").append(toIndentedString(idDocument)).append("\n");
    sb.append("    unitatGestoraIdext: ").append(toIndentedString(unitatGestoraIdext)).append("\n");
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

