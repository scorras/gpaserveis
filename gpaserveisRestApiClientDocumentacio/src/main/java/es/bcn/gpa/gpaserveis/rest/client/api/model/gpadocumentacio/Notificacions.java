/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.28.3
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
 * Notificacions
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-03-18T13:42:05.746+01:00")
public class Notificacions {
  @JsonProperty("codiError")
  private String codiError = null;

  @JsonProperty("dataAceptacioRebuig")
  private DateTime dataAceptacioRebuig = null;

  @JsonProperty("dataAcusamentRebuda")
  private DateTime dataAcusamentRebuda = null;

  @JsonProperty("dataDiposit")
  private DateTime dataDiposit = null;

  @JsonProperty("dataEnviament")
  private DateTime dataEnviament = null;

  @JsonProperty("dataLimit")
  private DateTime dataLimit = null;

  @JsonProperty("dataRegistre")
  private DateTime dataRegistre = null;

  @JsonProperty("dataVisualitzacio")
  private DateTime dataVisualitzacio = null;

  @JsonProperty("docEvidenciaElectronic")
  private BigDecimal docEvidenciaElectronic = null;

  @JsonProperty("docEvidenciaPaper")
  private BigDecimal docEvidenciaPaper = null;

  @JsonProperty("docTramitacio")
  private BigDecimal docTramitacio = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("missatgeError")
  private String missatgeError = null;

  @JsonProperty("notificacioId")
  private BigDecimal notificacioId = null;

  @JsonProperty("numRegistre")
  private String numRegistre = null;

  public Notificacions codiError(String codiError) {
    this.codiError = codiError;
    return this;
  }

   /**
   * Get codiError
   * @return codiError
  **/
  @ApiModelProperty(value = "")
  public String getCodiError() {
    return codiError;
  }

  public void setCodiError(String codiError) {
    this.codiError = codiError;
  }

  public Notificacions dataAceptacioRebuig(DateTime dataAceptacioRebuig) {
    this.dataAceptacioRebuig = dataAceptacioRebuig;
    return this;
  }

   /**
   * Get dataAceptacioRebuig
   * @return dataAceptacioRebuig
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataAceptacioRebuig() {
    return dataAceptacioRebuig;
  }

  public void setDataAceptacioRebuig(DateTime dataAceptacioRebuig) {
    this.dataAceptacioRebuig = dataAceptacioRebuig;
  }

  public Notificacions dataAcusamentRebuda(DateTime dataAcusamentRebuda) {
    this.dataAcusamentRebuda = dataAcusamentRebuda;
    return this;
  }

   /**
   * Get dataAcusamentRebuda
   * @return dataAcusamentRebuda
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataAcusamentRebuda() {
    return dataAcusamentRebuda;
  }

  public void setDataAcusamentRebuda(DateTime dataAcusamentRebuda) {
    this.dataAcusamentRebuda = dataAcusamentRebuda;
  }

  public Notificacions dataDiposit(DateTime dataDiposit) {
    this.dataDiposit = dataDiposit;
    return this;
  }

   /**
   * Get dataDiposit
   * @return dataDiposit
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataDiposit() {
    return dataDiposit;
  }

  public void setDataDiposit(DateTime dataDiposit) {
    this.dataDiposit = dataDiposit;
  }

  public Notificacions dataEnviament(DateTime dataEnviament) {
    this.dataEnviament = dataEnviament;
    return this;
  }

   /**
   * Get dataEnviament
   * @return dataEnviament
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataEnviament() {
    return dataEnviament;
  }

  public void setDataEnviament(DateTime dataEnviament) {
    this.dataEnviament = dataEnviament;
  }

  public Notificacions dataLimit(DateTime dataLimit) {
    this.dataLimit = dataLimit;
    return this;
  }

   /**
   * Get dataLimit
   * @return dataLimit
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataLimit() {
    return dataLimit;
  }

  public void setDataLimit(DateTime dataLimit) {
    this.dataLimit = dataLimit;
  }

  public Notificacions dataRegistre(DateTime dataRegistre) {
    this.dataRegistre = dataRegistre;
    return this;
  }

   /**
   * Get dataRegistre
   * @return dataRegistre
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataRegistre() {
    return dataRegistre;
  }

  public void setDataRegistre(DateTime dataRegistre) {
    this.dataRegistre = dataRegistre;
  }

  public Notificacions dataVisualitzacio(DateTime dataVisualitzacio) {
    this.dataVisualitzacio = dataVisualitzacio;
    return this;
  }

   /**
   * Get dataVisualitzacio
   * @return dataVisualitzacio
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataVisualitzacio() {
    return dataVisualitzacio;
  }

  public void setDataVisualitzacio(DateTime dataVisualitzacio) {
    this.dataVisualitzacio = dataVisualitzacio;
  }

  public Notificacions docEvidenciaElectronic(BigDecimal docEvidenciaElectronic) {
    this.docEvidenciaElectronic = docEvidenciaElectronic;
    return this;
  }

   /**
   * Get docEvidenciaElectronic
   * @return docEvidenciaElectronic
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDocEvidenciaElectronic() {
    return docEvidenciaElectronic;
  }

  public void setDocEvidenciaElectronic(BigDecimal docEvidenciaElectronic) {
    this.docEvidenciaElectronic = docEvidenciaElectronic;
  }

  public Notificacions docEvidenciaPaper(BigDecimal docEvidenciaPaper) {
    this.docEvidenciaPaper = docEvidenciaPaper;
    return this;
  }

   /**
   * Get docEvidenciaPaper
   * @return docEvidenciaPaper
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDocEvidenciaPaper() {
    return docEvidenciaPaper;
  }

  public void setDocEvidenciaPaper(BigDecimal docEvidenciaPaper) {
    this.docEvidenciaPaper = docEvidenciaPaper;
  }

  public Notificacions docTramitacio(BigDecimal docTramitacio) {
    this.docTramitacio = docTramitacio;
    return this;
  }

   /**
   * Get docTramitacio
   * @return docTramitacio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDocTramitacio() {
    return docTramitacio;
  }

  public void setDocTramitacio(BigDecimal docTramitacio) {
    this.docTramitacio = docTramitacio;
  }

  public Notificacions id(BigDecimal id) {
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

  public Notificacions missatgeError(String missatgeError) {
    this.missatgeError = missatgeError;
    return this;
  }

   /**
   * Get missatgeError
   * @return missatgeError
  **/
  @ApiModelProperty(value = "")
  public String getMissatgeError() {
    return missatgeError;
  }

  public void setMissatgeError(String missatgeError) {
    this.missatgeError = missatgeError;
  }

  public Notificacions notificacioId(BigDecimal notificacioId) {
    this.notificacioId = notificacioId;
    return this;
  }

   /**
   * Get notificacioId
   * @return notificacioId
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getNotificacioId() {
    return notificacioId;
  }

  public void setNotificacioId(BigDecimal notificacioId) {
    this.notificacioId = notificacioId;
  }

  public Notificacions numRegistre(String numRegistre) {
    this.numRegistre = numRegistre;
    return this;
  }

   /**
   * Get numRegistre
   * @return numRegistre
  **/
  @ApiModelProperty(value = "")
  public String getNumRegistre() {
    return numRegistre;
  }

  public void setNumRegistre(String numRegistre) {
    this.numRegistre = numRegistre;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Notificacions notificacions = (Notificacions) o;
    return Objects.equals(this.codiError, notificacions.codiError) &&
        Objects.equals(this.dataAceptacioRebuig, notificacions.dataAceptacioRebuig) &&
        Objects.equals(this.dataAcusamentRebuda, notificacions.dataAcusamentRebuda) &&
        Objects.equals(this.dataDiposit, notificacions.dataDiposit) &&
        Objects.equals(this.dataEnviament, notificacions.dataEnviament) &&
        Objects.equals(this.dataLimit, notificacions.dataLimit) &&
        Objects.equals(this.dataRegistre, notificacions.dataRegistre) &&
        Objects.equals(this.dataVisualitzacio, notificacions.dataVisualitzacio) &&
        Objects.equals(this.docEvidenciaElectronic, notificacions.docEvidenciaElectronic) &&
        Objects.equals(this.docEvidenciaPaper, notificacions.docEvidenciaPaper) &&
        Objects.equals(this.docTramitacio, notificacions.docTramitacio) &&
        Objects.equals(this.id, notificacions.id) &&
        Objects.equals(this.missatgeError, notificacions.missatgeError) &&
        Objects.equals(this.notificacioId, notificacions.notificacioId) &&
        Objects.equals(this.numRegistre, notificacions.numRegistre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiError, dataAceptacioRebuig, dataAcusamentRebuda, dataDiposit, dataEnviament, dataLimit, dataRegistre, dataVisualitzacio, docEvidenciaElectronic, docEvidenciaPaper, docTramitacio, id, missatgeError, notificacioId, numRegistre);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notificacions {\n");
    
    sb.append("    codiError: ").append(toIndentedString(codiError)).append("\n");
    sb.append("    dataAceptacioRebuig: ").append(toIndentedString(dataAceptacioRebuig)).append("\n");
    sb.append("    dataAcusamentRebuda: ").append(toIndentedString(dataAcusamentRebuda)).append("\n");
    sb.append("    dataDiposit: ").append(toIndentedString(dataDiposit)).append("\n");
    sb.append("    dataEnviament: ").append(toIndentedString(dataEnviament)).append("\n");
    sb.append("    dataLimit: ").append(toIndentedString(dataLimit)).append("\n");
    sb.append("    dataRegistre: ").append(toIndentedString(dataRegistre)).append("\n");
    sb.append("    dataVisualitzacio: ").append(toIndentedString(dataVisualitzacio)).append("\n");
    sb.append("    docEvidenciaElectronic: ").append(toIndentedString(docEvidenciaElectronic)).append("\n");
    sb.append("    docEvidenciaPaper: ").append(toIndentedString(docEvidenciaPaper)).append("\n");
    sb.append("    docTramitacio: ").append(toIndentedString(docTramitacio)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    missatgeError: ").append(toIndentedString(missatgeError)).append("\n");
    sb.append("    notificacioId: ").append(toIndentedString(notificacioId)).append("\n");
    sb.append("    numRegistre: ").append(toIndentedString(numRegistre)).append("\n");
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

