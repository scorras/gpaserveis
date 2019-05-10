/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 1.11.0
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
 * ProcedimentsForUnitatsRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-10T10:06:44.423+02:00")
public class ProcedimentsForUnitatsRDTO {
  @JsonProperty("codi")
  private String codi = null;

  @JsonProperty("idUgo")
  private BigDecimal idUgo = null;

  public ProcedimentsForUnitatsRDTO codi(String codi) {
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

  public ProcedimentsForUnitatsRDTO idUgo(BigDecimal idUgo) {
    this.idUgo = idUgo;
    return this;
  }

   /**
   * Get idUgo
   * @return idUgo
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIdUgo() {
    return idUgo;
  }

  public void setIdUgo(BigDecimal idUgo) {
    this.idUgo = idUgo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcedimentsForUnitatsRDTO procedimentsForUnitatsRDTO = (ProcedimentsForUnitatsRDTO) o;
    return Objects.equals(this.codi, procedimentsForUnitatsRDTO.codi) &&
        Objects.equals(this.idUgo, procedimentsForUnitatsRDTO.idUgo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codi, idUgo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcedimentsForUnitatsRDTO {\n");
    
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    idUgo: ").append(toIndentedString(idUgo)).append("\n");
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

