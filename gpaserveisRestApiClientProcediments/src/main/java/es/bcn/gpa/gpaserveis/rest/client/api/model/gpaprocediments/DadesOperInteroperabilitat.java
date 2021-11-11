/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 2.10.1
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

/**
 * DadesOperInteroperabilitat
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-08T16:49:56.830+01:00")
public class DadesOperInteroperabilitat {
  @JsonProperty("codi")
  private String codi = null;

  @JsonProperty("editable")
  private Boolean editable = null;

  @JsonProperty("entrada")
  private Integer entrada = null;

  @JsonProperty("grup")
  private BigDecimal grup = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("ordre")
  private Integer ordre = null;

  @JsonProperty("seleccionable")
  private Boolean seleccionable = null;

  @JsonProperty("tipus")
  private Integer tipus = null;

  @JsonProperty("titol")
  private String titol = null;

  public DadesOperInteroperabilitat codi(String codi) {
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

  public DadesOperInteroperabilitat editable(Boolean editable) {
    this.editable = editable;
    return this;
  }

   /**
   * Get editable
   * @return editable
  **/
  @ApiModelProperty(value = "")
  public Boolean isEditable() {
    return editable;
  }

  public void setEditable(Boolean editable) {
    this.editable = editable;
  }

  public DadesOperInteroperabilitat entrada(Integer entrada) {
    this.entrada = entrada;
    return this;
  }

   /**
   * Get entrada
   * @return entrada
  **/
  @ApiModelProperty(value = "")
  public Integer getEntrada() {
    return entrada;
  }

  public void setEntrada(Integer entrada) {
    this.entrada = entrada;
  }

  public DadesOperInteroperabilitat grup(BigDecimal grup) {
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

  public DadesOperInteroperabilitat id(BigDecimal id) {
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

  public DadesOperInteroperabilitat ordre(Integer ordre) {
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

  public DadesOperInteroperabilitat seleccionable(Boolean seleccionable) {
    this.seleccionable = seleccionable;
    return this;
  }

   /**
   * Get seleccionable
   * @return seleccionable
  **/
  @ApiModelProperty(value = "")
  public Boolean isSeleccionable() {
    return seleccionable;
  }

  public void setSeleccionable(Boolean seleccionable) {
    this.seleccionable = seleccionable;
  }

  public DadesOperInteroperabilitat tipus(Integer tipus) {
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

  public DadesOperInteroperabilitat titol(String titol) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DadesOperInteroperabilitat dadesOperInteroperabilitat = (DadesOperInteroperabilitat) o;
    return Objects.equals(this.codi, dadesOperInteroperabilitat.codi) &&
        Objects.equals(this.editable, dadesOperInteroperabilitat.editable) &&
        Objects.equals(this.entrada, dadesOperInteroperabilitat.entrada) &&
        Objects.equals(this.grup, dadesOperInteroperabilitat.grup) &&
        Objects.equals(this.id, dadesOperInteroperabilitat.id) &&
        Objects.equals(this.ordre, dadesOperInteroperabilitat.ordre) &&
        Objects.equals(this.seleccionable, dadesOperInteroperabilitat.seleccionable) &&
        Objects.equals(this.tipus, dadesOperInteroperabilitat.tipus) &&
        Objects.equals(this.titol, dadesOperInteroperabilitat.titol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codi, editable, entrada, grup, id, ordre, seleccionable, tipus, titol);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesOperInteroperabilitat {\n");
    
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
    sb.append("    entrada: ").append(toIndentedString(entrada)).append("\n");
    sb.append("    grup: ").append(toIndentedString(grup)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ordre: ").append(toIndentedString(ordre)).append("\n");
    sb.append("    seleccionable: ").append(toIndentedString(seleccionable)).append("\n");
    sb.append("    tipus: ").append(toIndentedString(tipus)).append("\n");
    sb.append("    titol: ").append(toIndentedString(titol)).append("\n");
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

