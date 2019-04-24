/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.10.0
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
import java.util.ArrayList;
import java.util.List;

/**
 * DocsEntradaIdsAndEstatRevisioId
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-24T15:03:39.598+02:00")
public class DocsEntradaIdsAndEstatRevisioId {
  @JsonProperty("docsEntradaIds")
  private List<BigDecimal> docsEntradaIds = null;

  @JsonProperty("estatRevisioId")
  private Integer estatRevisioId = null;

  @JsonProperty("expedientId")
  private BigDecimal expedientId = null;

  public DocsEntradaIdsAndEstatRevisioId docsEntradaIds(List<BigDecimal> docsEntradaIds) {
    this.docsEntradaIds = docsEntradaIds;
    return this;
  }

  public DocsEntradaIdsAndEstatRevisioId addDocsEntradaIdsItem(BigDecimal docsEntradaIdsItem) {
    if (this.docsEntradaIds == null) {
      this.docsEntradaIds = new ArrayList<BigDecimal>();
    }
    this.docsEntradaIds.add(docsEntradaIdsItem);
    return this;
  }

   /**
   * Get docsEntradaIds
   * @return docsEntradaIds
  **/
  @ApiModelProperty(value = "")
  public List<BigDecimal> getDocsEntradaIds() {
    return docsEntradaIds;
  }

  public void setDocsEntradaIds(List<BigDecimal> docsEntradaIds) {
    this.docsEntradaIds = docsEntradaIds;
  }

  public DocsEntradaIdsAndEstatRevisioId estatRevisioId(Integer estatRevisioId) {
    this.estatRevisioId = estatRevisioId;
    return this;
  }

   /**
   * Get estatRevisioId
   * @return estatRevisioId
  **/
  @ApiModelProperty(value = "")
  public Integer getEstatRevisioId() {
    return estatRevisioId;
  }

  public void setEstatRevisioId(Integer estatRevisioId) {
    this.estatRevisioId = estatRevisioId;
  }

  public DocsEntradaIdsAndEstatRevisioId expedientId(BigDecimal expedientId) {
    this.expedientId = expedientId;
    return this;
  }

   /**
   * Get expedientId
   * @return expedientId
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getExpedientId() {
    return expedientId;
  }

  public void setExpedientId(BigDecimal expedientId) {
    this.expedientId = expedientId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocsEntradaIdsAndEstatRevisioId docsEntradaIdsAndEstatRevisioId = (DocsEntradaIdsAndEstatRevisioId) o;
    return Objects.equals(this.docsEntradaIds, docsEntradaIdsAndEstatRevisioId.docsEntradaIds) &&
        Objects.equals(this.estatRevisioId, docsEntradaIdsAndEstatRevisioId.estatRevisioId) &&
        Objects.equals(this.expedientId, docsEntradaIdsAndEstatRevisioId.expedientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(docsEntradaIds, estatRevisioId, expedientId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocsEntradaIdsAndEstatRevisioId {\n");
    
    sb.append("    docsEntradaIds: ").append(toIndentedString(docsEntradaIds)).append("\n");
    sb.append("    estatRevisioId: ").append(toIndentedString(estatRevisioId)).append("\n");
    sb.append("    expedientId: ").append(toIndentedString(expedientId)).append("\n");
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

