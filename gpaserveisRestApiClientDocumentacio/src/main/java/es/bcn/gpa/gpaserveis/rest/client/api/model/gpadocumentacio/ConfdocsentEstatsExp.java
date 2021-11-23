/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 2.11.0
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
 * ConfdocsentEstatsExp
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-12T13:43:03.162+01:00")
public class ConfdocsentEstatsExp {
  @JsonProperty("confDocsEntrada")
  private BigDecimal confDocsEntrada = null;

  @JsonProperty("estatExpIdext")
  private BigDecimal estatExpIdext = null;

  public ConfdocsentEstatsExp confDocsEntrada(BigDecimal confDocsEntrada) {
    this.confDocsEntrada = confDocsEntrada;
    return this;
  }

   /**
   * Get confDocsEntrada
   * @return confDocsEntrada
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getConfDocsEntrada() {
    return confDocsEntrada;
  }

  public void setConfDocsEntrada(BigDecimal confDocsEntrada) {
    this.confDocsEntrada = confDocsEntrada;
  }

  public ConfdocsentEstatsExp estatExpIdext(BigDecimal estatExpIdext) {
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
    ConfdocsentEstatsExp confdocsentEstatsExp = (ConfdocsentEstatsExp) o;
    return Objects.equals(this.confDocsEntrada, confdocsentEstatsExp.confDocsEntrada) &&
        Objects.equals(this.estatExpIdext, confdocsentEstatsExp.estatExpIdext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(confDocsEntrada, estatExpIdext);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfdocsentEstatsExp {\n");
    
    sb.append("    confDocsEntrada: ").append(toIndentedString(confDocsEntrada)).append("\n");
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

