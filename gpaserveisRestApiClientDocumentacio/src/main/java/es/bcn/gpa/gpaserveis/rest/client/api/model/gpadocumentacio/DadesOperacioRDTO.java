/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 2.10.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * DadesOperacioRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-04T14:21:11.408+01:00")
public class DadesOperacioRDTO {
  @JsonProperty("codi")
  private String codi = null;

  @JsonProperty("desTipusCamp")
  private String desTipusCamp = null;

  @JsonProperty("grup")
  private BigDecimal grup = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("ordre")
  private Integer ordre = null;

  @JsonProperty("procediment")
  private BigDecimal procediment = null;

  @JsonProperty("tipus")
  private Integer tipus = null;

  @JsonProperty("titol")
  private String titol = null;

  @JsonProperty("titolGrup")
  private String titolGrup = null;

  public DadesOperacioRDTO codi(String codi) {
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

  public DadesOperacioRDTO desTipusCamp(String desTipusCamp) {
    this.desTipusCamp = desTipusCamp;
    return this;
  }

   /**
   * Get desTipusCamp
   * @return desTipusCamp
  **/
  @ApiModelProperty(value = "")
  public String getDesTipusCamp() {
    return desTipusCamp;
  }

  public void setDesTipusCamp(String desTipusCamp) {
    this.desTipusCamp = desTipusCamp;
  }

  public DadesOperacioRDTO grup(BigDecimal grup) {
    this.grup = grup;
    return this;
  }

   /**
   * Get grup
   * @return grup
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getGrup() {
    return grup;
  }

  public void setGrup(BigDecimal grup) {
    this.grup = grup;
  }

  public DadesOperacioRDTO id(BigDecimal id) {
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

  public DadesOperacioRDTO ordre(Integer ordre) {
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

  public DadesOperacioRDTO procediment(BigDecimal procediment) {
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

  public DadesOperacioRDTO tipus(Integer tipus) {
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

  public DadesOperacioRDTO titol(String titol) {
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

  public DadesOperacioRDTO titolGrup(String titolGrup) {
    this.titolGrup = titolGrup;
    return this;
  }

   /**
   * Get titolGrup
   * @return titolGrup
  **/
  @ApiModelProperty(value = "")
  public String getTitolGrup() {
    return titolGrup;
  }

  public void setTitolGrup(String titolGrup) {
    this.titolGrup = titolGrup;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DadesOperacioRDTO dadesOperacioRDTO = (DadesOperacioRDTO) o;
    return Objects.equals(this.codi, dadesOperacioRDTO.codi) &&
        Objects.equals(this.desTipusCamp, dadesOperacioRDTO.desTipusCamp) &&
        Objects.equals(this.grup, dadesOperacioRDTO.grup) &&
        Objects.equals(this.id, dadesOperacioRDTO.id) &&
        Objects.equals(this.ordre, dadesOperacioRDTO.ordre) &&
        Objects.equals(this.procediment, dadesOperacioRDTO.procediment) &&
        Objects.equals(this.tipus, dadesOperacioRDTO.tipus) &&
        Objects.equals(this.titol, dadesOperacioRDTO.titol) &&
        Objects.equals(this.titolGrup, dadesOperacioRDTO.titolGrup);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codi, desTipusCamp, grup, id, ordre, procediment, tipus, titol, titolGrup);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesOperacioRDTO {\n");
    
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    desTipusCamp: ").append(toIndentedString(desTipusCamp)).append("\n");
    sb.append("    grup: ").append(toIndentedString(grup)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ordre: ").append(toIndentedString(ordre)).append("\n");
    sb.append("    procediment: ").append(toIndentedString(procediment)).append("\n");
    sb.append("    tipus: ").append(toIndentedString(tipus)).append("\n");
    sb.append("    titol: ").append(toIndentedString(titol)).append("\n");
    sb.append("    titolGrup: ").append(toIndentedString(titolGrup)).append("\n");
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

