/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 2.5.3
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValorsJson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * DadesEspecifiquesRepetiblesRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-15T10:56:55.879+02:00")
public class DadesEspecifiquesRepetiblesRDTO {
  @JsonProperty("campIdext")
  private BigDecimal campIdext = null;

  @JsonProperty("dadesEspecifiquesValorsJsonList")
  private List<DadesEspecifiquesValorsJson> dadesEspecifiquesValorsJsonList = null;

  @JsonProperty("expedient")
  private BigDecimal expedient = null;

  @JsonProperty("grupIdext")
  private BigDecimal grupIdext = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("nou")
  private Integer nou = null;

  public DadesEspecifiquesRepetiblesRDTO campIdext(BigDecimal campIdext) {
    this.campIdext = campIdext;
    return this;
  }

   /**
   * Get campIdext
   * @return campIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getCampIdext() {
    return campIdext;
  }

  public void setCampIdext(BigDecimal campIdext) {
    this.campIdext = campIdext;
  }

  public DadesEspecifiquesRepetiblesRDTO dadesEspecifiquesValorsJsonList(List<DadesEspecifiquesValorsJson> dadesEspecifiquesValorsJsonList) {
    this.dadesEspecifiquesValorsJsonList = dadesEspecifiquesValorsJsonList;
    return this;
  }

  public DadesEspecifiquesRepetiblesRDTO addDadesEspecifiquesValorsJsonListItem(DadesEspecifiquesValorsJson dadesEspecifiquesValorsJsonListItem) {
    if (this.dadesEspecifiquesValorsJsonList == null) {
      this.dadesEspecifiquesValorsJsonList = new ArrayList<DadesEspecifiquesValorsJson>();
    }
    this.dadesEspecifiquesValorsJsonList.add(dadesEspecifiquesValorsJsonListItem);
    return this;
  }

   /**
   * Get dadesEspecifiquesValorsJsonList
   * @return dadesEspecifiquesValorsJsonList
  **/
  @ApiModelProperty(value = "")
  public List<DadesEspecifiquesValorsJson> getDadesEspecifiquesValorsJsonList() {
    return dadesEspecifiquesValorsJsonList;
  }

  public void setDadesEspecifiquesValorsJsonList(List<DadesEspecifiquesValorsJson> dadesEspecifiquesValorsJsonList) {
    this.dadesEspecifiquesValorsJsonList = dadesEspecifiquesValorsJsonList;
  }

  public DadesEspecifiquesRepetiblesRDTO expedient(BigDecimal expedient) {
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

  public DadesEspecifiquesRepetiblesRDTO grupIdext(BigDecimal grupIdext) {
    this.grupIdext = grupIdext;
    return this;
  }

   /**
   * Get grupIdext
   * @return grupIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getGrupIdext() {
    return grupIdext;
  }

  public void setGrupIdext(BigDecimal grupIdext) {
    this.grupIdext = grupIdext;
  }

  public DadesEspecifiquesRepetiblesRDTO id(BigDecimal id) {
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

  public DadesEspecifiquesRepetiblesRDTO nou(Integer nou) {
    this.nou = nou;
    return this;
  }

   /**
   * Get nou
   * @return nou
  **/
  @ApiModelProperty(value = "")
  public Integer getNou() {
    return nou;
  }

  public void setNou(Integer nou) {
    this.nou = nou;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DadesEspecifiquesRepetiblesRDTO dadesEspecifiquesRepetiblesRDTO = (DadesEspecifiquesRepetiblesRDTO) o;
    return Objects.equals(this.campIdext, dadesEspecifiquesRepetiblesRDTO.campIdext) &&
        Objects.equals(this.dadesEspecifiquesValorsJsonList, dadesEspecifiquesRepetiblesRDTO.dadesEspecifiquesValorsJsonList) &&
        Objects.equals(this.expedient, dadesEspecifiquesRepetiblesRDTO.expedient) &&
        Objects.equals(this.grupIdext, dadesEspecifiquesRepetiblesRDTO.grupIdext) &&
        Objects.equals(this.id, dadesEspecifiquesRepetiblesRDTO.id) &&
        Objects.equals(this.nou, dadesEspecifiquesRepetiblesRDTO.nou);
  }

  @Override
  public int hashCode() {
    return Objects.hash(campIdext, dadesEspecifiquesValorsJsonList, expedient, grupIdext, id, nou);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesEspecifiquesRepetiblesRDTO {\n");
    
    sb.append("    campIdext: ").append(toIndentedString(campIdext)).append("\n");
    sb.append("    dadesEspecifiquesValorsJsonList: ").append(toIndentedString(dadesEspecifiquesValorsJsonList)).append("\n");
    sb.append("    expedient: ").append(toIndentedString(expedient)).append("\n");
    sb.append("    grupIdext: ").append(toIndentedString(grupIdext)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nou: ").append(toIndentedString(nou)).append("\n");
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

