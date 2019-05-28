/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.11.0
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
 * ExpedientOpenTextRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-28T16:24:07.324+02:00")
public class ExpedientOpenTextRDTO {
  @JsonProperty("codiExpedient")
  private String codiExpedient = null;

  @JsonProperty("codiUnitatOrganigrama")
  private String codiUnitatOrganigrama = null;

  @JsonProperty("documentacioIdext")
  private BigDecimal documentacioIdext = null;

  @JsonProperty("idEstat")
  private BigDecimal idEstat = null;

  @JsonProperty("nomProc")
  private String nomProc = null;

  @JsonProperty("numRegistre")
  private String numRegistre = null;

  @JsonProperty("serieDoc")
  private String serieDoc = null;

  public ExpedientOpenTextRDTO codiExpedient(String codiExpedient) {
    this.codiExpedient = codiExpedient;
    return this;
  }

   /**
   * Get codiExpedient
   * @return codiExpedient
  **/
  @ApiModelProperty(value = "")
  public String getCodiExpedient() {
    return codiExpedient;
  }

  public void setCodiExpedient(String codiExpedient) {
    this.codiExpedient = codiExpedient;
  }

  public ExpedientOpenTextRDTO codiUnitatOrganigrama(String codiUnitatOrganigrama) {
    this.codiUnitatOrganigrama = codiUnitatOrganigrama;
    return this;
  }

   /**
   * Get codiUnitatOrganigrama
   * @return codiUnitatOrganigrama
  **/
  @ApiModelProperty(value = "")
  public String getCodiUnitatOrganigrama() {
    return codiUnitatOrganigrama;
  }

  public void setCodiUnitatOrganigrama(String codiUnitatOrganigrama) {
    this.codiUnitatOrganigrama = codiUnitatOrganigrama;
  }

  public ExpedientOpenTextRDTO documentacioIdext(BigDecimal documentacioIdext) {
    this.documentacioIdext = documentacioIdext;
    return this;
  }

   /**
   * Get documentacioIdext
   * @return documentacioIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDocumentacioIdext() {
    return documentacioIdext;
  }

  public void setDocumentacioIdext(BigDecimal documentacioIdext) {
    this.documentacioIdext = documentacioIdext;
  }

  public ExpedientOpenTextRDTO idEstat(BigDecimal idEstat) {
    this.idEstat = idEstat;
    return this;
  }

   /**
   * Get idEstat
   * @return idEstat
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIdEstat() {
    return idEstat;
  }

  public void setIdEstat(BigDecimal idEstat) {
    this.idEstat = idEstat;
  }

  public ExpedientOpenTextRDTO nomProc(String nomProc) {
    this.nomProc = nomProc;
    return this;
  }

   /**
   * Get nomProc
   * @return nomProc
  **/
  @ApiModelProperty(value = "")
  public String getNomProc() {
    return nomProc;
  }

  public void setNomProc(String nomProc) {
    this.nomProc = nomProc;
  }

  public ExpedientOpenTextRDTO numRegistre(String numRegistre) {
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

  public ExpedientOpenTextRDTO serieDoc(String serieDoc) {
    this.serieDoc = serieDoc;
    return this;
  }

   /**
   * Get serieDoc
   * @return serieDoc
  **/
  @ApiModelProperty(value = "")
  public String getSerieDoc() {
    return serieDoc;
  }

  public void setSerieDoc(String serieDoc) {
    this.serieDoc = serieDoc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExpedientOpenTextRDTO expedientOpenTextRDTO = (ExpedientOpenTextRDTO) o;
    return Objects.equals(this.codiExpedient, expedientOpenTextRDTO.codiExpedient) &&
        Objects.equals(this.codiUnitatOrganigrama, expedientOpenTextRDTO.codiUnitatOrganigrama) &&
        Objects.equals(this.documentacioIdext, expedientOpenTextRDTO.documentacioIdext) &&
        Objects.equals(this.idEstat, expedientOpenTextRDTO.idEstat) &&
        Objects.equals(this.nomProc, expedientOpenTextRDTO.nomProc) &&
        Objects.equals(this.numRegistre, expedientOpenTextRDTO.numRegistre) &&
        Objects.equals(this.serieDoc, expedientOpenTextRDTO.serieDoc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiExpedient, codiUnitatOrganigrama, documentacioIdext, idEstat, nomProc, numRegistre, serieDoc);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExpedientOpenTextRDTO {\n");
    
    sb.append("    codiExpedient: ").append(toIndentedString(codiExpedient)).append("\n");
    sb.append("    codiUnitatOrganigrama: ").append(toIndentedString(codiUnitatOrganigrama)).append("\n");
    sb.append("    documentacioIdext: ").append(toIndentedString(documentacioIdext)).append("\n");
    sb.append("    idEstat: ").append(toIndentedString(idEstat)).append("\n");
    sb.append("    nomProc: ").append(toIndentedString(nomProc)).append("\n");
    sb.append("    numRegistre: ").append(toIndentedString(numRegistre)).append("\n");
    sb.append("    serieDoc: ").append(toIndentedString(serieDoc)).append("\n");
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

