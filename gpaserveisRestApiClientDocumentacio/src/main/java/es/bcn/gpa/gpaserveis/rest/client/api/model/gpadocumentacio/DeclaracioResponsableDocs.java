/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.4.0
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
 * DeclaracioResponsableDocs
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T01:51:34.681+01:00")
public class DeclaracioResponsableDocs {
  @JsonProperty("categoriaNti")
  private Integer categoriaNti = null;

  @JsonProperty("condicionsSustitucio")
  private String condicionsSustitucio = null;

  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("plantillaBase")
  private String plantillaBase = null;

  @JsonProperty("plantillaEspecifica")
  private String plantillaEspecifica = null;

  @JsonProperty("sustituible")
  private Integer sustituible = null;

  @JsonProperty("tipusDocumental")
  private String tipusDocumental = null;

  public DeclaracioResponsableDocs categoriaNti(Integer categoriaNti) {
    this.categoriaNti = categoriaNti;
    return this;
  }

   /**
   * Get categoriaNti
   * @return categoriaNti
  **/
  @ApiModelProperty(value = "")
  public Integer getCategoriaNti() {
    return categoriaNti;
  }

  public void setCategoriaNti(Integer categoriaNti) {
    this.categoriaNti = categoriaNti;
  }

  public DeclaracioResponsableDocs condicionsSustitucio(String condicionsSustitucio) {
    this.condicionsSustitucio = condicionsSustitucio;
    return this;
  }

   /**
   * Get condicionsSustitucio
   * @return condicionsSustitucio
  **/
  @ApiModelProperty(value = "")
  public String getCondicionsSustitucio() {
    return condicionsSustitucio;
  }

  public void setCondicionsSustitucio(String condicionsSustitucio) {
    this.condicionsSustitucio = condicionsSustitucio;
  }

  public DeclaracioResponsableDocs descripcio(String descripcio) {
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

  public DeclaracioResponsableDocs id(BigDecimal id) {
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

  public DeclaracioResponsableDocs plantillaBase(String plantillaBase) {
    this.plantillaBase = plantillaBase;
    return this;
  }

   /**
   * Get plantillaBase
   * @return plantillaBase
  **/
  @ApiModelProperty(value = "")
  public String getPlantillaBase() {
    return plantillaBase;
  }

  public void setPlantillaBase(String plantillaBase) {
    this.plantillaBase = plantillaBase;
  }

  public DeclaracioResponsableDocs plantillaEspecifica(String plantillaEspecifica) {
    this.plantillaEspecifica = plantillaEspecifica;
    return this;
  }

   /**
   * Get plantillaEspecifica
   * @return plantillaEspecifica
  **/
  @ApiModelProperty(value = "")
  public String getPlantillaEspecifica() {
    return plantillaEspecifica;
  }

  public void setPlantillaEspecifica(String plantillaEspecifica) {
    this.plantillaEspecifica = plantillaEspecifica;
  }

  public DeclaracioResponsableDocs sustituible(Integer sustituible) {
    this.sustituible = sustituible;
    return this;
  }

   /**
   * Get sustituible
   * @return sustituible
  **/
  @ApiModelProperty(value = "")
  public Integer getSustituible() {
    return sustituible;
  }

  public void setSustituible(Integer sustituible) {
    this.sustituible = sustituible;
  }

  public DeclaracioResponsableDocs tipusDocumental(String tipusDocumental) {
    this.tipusDocumental = tipusDocumental;
    return this;
  }

   /**
   * Get tipusDocumental
   * @return tipusDocumental
  **/
  @ApiModelProperty(value = "")
  public String getTipusDocumental() {
    return tipusDocumental;
  }

  public void setTipusDocumental(String tipusDocumental) {
    this.tipusDocumental = tipusDocumental;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeclaracioResponsableDocs declaracioResponsableDocs = (DeclaracioResponsableDocs) o;
    return Objects.equals(this.categoriaNti, declaracioResponsableDocs.categoriaNti) &&
        Objects.equals(this.condicionsSustitucio, declaracioResponsableDocs.condicionsSustitucio) &&
        Objects.equals(this.descripcio, declaracioResponsableDocs.descripcio) &&
        Objects.equals(this.id, declaracioResponsableDocs.id) &&
        Objects.equals(this.plantillaBase, declaracioResponsableDocs.plantillaBase) &&
        Objects.equals(this.plantillaEspecifica, declaracioResponsableDocs.plantillaEspecifica) &&
        Objects.equals(this.sustituible, declaracioResponsableDocs.sustituible) &&
        Objects.equals(this.tipusDocumental, declaracioResponsableDocs.tipusDocumental);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoriaNti, condicionsSustitucio, descripcio, id, plantillaBase, plantillaEspecifica, sustituible, tipusDocumental);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeclaracioResponsableDocs {\n");
    
    sb.append("    categoriaNti: ").append(toIndentedString(categoriaNti)).append("\n");
    sb.append("    condicionsSustitucio: ").append(toIndentedString(condicionsSustitucio)).append("\n");
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    plantillaBase: ").append(toIndentedString(plantillaBase)).append("\n");
    sb.append("    plantillaEspecifica: ").append(toIndentedString(plantillaEspecifica)).append("\n");
    sb.append("    sustituible: ").append(toIndentedString(sustituible)).append("\n");
    sb.append("    tipusDocumental: ").append(toIndentedString(tipusDocumental)).append("\n");
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

