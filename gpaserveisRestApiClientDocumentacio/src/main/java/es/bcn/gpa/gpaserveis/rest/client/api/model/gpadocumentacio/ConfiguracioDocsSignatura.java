/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.16.2
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
 * ConfiguracioDocsSignatura
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-01-28T16:04:49.801+01:00")
public class ConfiguracioDocsSignatura {
  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("personesFirmantsMaxim")
  private Long personesFirmantsMaxim = null;

  @JsonProperty("unitatGestora")
  private String unitatGestora = null;

  public ConfiguracioDocsSignatura id(BigDecimal id) {
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

  public ConfiguracioDocsSignatura personesFirmantsMaxim(Long personesFirmantsMaxim) {
    this.personesFirmantsMaxim = personesFirmantsMaxim;
    return this;
  }

   /**
   * Get personesFirmantsMaxim
   * @return personesFirmantsMaxim
  **/
  @ApiModelProperty(value = "")
  public Long getPersonesFirmantsMaxim() {
    return personesFirmantsMaxim;
  }

  public void setPersonesFirmantsMaxim(Long personesFirmantsMaxim) {
    this.personesFirmantsMaxim = personesFirmantsMaxim;
  }

  public ConfiguracioDocsSignatura unitatGestora(String unitatGestora) {
    this.unitatGestora = unitatGestora;
    return this;
  }

   /**
   * Get unitatGestora
   * @return unitatGestora
  **/
  @ApiModelProperty(value = "")
  public String getUnitatGestora() {
    return unitatGestora;
  }

  public void setUnitatGestora(String unitatGestora) {
    this.unitatGestora = unitatGestora;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfiguracioDocsSignatura configuracioDocsSignatura = (ConfiguracioDocsSignatura) o;
    return Objects.equals(this.id, configuracioDocsSignatura.id) &&
        Objects.equals(this.personesFirmantsMaxim, configuracioDocsSignatura.personesFirmantsMaxim) &&
        Objects.equals(this.unitatGestora, configuracioDocsSignatura.unitatGestora);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, personesFirmantsMaxim, unitatGestora);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfiguracioDocsSignatura {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    personesFirmantsMaxim: ").append(toIndentedString(personesFirmantsMaxim)).append("\n");
    sb.append("    unitatGestora: ").append(toIndentedString(unitatGestora)).append("\n");
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

