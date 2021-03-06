/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 2.11.0
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TipusViesRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-12T12:40:33.333+01:00")
public class TipusViesRDTO {
  @JsonProperty("codi")
  private String codi = null;

  @JsonProperty("codiArvato")
  private String codiArvato = null;

  @JsonProperty("entitat")
  private String entitat = null;

  @JsonProperty("nom")
  private String nom = null;

  public TipusViesRDTO codi(String codi) {
    this.codi = codi;
    return this;
  }

   /**
   * Get codi
   * @return codi
  **/
  @ApiModelProperty(value = "")
  public String getCodi() {
    return codi;
  }

  public void setCodi(String codi) {
    this.codi = codi;
  }

  public TipusViesRDTO codiArvato(String codiArvato) {
    this.codiArvato = codiArvato;
    return this;
  }

   /**
   * Get codiArvato
   * @return codiArvato
  **/
  @ApiModelProperty(value = "")
  public String getCodiArvato() {
    return codiArvato;
  }

  public void setCodiArvato(String codiArvato) {
    this.codiArvato = codiArvato;
  }

  public TipusViesRDTO entitat(String entitat) {
    this.entitat = entitat;
    return this;
  }

   /**
   * Get entitat
   * @return entitat
  **/
  @ApiModelProperty(value = "")
  public String getEntitat() {
    return entitat;
  }

  public void setEntitat(String entitat) {
    this.entitat = entitat;
  }

  public TipusViesRDTO nom(String nom) {
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
    TipusViesRDTO tipusViesRDTO = (TipusViesRDTO) o;
    return Objects.equals(this.codi, tipusViesRDTO.codi) &&
        Objects.equals(this.codiArvato, tipusViesRDTO.codiArvato) &&
        Objects.equals(this.entitat, tipusViesRDTO.entitat) &&
        Objects.equals(this.nom, tipusViesRDTO.nom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codi, codiArvato, entitat, nom);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TipusViesRDTO {\n");
    
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    codiArvato: ").append(toIndentedString(codiArvato)).append("\n");
    sb.append("    entitat: ").append(toIndentedString(entitat)).append("\n");
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

