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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Usuaris;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.joda.time.DateTime;

/**
 * BloquejosRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-14T18:24:51.718+02:00")
public class BloquejosRDTO {
  @JsonProperty("expedientBloquejatPerAltreUsuari")
  private Boolean expedientBloquejatPerAltreUsuari = null;

  @JsonProperty("expedientEditable")
  private Boolean expedientEditable = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("momentBloqueig")
  private DateTime momentBloqueig = null;

  @JsonProperty("tipus")
  private String tipus = null;

  @JsonProperty("usuari")
  private BigDecimal usuari = null;

  @JsonProperty("usuariBloquejo")
  private Usuaris usuariBloquejo = null;

  public BloquejosRDTO expedientBloquejatPerAltreUsuari(Boolean expedientBloquejatPerAltreUsuari) {
    this.expedientBloquejatPerAltreUsuari = expedientBloquejatPerAltreUsuari;
    return this;
  }

   /**
   * Get expedientBloquejatPerAltreUsuari
   * @return expedientBloquejatPerAltreUsuari
  **/
  @ApiModelProperty(value = "")
  public Boolean isExpedientBloquejatPerAltreUsuari() {
    return expedientBloquejatPerAltreUsuari;
  }

  public void setExpedientBloquejatPerAltreUsuari(Boolean expedientBloquejatPerAltreUsuari) {
    this.expedientBloquejatPerAltreUsuari = expedientBloquejatPerAltreUsuari;
  }

  public BloquejosRDTO expedientEditable(Boolean expedientEditable) {
    this.expedientEditable = expedientEditable;
    return this;
  }

   /**
   * Get expedientEditable
   * @return expedientEditable
  **/
  @ApiModelProperty(value = "")
  public Boolean isExpedientEditable() {
    return expedientEditable;
  }

  public void setExpedientEditable(Boolean expedientEditable) {
    this.expedientEditable = expedientEditable;
  }

  public BloquejosRDTO id(BigDecimal id) {
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

  public BloquejosRDTO momentBloqueig(DateTime momentBloqueig) {
    this.momentBloqueig = momentBloqueig;
    return this;
  }

   /**
   * Get momentBloqueig
   * @return momentBloqueig
  **/
  @ApiModelProperty(value = "")
  public DateTime getMomentBloqueig() {
    return momentBloqueig;
  }

  public void setMomentBloqueig(DateTime momentBloqueig) {
    this.momentBloqueig = momentBloqueig;
  }

  public BloquejosRDTO tipus(String tipus) {
    this.tipus = tipus;
    return this;
  }

   /**
   * Get tipus
   * @return tipus
  **/
  @ApiModelProperty(value = "")
  public String getTipus() {
    return tipus;
  }

  public void setTipus(String tipus) {
    this.tipus = tipus;
  }

  public BloquejosRDTO usuari(BigDecimal usuari) {
    this.usuari = usuari;
    return this;
  }

   /**
   * Get usuari
   * @return usuari
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUsuari() {
    return usuari;
  }

  public void setUsuari(BigDecimal usuari) {
    this.usuari = usuari;
  }

  public BloquejosRDTO usuariBloquejo(Usuaris usuariBloquejo) {
    this.usuariBloquejo = usuariBloquejo;
    return this;
  }

   /**
   * Get usuariBloquejo
   * @return usuariBloquejo
  **/
  @ApiModelProperty(value = "")
  public Usuaris getUsuariBloquejo() {
    return usuariBloquejo;
  }

  public void setUsuariBloquejo(Usuaris usuariBloquejo) {
    this.usuariBloquejo = usuariBloquejo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BloquejosRDTO bloquejosRDTO = (BloquejosRDTO) o;
    return Objects.equals(this.expedientBloquejatPerAltreUsuari, bloquejosRDTO.expedientBloquejatPerAltreUsuari) &&
        Objects.equals(this.expedientEditable, bloquejosRDTO.expedientEditable) &&
        Objects.equals(this.id, bloquejosRDTO.id) &&
        Objects.equals(this.momentBloqueig, bloquejosRDTO.momentBloqueig) &&
        Objects.equals(this.tipus, bloquejosRDTO.tipus) &&
        Objects.equals(this.usuari, bloquejosRDTO.usuari) &&
        Objects.equals(this.usuariBloquejo, bloquejosRDTO.usuariBloquejo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expedientBloquejatPerAltreUsuari, expedientEditable, id, momentBloqueig, tipus, usuari, usuariBloquejo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BloquejosRDTO {\n");
    
    sb.append("    expedientBloquejatPerAltreUsuari: ").append(toIndentedString(expedientBloquejatPerAltreUsuari)).append("\n");
    sb.append("    expedientEditable: ").append(toIndentedString(expedientEditable)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    momentBloqueig: ").append(toIndentedString(momentBloqueig)).append("\n");
    sb.append("    tipus: ").append(toIndentedString(tipus)).append("\n");
    sb.append("    usuari: ").append(toIndentedString(usuari)).append("\n");
    sb.append("    usuariBloquejo: ").append(toIndentedString(usuariBloquejo)).append("\n");
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

