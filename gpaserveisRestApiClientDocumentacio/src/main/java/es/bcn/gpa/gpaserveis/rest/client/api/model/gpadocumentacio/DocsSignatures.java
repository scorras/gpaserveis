/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 2.5.3
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocsTramPolitiquesSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsFisics;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.joda.time.DateTime;

/**
 * DocsSignatures
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-17T17:20:36.241+02:00")
public class DocsSignatures {
  @JsonProperty("codiPeticio")
  private String codiPeticio = null;

  @JsonProperty("confDocsTramPolitiquesSig")
  private BigDecimal confDocsTramPolitiquesSig = null;

  @JsonProperty("confDocsTramPolitiquesSigEntity")
  private ConfDocsTramPolitiquesSig confDocsTramPolitiquesSigEntity = null;

  @JsonProperty("dataCaducitat")
  private DateTime dataCaducitat = null;

  @JsonProperty("dataSignatura")
  private DateTime dataSignatura = null;

  @JsonProperty("dataVistiplau")
  private DateTime dataVistiplau = null;

  @JsonProperty("docFisicSignat")
  private BigDecimal docFisicSignat = null;

  @JsonProperty("docsFisics")
  private DocsFisics docsFisics = null;

  @JsonProperty("documentTramitacio")
  private BigDecimal documentTramitacio = null;

  @JsonProperty("documentUsuariTablet")
  private String documentUsuariTablet = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("idTabletUsuari")
  private String idTabletUsuari = null;

  @JsonProperty("migracioIdOrigen")
  private String migracioIdOrigen = null;

  @JsonProperty("reintents")
  private Integer reintents = null;

  @JsonProperty("signat")
  private Integer signat = null;

  @JsonProperty("signatManualment")
  private Integer signatManualment = null;

  @JsonProperty("ticketPeticio")
  private BigDecimal ticketPeticio = null;

  @JsonProperty("usuariSignaturaIdext")
  private BigDecimal usuariSignaturaIdext = null;

  public DocsSignatures codiPeticio(String codiPeticio) {
    this.codiPeticio = codiPeticio;
    return this;
  }

   /**
   * Get codiPeticio
   * @return codiPeticio
  **/
  @ApiModelProperty(value = "")
  public String getCodiPeticio() {
    return codiPeticio;
  }

  public void setCodiPeticio(String codiPeticio) {
    this.codiPeticio = codiPeticio;
  }

  public DocsSignatures confDocsTramPolitiquesSig(BigDecimal confDocsTramPolitiquesSig) {
    this.confDocsTramPolitiquesSig = confDocsTramPolitiquesSig;
    return this;
  }

   /**
   * Get confDocsTramPolitiquesSig
   * @return confDocsTramPolitiquesSig
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getConfDocsTramPolitiquesSig() {
    return confDocsTramPolitiquesSig;
  }

  public void setConfDocsTramPolitiquesSig(BigDecimal confDocsTramPolitiquesSig) {
    this.confDocsTramPolitiquesSig = confDocsTramPolitiquesSig;
  }

  public DocsSignatures confDocsTramPolitiquesSigEntity(ConfDocsTramPolitiquesSig confDocsTramPolitiquesSigEntity) {
    this.confDocsTramPolitiquesSigEntity = confDocsTramPolitiquesSigEntity;
    return this;
  }

   /**
   * Get confDocsTramPolitiquesSigEntity
   * @return confDocsTramPolitiquesSigEntity
  **/
  @ApiModelProperty(value = "")
  public ConfDocsTramPolitiquesSig getConfDocsTramPolitiquesSigEntity() {
    return confDocsTramPolitiquesSigEntity;
  }

  public void setConfDocsTramPolitiquesSigEntity(ConfDocsTramPolitiquesSig confDocsTramPolitiquesSigEntity) {
    this.confDocsTramPolitiquesSigEntity = confDocsTramPolitiquesSigEntity;
  }

  public DocsSignatures dataCaducitat(DateTime dataCaducitat) {
    this.dataCaducitat = dataCaducitat;
    return this;
  }

   /**
   * Get dataCaducitat
   * @return dataCaducitat
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataCaducitat() {
    return dataCaducitat;
  }

  public void setDataCaducitat(DateTime dataCaducitat) {
    this.dataCaducitat = dataCaducitat;
  }

  public DocsSignatures dataSignatura(DateTime dataSignatura) {
    this.dataSignatura = dataSignatura;
    return this;
  }

   /**
   * Get dataSignatura
   * @return dataSignatura
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataSignatura() {
    return dataSignatura;
  }

  public void setDataSignatura(DateTime dataSignatura) {
    this.dataSignatura = dataSignatura;
  }

  public DocsSignatures dataVistiplau(DateTime dataVistiplau) {
    this.dataVistiplau = dataVistiplau;
    return this;
  }

   /**
   * Get dataVistiplau
   * @return dataVistiplau
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataVistiplau() {
    return dataVistiplau;
  }

  public void setDataVistiplau(DateTime dataVistiplau) {
    this.dataVistiplau = dataVistiplau;
  }

  public DocsSignatures docFisicSignat(BigDecimal docFisicSignat) {
    this.docFisicSignat = docFisicSignat;
    return this;
  }

   /**
   * Get docFisicSignat
   * @return docFisicSignat
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDocFisicSignat() {
    return docFisicSignat;
  }

  public void setDocFisicSignat(BigDecimal docFisicSignat) {
    this.docFisicSignat = docFisicSignat;
  }

  public DocsSignatures docsFisics(DocsFisics docsFisics) {
    this.docsFisics = docsFisics;
    return this;
  }

   /**
   * Get docsFisics
   * @return docsFisics
  **/
  @ApiModelProperty(value = "")
  public DocsFisics getDocsFisics() {
    return docsFisics;
  }

  public void setDocsFisics(DocsFisics docsFisics) {
    this.docsFisics = docsFisics;
  }

  public DocsSignatures documentTramitacio(BigDecimal documentTramitacio) {
    this.documentTramitacio = documentTramitacio;
    return this;
  }

   /**
   * Get documentTramitacio
   * @return documentTramitacio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDocumentTramitacio() {
    return documentTramitacio;
  }

  public void setDocumentTramitacio(BigDecimal documentTramitacio) {
    this.documentTramitacio = documentTramitacio;
  }

  public DocsSignatures documentUsuariTablet(String documentUsuariTablet) {
    this.documentUsuariTablet = documentUsuariTablet;
    return this;
  }

   /**
   * Get documentUsuariTablet
   * @return documentUsuariTablet
  **/
  @ApiModelProperty(value = "")
  public String getDocumentUsuariTablet() {
    return documentUsuariTablet;
  }

  public void setDocumentUsuariTablet(String documentUsuariTablet) {
    this.documentUsuariTablet = documentUsuariTablet;
  }

  public DocsSignatures id(BigDecimal id) {
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

  public DocsSignatures idTabletUsuari(String idTabletUsuari) {
    this.idTabletUsuari = idTabletUsuari;
    return this;
  }

   /**
   * Get idTabletUsuari
   * @return idTabletUsuari
  **/
  @ApiModelProperty(value = "")
  public String getIdTabletUsuari() {
    return idTabletUsuari;
  }

  public void setIdTabletUsuari(String idTabletUsuari) {
    this.idTabletUsuari = idTabletUsuari;
  }

  public DocsSignatures migracioIdOrigen(String migracioIdOrigen) {
    this.migracioIdOrigen = migracioIdOrigen;
    return this;
  }

   /**
   * Get migracioIdOrigen
   * @return migracioIdOrigen
  **/
  @ApiModelProperty(value = "")
  public String getMigracioIdOrigen() {
    return migracioIdOrigen;
  }

  public void setMigracioIdOrigen(String migracioIdOrigen) {
    this.migracioIdOrigen = migracioIdOrigen;
  }

  public DocsSignatures reintents(Integer reintents) {
    this.reintents = reintents;
    return this;
  }

   /**
   * Get reintents
   * @return reintents
  **/
  @ApiModelProperty(value = "")
  public Integer getReintents() {
    return reintents;
  }

  public void setReintents(Integer reintents) {
    this.reintents = reintents;
  }

  public DocsSignatures signat(Integer signat) {
    this.signat = signat;
    return this;
  }

   /**
   * Get signat
   * @return signat
  **/
  @ApiModelProperty(value = "")
  public Integer getSignat() {
    return signat;
  }

  public void setSignat(Integer signat) {
    this.signat = signat;
  }

  public DocsSignatures signatManualment(Integer signatManualment) {
    this.signatManualment = signatManualment;
    return this;
  }

   /**
   * Get signatManualment
   * @return signatManualment
  **/
  @ApiModelProperty(value = "")
  public Integer getSignatManualment() {
    return signatManualment;
  }

  public void setSignatManualment(Integer signatManualment) {
    this.signatManualment = signatManualment;
  }

  public DocsSignatures ticketPeticio(BigDecimal ticketPeticio) {
    this.ticketPeticio = ticketPeticio;
    return this;
  }

   /**
   * Get ticketPeticio
   * @return ticketPeticio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getTicketPeticio() {
    return ticketPeticio;
  }

  public void setTicketPeticio(BigDecimal ticketPeticio) {
    this.ticketPeticio = ticketPeticio;
  }

  public DocsSignatures usuariSignaturaIdext(BigDecimal usuariSignaturaIdext) {
    this.usuariSignaturaIdext = usuariSignaturaIdext;
    return this;
  }

   /**
   * Get usuariSignaturaIdext
   * @return usuariSignaturaIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUsuariSignaturaIdext() {
    return usuariSignaturaIdext;
  }

  public void setUsuariSignaturaIdext(BigDecimal usuariSignaturaIdext) {
    this.usuariSignaturaIdext = usuariSignaturaIdext;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocsSignatures docsSignatures = (DocsSignatures) o;
    return Objects.equals(this.codiPeticio, docsSignatures.codiPeticio) &&
        Objects.equals(this.confDocsTramPolitiquesSig, docsSignatures.confDocsTramPolitiquesSig) &&
        Objects.equals(this.confDocsTramPolitiquesSigEntity, docsSignatures.confDocsTramPolitiquesSigEntity) &&
        Objects.equals(this.dataCaducitat, docsSignatures.dataCaducitat) &&
        Objects.equals(this.dataSignatura, docsSignatures.dataSignatura) &&
        Objects.equals(this.dataVistiplau, docsSignatures.dataVistiplau) &&
        Objects.equals(this.docFisicSignat, docsSignatures.docFisicSignat) &&
        Objects.equals(this.docsFisics, docsSignatures.docsFisics) &&
        Objects.equals(this.documentTramitacio, docsSignatures.documentTramitacio) &&
        Objects.equals(this.documentUsuariTablet, docsSignatures.documentUsuariTablet) &&
        Objects.equals(this.id, docsSignatures.id) &&
        Objects.equals(this.idTabletUsuari, docsSignatures.idTabletUsuari) &&
        Objects.equals(this.migracioIdOrigen, docsSignatures.migracioIdOrigen) &&
        Objects.equals(this.reintents, docsSignatures.reintents) &&
        Objects.equals(this.signat, docsSignatures.signat) &&
        Objects.equals(this.signatManualment, docsSignatures.signatManualment) &&
        Objects.equals(this.ticketPeticio, docsSignatures.ticketPeticio) &&
        Objects.equals(this.usuariSignaturaIdext, docsSignatures.usuariSignaturaIdext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiPeticio, confDocsTramPolitiquesSig, confDocsTramPolitiquesSigEntity, dataCaducitat, dataSignatura, dataVistiplau, docFisicSignat, docsFisics, documentTramitacio, documentUsuariTablet, id, idTabletUsuari, migracioIdOrigen, reintents, signat, signatManualment, ticketPeticio, usuariSignaturaIdext);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocsSignatures {\n");
    
    sb.append("    codiPeticio: ").append(toIndentedString(codiPeticio)).append("\n");
    sb.append("    confDocsTramPolitiquesSig: ").append(toIndentedString(confDocsTramPolitiquesSig)).append("\n");
    sb.append("    confDocsTramPolitiquesSigEntity: ").append(toIndentedString(confDocsTramPolitiquesSigEntity)).append("\n");
    sb.append("    dataCaducitat: ").append(toIndentedString(dataCaducitat)).append("\n");
    sb.append("    dataSignatura: ").append(toIndentedString(dataSignatura)).append("\n");
    sb.append("    dataVistiplau: ").append(toIndentedString(dataVistiplau)).append("\n");
    sb.append("    docFisicSignat: ").append(toIndentedString(docFisicSignat)).append("\n");
    sb.append("    docsFisics: ").append(toIndentedString(docsFisics)).append("\n");
    sb.append("    documentTramitacio: ").append(toIndentedString(documentTramitacio)).append("\n");
    sb.append("    documentUsuariTablet: ").append(toIndentedString(documentUsuariTablet)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idTabletUsuari: ").append(toIndentedString(idTabletUsuari)).append("\n");
    sb.append("    migracioIdOrigen: ").append(toIndentedString(migracioIdOrigen)).append("\n");
    sb.append("    reintents: ").append(toIndentedString(reintents)).append("\n");
    sb.append("    signat: ").append(toIndentedString(signat)).append("\n");
    sb.append("    signatManualment: ").append(toIndentedString(signatManualment)).append("\n");
    sb.append("    ticketPeticio: ").append(toIndentedString(ticketPeticio)).append("\n");
    sb.append("    usuariSignaturaIdext: ").append(toIndentedString(usuariSignaturaIdext)).append("\n");
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

