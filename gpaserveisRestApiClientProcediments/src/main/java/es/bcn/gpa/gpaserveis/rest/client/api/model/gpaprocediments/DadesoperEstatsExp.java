/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 1.8.0
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
 * DadesoperEstatsExp
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-08T18:54:04.705+02:00")
public class DadesoperEstatsExp {
  @JsonProperty("dadesOperacio")
  private BigDecimal dadesOperacio = null;

  @JsonProperty("estatExpIdext")
  private BigDecimal estatExpIdext = null;

  public DadesoperEstatsExp dadesOperacio(BigDecimal dadesOperacio) {
    this.dadesOperacio = dadesOperacio;
    return this;
  }

   /**
   * Get dadesOperacio
   * @return dadesOperacio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDadesOperacio() {
    return dadesOperacio;
  }

  public void setDadesOperacio(BigDecimal dadesOperacio) {
    this.dadesOperacio = dadesOperacio;
  }

  public DadesoperEstatsExp estatExpIdext(BigDecimal estatExpIdext) {
    this.estatExpIdext = estatExpIdext;
    return this;
  }

   /**
   * Get estatExpIdext
   * @return estatExpIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getEstatExpIdext() {
    return estatExpIdext;
  }

  public void setEstatExpIdext(BigDecimal estatExpIdext) {
    this.estatExpIdext = estatExpIdext;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DadesoperEstatsExp dadesoperEstatsExp = (DadesoperEstatsExp) o;
    return Objects.equals(this.dadesOperacio, dadesoperEstatsExp.dadesOperacio) &&
        Objects.equals(this.estatExpIdext, dadesoperEstatsExp.estatExpIdext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dadesOperacio, estatExpIdext);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesoperEstatsExp {\n");
    
    sb.append("    dadesOperacio: ").append(toIndentedString(dadesOperacio)).append("\n");
    sb.append("    estatExpIdext: ").append(toIndentedString(estatExpIdext)).append("\n");
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
