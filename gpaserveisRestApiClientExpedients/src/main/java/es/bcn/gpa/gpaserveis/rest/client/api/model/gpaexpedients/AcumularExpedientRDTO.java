/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.11.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Comentaris;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AcumularExpedientRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-08T14:08:13.234+02:00")
public class AcumularExpedientRDTO {
  @JsonProperty("codiExpedientAcumulador")
  private String codiExpedientAcumulador = null;

  @JsonProperty("comentari")
  private Comentaris comentari = null;

  @JsonProperty("expedientsAcumulats")
  private Map<String, String> expedientsAcumulats = null;

  @JsonProperty("idExpedientAcumulador")
  private BigDecimal idExpedientAcumulador = null;

  public AcumularExpedientRDTO codiExpedientAcumulador(String codiExpedientAcumulador) {
    this.codiExpedientAcumulador = codiExpedientAcumulador;
    return this;
  }

   /**
   * Get codiExpedientAcumulador
   * @return codiExpedientAcumulador
  **/
  @ApiModelProperty(value = "")
  public String getCodiExpedientAcumulador() {
    return codiExpedientAcumulador;
  }

  public void setCodiExpedientAcumulador(String codiExpedientAcumulador) {
    this.codiExpedientAcumulador = codiExpedientAcumulador;
  }

  public AcumularExpedientRDTO comentari(Comentaris comentari) {
    this.comentari = comentari;
    return this;
  }

   /**
   * Get comentari
   * @return comentari
  **/
  @ApiModelProperty(value = "")
  public Comentaris getComentari() {
    return comentari;
  }

  public void setComentari(Comentaris comentari) {
    this.comentari = comentari;
  }

  public AcumularExpedientRDTO expedientsAcumulats(Map<String, String> expedientsAcumulats) {
    this.expedientsAcumulats = expedientsAcumulats;
    return this;
  }

  public AcumularExpedientRDTO putExpedientsAcumulatsItem(String key, String expedientsAcumulatsItem) {
    if (this.expedientsAcumulats == null) {
      this.expedientsAcumulats = new HashMap<String, String>();
    }
    this.expedientsAcumulats.put(key, expedientsAcumulatsItem);
    return this;
  }

   /**
   * Get expedientsAcumulats
   * @return expedientsAcumulats
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getExpedientsAcumulats() {
    return expedientsAcumulats;
  }

  public void setExpedientsAcumulats(Map<String, String> expedientsAcumulats) {
    this.expedientsAcumulats = expedientsAcumulats;
  }

  public AcumularExpedientRDTO idExpedientAcumulador(BigDecimal idExpedientAcumulador) {
    this.idExpedientAcumulador = idExpedientAcumulador;
    return this;
  }

   /**
   * Get idExpedientAcumulador
   * @return idExpedientAcumulador
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIdExpedientAcumulador() {
    return idExpedientAcumulador;
  }

  public void setIdExpedientAcumulador(BigDecimal idExpedientAcumulador) {
    this.idExpedientAcumulador = idExpedientAcumulador;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcumularExpedientRDTO acumularExpedientRDTO = (AcumularExpedientRDTO) o;
    return Objects.equals(this.codiExpedientAcumulador, acumularExpedientRDTO.codiExpedientAcumulador) &&
        Objects.equals(this.comentari, acumularExpedientRDTO.comentari) &&
        Objects.equals(this.expedientsAcumulats, acumularExpedientRDTO.expedientsAcumulats) &&
        Objects.equals(this.idExpedientAcumulador, acumularExpedientRDTO.idExpedientAcumulador);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiExpedientAcumulador, comentari, expedientsAcumulats, idExpedientAcumulador);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcumularExpedientRDTO {\n");
    
    sb.append("    codiExpedientAcumulador: ").append(toIndentedString(codiExpedientAcumulador)).append("\n");
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
    sb.append("    expedientsAcumulats: ").append(toIndentedString(expedientsAcumulats)).append("\n");
    sb.append("    idExpedientAcumulador: ").append(toIndentedString(idExpedientAcumulador)).append("\n");
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

