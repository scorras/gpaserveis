/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.12.0
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * CrearNotificacio
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-19T16:12:57.396+02:00")
public class CrearNotificacio {
  @JsonProperty("codiExpedient")
  private String codiExpedient = null;

  @JsonProperty("idDocument")
  private BigDecimal idDocument = null;

  @JsonProperty("idExpedient")
  private BigDecimal idExpedient = null;

  @JsonProperty("nomProcediment")
  private String nomProcediment = null;

  @JsonProperty("persones")
  private List<Persones> persones = null;

  public CrearNotificacio codiExpedient(String codiExpedient) {
    this.codiExpedient = codiExpedient;
    return this;
  }

   /**
   * Codi Opentext de l&#39;expedient
   * @return codiExpedient
  **/
  @ApiModelProperty(value = "Codi Opentext de l'expedient")
  public String getCodiExpedient() {
    return codiExpedient;
  }

  public void setCodiExpedient(String codiExpedient) {
    this.codiExpedient = codiExpedient;
  }

  public CrearNotificacio idDocument(BigDecimal idDocument) {
    this.idDocument = idDocument;
    return this;
  }

   /**
   * Identificador del document de tramitació
   * @return idDocument
  **/
  @ApiModelProperty(value = "Identificador del document de tramitació")
  public BigDecimal getIdDocument() {
    return idDocument;
  }

  public void setIdDocument(BigDecimal idDocument) {
    this.idDocument = idDocument;
  }

  public CrearNotificacio idExpedient(BigDecimal idExpedient) {
    this.idExpedient = idExpedient;
    return this;
  }

   /**
   * Identificador de l&#39;expedient
   * @return idExpedient
  **/
  @ApiModelProperty(value = "Identificador de l'expedient")
  public BigDecimal getIdExpedient() {
    return idExpedient;
  }

  public void setIdExpedient(BigDecimal idExpedient) {
    this.idExpedient = idExpedient;
  }

  public CrearNotificacio nomProcediment(String nomProcediment) {
    this.nomProcediment = nomProcediment;
    return this;
  }

   /**
   * Nom del procediment de l&#39;expedient
   * @return nomProcediment
  **/
  @ApiModelProperty(value = "Nom del procediment de l'expedient")
  public String getNomProcediment() {
    return nomProcediment;
  }

  public void setNomProcediment(String nomProcediment) {
    this.nomProcediment = nomProcediment;
  }

  public CrearNotificacio persones(List<Persones> persones) {
    this.persones = persones;
    return this;
  }

  public CrearNotificacio addPersonesItem(Persones personesItem) {
    if (this.persones == null) {
      this.persones = new ArrayList<Persones>();
    }
    this.persones.add(personesItem);
    return this;
  }

   /**
   * Llista de persones a notificar
   * @return persones
  **/
  @ApiModelProperty(value = "Llista de persones a notificar")
  public List<Persones> getPersones() {
    return persones;
  }

  public void setPersones(List<Persones> persones) {
    this.persones = persones;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrearNotificacio crearNotificacio = (CrearNotificacio) o;
    return Objects.equals(this.codiExpedient, crearNotificacio.codiExpedient) &&
        Objects.equals(this.idDocument, crearNotificacio.idDocument) &&
        Objects.equals(this.idExpedient, crearNotificacio.idExpedient) &&
        Objects.equals(this.nomProcediment, crearNotificacio.nomProcediment) &&
        Objects.equals(this.persones, crearNotificacio.persones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiExpedient, idDocument, idExpedient, nomProcediment, persones);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrearNotificacio {\n");
    
    sb.append("    codiExpedient: ").append(toIndentedString(codiExpedient)).append("\n");
    sb.append("    idDocument: ").append(toIndentedString(idDocument)).append("\n");
    sb.append("    idExpedient: ").append(toIndentedString(idExpedient)).append("\n");
    sb.append("    nomProcediment: ").append(toIndentedString(nomProcediment)).append("\n");
    sb.append("    persones: ").append(toIndentedString(persones)).append("\n");
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

