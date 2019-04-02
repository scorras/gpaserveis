/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 1.8.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * DadesGrups
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-02T16:38:17.843+02:00")
public class DadesGrups {
  @JsonProperty("dadesOperacionsList")
  private List<DadesOperacions> dadesOperacionsList = null;

  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("descripcioCastella")
  private String descripcioCastella = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("nomColumnes")
  private Integer nomColumnes = null;

  @JsonProperty("ordre")
  private Integer ordre = null;

  @JsonProperty("procediment")
  private BigDecimal procediment = null;

  @JsonProperty("titol")
  private String titol = null;

  @JsonProperty("titolCastella")
  private String titolCastella = null;

  @JsonProperty("urlValidacio")
  private String urlValidacio = null;

  @JsonProperty("vigent")
  private Integer vigent = null;

  public DadesGrups dadesOperacionsList(List<DadesOperacions> dadesOperacionsList) {
    this.dadesOperacionsList = dadesOperacionsList;
    return this;
  }

  public DadesGrups addDadesOperacionsListItem(DadesOperacions dadesOperacionsListItem) {
    if (this.dadesOperacionsList == null) {
      this.dadesOperacionsList = new ArrayList<DadesOperacions>();
    }
    this.dadesOperacionsList.add(dadesOperacionsListItem);
    return this;
  }

   /**
   * Get dadesOperacionsList
   * @return dadesOperacionsList
  **/
  @ApiModelProperty(value = "")
  public List<DadesOperacions> getDadesOperacionsList() {
    return dadesOperacionsList;
  }

  public void setDadesOperacionsList(List<DadesOperacions> dadesOperacionsList) {
    this.dadesOperacionsList = dadesOperacionsList;
  }

  public DadesGrups descripcio(String descripcio) {
    this.descripcio = descripcio;
    return this;
  }

   /**
   * Get descripcio
   * @return descripcio
  **/
  @ApiModelProperty(value = "")
  public String getDescripcio() {
    return descripcio;
  }

  public void setDescripcio(String descripcio) {
    this.descripcio = descripcio;
  }

  public DadesGrups descripcioCastella(String descripcioCastella) {
    this.descripcioCastella = descripcioCastella;
    return this;
  }

   /**
   * Get descripcioCastella
   * @return descripcioCastella
  **/
  @ApiModelProperty(value = "")
  public String getDescripcioCastella() {
    return descripcioCastella;
  }

  public void setDescripcioCastella(String descripcioCastella) {
    this.descripcioCastella = descripcioCastella;
  }

  public DadesGrups id(BigDecimal id) {
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

  public DadesGrups nomColumnes(Integer nomColumnes) {
    this.nomColumnes = nomColumnes;
    return this;
  }

   /**
   * Get nomColumnes
   * @return nomColumnes
  **/
  @ApiModelProperty(value = "")
  public Integer getNomColumnes() {
    return nomColumnes;
  }

  public void setNomColumnes(Integer nomColumnes) {
    this.nomColumnes = nomColumnes;
  }

  public DadesGrups ordre(Integer ordre) {
    this.ordre = ordre;
    return this;
  }

   /**
   * Get ordre
   * @return ordre
  **/
  @ApiModelProperty(value = "")
  public Integer getOrdre() {
    return ordre;
  }

  public void setOrdre(Integer ordre) {
    this.ordre = ordre;
  }

  public DadesGrups procediment(BigDecimal procediment) {
    this.procediment = procediment;
    return this;
  }

   /**
   * Get procediment
   * @return procediment
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getProcediment() {
    return procediment;
  }

  public void setProcediment(BigDecimal procediment) {
    this.procediment = procediment;
  }

  public DadesGrups titol(String titol) {
    this.titol = titol;
    return this;
  }

   /**
   * Get titol
   * @return titol
  **/
  @ApiModelProperty(value = "")
  public String getTitol() {
    return titol;
  }

  public void setTitol(String titol) {
    this.titol = titol;
  }

  public DadesGrups titolCastella(String titolCastella) {
    this.titolCastella = titolCastella;
    return this;
  }

   /**
   * Get titolCastella
   * @return titolCastella
  **/
  @ApiModelProperty(value = "")
  public String getTitolCastella() {
    return titolCastella;
  }

  public void setTitolCastella(String titolCastella) {
    this.titolCastella = titolCastella;
  }

  public DadesGrups urlValidacio(String urlValidacio) {
    this.urlValidacio = urlValidacio;
    return this;
  }

   /**
   * Get urlValidacio
   * @return urlValidacio
  **/
  @ApiModelProperty(value = "")
  public String getUrlValidacio() {
    return urlValidacio;
  }

  public void setUrlValidacio(String urlValidacio) {
    this.urlValidacio = urlValidacio;
  }

  public DadesGrups vigent(Integer vigent) {
    this.vigent = vigent;
    return this;
  }

   /**
   * Get vigent
   * @return vigent
  **/
  @ApiModelProperty(value = "")
  public Integer getVigent() {
    return vigent;
  }

  public void setVigent(Integer vigent) {
    this.vigent = vigent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DadesGrups dadesGrups = (DadesGrups) o;
    return Objects.equals(this.dadesOperacionsList, dadesGrups.dadesOperacionsList) &&
        Objects.equals(this.descripcio, dadesGrups.descripcio) &&
        Objects.equals(this.descripcioCastella, dadesGrups.descripcioCastella) &&
        Objects.equals(this.id, dadesGrups.id) &&
        Objects.equals(this.nomColumnes, dadesGrups.nomColumnes) &&
        Objects.equals(this.ordre, dadesGrups.ordre) &&
        Objects.equals(this.procediment, dadesGrups.procediment) &&
        Objects.equals(this.titol, dadesGrups.titol) &&
        Objects.equals(this.titolCastella, dadesGrups.titolCastella) &&
        Objects.equals(this.urlValidacio, dadesGrups.urlValidacio) &&
        Objects.equals(this.vigent, dadesGrups.vigent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dadesOperacionsList, descripcio, descripcioCastella, id, nomColumnes, ordre, procediment, titol, titolCastella, urlValidacio, vigent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesGrups {\n");
    
    sb.append("    dadesOperacionsList: ").append(toIndentedString(dadesOperacionsList)).append("\n");
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
    sb.append("    descripcioCastella: ").append(toIndentedString(descripcioCastella)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nomColumnes: ").append(toIndentedString(nomColumnes)).append("\n");
    sb.append("    ordre: ").append(toIndentedString(ordre)).append("\n");
    sb.append("    procediment: ").append(toIndentedString(procediment)).append("\n");
    sb.append("    titol: ").append(toIndentedString(titol)).append("\n");
    sb.append("    titolCastella: ").append(toIndentedString(titolCastella)).append("\n");
    sb.append("    urlValidacio: ").append(toIndentedString(urlValidacio)).append("\n");
    sb.append("    vigent: ").append(toIndentedString(vigent)).append("\n");
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

