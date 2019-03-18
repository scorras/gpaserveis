/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.6.0
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
 * RespostaSincronitzarRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-18T10:38:37.495+01:00")
public class RespostaSincronitzarRDTO {
  @JsonProperty("idConfDoc")
  private BigDecimal idConfDoc = null;

  @JsonProperty("idProcediment")
  private BigDecimal idProcediment = null;

  @JsonProperty("idProcedimentVersionat")
  private BigDecimal idProcedimentVersionat = null;

  @JsonProperty("versioDocumental")
  private Integer versioDocumental = null;

  public RespostaSincronitzarRDTO idConfDoc(BigDecimal idConfDoc) {
    this.idConfDoc = idConfDoc;
    return this;
  }

   /**
   * Get idConfDoc
   * @return idConfDoc
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIdConfDoc() {
    return idConfDoc;
  }

  public void setIdConfDoc(BigDecimal idConfDoc) {
    this.idConfDoc = idConfDoc;
  }

  public RespostaSincronitzarRDTO idProcediment(BigDecimal idProcediment) {
    this.idProcediment = idProcediment;
    return this;
  }

   /**
   * Get idProcediment
   * @return idProcediment
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIdProcediment() {
    return idProcediment;
  }

  public void setIdProcediment(BigDecimal idProcediment) {
    this.idProcediment = idProcediment;
  }

  public RespostaSincronitzarRDTO idProcedimentVersionat(BigDecimal idProcedimentVersionat) {
    this.idProcedimentVersionat = idProcedimentVersionat;
    return this;
  }

   /**
   * Get idProcedimentVersionat
   * @return idProcedimentVersionat
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIdProcedimentVersionat() {
    return idProcedimentVersionat;
  }

  public void setIdProcedimentVersionat(BigDecimal idProcedimentVersionat) {
    this.idProcedimentVersionat = idProcedimentVersionat;
  }

  public RespostaSincronitzarRDTO versioDocumental(Integer versioDocumental) {
    this.versioDocumental = versioDocumental;
    return this;
  }

   /**
   * Get versioDocumental
   * @return versioDocumental
  **/
  @ApiModelProperty(value = "")
  public Integer getVersioDocumental() {
    return versioDocumental;
  }

  public void setVersioDocumental(Integer versioDocumental) {
    this.versioDocumental = versioDocumental;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespostaSincronitzarRDTO respostaSincronitzarRDTO = (RespostaSincronitzarRDTO) o;
    return Objects.equals(this.idConfDoc, respostaSincronitzarRDTO.idConfDoc) &&
        Objects.equals(this.idProcediment, respostaSincronitzarRDTO.idProcediment) &&
        Objects.equals(this.idProcedimentVersionat, respostaSincronitzarRDTO.idProcedimentVersionat) &&
        Objects.equals(this.versioDocumental, respostaSincronitzarRDTO.versioDocumental);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idConfDoc, idProcediment, idProcedimentVersionat, versioDocumental);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespostaSincronitzarRDTO {\n");
    
    sb.append("    idConfDoc: ").append(toIndentedString(idConfDoc)).append("\n");
    sb.append("    idProcediment: ").append(toIndentedString(idProcediment)).append("\n");
    sb.append("    idProcedimentVersionat: ").append(toIndentedString(idProcedimentVersionat)).append("\n");
    sb.append("    versioDocumental: ").append(toIndentedString(versioDocumental)).append("\n");
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

