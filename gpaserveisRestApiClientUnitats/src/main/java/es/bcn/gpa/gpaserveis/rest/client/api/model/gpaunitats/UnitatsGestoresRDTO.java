/*
 * API gpaunitats
 * API gpaunitats
 *
 * OpenAPI spec version: 1.5.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.joda.time.DateTime;

/**
 * UnitatsGestoresRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-21T03:13:50.567+01:00")
public class UnitatsGestoresRDTO {
  @JsonProperty("codi")
  private String codi = null;

  @JsonProperty("dataCreacio")
  private DateTime dataCreacio = null;

  @JsonProperty("dataModificacio")
  private DateTime dataModificacio = null;

  @JsonProperty("descUnitatOrganigrama")
  private String descUnitatOrganigrama = null;

  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("nom")
  private String nom = null;

  @JsonProperty("unitatOrganigrama")
  private BigDecimal unitatOrganigrama = null;

  @JsonProperty("vigent")
  private Integer vigent = null;

  public UnitatsGestoresRDTO codi(String codi) {
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

  public UnitatsGestoresRDTO dataCreacio(DateTime dataCreacio) {
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

  public UnitatsGestoresRDTO dataModificacio(DateTime dataModificacio) {
    this.dataModificacio = dataModificacio;
    return this;
  }

   /**
   * Get dataModificacio
   * @return dataModificacio
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataModificacio() {
    return dataModificacio;
  }

  public void setDataModificacio(DateTime dataModificacio) {
    this.dataModificacio = dataModificacio;
  }

  public UnitatsGestoresRDTO descUnitatOrganigrama(String descUnitatOrganigrama) {
    this.descUnitatOrganigrama = descUnitatOrganigrama;
    return this;
  }

   /**
   * Get descUnitatOrganigrama
   * @return descUnitatOrganigrama
  **/
  @ApiModelProperty(value = "")
  public String getDescUnitatOrganigrama() {
    return descUnitatOrganigrama;
  }

  public void setDescUnitatOrganigrama(String descUnitatOrganigrama) {
    this.descUnitatOrganigrama = descUnitatOrganigrama;
  }

  public UnitatsGestoresRDTO descripcio(String descripcio) {
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

  public UnitatsGestoresRDTO id(BigDecimal id) {
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

  public UnitatsGestoresRDTO nom(String nom) {
    this.nom = nom;
    return this;
  }

   /**
   * Get nom
   * @return nom
  **/
  @ApiModelProperty(value = "")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public UnitatsGestoresRDTO unitatOrganigrama(BigDecimal unitatOrganigrama) {
    this.unitatOrganigrama = unitatOrganigrama;
    return this;
  }

   /**
   * Get unitatOrganigrama
   * @return unitatOrganigrama
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUnitatOrganigrama() {
    return unitatOrganigrama;
  }

  public void setUnitatOrganigrama(BigDecimal unitatOrganigrama) {
    this.unitatOrganigrama = unitatOrganigrama;
  }

  public UnitatsGestoresRDTO vigent(Integer vigent) {
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
    UnitatsGestoresRDTO unitatsGestoresRDTO = (UnitatsGestoresRDTO) o;
    return Objects.equals(this.codi, unitatsGestoresRDTO.codi) &&
        Objects.equals(this.dataCreacio, unitatsGestoresRDTO.dataCreacio) &&
        Objects.equals(this.dataModificacio, unitatsGestoresRDTO.dataModificacio) &&
        Objects.equals(this.descUnitatOrganigrama, unitatsGestoresRDTO.descUnitatOrganigrama) &&
        Objects.equals(this.descripcio, unitatsGestoresRDTO.descripcio) &&
        Objects.equals(this.id, unitatsGestoresRDTO.id) &&
        Objects.equals(this.nom, unitatsGestoresRDTO.nom) &&
        Objects.equals(this.unitatOrganigrama, unitatsGestoresRDTO.unitatOrganigrama) &&
        Objects.equals(this.vigent, unitatsGestoresRDTO.vigent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codi, dataCreacio, dataModificacio, descUnitatOrganigrama, descripcio, id, nom, unitatOrganigrama, vigent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnitatsGestoresRDTO {\n");
    
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    dataCreacio: ").append(toIndentedString(dataCreacio)).append("\n");
    sb.append("    dataModificacio: ").append(toIndentedString(dataModificacio)).append("\n");
    sb.append("    descUnitatOrganigrama: ").append(toIndentedString(descUnitatOrganigrama)).append("\n");
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    unitatOrganigrama: ").append(toIndentedString(unitatOrganigrama)).append("\n");
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

