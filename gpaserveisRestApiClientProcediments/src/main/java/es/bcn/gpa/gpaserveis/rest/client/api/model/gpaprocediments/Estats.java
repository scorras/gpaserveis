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
 * Estats
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-02T01:20:30.818+02:00")
public class Estats {
  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("descripcioCastella")
  private String descripcioCastella = null;

  @JsonProperty("descripcioCatala")
  private String descripcioCatala = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  public Estats descripcio(String descripcio) {
    this.descripcio = descripcio;
    return this;
  }

   /**
   * Get descripcio
   * @return descripcio
  **/
  @ApiModelProperty(value = "")
  public String getDescripcio() {
    return descripcio;
  }

  public void setDescripcio(String descripcio) {
    this.descripcio = descripcio;
  }

  public Estats descripcioCastella(String descripcioCastella) {
    this.descripcioCastella = descripcioCastella;
    return this;
  }

   /**
   * Get descripcioCastella
   * @return descripcioCastella
  **/
  @ApiModelProperty(value = "")
  public String getDescripcioCastella() {
    return descripcioCastella;
  }

  public void setDescripcioCastella(String descripcioCastella) {
    this.descripcioCastella = descripcioCastella;
  }

  public Estats descripcioCatala(String descripcioCatala) {
    this.descripcioCatala = descripcioCatala;
    return this;
  }

   /**
   * Get descripcioCatala
   * @return descripcioCatala
  **/
  @ApiModelProperty(value = "")
  public String getDescripcioCatala() {
    return descripcioCatala;
  }

  public void setDescripcioCatala(String descripcioCatala) {
    this.descripcioCatala = descripcioCatala;
  }

  public Estats id(BigDecimal id) {
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
    Estats estats = (Estats) o;
    return Objects.equals(this.descripcio, estats.descripcio) &&
        Objects.equals(this.descripcioCastella, estats.descripcioCastella) &&
        Objects.equals(this.descripcioCatala, estats.descripcioCatala) &&
        Objects.equals(this.id, estats.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(descripcio, descripcioCastella, descripcioCatala, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Estats {\n");
    
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
    sb.append("    descripcioCastella: ").append(toIndentedString(descripcioCastella)).append("\n");
    sb.append("    descripcioCatala: ").append(toIndentedString(descripcioCatala)).append("\n");
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

