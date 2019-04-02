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
import java.math.BigDecimal;
import org.joda.time.DateTime;

/**
 * AvisosRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-02T11:40:28.073+02:00")
public class AvisosRDTO {
  @JsonProperty("avis")
  private String avis = null;

  @JsonProperty("criticitat")
  private BigDecimal criticitat = null;

  @JsonProperty("dataCreacio")
  private DateTime dataCreacio = null;

  @JsonProperty("dataLimit")
  private DateTime dataLimit = null;

  @JsonProperty("descripcioAvis")
  private String descripcioAvis = null;

  @JsonProperty("expedient")
  private BigDecimal expedient = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("tipus")
  private BigDecimal tipus = null;

  public AvisosRDTO avis(String avis) {
    this.avis = avis;
    return this;
  }

   /**
   * Get avis
   * @return avis
  **/
  @ApiModelProperty(value = "")
  public String getAvis() {
    return avis;
  }

  public void setAvis(String avis) {
    this.avis = avis;
  }

  public AvisosRDTO criticitat(BigDecimal criticitat) {
    this.criticitat = criticitat;
    return this;
  }

   /**
   * Get criticitat
   * @return criticitat
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getCriticitat() {
    return criticitat;
  }

  public void setCriticitat(BigDecimal criticitat) {
    this.criticitat = criticitat;
  }

  public AvisosRDTO dataCreacio(DateTime dataCreacio) {
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

  public AvisosRDTO dataLimit(DateTime dataLimit) {
    this.dataLimit = dataLimit;
    return this;
  }

   /**
   * Get dataLimit
   * @return dataLimit
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataLimit() {
    return dataLimit;
  }

  public void setDataLimit(DateTime dataLimit) {
    this.dataLimit = dataLimit;
  }

  public AvisosRDTO descripcioAvis(String descripcioAvis) {
    this.descripcioAvis = descripcioAvis;
    return this;
  }

   /**
   * Get descripcioAvis
   * @return descripcioAvis
  **/
  @ApiModelProperty(value = "")
  public String getDescripcioAvis() {
    return descripcioAvis;
  }

  public void setDescripcioAvis(String descripcioAvis) {
    this.descripcioAvis = descripcioAvis;
  }

  public AvisosRDTO expedient(BigDecimal expedient) {
    this.expedient = expedient;
    return this;
  }

   /**
   * Get expedient
   * @return expedient
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getExpedient() {
    return expedient;
  }

  public void setExpedient(BigDecimal expedient) {
    this.expedient = expedient;
  }

  public AvisosRDTO id(BigDecimal id) {
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

  public AvisosRDTO tipus(BigDecimal tipus) {
    this.tipus = tipus;
    return this;
  }

   /**
   * Get tipus
   * @return tipus
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getTipus() {
    return tipus;
  }

  public void setTipus(BigDecimal tipus) {
    this.tipus = tipus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvisosRDTO avisosRDTO = (AvisosRDTO) o;
    return Objects.equals(this.avis, avisosRDTO.avis) &&
        Objects.equals(this.criticitat, avisosRDTO.criticitat) &&
        Objects.equals(this.dataCreacio, avisosRDTO.dataCreacio) &&
        Objects.equals(this.dataLimit, avisosRDTO.dataLimit) &&
        Objects.equals(this.descripcioAvis, avisosRDTO.descripcioAvis) &&
        Objects.equals(this.expedient, avisosRDTO.expedient) &&
        Objects.equals(this.id, avisosRDTO.id) &&
        Objects.equals(this.tipus, avisosRDTO.tipus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(avis, criticitat, dataCreacio, dataLimit, descripcioAvis, expedient, id, tipus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvisosRDTO {\n");
    
    sb.append("    avis: ").append(toIndentedString(avis)).append("\n");
    sb.append("    criticitat: ").append(toIndentedString(criticitat)).append("\n");
    sb.append("    dataCreacio: ").append(toIndentedString(dataCreacio)).append("\n");
    sb.append("    dataLimit: ").append(toIndentedString(dataLimit)).append("\n");
    sb.append("    descripcioAvis: ").append(toIndentedString(descripcioAvis)).append("\n");
    sb.append("    expedient: ").append(toIndentedString(expedient)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tipus: ").append(toIndentedString(tipus)).append("\n");
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

