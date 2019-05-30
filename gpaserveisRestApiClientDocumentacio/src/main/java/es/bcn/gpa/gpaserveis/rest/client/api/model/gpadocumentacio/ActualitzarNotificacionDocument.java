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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.joda.time.DateTime;

/**
 * ActualitzarNotificacionDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-30T14:02:05.775+02:00")
public class ActualitzarNotificacionDocument {
  @JsonProperty("dataAceptacioRebuig")
  private DateTime dataAceptacioRebuig = null;

  @JsonProperty("dataAcusamentRebuda")
  private DateTime dataAcusamentRebuda = null;

  @JsonProperty("dataEnviament")
  private DateTime dataEnviament = null;

  @JsonProperty("dataHoraDiposit")
  private DateTime dataHoraDiposit = null;

  @JsonProperty("dataHoraVisualitzacio")
  private DateTime dataHoraVisualitzacio = null;

  @JsonProperty("dataLimit")
  private DateTime dataLimit = null;

  @JsonProperty("docEvidenciaElectronic")
  private String docEvidenciaElectronic = null;

  @JsonProperty("docEvidenciaPaper")
  private String docEvidenciaPaper = null;

  @JsonProperty("notificacioId")
  private BigDecimal notificacioId = null;

  public ActualitzarNotificacionDocument dataAceptacioRebuig(DateTime dataAceptacioRebuig) {
    this.dataAceptacioRebuig = dataAceptacioRebuig;
    return this;
  }

   /**
   * Data i hora d&#39;aceptació o rebuig
   * @return dataAceptacioRebuig
  **/
  @ApiModelProperty(value = "Data i hora d'aceptació o rebuig")
  public DateTime getDataAceptacioRebuig() {
    return dataAceptacioRebuig;
  }

  public void setDataAceptacioRebuig(DateTime dataAceptacioRebuig) {
    this.dataAceptacioRebuig = dataAceptacioRebuig;
  }

  public ActualitzarNotificacionDocument dataAcusamentRebuda(DateTime dataAcusamentRebuda) {
    this.dataAcusamentRebuda = dataAcusamentRebuda;
    return this;
  }

   /**
   * Data d&#39;acusament rebuda
   * @return dataAcusamentRebuda
  **/
  @ApiModelProperty(value = "Data d'acusament rebuda")
  public DateTime getDataAcusamentRebuda() {
    return dataAcusamentRebuda;
  }

  public void setDataAcusamentRebuda(DateTime dataAcusamentRebuda) {
    this.dataAcusamentRebuda = dataAcusamentRebuda;
  }

  public ActualitzarNotificacionDocument dataEnviament(DateTime dataEnviament) {
    this.dataEnviament = dataEnviament;
    return this;
  }

   /**
   * Data d&#39;enviament
   * @return dataEnviament
  **/
  @ApiModelProperty(value = "Data d'enviament")
  public DateTime getDataEnviament() {
    return dataEnviament;
  }

  public void setDataEnviament(DateTime dataEnviament) {
    this.dataEnviament = dataEnviament;
  }

  public ActualitzarNotificacionDocument dataHoraDiposit(DateTime dataHoraDiposit) {
    this.dataHoraDiposit = dataHoraDiposit;
    return this;
  }

   /**
   * Data i hora dde diposit
   * @return dataHoraDiposit
  **/
  @ApiModelProperty(value = "Data i hora dde diposit")
  public DateTime getDataHoraDiposit() {
    return dataHoraDiposit;
  }

  public void setDataHoraDiposit(DateTime dataHoraDiposit) {
    this.dataHoraDiposit = dataHoraDiposit;
  }

  public ActualitzarNotificacionDocument dataHoraVisualitzacio(DateTime dataHoraVisualitzacio) {
    this.dataHoraVisualitzacio = dataHoraVisualitzacio;
    return this;
  }

   /**
   * Data i hora de visualitzacio
   * @return dataHoraVisualitzacio
  **/
  @ApiModelProperty(value = "Data i hora de visualitzacio")
  public DateTime getDataHoraVisualitzacio() {
    return dataHoraVisualitzacio;
  }

  public void setDataHoraVisualitzacio(DateTime dataHoraVisualitzacio) {
    this.dataHoraVisualitzacio = dataHoraVisualitzacio;
  }

  public ActualitzarNotificacionDocument dataLimit(DateTime dataLimit) {
    this.dataLimit = dataLimit;
    return this;
  }

   /**
   * Data limit
   * @return dataLimit
  **/
  @ApiModelProperty(value = "Data limit")
  public DateTime getDataLimit() {
    return dataLimit;
  }

  public void setDataLimit(DateTime dataLimit) {
    this.dataLimit = dataLimit;
  }

  public ActualitzarNotificacionDocument docEvidenciaElectronic(String docEvidenciaElectronic) {
    this.docEvidenciaElectronic = docEvidenciaElectronic;
    return this;
  }

   /**
   * Document de la evidència electrònica de la notificació
   * @return docEvidenciaElectronic
  **/
  @ApiModelProperty(value = "Document de la evidència electrònica de la notificació")
  public String getDocEvidenciaElectronic() {
    return docEvidenciaElectronic;
  }

  public void setDocEvidenciaElectronic(String docEvidenciaElectronic) {
    this.docEvidenciaElectronic = docEvidenciaElectronic;
  }

  public ActualitzarNotificacionDocument docEvidenciaPaper(String docEvidenciaPaper) {
    this.docEvidenciaPaper = docEvidenciaPaper;
    return this;
  }

   /**
   * Document de la evidència en paper de la notificació
   * @return docEvidenciaPaper
  **/
  @ApiModelProperty(value = "Document de la evidència en paper de la notificació")
  public String getDocEvidenciaPaper() {
    return docEvidenciaPaper;
  }

  public void setDocEvidenciaPaper(String docEvidenciaPaper) {
    this.docEvidenciaPaper = docEvidenciaPaper;
  }

  public ActualitzarNotificacionDocument notificacioId(BigDecimal notificacioId) {
    this.notificacioId = notificacioId;
    return this;
  }

   /**
   * Identificador de la notificació
   * @return notificacioId
  **/
  @ApiModelProperty(value = "Identificador de la notificació")
  public BigDecimal getNotificacioId() {
    return notificacioId;
  }

  public void setNotificacioId(BigDecimal notificacioId) {
    this.notificacioId = notificacioId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActualitzarNotificacionDocument actualitzarNotificacionDocument = (ActualitzarNotificacionDocument) o;
    return Objects.equals(this.dataAceptacioRebuig, actualitzarNotificacionDocument.dataAceptacioRebuig) &&
        Objects.equals(this.dataAcusamentRebuda, actualitzarNotificacionDocument.dataAcusamentRebuda) &&
        Objects.equals(this.dataEnviament, actualitzarNotificacionDocument.dataEnviament) &&
        Objects.equals(this.dataHoraDiposit, actualitzarNotificacionDocument.dataHoraDiposit) &&
        Objects.equals(this.dataHoraVisualitzacio, actualitzarNotificacionDocument.dataHoraVisualitzacio) &&
        Objects.equals(this.dataLimit, actualitzarNotificacionDocument.dataLimit) &&
        Objects.equals(this.docEvidenciaElectronic, actualitzarNotificacionDocument.docEvidenciaElectronic) &&
        Objects.equals(this.docEvidenciaPaper, actualitzarNotificacionDocument.docEvidenciaPaper) &&
        Objects.equals(this.notificacioId, actualitzarNotificacionDocument.notificacioId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataAceptacioRebuig, dataAcusamentRebuda, dataEnviament, dataHoraDiposit, dataHoraVisualitzacio, dataLimit, docEvidenciaElectronic, docEvidenciaPaper, notificacioId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActualitzarNotificacionDocument {\n");
    
    sb.append("    dataAceptacioRebuig: ").append(toIndentedString(dataAceptacioRebuig)).append("\n");
    sb.append("    dataAcusamentRebuda: ").append(toIndentedString(dataAcusamentRebuda)).append("\n");
    sb.append("    dataEnviament: ").append(toIndentedString(dataEnviament)).append("\n");
    sb.append("    dataHoraDiposit: ").append(toIndentedString(dataHoraDiposit)).append("\n");
    sb.append("    dataHoraVisualitzacio: ").append(toIndentedString(dataHoraVisualitzacio)).append("\n");
    sb.append("    dataLimit: ").append(toIndentedString(dataLimit)).append("\n");
    sb.append("    docEvidenciaElectronic: ").append(toIndentedString(docEvidenciaElectronic)).append("\n");
    sb.append("    docEvidenciaPaper: ").append(toIndentedString(docEvidenciaPaper)).append("\n");
    sb.append("    notificacioId: ").append(toIndentedString(notificacioId)).append("\n");
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

