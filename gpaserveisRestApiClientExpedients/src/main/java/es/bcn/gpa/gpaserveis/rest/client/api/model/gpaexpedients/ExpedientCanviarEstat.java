/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 2.10.3
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ExpedientCanviarEstat
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-08T15:53:07.446+01:00")
public class ExpedientCanviarEstat {
  @JsonProperty("codi")
  private String codi = null;

  @JsonProperty("documentacioPendente")
  private List<String> documentacioPendente = null;

  @JsonProperty("estat")
  private String estat = null;

  @JsonProperty("estatCastella")
  private String estatCastella = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  public ExpedientCanviarEstat codi(String codi) {
    this.codi = codi;
    return this;
  }

   /**
   * Codi identificador de l&#39;expedient
   * @return codi
  **/
  @ApiModelProperty(value = "Codi identificador de l'expedient")
  public String getCodi() {
    return codi;
  }

  public void setCodi(String codi) {
    this.codi = codi;
  }

  public ExpedientCanviarEstat documentacioPendente(List<String> documentacioPendente) {
    this.documentacioPendente = documentacioPendente;
    return this;
  }

  public ExpedientCanviarEstat addDocumentacioPendenteItem(String documentacioPendenteItem) {
    if (this.documentacioPendente == null) {
      this.documentacioPendente = new ArrayList<String>();
    }
    this.documentacioPendente.add(documentacioPendenteItem);
    return this;
  }

   /**
   * Documentaciò pendente
   * @return documentacioPendente
  **/
  @ApiModelProperty(value = "Documentaciò pendente")
  public List<String> getDocumentacioPendente() {
    return documentacioPendente;
  }

  public void setDocumentacioPendente(List<String> documentacioPendente) {
    this.documentacioPendente = documentacioPendente;
  }

  public ExpedientCanviarEstat estat(String estat) {
    this.estat = estat;
    return this;
  }

   /**
   * Estat actual del expedient
   * @return estat
  **/
  @ApiModelProperty(value = "Estat actual del expedient")
  public String getEstat() {
    return estat;
  }

  public void setEstat(String estat) {
    this.estat = estat;
  }

  public ExpedientCanviarEstat estatCastella(String estatCastella) {
    this.estatCastella = estatCastella;
    return this;
  }

   /**
   * Estat actual del expedient en castellà
   * @return estatCastella
  **/
  @ApiModelProperty(value = "Estat actual del expedient en castellà")
  public String getEstatCastella() {
    return estatCastella;
  }

  public void setEstatCastella(String estatCastella) {
    this.estatCastella = estatCastella;
  }

  public ExpedientCanviarEstat id(BigDecimal id) {
    this.id = id;
    return this;
  }

   /**
   * Identificador de l&#39;expedient
   * @return id
  **/
  @ApiModelProperty(value = "Identificador de l'expedient")
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
    ExpedientCanviarEstat expedientCanviarEstat = (ExpedientCanviarEstat) o;
    return Objects.equals(this.codi, expedientCanviarEstat.codi) &&
        Objects.equals(this.documentacioPendente, expedientCanviarEstat.documentacioPendente) &&
        Objects.equals(this.estat, expedientCanviarEstat.estat) &&
        Objects.equals(this.estatCastella, expedientCanviarEstat.estatCastella) &&
        Objects.equals(this.id, expedientCanviarEstat.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codi, documentacioPendente, estat, estatCastella, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExpedientCanviarEstat {\n");
    
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    documentacioPendente: ").append(toIndentedString(documentacioPendente)).append("\n");
    sb.append("    estat: ").append(toIndentedString(estat)).append("\n");
    sb.append("    estatCastella: ").append(toIndentedString(estatCastella)).append("\n");
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

