/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 1.12.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Historics
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-14T14:00:34.420+02:00")
public class Historics {
  @JsonProperty("clauMissatge")
  private String clauMissatge = null;

  @JsonProperty("dataCreacio")
  private DateTime dataCreacio = null;

  @JsonProperty("descTipus")
  private String descTipus = null;

  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("historicValorsList")
  private List<HistoricValors> historicValorsList = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("procediment")
  private BigDecimal procediment = null;

  @JsonProperty("tipus")
  private Integer tipus = null;

  @JsonProperty("usuari")
  private BigDecimal usuari = null;

  @JsonProperty("usuariNom")
  private String usuariNom = null;

  public Historics clauMissatge(String clauMissatge) {
    this.clauMissatge = clauMissatge;
    return this;
  }

   /**
   * Get clauMissatge
   * @return clauMissatge
  **/
  @ApiModelProperty(value = "")
  public String getClauMissatge() {
    return clauMissatge;
  }

  public void setClauMissatge(String clauMissatge) {
    this.clauMissatge = clauMissatge;
  }

  public Historics dataCreacio(DateTime dataCreacio) {
    this.dataCreacio = dataCreacio;
    return this;
  }

   /**
   * Get dataCreacio
   * @return dataCreacio
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataCreacio() {
    return dataCreacio;
  }

  public void setDataCreacio(DateTime dataCreacio) {
    this.dataCreacio = dataCreacio;
  }

  public Historics descTipus(String descTipus) {
    this.descTipus = descTipus;
    return this;
  }

   /**
   * Get descTipus
   * @return descTipus
  **/
  @ApiModelProperty(value = "")
  public String getDescTipus() {
    return descTipus;
  }

  public void setDescTipus(String descTipus) {
    this.descTipus = descTipus;
  }

  public Historics descripcio(String descripcio) {
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

  public Historics historicValorsList(List<HistoricValors> historicValorsList) {
    this.historicValorsList = historicValorsList;
    return this;
  }

  public Historics addHistoricValorsListItem(HistoricValors historicValorsListItem) {
    if (this.historicValorsList == null) {
      this.historicValorsList = new ArrayList<HistoricValors>();
    }
    this.historicValorsList.add(historicValorsListItem);
    return this;
  }

   /**
   * Get historicValorsList
   * @return historicValorsList
  **/
  @ApiModelProperty(value = "")
  public List<HistoricValors> getHistoricValorsList() {
    return historicValorsList;
  }

  public void setHistoricValorsList(List<HistoricValors> historicValorsList) {
    this.historicValorsList = historicValorsList;
  }

  public Historics id(BigDecimal id) {
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

  public Historics procediment(BigDecimal procediment) {
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

  public Historics tipus(Integer tipus) {
    this.tipus = tipus;
    return this;
  }

   /**
   * Get tipus
   * @return tipus
  **/
  @ApiModelProperty(value = "")
  public Integer getTipus() {
    return tipus;
  }

  public void setTipus(Integer tipus) {
    this.tipus = tipus;
  }

  public Historics usuari(BigDecimal usuari) {
    this.usuari = usuari;
    return this;
  }

   /**
   * Get usuari
   * @return usuari
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUsuari() {
    return usuari;
  }

  public void setUsuari(BigDecimal usuari) {
    this.usuari = usuari;
  }

  public Historics usuariNom(String usuariNom) {
    this.usuariNom = usuariNom;
    return this;
  }

   /**
   * Get usuariNom
   * @return usuariNom
  **/
  @ApiModelProperty(value = "")
  public String getUsuariNom() {
    return usuariNom;
  }

  public void setUsuariNom(String usuariNom) {
    this.usuariNom = usuariNom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Historics historics = (Historics) o;
    return Objects.equals(this.clauMissatge, historics.clauMissatge) &&
        Objects.equals(this.dataCreacio, historics.dataCreacio) &&
        Objects.equals(this.descTipus, historics.descTipus) &&
        Objects.equals(this.descripcio, historics.descripcio) &&
        Objects.equals(this.historicValorsList, historics.historicValorsList) &&
        Objects.equals(this.id, historics.id) &&
        Objects.equals(this.procediment, historics.procediment) &&
        Objects.equals(this.tipus, historics.tipus) &&
        Objects.equals(this.usuari, historics.usuari) &&
        Objects.equals(this.usuariNom, historics.usuariNom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clauMissatge, dataCreacio, descTipus, descripcio, historicValorsList, id, procediment, tipus, usuari, usuariNom);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Historics {\n");
    
    sb.append("    clauMissatge: ").append(toIndentedString(clauMissatge)).append("\n");
    sb.append("    dataCreacio: ").append(toIndentedString(dataCreacio)).append("\n");
    sb.append("    descTipus: ").append(toIndentedString(descTipus)).append("\n");
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
    sb.append("    historicValorsList: ").append(toIndentedString(historicValorsList)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    procediment: ").append(toIndentedString(procediment)).append("\n");
    sb.append("    tipus: ").append(toIndentedString(tipus)).append("\n");
    sb.append("    usuari: ").append(toIndentedString(usuari)).append("\n");
    sb.append("    usuariNom: ").append(toIndentedString(usuariNom)).append("\n");
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

