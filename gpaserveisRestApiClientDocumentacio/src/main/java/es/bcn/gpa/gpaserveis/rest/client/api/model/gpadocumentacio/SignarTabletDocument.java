/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 2.5.3
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
 * SignarTabletDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-17T17:20:36.241+02:00")
public class SignarTabletDocument {
  @JsonProperty("documentIdentitatUsuari")
  private String documentIdentitatUsuari = null;

  @JsonProperty("idDocument")
  private BigDecimal idDocument = null;

  @JsonProperty("idTabletUsuari")
  private String idTabletUsuari = null;

  @JsonProperty("nomUsuari")
  private String nomUsuari = null;

  @JsonProperty("politicaSignatura")
  private String politicaSignatura = null;

  @JsonProperty("tipusDocumentIdentitat")
  private String tipusDocumentIdentitat = null;

  public SignarTabletDocument documentIdentitatUsuari(String documentIdentitatUsuari) {
    this.documentIdentitatUsuari = documentIdentitatUsuari;
    return this;
  }

   /**
   * Document identitat de l&#39;usuari
   * @return documentIdentitatUsuari
  **/
  @ApiModelProperty(value = "Document identitat de l'usuari")
  public String getDocumentIdentitatUsuari() {
    return documentIdentitatUsuari;
  }

  public void setDocumentIdentitatUsuari(String documentIdentitatUsuari) {
    this.documentIdentitatUsuari = documentIdentitatUsuari;
  }

  public SignarTabletDocument idDocument(BigDecimal idDocument) {
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

  public SignarTabletDocument idTabletUsuari(String idTabletUsuari) {
    this.idTabletUsuari = idTabletUsuari;
    return this;
  }

   /**
   * Identificador de la tauleta on signarà l&#39;usuari
   * @return idTabletUsuari
  **/
  @ApiModelProperty(value = "Identificador de la tauleta on signarà l'usuari")
  public String getIdTabletUsuari() {
    return idTabletUsuari;
  }

  public void setIdTabletUsuari(String idTabletUsuari) {
    this.idTabletUsuari = idTabletUsuari;
  }

  public SignarTabletDocument nomUsuari(String nomUsuari) {
    this.nomUsuari = nomUsuari;
    return this;
  }

   /**
   * Nom de l&#39;usuari
   * @return nomUsuari
  **/
  @ApiModelProperty(value = "Nom de l'usuari")
  public String getNomUsuari() {
    return nomUsuari;
  }

  public void setNomUsuari(String nomUsuari) {
    this.nomUsuari = nomUsuari;
  }

  public SignarTabletDocument politicaSignatura(String politicaSignatura) {
    this.politicaSignatura = politicaSignatura;
    return this;
  }

   /**
   * Nom de la política de signatura
   * @return politicaSignatura
  **/
  @ApiModelProperty(value = "Nom de la política de signatura")
  public String getPoliticaSignatura() {
    return politicaSignatura;
  }

  public void setPoliticaSignatura(String politicaSignatura) {
    this.politicaSignatura = politicaSignatura;
  }

  public SignarTabletDocument tipusDocumentIdentitat(String tipusDocumentIdentitat) {
    this.tipusDocumentIdentitat = tipusDocumentIdentitat;
    return this;
  }

   /**
   * Tipus document identitat de l&#39;usuari
   * @return tipusDocumentIdentitat
  **/
  @ApiModelProperty(value = "Tipus document identitat de l'usuari")
  public String getTipusDocumentIdentitat() {
    return tipusDocumentIdentitat;
  }

  public void setTipusDocumentIdentitat(String tipusDocumentIdentitat) {
    this.tipusDocumentIdentitat = tipusDocumentIdentitat;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignarTabletDocument signarTabletDocument = (SignarTabletDocument) o;
    return Objects.equals(this.documentIdentitatUsuari, signarTabletDocument.documentIdentitatUsuari) &&
        Objects.equals(this.idDocument, signarTabletDocument.idDocument) &&
        Objects.equals(this.idTabletUsuari, signarTabletDocument.idTabletUsuari) &&
        Objects.equals(this.nomUsuari, signarTabletDocument.nomUsuari) &&
        Objects.equals(this.politicaSignatura, signarTabletDocument.politicaSignatura) &&
        Objects.equals(this.tipusDocumentIdentitat, signarTabletDocument.tipusDocumentIdentitat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documentIdentitatUsuari, idDocument, idTabletUsuari, nomUsuari, politicaSignatura, tipusDocumentIdentitat);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignarTabletDocument {\n");
    
    sb.append("    documentIdentitatUsuari: ").append(toIndentedString(documentIdentitatUsuari)).append("\n");
    sb.append("    idDocument: ").append(toIndentedString(idDocument)).append("\n");
    sb.append("    idTabletUsuari: ").append(toIndentedString(idTabletUsuari)).append("\n");
    sb.append("    nomUsuari: ").append(toIndentedString(nomUsuari)).append("\n");
    sb.append("    politicaSignatura: ").append(toIndentedString(politicaSignatura)).append("\n");
    sb.append("    tipusDocumentIdentitat: ").append(toIndentedString(tipusDocumentIdentitat)).append("\n");
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

