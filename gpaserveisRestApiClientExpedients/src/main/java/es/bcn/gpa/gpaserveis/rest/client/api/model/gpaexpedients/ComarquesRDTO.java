/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.8.0
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
 * ComarquesRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-28T09:29:38.619+01:00")
public class ComarquesRDTO {
  @JsonProperty("codiIne")
  private String codiIne = null;

  @JsonProperty("nom")
  private String nom = null;

  public ComarquesRDTO codiIne(String codiIne) {
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

  public ComarquesRDTO nom(String nom) {
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
    ComarquesRDTO comarquesRDTO = (ComarquesRDTO) o;
    return Objects.equals(this.codiIne, comarquesRDTO.codiIne) &&
        Objects.equals(this.nom, comarquesRDTO.nom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiIne, nom);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComarquesRDTO {\n");
    
    sb.append("    codiIne: ").append(toIndentedString(codiIne)).append("\n");
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

