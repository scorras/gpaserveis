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
 * ProcedimentsIniciacions
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-08T16:49:56.830+01:00")
public class ProcedimentsIniciacions {
  @JsonProperty("iniciacio")
  private Integer iniciacio = null;

  @JsonProperty("procediment")
  private BigDecimal procediment = null;

  public ProcedimentsIniciacions iniciacio(Integer iniciacio) {
    this.iniciacio = iniciacio;
    return this;
  }

   /**
   * Get iniciacio
   * @return iniciacio
  **/
  @ApiModelProperty(value = "")
  public Integer getIniciacio() {
    return iniciacio;
  }

  public void setIniciacio(Integer iniciacio) {
    this.iniciacio = iniciacio;
  }

  public ProcedimentsIniciacions procediment(BigDecimal procediment) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcedimentsIniciacions procedimentsIniciacions = (ProcedimentsIniciacions) o;
    return Objects.equals(this.iniciacio, procedimentsIniciacions.iniciacio) &&
        Objects.equals(this.procediment, procedimentsIniciacions.procediment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iniciacio, procediment);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcedimentsIniciacions {\n");
    
    sb.append("    iniciacio: ").append(toIndentedString(iniciacio)).append("\n");
    sb.append("    procediment: ").append(toIndentedString(procediment)).append("\n");
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

