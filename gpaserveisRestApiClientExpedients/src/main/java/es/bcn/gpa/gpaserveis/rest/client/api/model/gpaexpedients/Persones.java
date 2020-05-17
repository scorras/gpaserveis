/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.21.0
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DocumentsIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesDadescontacte;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * Persones
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-13T12:48:59.755+02:00")
public class Persones {
  @JsonProperty("cognom1")
  private String cognom1 = null;

  @JsonProperty("cognom2")
  private String cognom2 = null;

  @JsonProperty("dadesContacte")
  private BigDecimal dadesContacte = null;

  @JsonProperty("docIndentitat")
  private BigDecimal docIndentitat = null;

  @JsonProperty("documentsIdentitat")
  private DocumentsIdentitat documentsIdentitat = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("nomPresentacio")
  private String nomPresentacio = null;

  @JsonProperty("nomRaoSocial")
  private String nomRaoSocial = null;

  @JsonProperty("personesDadescontacte")
  private PersonesDadescontacte personesDadescontacte = null;

  @JsonProperty("tipusPersona")
  private BigDecimal tipusPersona = null;

  public Persones cognom1(String cognom1) {
    this.cognom1 = cognom1;
    return this;
  }

   /**
   * Get cognom1
   * @return cognom1
  **/
  @ApiModelProperty(value = "")
  public String getCognom1() {
    return cognom1;
  }

  public void setCognom1(String cognom1) {
    this.cognom1 = cognom1;
  }

  public Persones cognom2(String cognom2) {
    this.cognom2 = cognom2;
    return this;
  }

   /**
   * Get cognom2
   * @return cognom2
  **/
  @ApiModelProperty(value = "")
  public String getCognom2() {
    return cognom2;
  }

  public void setCognom2(String cognom2) {
    this.cognom2 = cognom2;
  }

  public Persones dadesContacte(BigDecimal dadesContacte) {
    this.dadesContacte = dadesContacte;
    return this;
  }

   /**
   * Get dadesContacte
   * @return dadesContacte
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDadesContacte() {
    return dadesContacte;
  }

  public void setDadesContacte(BigDecimal dadesContacte) {
    this.dadesContacte = dadesContacte;
  }

  public Persones docIndentitat(BigDecimal docIndentitat) {
    this.docIndentitat = docIndentitat;
    return this;
  }

   /**
   * Get docIndentitat
   * @return docIndentitat
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDocIndentitat() {
    return docIndentitat;
  }

  public void setDocIndentitat(BigDecimal docIndentitat) {
    this.docIndentitat = docIndentitat;
  }

  public Persones documentsIdentitat(DocumentsIdentitat documentsIdentitat) {
    this.documentsIdentitat = documentsIdentitat;
    return this;
  }

   /**
   * Get documentsIdentitat
   * @return documentsIdentitat
  **/
  @ApiModelProperty(value = "")
  public DocumentsIdentitat getDocumentsIdentitat() {
    return documentsIdentitat;
  }

  public void setDocumentsIdentitat(DocumentsIdentitat documentsIdentitat) {
    this.documentsIdentitat = documentsIdentitat;
  }

  public Persones id(BigDecimal id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Persones nomPresentacio(String nomPresentacio) {
    this.nomPresentacio = nomPresentacio;
    return this;
  }

   /**
   * Get nomPresentacio
   * @return nomPresentacio
  **/
  @ApiModelProperty(value = "")
  public String getNomPresentacio() {
    return nomPresentacio;
  }

  public void setNomPresentacio(String nomPresentacio) {
    this.nomPresentacio = nomPresentacio;
  }

  public Persones nomRaoSocial(String nomRaoSocial) {
    this.nomRaoSocial = nomRaoSocial;
    return this;
  }

   /**
   * Get nomRaoSocial
   * @return nomRaoSocial
  **/
  @ApiModelProperty(value = "")
  public String getNomRaoSocial() {
    return nomRaoSocial;
  }

  public void setNomRaoSocial(String nomRaoSocial) {
    this.nomRaoSocial = nomRaoSocial;
  }

  public Persones personesDadescontacte(PersonesDadescontacte personesDadescontacte) {
    this.personesDadescontacte = personesDadescontacte;
    return this;
  }

   /**
   * Get personesDadescontacte
   * @return personesDadescontacte
  **/
  @ApiModelProperty(value = "")
  public PersonesDadescontacte getPersonesDadescontacte() {
    return personesDadescontacte;
  }

  public void setPersonesDadescontacte(PersonesDadescontacte personesDadescontacte) {
    this.personesDadescontacte = personesDadescontacte;
  }

  public Persones tipusPersona(BigDecimal tipusPersona) {
    this.tipusPersona = tipusPersona;
    return this;
  }

   /**
   * Get tipusPersona
   * @return tipusPersona
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getTipusPersona() {
    return tipusPersona;
  }

  public void setTipusPersona(BigDecimal tipusPersona) {
    this.tipusPersona = tipusPersona;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Persones persones = (Persones) o;
    return Objects.equals(this.cognom1, persones.cognom1) &&
        Objects.equals(this.cognom2, persones.cognom2) &&
        Objects.equals(this.dadesContacte, persones.dadesContacte) &&
        Objects.equals(this.docIndentitat, persones.docIndentitat) &&
        Objects.equals(this.documentsIdentitat, persones.documentsIdentitat) &&
        Objects.equals(this.id, persones.id) &&
        Objects.equals(this.nomPresentacio, persones.nomPresentacio) &&
        Objects.equals(this.nomRaoSocial, persones.nomRaoSocial) &&
        Objects.equals(this.personesDadescontacte, persones.personesDadescontacte) &&
        Objects.equals(this.tipusPersona, persones.tipusPersona);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cognom1, cognom2, dadesContacte, docIndentitat, documentsIdentitat, id, nomPresentacio, nomRaoSocial, personesDadescontacte, tipusPersona);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Persones {\n");
    
    sb.append("    cognom1: ").append(toIndentedString(cognom1)).append("\n");
    sb.append("    cognom2: ").append(toIndentedString(cognom2)).append("\n");
    sb.append("    dadesContacte: ").append(toIndentedString(dadesContacte)).append("\n");
    sb.append("    docIndentitat: ").append(toIndentedString(docIndentitat)).append("\n");
    sb.append("    documentsIdentitat: ").append(toIndentedString(documentsIdentitat)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nomPresentacio: ").append(toIndentedString(nomPresentacio)).append("\n");
    sb.append("    nomRaoSocial: ").append(toIndentedString(nomRaoSocial)).append("\n");
    sb.append("    personesDadescontacte: ").append(toIndentedString(personesDadescontacte)).append("\n");
    sb.append("    tipusPersona: ").append(toIndentedString(tipusPersona)).append("\n");
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

