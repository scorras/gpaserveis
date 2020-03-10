/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.18.0
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
 * Estats
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-03-06T14:11:58.043+01:00")
public class Estats {
  @JsonProperty("accioEstatIdext")
  private BigDecimal accioEstatIdext = null;

  @JsonProperty("comentari")
  private BigDecimal comentari = null;

  @JsonProperty("dataCreacio")
  private DateTime dataCreacio = null;

  @JsonProperty("estatAnterior")
  private BigDecimal estatAnterior = null;

  @JsonProperty("expedient")
  private BigDecimal expedient = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("unitatGestoraIdext")
  private BigDecimal unitatGestoraIdext = null;

  @JsonProperty("usuari")
  private BigDecimal usuari = null;

  public Estats accioEstatIdext(BigDecimal accioEstatIdext) {
    this.accioEstatIdext = accioEstatIdext;
    return this;
  }

   /**
   * Get accioEstatIdext
   * @return accioEstatIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getAccioEstatIdext() {
    return accioEstatIdext;
  }

  public void setAccioEstatIdext(BigDecimal accioEstatIdext) {
    this.accioEstatIdext = accioEstatIdext;
  }

  public Estats comentari(BigDecimal comentari) {
    this.comentari = comentari;
    return this;
  }

   /**
   * Get comentari
   * @return comentari
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getComentari() {
    return comentari;
  }

  public void setComentari(BigDecimal comentari) {
    this.comentari = comentari;
  }

  public Estats dataCreacio(DateTime dataCreacio) {
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

  public Estats estatAnterior(BigDecimal estatAnterior) {
    this.estatAnterior = estatAnterior;
    return this;
  }

   /**
   * Get estatAnterior
   * @return estatAnterior
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getEstatAnterior() {
    return estatAnterior;
  }

  public void setEstatAnterior(BigDecimal estatAnterior) {
    this.estatAnterior = estatAnterior;
  }

  public Estats expedient(BigDecimal expedient) {
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

  public Estats id(BigDecimal id) {
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

  public Estats unitatGestoraIdext(BigDecimal unitatGestoraIdext) {
    this.unitatGestoraIdext = unitatGestoraIdext;
    return this;
  }

   /**
   * Get unitatGestoraIdext
   * @return unitatGestoraIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUnitatGestoraIdext() {
    return unitatGestoraIdext;
  }

  public void setUnitatGestoraIdext(BigDecimal unitatGestoraIdext) {
    this.unitatGestoraIdext = unitatGestoraIdext;
  }

  public Estats usuari(BigDecimal usuari) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Estats estats = (Estats) o;
    return Objects.equals(this.accioEstatIdext, estats.accioEstatIdext) &&
        Objects.equals(this.comentari, estats.comentari) &&
        Objects.equals(this.dataCreacio, estats.dataCreacio) &&
        Objects.equals(this.estatAnterior, estats.estatAnterior) &&
        Objects.equals(this.expedient, estats.expedient) &&
        Objects.equals(this.id, estats.id) &&
        Objects.equals(this.unitatGestoraIdext, estats.unitatGestoraIdext) &&
        Objects.equals(this.usuari, estats.usuari);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accioEstatIdext, comentari, dataCreacio, estatAnterior, expedient, id, unitatGestoraIdext, usuari);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Estats {\n");
    
    sb.append("    accioEstatIdext: ").append(toIndentedString(accioEstatIdext)).append("\n");
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
    sb.append("    dataCreacio: ").append(toIndentedString(dataCreacio)).append("\n");
    sb.append("    estatAnterior: ").append(toIndentedString(estatAnterior)).append("\n");
    sb.append("    expedient: ").append(toIndentedString(expedient)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    unitatGestoraIdext: ").append(toIndentedString(unitatGestoraIdext)).append("\n");
    sb.append("    usuari: ").append(toIndentedString(usuari)).append("\n");
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

