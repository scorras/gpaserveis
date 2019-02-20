/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.4.0
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
 * CrearAvisRequeriment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-19T12:01:33.083+01:00")
public class CrearAvisRequeriment {
  @JsonProperty("criticitat")
  private BigDecimal criticitat = null;

  @JsonProperty("dataCreacio")
  private DateTime dataCreacio = null;

  @JsonProperty("dataLimit")
  private DateTime dataLimit = null;

  @JsonProperty("expedient")
  private BigDecimal expedient = null;

  @JsonProperty("respostaRequeriment")
  private BigDecimal respostaRequeriment = null;

  @JsonProperty("tipus")
  private BigDecimal tipus = null;

  public CrearAvisRequeriment criticitat(BigDecimal criticitat) {
    this.criticitat = criticitat;
    return this;
  }

   /**
   * Criticitat de l&#39;avís
   * @return criticitat
  **/
  @ApiModelProperty(value = "Criticitat de l'avís")
  public BigDecimal getCriticitat() {
    return criticitat;
  }

  public void setCriticitat(BigDecimal criticitat) {
    this.criticitat = criticitat;
  }

  public CrearAvisRequeriment dataCreacio(DateTime dataCreacio) {
    this.dataCreacio = dataCreacio;
    return this;
  }

   /**
   * Data creació de l&#39;avís
   * @return dataCreacio
  **/
  @ApiModelProperty(value = "Data creació de l'avís")
  public DateTime getDataCreacio() {
    return dataCreacio;
  }

  public void setDataCreacio(DateTime dataCreacio) {
    this.dataCreacio = dataCreacio;
  }

  public CrearAvisRequeriment dataLimit(DateTime dataLimit) {
    this.dataLimit = dataLimit;
    return this;
  }

   /**
   * Data límit de l&#39;avís
   * @return dataLimit
  **/
  @ApiModelProperty(value = "Data límit de l'avís")
  public DateTime getDataLimit() {
    return dataLimit;
  }

  public void setDataLimit(DateTime dataLimit) {
    this.dataLimit = dataLimit;
  }

  public CrearAvisRequeriment expedient(BigDecimal expedient) {
    this.expedient = expedient;
    return this;
  }

   /**
   * Identificador de l&#39;expedient per al qual s&#39;ha de crear l&#39;avís
   * @return expedient
  **/
  @ApiModelProperty(value = "Identificador de l'expedient per al qual s'ha de crear l'avís")
  public BigDecimal getExpedient() {
    return expedient;
  }

  public void setExpedient(BigDecimal expedient) {
    this.expedient = expedient;
  }

  public CrearAvisRequeriment respostaRequeriment(BigDecimal respostaRequeriment) {
    this.respostaRequeriment = respostaRequeriment;
    return this;
  }

   /**
   * Termini de resposta de requeriment
   * @return respostaRequeriment
  **/
  @ApiModelProperty(value = "Termini de resposta de requeriment")
  public BigDecimal getRespostaRequeriment() {
    return respostaRequeriment;
  }

  public void setRespostaRequeriment(BigDecimal respostaRequeriment) {
    this.respostaRequeriment = respostaRequeriment;
  }

  public CrearAvisRequeriment tipus(BigDecimal tipus) {
    this.tipus = tipus;
    return this;
  }

   /**
   * Tipus de l&#39;avís
   * @return tipus
  **/
  @ApiModelProperty(value = "Tipus de l'avís")
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
    CrearAvisRequeriment crearAvisRequeriment = (CrearAvisRequeriment) o;
    return Objects.equals(this.criticitat, crearAvisRequeriment.criticitat) &&
        Objects.equals(this.dataCreacio, crearAvisRequeriment.dataCreacio) &&
        Objects.equals(this.dataLimit, crearAvisRequeriment.dataLimit) &&
        Objects.equals(this.expedient, crearAvisRequeriment.expedient) &&
        Objects.equals(this.respostaRequeriment, crearAvisRequeriment.respostaRequeriment) &&
        Objects.equals(this.tipus, crearAvisRequeriment.tipus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(criticitat, dataCreacio, dataLimit, expedient, respostaRequeriment, tipus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrearAvisRequeriment {\n");
    
    sb.append("    criticitat: ").append(toIndentedString(criticitat)).append("\n");
    sb.append("    dataCreacio: ").append(toIndentedString(dataCreacio)).append("\n");
    sb.append("    dataLimit: ").append(toIndentedString(dataLimit)).append("\n");
    sb.append("    expedient: ").append(toIndentedString(expedient)).append("\n");
    sb.append("    respostaRequeriment: ").append(toIndentedString(respostaRequeriment)).append("\n");
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

