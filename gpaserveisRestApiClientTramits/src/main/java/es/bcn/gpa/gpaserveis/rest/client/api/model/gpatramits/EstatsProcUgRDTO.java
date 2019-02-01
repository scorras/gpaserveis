/*
 * API gpatramits
 * API gpatramits
 *
 * OpenAPI spec version: 1.3.0
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
 * EstatsProcUgRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-30T14:54:34.572+01:00")
public class EstatsProcUgRDTO {
  @JsonProperty("estatTramitador")
  private String estatTramitador = null;

  @JsonProperty("estats")
  private BigDecimal estats = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("ordre")
  private Integer ordre = null;

  @JsonProperty("procIdext")
  private BigDecimal procIdext = null;

  @JsonProperty("ugDesc")
  private String ugDesc = null;

  @JsonProperty("ugIdext")
  private BigDecimal ugIdext = null;

  public EstatsProcUgRDTO estatTramitador(String estatTramitador) {
    this.estatTramitador = estatTramitador;
    return this;
  }

   /**
   * Get estatTramitador
   * @return estatTramitador
  **/
  @ApiModelProperty(value = "")
  public String getEstatTramitador() {
    return estatTramitador;
  }

  public void setEstatTramitador(String estatTramitador) {
    this.estatTramitador = estatTramitador;
  }

  public EstatsProcUgRDTO estats(BigDecimal estats) {
    this.estats = estats;
    return this;
  }

   /**
   * Get estats
   * @return estats
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getEstats() {
    return estats;
  }

  public void setEstats(BigDecimal estats) {
    this.estats = estats;
  }

  public EstatsProcUgRDTO id(BigDecimal id) {
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

  public EstatsProcUgRDTO ordre(Integer ordre) {
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

  public EstatsProcUgRDTO procIdext(BigDecimal procIdext) {
    this.procIdext = procIdext;
    return this;
  }

   /**
   * Get procIdext
   * @return procIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getProcIdext() {
    return procIdext;
  }

  public void setProcIdext(BigDecimal procIdext) {
    this.procIdext = procIdext;
  }

  public EstatsProcUgRDTO ugDesc(String ugDesc) {
    this.ugDesc = ugDesc;
    return this;
  }

   /**
   * Get ugDesc
   * @return ugDesc
  **/
  @ApiModelProperty(value = "")
  public String getUgDesc() {
    return ugDesc;
  }

  public void setUgDesc(String ugDesc) {
    this.ugDesc = ugDesc;
  }

  public EstatsProcUgRDTO ugIdext(BigDecimal ugIdext) {
    this.ugIdext = ugIdext;
    return this;
  }

   /**
   * Get ugIdext
   * @return ugIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUgIdext() {
    return ugIdext;
  }

  public void setUgIdext(BigDecimal ugIdext) {
    this.ugIdext = ugIdext;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EstatsProcUgRDTO estatsProcUgRDTO = (EstatsProcUgRDTO) o;
    return Objects.equals(this.estatTramitador, estatsProcUgRDTO.estatTramitador) &&
        Objects.equals(this.estats, estatsProcUgRDTO.estats) &&
        Objects.equals(this.id, estatsProcUgRDTO.id) &&
        Objects.equals(this.ordre, estatsProcUgRDTO.ordre) &&
        Objects.equals(this.procIdext, estatsProcUgRDTO.procIdext) &&
        Objects.equals(this.ugDesc, estatsProcUgRDTO.ugDesc) &&
        Objects.equals(this.ugIdext, estatsProcUgRDTO.ugIdext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(estatTramitador, estats, id, ordre, procIdext, ugDesc, ugIdext);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EstatsProcUgRDTO {\n");
    
    sb.append("    estatTramitador: ").append(toIndentedString(estatTramitador)).append("\n");
    sb.append("    estats: ").append(toIndentedString(estats)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ordre: ").append(toIndentedString(ordre)).append("\n");
    sb.append("    procIdext: ").append(toIndentedString(procIdext)).append("\n");
    sb.append("    ugDesc: ").append(toIndentedString(ugDesc)).append("\n");
    sb.append("    ugIdext: ").append(toIndentedString(ugIdext)).append("\n");
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

