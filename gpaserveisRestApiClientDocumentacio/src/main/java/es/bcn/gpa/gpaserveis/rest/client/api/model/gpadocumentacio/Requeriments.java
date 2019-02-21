/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.5.0
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
 * Requeriments
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-21T02:17:09.808+01:00")
public class Requeriments {
  @JsonProperty("docsTramitacio")
  private BigDecimal docsTramitacio = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  public Requeriments docsTramitacio(BigDecimal docsTramitacio) {
    this.docsTramitacio = docsTramitacio;
    return this;
  }

   /**
   * Get docsTramitacio
   * @return docsTramitacio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDocsTramitacio() {
    return docsTramitacio;
  }

  public void setDocsTramitacio(BigDecimal docsTramitacio) {
    this.docsTramitacio = docsTramitacio;
  }

  public Requeriments id(BigDecimal id) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Requeriments requeriments = (Requeriments) o;
    return Objects.equals(this.docsTramitacio, requeriments.docsTramitacio) &&
        Objects.equals(this.id, requeriments.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(docsTramitacio, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Requeriments {\n");
    
    sb.append("    docsTramitacio: ").append(toIndentedString(docsTramitacio)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

