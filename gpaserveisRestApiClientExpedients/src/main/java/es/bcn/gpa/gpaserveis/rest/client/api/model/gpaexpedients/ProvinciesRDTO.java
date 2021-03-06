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
 * ProvinciesRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-12T12:40:33.333+01:00")
public class ProvinciesRDTO {
  @JsonProperty("codiIne")
  private String codiIne = null;

  @JsonProperty("nom")
  private String nom = null;

  @JsonProperty("nomCastella")
  private String nomCastella = null;

  @JsonProperty("nomCatala")
  private String nomCatala = null;

  @JsonProperty("pais")
  private String pais = null;

  public ProvinciesRDTO codiIne(String codiIne) {
    this.codiIne = codiIne;
    return this;
  }

   /**
   * Get codiIne
   * @return codiIne
  **/
  @ApiModelProperty(value = "")
  public String getCodiIne() {
    return codiIne;
  }

  public void setCodiIne(String codiIne) {
    this.codiIne = codiIne;
  }

  public ProvinciesRDTO nom(String nom) {
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

  public ProvinciesRDTO nomCastella(String nomCastella) {
    this.nomCastella = nomCastella;
    return this;
  }

   /**
   * Get nomCastella
   * @return nomCastella
  **/
  @ApiModelProperty(value = "")
  public String getNomCastella() {
    return nomCastella;
  }

  public void setNomCastella(String nomCastella) {
    this.nomCastella = nomCastella;
  }

  public ProvinciesRDTO nomCatala(String nomCatala) {
    this.nomCatala = nomCatala;
    return this;
  }

   /**
   * Get nomCatala
   * @return nomCatala
  **/
  @ApiModelProperty(value = "")
  public String getNomCatala() {
    return nomCatala;
  }

  public void setNomCatala(String nomCatala) {
    this.nomCatala = nomCatala;
  }

  public ProvinciesRDTO pais(String pais) {
    this.pais = pais;
    return this;
  }

   /**
   * Get pais
   * @return pais
  **/
  @ApiModelProperty(value = "")
  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvinciesRDTO provinciesRDTO = (ProvinciesRDTO) o;
    return Objects.equals(this.codiIne, provinciesRDTO.codiIne) &&
        Objects.equals(this.nom, provinciesRDTO.nom) &&
        Objects.equals(this.nomCastella, provinciesRDTO.nomCastella) &&
        Objects.equals(this.nomCatala, provinciesRDTO.nomCatala) &&
        Objects.equals(this.pais, provinciesRDTO.pais);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiIne, nom, nomCastella, nomCatala, pais);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvinciesRDTO {\n");
    
    sb.append("    codiIne: ").append(toIndentedString(codiIne)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    nomCastella: ").append(toIndentedString(nomCastella)).append("\n");
    sb.append("    nomCatala: ").append(toIndentedString(nomCatala)).append("\n");
    sb.append("    pais: ").append(toIndentedString(pais)).append("\n");
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

