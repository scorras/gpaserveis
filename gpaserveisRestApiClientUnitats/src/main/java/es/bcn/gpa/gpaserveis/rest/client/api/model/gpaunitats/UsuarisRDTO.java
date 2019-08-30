/*
 * API gpaunitats
 * API gpaunitats
 *
 * OpenAPI spec version: 1.15.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * UsuarisRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-30T12:06:02.625+02:00")
public class UsuarisRDTO {
  @JsonProperty("carrec")
  private String carrec = null;

  @JsonProperty("cognom1")
  private String cognom1 = null;

  @JsonProperty("cognom2")
  private String cognom2 = null;

  @JsonProperty("documentIdentitat")
  private String documentIdentitat = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("grp")
  private List<String> grp = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("matricula")
  private String matricula = null;

  @JsonProperty("nom")
  private String nom = null;

  public UsuarisRDTO carrec(String carrec) {
    this.carrec = carrec;
    return this;
  }

   /**
   * Get carrec
   * @return carrec
  **/
  @ApiModelProperty(value = "")
  public String getCarrec() {
    return carrec;
  }

  public void setCarrec(String carrec) {
    this.carrec = carrec;
  }

  public UsuarisRDTO cognom1(String cognom1) {
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

  public UsuarisRDTO cognom2(String cognom2) {
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

  public UsuarisRDTO documentIdentitat(String documentIdentitat) {
    this.documentIdentitat = documentIdentitat;
    return this;
  }

   /**
   * Get documentIdentitat
   * @return documentIdentitat
  **/
  @ApiModelProperty(value = "")
  public String getDocumentIdentitat() {
    return documentIdentitat;
  }

  public void setDocumentIdentitat(String documentIdentitat) {
    this.documentIdentitat = documentIdentitat;
  }

  public UsuarisRDTO email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UsuarisRDTO grp(List<String> grp) {
    this.grp = grp;
    return this;
  }

  public UsuarisRDTO addGrpItem(String grpItem) {
    if (this.grp == null) {
      this.grp = new ArrayList<String>();
    }
    this.grp.add(grpItem);
    return this;
  }

   /**
   * Get grp
   * @return grp
  **/
  @ApiModelProperty(value = "")
  public List<String> getGrp() {
    return grp;
  }

  public void setGrp(List<String> grp) {
    this.grp = grp;
  }

  public UsuarisRDTO id(BigDecimal id) {
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

  public UsuarisRDTO matricula(String matricula) {
    this.matricula = matricula;
    return this;
  }

   /**
   * Get matricula
   * @return matricula
  **/
  @ApiModelProperty(value = "")
  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public UsuarisRDTO nom(String nom) {
    this.nom = nom;
    return this;
  }

   /**
   * Get nom
   * @return nom
  **/
  @ApiModelProperty(value = "")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsuarisRDTO usuarisRDTO = (UsuarisRDTO) o;
    return Objects.equals(this.carrec, usuarisRDTO.carrec) &&
        Objects.equals(this.cognom1, usuarisRDTO.cognom1) &&
        Objects.equals(this.cognom2, usuarisRDTO.cognom2) &&
        Objects.equals(this.documentIdentitat, usuarisRDTO.documentIdentitat) &&
        Objects.equals(this.email, usuarisRDTO.email) &&
        Objects.equals(this.grp, usuarisRDTO.grp) &&
        Objects.equals(this.id, usuarisRDTO.id) &&
        Objects.equals(this.matricula, usuarisRDTO.matricula) &&
        Objects.equals(this.nom, usuarisRDTO.nom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carrec, cognom1, cognom2, documentIdentitat, email, grp, id, matricula, nom);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsuarisRDTO {\n");
    
    sb.append("    carrec: ").append(toIndentedString(carrec)).append("\n");
    sb.append("    cognom1: ").append(toIndentedString(cognom1)).append("\n");
    sb.append("    cognom2: ").append(toIndentedString(cognom2)).append("\n");
    sb.append("    documentIdentitat: ").append(toIndentedString(documentIdentitat)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    grp: ").append(toIndentedString(grp)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    matricula: ").append(toIndentedString(matricula)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
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
