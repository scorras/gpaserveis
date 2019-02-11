/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 1.4.0
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
 * ProcedimentsTramitsRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-11T02:29:50.908+01:00")
public class ProcedimentsTramitsRDTO {
  @JsonProperty("procediment")
  private BigDecimal procediment = null;

  @JsonProperty("tramit")
  private BigDecimal tramit = null;

  public ProcedimentsTramitsRDTO procediment(BigDecimal procediment) {
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

  public ProcedimentsTramitsRDTO tramit(BigDecimal tramit) {
    this.tramit = tramit;
    return this;
  }

   /**
   * Get tramit
   * @return tramit
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getTramit() {
    return tramit;
  }

  public void setTramit(BigDecimal tramit) {
    this.tramit = tramit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcedimentsTramitsRDTO procedimentsTramitsRDTO = (ProcedimentsTramitsRDTO) o;
    return Objects.equals(this.procediment, procedimentsTramitsRDTO.procediment) &&
        Objects.equals(this.tramit, procedimentsTramitsRDTO.tramit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(procediment, tramit);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcedimentsTramitsRDTO {\n");
    
    sb.append("    procediment: ").append(toIndentedString(procediment)).append("\n");
    sb.append("    tramit: ").append(toIndentedString(tramit)).append("\n");
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

