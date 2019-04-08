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
 * Items
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-08T18:12:32.660+02:00")
public class Items {
  @JsonProperty("dadesOperacions")
  private BigDecimal dadesOperacions = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("itemDescripcio")
  private String itemDescripcio = null;

  @JsonProperty("itemId")
  private Integer itemId = null;

  @JsonProperty("itemOrdre")
  private Integer itemOrdre = null;

  public Items dadesOperacions(BigDecimal dadesOperacions) {
    this.dadesOperacions = dadesOperacions;
    return this;
  }

   /**
   * Get dadesOperacions
   * @return dadesOperacions
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDadesOperacions() {
    return dadesOperacions;
  }

  public void setDadesOperacions(BigDecimal dadesOperacions) {
    this.dadesOperacions = dadesOperacions;
  }

  public Items id(BigDecimal id) {
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

  public Items itemDescripcio(String itemDescripcio) {
    this.itemDescripcio = itemDescripcio;
    return this;
  }

   /**
   * Get itemDescripcio
   * @return itemDescripcio
  **/
  @ApiModelProperty(value = "")
  public String getItemDescripcio() {
    return itemDescripcio;
  }

  public void setItemDescripcio(String itemDescripcio) {
    this.itemDescripcio = itemDescripcio;
  }

  public Items itemId(Integer itemId) {
    this.itemId = itemId;
    return this;
  }

   /**
   * Get itemId
   * @return itemId
  **/
  @ApiModelProperty(value = "")
  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public Items itemOrdre(Integer itemOrdre) {
    this.itemOrdre = itemOrdre;
    return this;
  }

   /**
   * Get itemOrdre
   * @return itemOrdre
  **/
  @ApiModelProperty(value = "")
  public Integer getItemOrdre() {
    return itemOrdre;
  }

  public void setItemOrdre(Integer itemOrdre) {
    this.itemOrdre = itemOrdre;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Items items = (Items) o;
    return Objects.equals(this.dadesOperacions, items.dadesOperacions) &&
        Objects.equals(this.id, items.id) &&
        Objects.equals(this.itemDescripcio, items.itemDescripcio) &&
        Objects.equals(this.itemId, items.itemId) &&
        Objects.equals(this.itemOrdre, items.itemOrdre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dadesOperacions, id, itemDescripcio, itemId, itemOrdre);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Items {\n");
    
    sb.append("    dadesOperacions: ").append(toIndentedString(dadesOperacions)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    itemDescripcio: ").append(toIndentedString(itemDescripcio)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    itemOrdre: ").append(toIndentedString(itemOrdre)).append("\n");
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

