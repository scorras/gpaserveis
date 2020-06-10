/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.23.4
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DadesSignatura;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.joda.time.DateTime;

/**
 * CallbackPortaSig
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-06-10T09:35:26.942+02:00")
public class CallbackPortaSig {
  @JsonProperty("codiEstat")
  private String codiEstat = null;

  @JsonProperty("codiPeticio")
  private String codiPeticio = null;

  @JsonProperty("codiUsuari")
  private String codiUsuari = null;

  @JsonProperty("dadesSignaturaDocumentRDTO")
  private DadesSignatura dadesSignaturaDocumentRDTO = null;

  @JsonProperty("dataCaducitat")
  private DateTime dataCaducitat = null;

  @JsonProperty("instantSignatura")
  private DateTime instantSignatura = null;

  @JsonProperty("nifUsuari")
  private String nifUsuari = null;

  @JsonProperty("nomCompletUsuari")
  private String nomCompletUsuari = null;

  @JsonProperty("ticketPeticio")
  private BigDecimal ticketPeticio = null;

  @JsonProperty("tipusPeticio")
  private String tipusPeticio = null;

  @JsonProperty("unitatGestoraIdext")
  private BigDecimal unitatGestoraIdext = null;

  public CallbackPortaSig codiEstat(String codiEstat) {
    this.codiEstat = codiEstat;
    return this;
  }

   /**
   * Indicador de l&#39;estat global de la petició, o buit en cas que es produeixi un error
   * @return codiEstat
  **/
  @ApiModelProperty(value = "Indicador de l'estat global de la petició, o buit en cas que es produeixi un error")
  public String getCodiEstat() {
    return codiEstat;
  }

  public void setCodiEstat(String codiEstat) {
    this.codiEstat = codiEstat;
  }

  public CallbackPortaSig codiPeticio(String codiPeticio) {
    this.codiPeticio = codiPeticio;
    return this;
  }

   /**
   * Identificador assignat pel Portasignatures en el moment d&#39;acceptar la petició
   * @return codiPeticio
  **/
  @ApiModelProperty(value = "Identificador assignat pel Portasignatures en el moment d'acceptar la petició")
  public String getCodiPeticio() {
    return codiPeticio;
  }

  public void setCodiPeticio(String codiPeticio) {
    this.codiPeticio = codiPeticio;
  }

  public CallbackPortaSig codiUsuari(String codiUsuari) {
    this.codiUsuari = codiUsuari;
    return this;
  }

   /**
   * Identificador ControlUser de l&#39;usuari que ha de signar/validar el document
   * @return codiUsuari
  **/
  @ApiModelProperty(value = "Identificador ControlUser de l'usuari que ha de signar/validar el document")
  public String getCodiUsuari() {
    return codiUsuari;
  }

  public void setCodiUsuari(String codiUsuari) {
    this.codiUsuari = codiUsuari;
  }

  public CallbackPortaSig dadesSignaturaDocumentRDTO(DadesSignatura dadesSignaturaDocumentRDTO) {
    this.dadesSignaturaDocumentRDTO = dadesSignaturaDocumentRDTO;
    return this;
  }

   /**
   * Dades signatura del document.
   * @return dadesSignaturaDocumentRDTO
  **/
  @ApiModelProperty(value = "Dades signatura del document.")
  public DadesSignatura getDadesSignaturaDocumentRDTO() {
    return dadesSignaturaDocumentRDTO;
  }

  public void setDadesSignaturaDocumentRDTO(DadesSignatura dadesSignaturaDocumentRDTO) {
    this.dadesSignaturaDocumentRDTO = dadesSignaturaDocumentRDTO;
  }

  public CallbackPortaSig dataCaducitat(DateTime dataCaducitat) {
    this.dataCaducitat = dataCaducitat;
    return this;
  }

   /**
   * Data, hora i minut límit abans de considerar aquest pas de la petició global com caducada i no permetre a l&#39;usuari d&#39;aquest pas signar el document. Si es supera la dataCaducitat en un pas, tota la petició global és considerada caducada, i l&#39;aplicació origen és notificada
   * @return dataCaducitat
  **/
  @ApiModelProperty(value = "Data, hora i minut límit abans de considerar aquest pas de la petició global com caducada i no permetre a l'usuari d'aquest pas signar el document. Si es supera la dataCaducitat en un pas, tota la petició global és considerada caducada, i l'aplicació origen és notificada")
  public DateTime getDataCaducitat() {
    return dataCaducitat;
  }

  public void setDataCaducitat(DateTime dataCaducitat) {
    this.dataCaducitat = dataCaducitat;
  }

  public CallbackPortaSig instantSignatura(DateTime instantSignatura) {
    this.instantSignatura = instantSignatura;
    return this;
  }

   /**
   * Instant (data i hora) en que l&#39;usuari va signar el document. No més es retorna si al demanar el alta de la petició es va indicar un valor de versioIntegracio igual o major que 2. Aquest camp pot no estar informat o estar buit, depenent de l&#39;estat d&#39;aquest pas.
   * @return instantSignatura
  **/
  @ApiModelProperty(value = "Instant (data i hora) en que l'usuari va signar el document. No més es retorna si al demanar el alta de la petició es va indicar un valor de versioIntegracio igual o major que 2. Aquest camp pot no estar informat o estar buit, depenent de l'estat d'aquest pas.")
  public DateTime getInstantSignatura() {
    return instantSignatura;
  }

  public void setInstantSignatura(DateTime instantSignatura) {
    this.instantSignatura = instantSignatura;
  }

  public CallbackPortaSig nifUsuari(String nifUsuari) {
    this.nifUsuari = nifUsuari;
    return this;
  }

   /**
   * NIF del usuari
   * @return nifUsuari
  **/
  @ApiModelProperty(value = "NIF del usuari")
  public String getNifUsuari() {
    return nifUsuari;
  }

  public void setNifUsuari(String nifUsuari) {
    this.nifUsuari = nifUsuari;
  }

  public CallbackPortaSig nomCompletUsuari(String nomCompletUsuari) {
    this.nomCompletUsuari = nomCompletUsuari;
    return this;
  }

   /**
   * Nom i cognoms del usuari
   * @return nomCompletUsuari
  **/
  @ApiModelProperty(value = "Nom i cognoms del usuari")
  public String getNomCompletUsuari() {
    return nomCompletUsuari;
  }

  public void setNomCompletUsuari(String nomCompletUsuari) {
    this.nomCompletUsuari = nomCompletUsuari;
  }

  public CallbackPortaSig ticketPeticio(BigDecimal ticketPeticio) {
    this.ticketPeticio = ticketPeticio;
    return this;
  }

   /**
   * Si el document ja ha sigut signat/vist-i-plau, en aquest camp s&#39;informa el id assignat pel Mòdul de Signatura a aquesta signatura/ vist-i-plau. La aplicació client pot fer servir APIs del Mòdul de Signatura per a obtindre les dades de la signatura (timestamp, common name del certificat del signatari...)
   * @return ticketPeticio
  **/
  @ApiModelProperty(value = "Si el document ja ha sigut signat/vist-i-plau, en aquest camp s'informa el id assignat pel Mòdul de Signatura a aquesta signatura/ vist-i-plau. La aplicació client pot fer servir APIs del Mòdul de Signatura per a obtindre les dades de la signatura (timestamp, common name del certificat del signatari...)")
  public BigDecimal getTicketPeticio() {
    return ticketPeticio;
  }

  public void setTicketPeticio(BigDecimal ticketPeticio) {
    this.ticketPeticio = ticketPeticio;
  }

  public CallbackPortaSig tipusPeticio(String tipusPeticio) {
    this.tipusPeticio = tipusPeticio;
    return this;
  }

   /**
   * Amb 2 valors possibles: SIGNATURA i VIST_I_PLAU, indicant si es demana de l&#39;usuari que signi o que validi el document
   * @return tipusPeticio
  **/
  @ApiModelProperty(value = "Amb 2 valors possibles: SIGNATURA i VIST_I_PLAU, indicant si es demana de l'usuari que signi o que validi el document")
  public String getTipusPeticio() {
    return tipusPeticio;
  }

  public void setTipusPeticio(String tipusPeticio) {
    this.tipusPeticio = tipusPeticio;
  }

  public CallbackPortaSig unitatGestoraIdext(BigDecimal unitatGestoraIdext) {
    this.unitatGestoraIdext = unitatGestoraIdext;
    return this;
  }

   /**
   * Identificador de la unitat gestora de l&#39;expedient.
   * @return unitatGestoraIdext
  **/
  @ApiModelProperty(value = "Identificador de la unitat gestora de l'expedient.")
  public BigDecimal getUnitatGestoraIdext() {
    return unitatGestoraIdext;
  }

  public void setUnitatGestoraIdext(BigDecimal unitatGestoraIdext) {
    this.unitatGestoraIdext = unitatGestoraIdext;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallbackPortaSig callbackPortaSig = (CallbackPortaSig) o;
    return Objects.equals(this.codiEstat, callbackPortaSig.codiEstat) &&
        Objects.equals(this.codiPeticio, callbackPortaSig.codiPeticio) &&
        Objects.equals(this.codiUsuari, callbackPortaSig.codiUsuari) &&
        Objects.equals(this.dadesSignaturaDocumentRDTO, callbackPortaSig.dadesSignaturaDocumentRDTO) &&
        Objects.equals(this.dataCaducitat, callbackPortaSig.dataCaducitat) &&
        Objects.equals(this.instantSignatura, callbackPortaSig.instantSignatura) &&
        Objects.equals(this.nifUsuari, callbackPortaSig.nifUsuari) &&
        Objects.equals(this.nomCompletUsuari, callbackPortaSig.nomCompletUsuari) &&
        Objects.equals(this.ticketPeticio, callbackPortaSig.ticketPeticio) &&
        Objects.equals(this.tipusPeticio, callbackPortaSig.tipusPeticio) &&
        Objects.equals(this.unitatGestoraIdext, callbackPortaSig.unitatGestoraIdext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiEstat, codiPeticio, codiUsuari, dadesSignaturaDocumentRDTO, dataCaducitat, instantSignatura, nifUsuari, nomCompletUsuari, ticketPeticio, tipusPeticio, unitatGestoraIdext);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallbackPortaSig {\n");
    
    sb.append("    codiEstat: ").append(toIndentedString(codiEstat)).append("\n");
    sb.append("    codiPeticio: ").append(toIndentedString(codiPeticio)).append("\n");
    sb.append("    codiUsuari: ").append(toIndentedString(codiUsuari)).append("\n");
    sb.append("    dadesSignaturaDocumentRDTO: ").append(toIndentedString(dadesSignaturaDocumentRDTO)).append("\n");
    sb.append("    dataCaducitat: ").append(toIndentedString(dataCaducitat)).append("\n");
    sb.append("    instantSignatura: ").append(toIndentedString(instantSignatura)).append("\n");
    sb.append("    nifUsuari: ").append(toIndentedString(nifUsuari)).append("\n");
    sb.append("    nomCompletUsuari: ").append(toIndentedString(nomCompletUsuari)).append("\n");
    sb.append("    ticketPeticio: ").append(toIndentedString(ticketPeticio)).append("\n");
    sb.append("    tipusPeticio: ").append(toIndentedString(tipusPeticio)).append("\n");
    sb.append("    unitatGestoraIdext: ").append(toIndentedString(unitatGestoraIdext)).append("\n");
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

