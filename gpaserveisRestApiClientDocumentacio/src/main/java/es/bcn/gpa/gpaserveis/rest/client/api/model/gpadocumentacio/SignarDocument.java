/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.13.2
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.UsuariPortaSig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * SignarDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-24T01:04:59.179+02:00")
public class SignarDocument {
  @JsonProperty("accio")
  private BigDecimal accio = null;

  @JsonProperty("listIdDocument")
  private List<BigDecimal> listIdDocument = null;

  @JsonProperty("unitatGestoraIdext")
  private BigDecimal unitatGestoraIdext = null;

  @JsonProperty("usuariPortaSig")
  private UsuariPortaSig usuariPortaSig = null;

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

  public SignarDocument listIdDocument(List<BigDecimal> listIdDocument) {
    this.listIdDocument = listIdDocument;
    return this;
  }

  public SignarDocument addListIdDocumentItem(BigDecimal listIdDocumentItem) {
    if (this.listIdDocument == null) {
      this.listIdDocument = new ArrayList<BigDecimal>();
    }
    this.listIdDocument.add(listIdDocumentItem);
    return this;
  }

   /**
   * Llista d&#39;identificadors dels documents
   * @return listIdDocument
  **/
  @ApiModelProperty(value = "Llista d'identificadors dels documents")
  public List<BigDecimal> getListIdDocument() {
    return listIdDocument;
  }

  public void setListIdDocument(List<BigDecimal> listIdDocument) {
    this.listIdDocument = listIdDocument;
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

  public SignarDocument usuariPortaSig(UsuariPortaSig usuariPortaSig) {
    this.usuariPortaSig = usuariPortaSig;
    return this;
  }

   /**
   * Usuari que va realitzar l&#39;acció
   * @return usuariPortaSig
  **/
  @ApiModelProperty(value = "Usuari que va realitzar l'acció")
  public UsuariPortaSig getUsuariPortaSig() {
    return usuariPortaSig;
  }

  public void setUsuariPortaSig(UsuariPortaSig usuariPortaSig) {
    this.usuariPortaSig = usuariPortaSig;
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
        Objects.equals(this.listIdDocument, signarDocument.listIdDocument) &&
        Objects.equals(this.unitatGestoraIdext, signarDocument.unitatGestoraIdext) &&
        Objects.equals(this.usuariPortaSig, signarDocument.usuariPortaSig);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accio, listIdDocument, unitatGestoraIdext, usuariPortaSig);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignarDocument {\n");
    
    sb.append("    accio: ").append(toIndentedString(accio)).append("\n");
    sb.append("    listIdDocument: ").append(toIndentedString(listIdDocument)).append("\n");
    sb.append("    unitatGestoraIdext: ").append(toIndentedString(unitatGestoraIdext)).append("\n");
    sb.append("    usuariPortaSig: ").append(toIndentedString(usuariPortaSig)).append("\n");
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

