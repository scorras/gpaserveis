/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 2.11.0
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
 * DadesOperTramitsOvt
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-17T10:14:01.849+01:00")
public class DadesOperTramitsOvt {
  @JsonProperty("dadaOper")
  private BigDecimal dadaOper = null;

  @JsonProperty("tramitOvtIdext")
  private BigDecimal tramitOvtIdext = null;

  public DadesOperTramitsOvt dadaOper(BigDecimal dadaOper) {
    this.dadaOper = dadaOper;
    return this;
  }

   /**
   * Get dadaOper
   * @return dadaOper
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDadaOper() {
    return dadaOper;
  }

  public void setDadaOper(BigDecimal dadaOper) {
    this.dadaOper = dadaOper;
  }

  public DadesOperTramitsOvt tramitOvtIdext(BigDecimal tramitOvtIdext) {
    this.tramitOvtIdext = tramitOvtIdext;
    return this;
  }

   /**
   * Get tramitOvtIdext
   * @return tramitOvtIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getTramitOvtIdext() {
    return tramitOvtIdext;
  }

  public void setTramitOvtIdext(BigDecimal tramitOvtIdext) {
    this.tramitOvtIdext = tramitOvtIdext;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DadesOperTramitsOvt dadesOperTramitsOvt = (DadesOperTramitsOvt) o;
    return Objects.equals(this.dadaOper, dadesOperTramitsOvt.dadaOper) &&
        Objects.equals(this.tramitOvtIdext, dadesOperTramitsOvt.tramitOvtIdext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dadaOper, tramitOvtIdext);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesOperTramitsOvt {\n");
    
    sb.append("    dadaOper: ").append(toIndentedString(dadaOper)).append("\n");
    sb.append("    tramitOvtIdext: ").append(toIndentedString(tramitOvtIdext)).append("\n");
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

