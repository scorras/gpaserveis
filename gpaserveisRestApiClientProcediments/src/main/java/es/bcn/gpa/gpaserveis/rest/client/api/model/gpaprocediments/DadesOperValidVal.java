/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 2.11.0
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.joda.time.DateTime;

/**
 * DadesOperValidVal
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-17T10:14:01.849+01:00")
public class DadesOperValidVal {
  @JsonProperty("dadesOperValid")
  private BigDecimal dadesOperValid = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("ordre")
  private Long ordre = null;

  @JsonProperty("valor")
  private String valor = null;

  @JsonProperty("valorBoolean")
  private Integer valorBoolean = null;

  @JsonProperty("valorCalendar")
  private DateTime valorCalendar = null;

  @JsonProperty("valorClob")
  private String valorClob = null;

  @JsonProperty("valorDouble")
  private Double valorDouble = null;

  @JsonProperty("valorInteger")
  private Long valorInteger = null;

  @JsonProperty("valorListaMultiple")
  private Integer valorListaMultiple = null;

  @JsonProperty("valorListaSimple")
  private Integer valorListaSimple = null;

  @JsonProperty("valorMoneda")
  private Double valorMoneda = null;

  @JsonProperty("valorMunicipi")
  private String valorMunicipi = null;

  @JsonProperty("valorPais")
  private String valorPais = null;

  @JsonProperty("valorProvincia")
  private String valorProvincia = null;

  @JsonProperty("valorString")
  private String valorString = null;

  public DadesOperValidVal dadesOperValid(BigDecimal dadesOperValid) {
    this.dadesOperValid = dadesOperValid;
    return this;
  }

   /**
   * Get dadesOperValid
   * @return dadesOperValid
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDadesOperValid() {
    return dadesOperValid;
  }

  public void setDadesOperValid(BigDecimal dadesOperValid) {
    this.dadesOperValid = dadesOperValid;
  }

  public DadesOperValidVal id(BigDecimal id) {
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

  public DadesOperValidVal ordre(Long ordre) {
    this.ordre = ordre;
    return this;
  }

   /**
   * Get ordre
   * @return ordre
  **/
  @ApiModelProperty(value = "")
  public Long getOrdre() {
    return ordre;
  }

  public void setOrdre(Long ordre) {
    this.ordre = ordre;
  }

  public DadesOperValidVal valor(String valor) {
    this.valor = valor;
    return this;
  }

   /**
   * Get valor
   * @return valor
  **/
  @ApiModelProperty(value = "")
  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public DadesOperValidVal valorBoolean(Integer valorBoolean) {
    this.valorBoolean = valorBoolean;
    return this;
  }

   /**
   * Get valorBoolean
   * @return valorBoolean
  **/
  @ApiModelProperty(value = "")
  public Integer getValorBoolean() {
    return valorBoolean;
  }

  public void setValorBoolean(Integer valorBoolean) {
    this.valorBoolean = valorBoolean;
  }

  public DadesOperValidVal valorCalendar(DateTime valorCalendar) {
    this.valorCalendar = valorCalendar;
    return this;
  }

   /**
   * Get valorCalendar
   * @return valorCalendar
  **/
  @ApiModelProperty(value = "")
  public DateTime getValorCalendar() {
    return valorCalendar;
  }

  public void setValorCalendar(DateTime valorCalendar) {
    this.valorCalendar = valorCalendar;
  }

  public DadesOperValidVal valorClob(String valorClob) {
    this.valorClob = valorClob;
    return this;
  }

   /**
   * Get valorClob
   * @return valorClob
  **/
  @ApiModelProperty(value = "")
  public String getValorClob() {
    return valorClob;
  }

  public void setValorClob(String valorClob) {
    this.valorClob = valorClob;
  }

  public DadesOperValidVal valorDouble(Double valorDouble) {
    this.valorDouble = valorDouble;
    return this;
  }

   /**
   * Get valorDouble
   * @return valorDouble
  **/
  @ApiModelProperty(value = "")
  public Double getValorDouble() {
    return valorDouble;
  }

  public void setValorDouble(Double valorDouble) {
    this.valorDouble = valorDouble;
  }

  public DadesOperValidVal valorInteger(Long valorInteger) {
    this.valorInteger = valorInteger;
    return this;
  }

   /**
   * Get valorInteger
   * @return valorInteger
  **/
  @ApiModelProperty(value = "")
  public Long getValorInteger() {
    return valorInteger;
  }

  public void setValorInteger(Long valorInteger) {
    this.valorInteger = valorInteger;
  }

  public DadesOperValidVal valorListaMultiple(Integer valorListaMultiple) {
    this.valorListaMultiple = valorListaMultiple;
    return this;
  }

   /**
   * Get valorListaMultiple
   * @return valorListaMultiple
  **/
  @ApiModelProperty(value = "")
  public Integer getValorListaMultiple() {
    return valorListaMultiple;
  }

  public void setValorListaMultiple(Integer valorListaMultiple) {
    this.valorListaMultiple = valorListaMultiple;
  }

  public DadesOperValidVal valorListaSimple(Integer valorListaSimple) {
    this.valorListaSimple = valorListaSimple;
    return this;
  }

   /**
   * Get valorListaSimple
   * @return valorListaSimple
  **/
  @ApiModelProperty(value = "")
  public Integer getValorListaSimple() {
    return valorListaSimple;
  }

  public void setValorListaSimple(Integer valorListaSimple) {
    this.valorListaSimple = valorListaSimple;
  }

  public DadesOperValidVal valorMoneda(Double valorMoneda) {
    this.valorMoneda = valorMoneda;
    return this;
  }

   /**
   * Get valorMoneda
   * @return valorMoneda
  **/
  @ApiModelProperty(value = "")
  public Double getValorMoneda() {
    return valorMoneda;
  }

  public void setValorMoneda(Double valorMoneda) {
    this.valorMoneda = valorMoneda;
  }

  public DadesOperValidVal valorMunicipi(String valorMunicipi) {
    this.valorMunicipi = valorMunicipi;
    return this;
  }

   /**
   * Get valorMunicipi
   * @return valorMunicipi
  **/
  @ApiModelProperty(value = "")
  public String getValorMunicipi() {
    return valorMunicipi;
  }

  public void setValorMunicipi(String valorMunicipi) {
    this.valorMunicipi = valorMunicipi;
  }

  public DadesOperValidVal valorPais(String valorPais) {
    this.valorPais = valorPais;
    return this;
  }

   /**
   * Get valorPais
   * @return valorPais
  **/
  @ApiModelProperty(value = "")
  public String getValorPais() {
    return valorPais;
  }

  public void setValorPais(String valorPais) {
    this.valorPais = valorPais;
  }

  public DadesOperValidVal valorProvincia(String valorProvincia) {
    this.valorProvincia = valorProvincia;
    return this;
  }

   /**
   * Get valorProvincia
   * @return valorProvincia
  **/
  @ApiModelProperty(value = "")
  public String getValorProvincia() {
    return valorProvincia;
  }

  public void setValorProvincia(String valorProvincia) {
    this.valorProvincia = valorProvincia;
  }

  public DadesOperValidVal valorString(String valorString) {
    this.valorString = valorString;
    return this;
  }

   /**
   * Get valorString
   * @return valorString
  **/
  @ApiModelProperty(value = "")
  public String getValorString() {
    return valorString;
  }

  public void setValorString(String valorString) {
    this.valorString = valorString;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DadesOperValidVal dadesOperValidVal = (DadesOperValidVal) o;
    return Objects.equals(this.dadesOperValid, dadesOperValidVal.dadesOperValid) &&
        Objects.equals(this.id, dadesOperValidVal.id) &&
        Objects.equals(this.ordre, dadesOperValidVal.ordre) &&
        Objects.equals(this.valor, dadesOperValidVal.valor) &&
        Objects.equals(this.valorBoolean, dadesOperValidVal.valorBoolean) &&
        Objects.equals(this.valorCalendar, dadesOperValidVal.valorCalendar) &&
        Objects.equals(this.valorClob, dadesOperValidVal.valorClob) &&
        Objects.equals(this.valorDouble, dadesOperValidVal.valorDouble) &&
        Objects.equals(this.valorInteger, dadesOperValidVal.valorInteger) &&
        Objects.equals(this.valorListaMultiple, dadesOperValidVal.valorListaMultiple) &&
        Objects.equals(this.valorListaSimple, dadesOperValidVal.valorListaSimple) &&
        Objects.equals(this.valorMoneda, dadesOperValidVal.valorMoneda) &&
        Objects.equals(this.valorMunicipi, dadesOperValidVal.valorMunicipi) &&
        Objects.equals(this.valorPais, dadesOperValidVal.valorPais) &&
        Objects.equals(this.valorProvincia, dadesOperValidVal.valorProvincia) &&
        Objects.equals(this.valorString, dadesOperValidVal.valorString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dadesOperValid, id, ordre, valor, valorBoolean, valorCalendar, valorClob, valorDouble, valorInteger, valorListaMultiple, valorListaSimple, valorMoneda, valorMunicipi, valorPais, valorProvincia, valorString);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesOperValidVal {\n");
    
    sb.append("    dadesOperValid: ").append(toIndentedString(dadesOperValid)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ordre: ").append(toIndentedString(ordre)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
    sb.append("    valorBoolean: ").append(toIndentedString(valorBoolean)).append("\n");
    sb.append("    valorCalendar: ").append(toIndentedString(valorCalendar)).append("\n");
    sb.append("    valorClob: ").append(toIndentedString(valorClob)).append("\n");
    sb.append("    valorDouble: ").append(toIndentedString(valorDouble)).append("\n");
    sb.append("    valorInteger: ").append(toIndentedString(valorInteger)).append("\n");
    sb.append("    valorListaMultiple: ").append(toIndentedString(valorListaMultiple)).append("\n");
    sb.append("    valorListaSimple: ").append(toIndentedString(valorListaSimple)).append("\n");
    sb.append("    valorMoneda: ").append(toIndentedString(valorMoneda)).append("\n");
    sb.append("    valorMunicipi: ").append(toIndentedString(valorMunicipi)).append("\n");
    sb.append("    valorPais: ").append(toIndentedString(valorPais)).append("\n");
    sb.append("    valorProvincia: ").append(toIndentedString(valorProvincia)).append("\n");
    sb.append("    valorString: ").append(toIndentedString(valorString)).append("\n");
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

