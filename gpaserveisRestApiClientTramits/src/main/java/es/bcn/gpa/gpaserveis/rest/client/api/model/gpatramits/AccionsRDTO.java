/*
 * API gpatramits
 * API gpatramits
 *
 * OpenAPI spec version: 1.8.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * AccionsRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-02T03:58:39.261+02:00")
public class AccionsRDTO {
  @JsonProperty("activador")
  private String activador = null;

  @JsonProperty("codi")
  private String codi = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("nom")
  private String nom = null;

  @JsonProperty("receptor")
  private String receptor = null;

  @JsonProperty("resum")
  private String resum = null;

  @JsonProperty("rolUsuari")
  private String rolUsuari = null;

  @JsonProperty("visible")
  private Integer visible = null;

  public AccionsRDTO activador(String activador) {
    this.activador = activador;
    return this;
  }

   /**
   * Get activador
   * @return activador
  **/
  @ApiModelProperty(value = "")
  public String getActivador() {
    return activador;
  }

  public void setActivador(String activador) {
    this.activador = activador;
  }

  public AccionsRDTO codi(String codi) {
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

  public AccionsRDTO id(BigDecimal id) {
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

  public AccionsRDTO nom(String nom) {
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

  public AccionsRDTO receptor(String receptor) {
    this.receptor = receptor;
    return this;
  }

   /**
   * Get receptor
   * @return receptor
  **/
  @ApiModelProperty(value = "")
  public String getReceptor() {
    return receptor;
  }

  public void setReceptor(String receptor) {
    this.receptor = receptor;
  }

  public AccionsRDTO resum(String resum) {
    this.resum = resum;
    return this;
  }

   /**
   * Get resum
   * @return resum
  **/
  @ApiModelProperty(value = "")
  public String getResum() {
    return resum;
  }

  public void setResum(String resum) {
    this.resum = resum;
  }

  public AccionsRDTO rolUsuari(String rolUsuari) {
    this.rolUsuari = rolUsuari;
    return this;
  }

   /**
   * Get rolUsuari
   * @return rolUsuari
  **/
  @ApiModelProperty(value = "")
  public String getRolUsuari() {
    return rolUsuari;
  }

  public void setRolUsuari(String rolUsuari) {
    this.rolUsuari = rolUsuari;
  }

  public AccionsRDTO visible(Integer visible) {
    this.visible = visible;
    return this;
  }

   /**
   * Get visible
   * @return visible
  **/
  @ApiModelProperty(value = "")
  public Integer getVisible() {
    return visible;
  }

  public void setVisible(Integer visible) {
    this.visible = visible;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccionsRDTO accionsRDTO = (AccionsRDTO) o;
    return Objects.equals(this.activador, accionsRDTO.activador) &&
        Objects.equals(this.codi, accionsRDTO.codi) &&
        Objects.equals(this.id, accionsRDTO.id) &&
        Objects.equals(this.nom, accionsRDTO.nom) &&
        Objects.equals(this.receptor, accionsRDTO.receptor) &&
        Objects.equals(this.resum, accionsRDTO.resum) &&
        Objects.equals(this.rolUsuari, accionsRDTO.rolUsuari) &&
        Objects.equals(this.visible, accionsRDTO.visible);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activador, codi, id, nom, receptor, resum, rolUsuari, visible);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccionsRDTO {\n");
    
    sb.append("    activador: ").append(toIndentedString(activador)).append("\n");
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    receptor: ").append(toIndentedString(receptor)).append("\n");
    sb.append("    resum: ").append(toIndentedString(resum)).append("\n");
    sb.append("    rolUsuari: ").append(toIndentedString(rolUsuari)).append("\n");
    sb.append("    visible: ").append(toIndentedString(visible)).append("\n");
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

