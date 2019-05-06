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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Bloquejos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Estats;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Sollicituds;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.joda.time.DateTime;

/**
 * ExpedientsRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-06T09:02:05.732+02:00")
public class ExpedientsRDTO {
  @JsonProperty("accioEstatIdext")
  private BigDecimal accioEstatIdext = null;

  @JsonProperty("acumulador")
  private BigDecimal acumulador = null;

  @JsonProperty("aplicacioNegoci")
  private String aplicacioNegoci = null;

  @JsonProperty("bloqueig")
  private BigDecimal bloqueig = null;

  @JsonProperty("bloquejos")
  private Bloquejos bloquejos = null;

  @JsonProperty("codi")
  private String codi = null;

  @JsonProperty("configuracioDocumentacioProc")
  private BigDecimal configuracioDocumentacioProc = null;

  @JsonProperty("criticitatAvis")
  private BigDecimal criticitatAvis = null;

  @JsonProperty("darreraModificacio")
  private DateTime darreraModificacio = null;

  @JsonProperty("dataAllegacio")
  private DateTime dataAllegacio = null;

  @JsonProperty("dataEsmena")
  private DateTime dataEsmena = null;

  @JsonProperty("dataPresentacio")
  private DateTime dataPresentacio = null;

  @JsonProperty("dataPresentacioDes")
  private DateTime dataPresentacioDes = null;

  @JsonProperty("dataPresentacioFinsA")
  private DateTime dataPresentacioFinsA = null;

  @JsonProperty("descEstat")
  private String descEstat = null;

  @JsonProperty("descEstatCastella")
  private String descEstatCastella = null;

  @JsonProperty("descEstatCatala")
  private String descEstatCatala = null;

  @JsonProperty("descEstatCiutada")
  private String descEstatCiutada = null;

  @JsonProperty("descEstatCiutadaCastella")
  private String descEstatCiutadaCastella = null;

  @JsonProperty("descEstatCiutadaCatala")
  private String descEstatCiutadaCatala = null;

  @JsonProperty("descUGConvidada")
  private String descUGConvidada = null;

  @JsonProperty("descUnitatGestora")
  private String descUnitatGestora = null;

  @JsonProperty("diesTerminiAllegacio")
  private BigDecimal diesTerminiAllegacio = null;

  @JsonProperty("diesTerminiRequeriment")
  private BigDecimal diesTerminiRequeriment = null;

  @JsonProperty("documentacioIdext")
  private BigDecimal documentacioIdext = null;

  @JsonProperty("editable")
  private Boolean editable = null;

  @JsonProperty("estat")
  private Estats estat = null;

  @JsonProperty("estatActual")
  private BigDecimal estatActual = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("idEstat")
  private BigDecimal idEstat = null;

  @JsonProperty("isOge")
  private Boolean isOge = null;

  @JsonProperty("nomDescUGConvidada")
  private String nomDescUGConvidada = null;

  @JsonProperty("nomDescUnitatGestora")
  private String nomDescUnitatGestora = null;

  @JsonProperty("nomProcediment")
  private String nomProcediment = null;

  @JsonProperty("nomProcedimentCastella")
  private String nomProcedimentCastella = null;

  @JsonProperty("numeroDocumentSollicitant")
  private String numeroDocumentSollicitant = null;

  @JsonProperty("numeroDocumentSollicitantEstricte")
  private String numeroDocumentSollicitantEstricte = null;

  @JsonProperty("procedimentCodi")
  private String procedimentCodi = null;

  @JsonProperty("procedimentIdext")
  private BigDecimal procedimentIdext = null;

  @JsonProperty("procedimentVersio")
  private String procedimentVersio = null;

  @JsonProperty("representantPrincipal")
  private PersonesSollicitud representantPrincipal = null;

  @JsonProperty("seleccionable")
  private Boolean seleccionable = null;

  @JsonProperty("sollicitant")
  private String sollicitant = null;

  @JsonProperty("sollicitantPrincipal")
  private PersonesSollicitud sollicitantPrincipal = null;

  @JsonProperty("sollicitud")
  private BigDecimal sollicitud = null;

  @JsonProperty("sollicituds")
  private Sollicituds sollicituds = null;

  @JsonProperty("tipusAvis")
  private BigDecimal tipusAvis = null;

  @JsonProperty("tramitador")
  private String tramitador = null;

  @JsonProperty("ugConvidadaIdext")
  private BigDecimal ugConvidadaIdext = null;

  @JsonProperty("ultimaModificacio")
  private BigDecimal ultimaModificacio = null;

  @JsonProperty("unitatGestoraIdext")
  private BigDecimal unitatGestoraIdext = null;

  public ExpedientsRDTO accioEstatIdext(BigDecimal accioEstatIdext) {
    this.accioEstatIdext = accioEstatIdext;
    return this;
  }

   /**
   * Get accioEstatIdext
   * @return accioEstatIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getAccioEstatIdext() {
    return accioEstatIdext;
  }

  public void setAccioEstatIdext(BigDecimal accioEstatIdext) {
    this.accioEstatIdext = accioEstatIdext;
  }

  public ExpedientsRDTO acumulador(BigDecimal acumulador) {
    this.acumulador = acumulador;
    return this;
  }

   /**
   * Get acumulador
   * @return acumulador
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getAcumulador() {
    return acumulador;
  }

  public void setAcumulador(BigDecimal acumulador) {
    this.acumulador = acumulador;
  }

  public ExpedientsRDTO aplicacioNegoci(String aplicacioNegoci) {
    this.aplicacioNegoci = aplicacioNegoci;
    return this;
  }

   /**
   * Get aplicacioNegoci
   * @return aplicacioNegoci
  **/
  @ApiModelProperty(value = "")
  public String getAplicacioNegoci() {
    return aplicacioNegoci;
  }

  public void setAplicacioNegoci(String aplicacioNegoci) {
    this.aplicacioNegoci = aplicacioNegoci;
  }

  public ExpedientsRDTO bloqueig(BigDecimal bloqueig) {
    this.bloqueig = bloqueig;
    return this;
  }

   /**
   * Get bloqueig
   * @return bloqueig
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getBloqueig() {
    return bloqueig;
  }

  public void setBloqueig(BigDecimal bloqueig) {
    this.bloqueig = bloqueig;
  }

  public ExpedientsRDTO bloquejos(Bloquejos bloquejos) {
    this.bloquejos = bloquejos;
    return this;
  }

   /**
   * Get bloquejos
   * @return bloquejos
  **/
  @ApiModelProperty(value = "")
  public Bloquejos getBloquejos() {
    return bloquejos;
  }

  public void setBloquejos(Bloquejos bloquejos) {
    this.bloquejos = bloquejos;
  }

  public ExpedientsRDTO codi(String codi) {
    this.codi = codi;
    return this;
  }

   /**
   * Get codi
   * @return codi
  **/
  @ApiModelProperty(value = "")
  public String getCodi() {
    return codi;
  }

  public void setCodi(String codi) {
    this.codi = codi;
  }

  public ExpedientsRDTO configuracioDocumentacioProc(BigDecimal configuracioDocumentacioProc) {
    this.configuracioDocumentacioProc = configuracioDocumentacioProc;
    return this;
  }

   /**
   * Get configuracioDocumentacioProc
   * @return configuracioDocumentacioProc
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getConfiguracioDocumentacioProc() {
    return configuracioDocumentacioProc;
  }

  public void setConfiguracioDocumentacioProc(BigDecimal configuracioDocumentacioProc) {
    this.configuracioDocumentacioProc = configuracioDocumentacioProc;
  }

  public ExpedientsRDTO criticitatAvis(BigDecimal criticitatAvis) {
    this.criticitatAvis = criticitatAvis;
    return this;
  }

   /**
   * Get criticitatAvis
   * @return criticitatAvis
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getCriticitatAvis() {
    return criticitatAvis;
  }

  public void setCriticitatAvis(BigDecimal criticitatAvis) {
    this.criticitatAvis = criticitatAvis;
  }

  public ExpedientsRDTO darreraModificacio(DateTime darreraModificacio) {
    this.darreraModificacio = darreraModificacio;
    return this;
  }

   /**
   * Get darreraModificacio
   * @return darreraModificacio
  **/
  @ApiModelProperty(value = "")
  public DateTime getDarreraModificacio() {
    return darreraModificacio;
  }

  public void setDarreraModificacio(DateTime darreraModificacio) {
    this.darreraModificacio = darreraModificacio;
  }

  public ExpedientsRDTO dataAllegacio(DateTime dataAllegacio) {
    this.dataAllegacio = dataAllegacio;
    return this;
  }

   /**
   * Get dataAllegacio
   * @return dataAllegacio
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataAllegacio() {
    return dataAllegacio;
  }

  public void setDataAllegacio(DateTime dataAllegacio) {
    this.dataAllegacio = dataAllegacio;
  }

  public ExpedientsRDTO dataEsmena(DateTime dataEsmena) {
    this.dataEsmena = dataEsmena;
    return this;
  }

   /**
   * Get dataEsmena
   * @return dataEsmena
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataEsmena() {
    return dataEsmena;
  }

  public void setDataEsmena(DateTime dataEsmena) {
    this.dataEsmena = dataEsmena;
  }

  public ExpedientsRDTO dataPresentacio(DateTime dataPresentacio) {
    this.dataPresentacio = dataPresentacio;
    return this;
  }

   /**
   * Get dataPresentacio
   * @return dataPresentacio
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataPresentacio() {
    return dataPresentacio;
  }

  public void setDataPresentacio(DateTime dataPresentacio) {
    this.dataPresentacio = dataPresentacio;
  }

  public ExpedientsRDTO dataPresentacioDes(DateTime dataPresentacioDes) {
    this.dataPresentacioDes = dataPresentacioDes;
    return this;
  }

   /**
   * Get dataPresentacioDes
   * @return dataPresentacioDes
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataPresentacioDes() {
    return dataPresentacioDes;
  }

  public void setDataPresentacioDes(DateTime dataPresentacioDes) {
    this.dataPresentacioDes = dataPresentacioDes;
  }

  public ExpedientsRDTO dataPresentacioFinsA(DateTime dataPresentacioFinsA) {
    this.dataPresentacioFinsA = dataPresentacioFinsA;
    return this;
  }

   /**
   * Get dataPresentacioFinsA
   * @return dataPresentacioFinsA
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataPresentacioFinsA() {
    return dataPresentacioFinsA;
  }

  public void setDataPresentacioFinsA(DateTime dataPresentacioFinsA) {
    this.dataPresentacioFinsA = dataPresentacioFinsA;
  }

  public ExpedientsRDTO descEstat(String descEstat) {
    this.descEstat = descEstat;
    return this;
  }

   /**
   * Get descEstat
   * @return descEstat
  **/
  @ApiModelProperty(value = "")
  public String getDescEstat() {
    return descEstat;
  }

  public void setDescEstat(String descEstat) {
    this.descEstat = descEstat;
  }

  public ExpedientsRDTO descEstatCastella(String descEstatCastella) {
    this.descEstatCastella = descEstatCastella;
    return this;
  }

   /**
   * Get descEstatCastella
   * @return descEstatCastella
  **/
  @ApiModelProperty(value = "")
  public String getDescEstatCastella() {
    return descEstatCastella;
  }

  public void setDescEstatCastella(String descEstatCastella) {
    this.descEstatCastella = descEstatCastella;
  }

  public ExpedientsRDTO descEstatCatala(String descEstatCatala) {
    this.descEstatCatala = descEstatCatala;
    return this;
  }

   /**
   * Get descEstatCatala
   * @return descEstatCatala
  **/
  @ApiModelProperty(value = "")
  public String getDescEstatCatala() {
    return descEstatCatala;
  }

  public void setDescEstatCatala(String descEstatCatala) {
    this.descEstatCatala = descEstatCatala;
  }

  public ExpedientsRDTO descEstatCiutada(String descEstatCiutada) {
    this.descEstatCiutada = descEstatCiutada;
    return this;
  }

   /**
   * Get descEstatCiutada
   * @return descEstatCiutada
  **/
  @ApiModelProperty(value = "")
  public String getDescEstatCiutada() {
    return descEstatCiutada;
  }

  public void setDescEstatCiutada(String descEstatCiutada) {
    this.descEstatCiutada = descEstatCiutada;
  }

  public ExpedientsRDTO descEstatCiutadaCastella(String descEstatCiutadaCastella) {
    this.descEstatCiutadaCastella = descEstatCiutadaCastella;
    return this;
  }

   /**
   * Get descEstatCiutadaCastella
   * @return descEstatCiutadaCastella
  **/
  @ApiModelProperty(value = "")
  public String getDescEstatCiutadaCastella() {
    return descEstatCiutadaCastella;
  }

  public void setDescEstatCiutadaCastella(String descEstatCiutadaCastella) {
    this.descEstatCiutadaCastella = descEstatCiutadaCastella;
  }

  public ExpedientsRDTO descEstatCiutadaCatala(String descEstatCiutadaCatala) {
    this.descEstatCiutadaCatala = descEstatCiutadaCatala;
    return this;
  }

   /**
   * Get descEstatCiutadaCatala
   * @return descEstatCiutadaCatala
  **/
  @ApiModelProperty(value = "")
  public String getDescEstatCiutadaCatala() {
    return descEstatCiutadaCatala;
  }

  public void setDescEstatCiutadaCatala(String descEstatCiutadaCatala) {
    this.descEstatCiutadaCatala = descEstatCiutadaCatala;
  }

  public ExpedientsRDTO descUGConvidada(String descUGConvidada) {
    this.descUGConvidada = descUGConvidada;
    return this;
  }

   /**
   * Get descUGConvidada
   * @return descUGConvidada
  **/
  @ApiModelProperty(value = "")
  public String getDescUGConvidada() {
    return descUGConvidada;
  }

  public void setDescUGConvidada(String descUGConvidada) {
    this.descUGConvidada = descUGConvidada;
  }

  public ExpedientsRDTO descUnitatGestora(String descUnitatGestora) {
    this.descUnitatGestora = descUnitatGestora;
    return this;
  }

   /**
   * Get descUnitatGestora
   * @return descUnitatGestora
  **/
  @ApiModelProperty(value = "")
  public String getDescUnitatGestora() {
    return descUnitatGestora;
  }

  public void setDescUnitatGestora(String descUnitatGestora) {
    this.descUnitatGestora = descUnitatGestora;
  }

  public ExpedientsRDTO diesTerminiAllegacio(BigDecimal diesTerminiAllegacio) {
    this.diesTerminiAllegacio = diesTerminiAllegacio;
    return this;
  }

   /**
   * Get diesTerminiAllegacio
   * @return diesTerminiAllegacio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDiesTerminiAllegacio() {
    return diesTerminiAllegacio;
  }

  public void setDiesTerminiAllegacio(BigDecimal diesTerminiAllegacio) {
    this.diesTerminiAllegacio = diesTerminiAllegacio;
  }

  public ExpedientsRDTO diesTerminiRequeriment(BigDecimal diesTerminiRequeriment) {
    this.diesTerminiRequeriment = diesTerminiRequeriment;
    return this;
  }

   /**
   * Get diesTerminiRequeriment
   * @return diesTerminiRequeriment
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getDiesTerminiRequeriment() {
    return diesTerminiRequeriment;
  }

  public void setDiesTerminiRequeriment(BigDecimal diesTerminiRequeriment) {
    this.diesTerminiRequeriment = diesTerminiRequeriment;
  }

  public ExpedientsRDTO documentacioIdext(BigDecimal documentacioIdext) {
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

  public ExpedientsRDTO editable(Boolean editable) {
    this.editable = editable;
    return this;
  }

   /**
   * Get editable
   * @return editable
  **/
  @ApiModelProperty(value = "")
  public Boolean isEditable() {
    return editable;
  }

  public void setEditable(Boolean editable) {
    this.editable = editable;
  }

  public ExpedientsRDTO estat(Estats estat) {
    this.estat = estat;
    return this;
  }

   /**
   * Get estat
   * @return estat
  **/
  @ApiModelProperty(value = "")
  public Estats getEstat() {
    return estat;
  }

  public void setEstat(Estats estat) {
    this.estat = estat;
  }

  public ExpedientsRDTO estatActual(BigDecimal estatActual) {
    this.estatActual = estatActual;
    return this;
  }

   /**
   * Get estatActual
   * @return estatActual
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getEstatActual() {
    return estatActual;
  }

  public void setEstatActual(BigDecimal estatActual) {
    this.estatActual = estatActual;
  }

  public ExpedientsRDTO id(BigDecimal id) {
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

  public ExpedientsRDTO idEstat(BigDecimal idEstat) {
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

  public ExpedientsRDTO isOge(Boolean isOge) {
    this.isOge = isOge;
    return this;
  }

   /**
   * Get isOge
   * @return isOge
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsOge() {
    return isOge;
  }

  public void setIsOge(Boolean isOge) {
    this.isOge = isOge;
  }

  public ExpedientsRDTO nomDescUGConvidada(String nomDescUGConvidada) {
    this.nomDescUGConvidada = nomDescUGConvidada;
    return this;
  }

   /**
   * Get nomDescUGConvidada
   * @return nomDescUGConvidada
  **/
  @ApiModelProperty(value = "")
  public String getNomDescUGConvidada() {
    return nomDescUGConvidada;
  }

  public void setNomDescUGConvidada(String nomDescUGConvidada) {
    this.nomDescUGConvidada = nomDescUGConvidada;
  }

  public ExpedientsRDTO nomDescUnitatGestora(String nomDescUnitatGestora) {
    this.nomDescUnitatGestora = nomDescUnitatGestora;
    return this;
  }

   /**
   * Get nomDescUnitatGestora
   * @return nomDescUnitatGestora
  **/
  @ApiModelProperty(value = "")
  public String getNomDescUnitatGestora() {
    return nomDescUnitatGestora;
  }

  public void setNomDescUnitatGestora(String nomDescUnitatGestora) {
    this.nomDescUnitatGestora = nomDescUnitatGestora;
  }

  public ExpedientsRDTO nomProcediment(String nomProcediment) {
    this.nomProcediment = nomProcediment;
    return this;
  }

   /**
   * Get nomProcediment
   * @return nomProcediment
  **/
  @ApiModelProperty(value = "")
  public String getNomProcediment() {
    return nomProcediment;
  }

  public void setNomProcediment(String nomProcediment) {
    this.nomProcediment = nomProcediment;
  }

  public ExpedientsRDTO nomProcedimentCastella(String nomProcedimentCastella) {
    this.nomProcedimentCastella = nomProcedimentCastella;
    return this;
  }

   /**
   * Get nomProcedimentCastella
   * @return nomProcedimentCastella
  **/
  @ApiModelProperty(value = "")
  public String getNomProcedimentCastella() {
    return nomProcedimentCastella;
  }

  public void setNomProcedimentCastella(String nomProcedimentCastella) {
    this.nomProcedimentCastella = nomProcedimentCastella;
  }

  public ExpedientsRDTO numeroDocumentSollicitant(String numeroDocumentSollicitant) {
    this.numeroDocumentSollicitant = numeroDocumentSollicitant;
    return this;
  }

   /**
   * Get numeroDocumentSollicitant
   * @return numeroDocumentSollicitant
  **/
  @ApiModelProperty(value = "")
  public String getNumeroDocumentSollicitant() {
    return numeroDocumentSollicitant;
  }

  public void setNumeroDocumentSollicitant(String numeroDocumentSollicitant) {
    this.numeroDocumentSollicitant = numeroDocumentSollicitant;
  }

  public ExpedientsRDTO numeroDocumentSollicitantEstricte(String numeroDocumentSollicitantEstricte) {
    this.numeroDocumentSollicitantEstricte = numeroDocumentSollicitantEstricte;
    return this;
  }

   /**
   * Get numeroDocumentSollicitantEstricte
   * @return numeroDocumentSollicitantEstricte
  **/
  @ApiModelProperty(value = "")
  public String getNumeroDocumentSollicitantEstricte() {
    return numeroDocumentSollicitantEstricte;
  }

  public void setNumeroDocumentSollicitantEstricte(String numeroDocumentSollicitantEstricte) {
    this.numeroDocumentSollicitantEstricte = numeroDocumentSollicitantEstricte;
  }

  public ExpedientsRDTO procedimentCodi(String procedimentCodi) {
    this.procedimentCodi = procedimentCodi;
    return this;
  }

   /**
   * Get procedimentCodi
   * @return procedimentCodi
  **/
  @ApiModelProperty(value = "")
  public String getProcedimentCodi() {
    return procedimentCodi;
  }

  public void setProcedimentCodi(String procedimentCodi) {
    this.procedimentCodi = procedimentCodi;
  }

  public ExpedientsRDTO procedimentIdext(BigDecimal procedimentIdext) {
    this.procedimentIdext = procedimentIdext;
    return this;
  }

   /**
   * Get procedimentIdext
   * @return procedimentIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getProcedimentIdext() {
    return procedimentIdext;
  }

  public void setProcedimentIdext(BigDecimal procedimentIdext) {
    this.procedimentIdext = procedimentIdext;
  }

  public ExpedientsRDTO procedimentVersio(String procedimentVersio) {
    this.procedimentVersio = procedimentVersio;
    return this;
  }

   /**
   * Get procedimentVersio
   * @return procedimentVersio
  **/
  @ApiModelProperty(value = "")
  public String getProcedimentVersio() {
    return procedimentVersio;
  }

  public void setProcedimentVersio(String procedimentVersio) {
    this.procedimentVersio = procedimentVersio;
  }

  public ExpedientsRDTO representantPrincipal(PersonesSollicitud representantPrincipal) {
    this.representantPrincipal = representantPrincipal;
    return this;
  }

   /**
   * Get representantPrincipal
   * @return representantPrincipal
  **/
  @ApiModelProperty(value = "")
  public PersonesSollicitud getRepresentantPrincipal() {
    return representantPrincipal;
  }

  public void setRepresentantPrincipal(PersonesSollicitud representantPrincipal) {
    this.representantPrincipal = representantPrincipal;
  }

  public ExpedientsRDTO seleccionable(Boolean seleccionable) {
    this.seleccionable = seleccionable;
    return this;
  }

   /**
   * Get seleccionable
   * @return seleccionable
  **/
  @ApiModelProperty(value = "")
  public Boolean isSeleccionable() {
    return seleccionable;
  }

  public void setSeleccionable(Boolean seleccionable) {
    this.seleccionable = seleccionable;
  }

  public ExpedientsRDTO sollicitant(String sollicitant) {
    this.sollicitant = sollicitant;
    return this;
  }

   /**
   * Get sollicitant
   * @return sollicitant
  **/
  @ApiModelProperty(value = "")
  public String getSollicitant() {
    return sollicitant;
  }

  public void setSollicitant(String sollicitant) {
    this.sollicitant = sollicitant;
  }

  public ExpedientsRDTO sollicitantPrincipal(PersonesSollicitud sollicitantPrincipal) {
    this.sollicitantPrincipal = sollicitantPrincipal;
    return this;
  }

   /**
   * Get sollicitantPrincipal
   * @return sollicitantPrincipal
  **/
  @ApiModelProperty(value = "")
  public PersonesSollicitud getSollicitantPrincipal() {
    return sollicitantPrincipal;
  }

  public void setSollicitantPrincipal(PersonesSollicitud sollicitantPrincipal) {
    this.sollicitantPrincipal = sollicitantPrincipal;
  }

  public ExpedientsRDTO sollicitud(BigDecimal sollicitud) {
    this.sollicitud = sollicitud;
    return this;
  }

   /**
   * Get sollicitud
   * @return sollicitud
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getSollicitud() {
    return sollicitud;
  }

  public void setSollicitud(BigDecimal sollicitud) {
    this.sollicitud = sollicitud;
  }

  public ExpedientsRDTO sollicituds(Sollicituds sollicituds) {
    this.sollicituds = sollicituds;
    return this;
  }

   /**
   * Get sollicituds
   * @return sollicituds
  **/
  @ApiModelProperty(value = "")
  public Sollicituds getSollicituds() {
    return sollicituds;
  }

  public void setSollicituds(Sollicituds sollicituds) {
    this.sollicituds = sollicituds;
  }

  public ExpedientsRDTO tipusAvis(BigDecimal tipusAvis) {
    this.tipusAvis = tipusAvis;
    return this;
  }

   /**
   * Get tipusAvis
   * @return tipusAvis
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getTipusAvis() {
    return tipusAvis;
  }

  public void setTipusAvis(BigDecimal tipusAvis) {
    this.tipusAvis = tipusAvis;
  }

  public ExpedientsRDTO tramitador(String tramitador) {
    this.tramitador = tramitador;
    return this;
  }

   /**
   * Get tramitador
   * @return tramitador
  **/
  @ApiModelProperty(value = "")
  public String getTramitador() {
    return tramitador;
  }

  public void setTramitador(String tramitador) {
    this.tramitador = tramitador;
  }

  public ExpedientsRDTO ugConvidadaIdext(BigDecimal ugConvidadaIdext) {
    this.ugConvidadaIdext = ugConvidadaIdext;
    return this;
  }

   /**
   * Get ugConvidadaIdext
   * @return ugConvidadaIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUgConvidadaIdext() {
    return ugConvidadaIdext;
  }

  public void setUgConvidadaIdext(BigDecimal ugConvidadaIdext) {
    this.ugConvidadaIdext = ugConvidadaIdext;
  }

  public ExpedientsRDTO ultimaModificacio(BigDecimal ultimaModificacio) {
    this.ultimaModificacio = ultimaModificacio;
    return this;
  }

   /**
   * Get ultimaModificacio
   * @return ultimaModificacio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUltimaModificacio() {
    return ultimaModificacio;
  }

  public void setUltimaModificacio(BigDecimal ultimaModificacio) {
    this.ultimaModificacio = ultimaModificacio;
  }

  public ExpedientsRDTO unitatGestoraIdext(BigDecimal unitatGestoraIdext) {
    this.unitatGestoraIdext = unitatGestoraIdext;
    return this;
  }

   /**
   * Get unitatGestoraIdext
   * @return unitatGestoraIdext
  **/
  @ApiModelProperty(value = "")
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
    ExpedientsRDTO expedientsRDTO = (ExpedientsRDTO) o;
    return Objects.equals(this.accioEstatIdext, expedientsRDTO.accioEstatIdext) &&
        Objects.equals(this.acumulador, expedientsRDTO.acumulador) &&
        Objects.equals(this.aplicacioNegoci, expedientsRDTO.aplicacioNegoci) &&
        Objects.equals(this.bloqueig, expedientsRDTO.bloqueig) &&
        Objects.equals(this.bloquejos, expedientsRDTO.bloquejos) &&
        Objects.equals(this.codi, expedientsRDTO.codi) &&
        Objects.equals(this.configuracioDocumentacioProc, expedientsRDTO.configuracioDocumentacioProc) &&
        Objects.equals(this.criticitatAvis, expedientsRDTO.criticitatAvis) &&
        Objects.equals(this.darreraModificacio, expedientsRDTO.darreraModificacio) &&
        Objects.equals(this.dataAllegacio, expedientsRDTO.dataAllegacio) &&
        Objects.equals(this.dataEsmena, expedientsRDTO.dataEsmena) &&
        Objects.equals(this.dataPresentacio, expedientsRDTO.dataPresentacio) &&
        Objects.equals(this.dataPresentacioDes, expedientsRDTO.dataPresentacioDes) &&
        Objects.equals(this.dataPresentacioFinsA, expedientsRDTO.dataPresentacioFinsA) &&
        Objects.equals(this.descEstat, expedientsRDTO.descEstat) &&
        Objects.equals(this.descEstatCastella, expedientsRDTO.descEstatCastella) &&
        Objects.equals(this.descEstatCatala, expedientsRDTO.descEstatCatala) &&
        Objects.equals(this.descEstatCiutada, expedientsRDTO.descEstatCiutada) &&
        Objects.equals(this.descEstatCiutadaCastella, expedientsRDTO.descEstatCiutadaCastella) &&
        Objects.equals(this.descEstatCiutadaCatala, expedientsRDTO.descEstatCiutadaCatala) &&
        Objects.equals(this.descUGConvidada, expedientsRDTO.descUGConvidada) &&
        Objects.equals(this.descUnitatGestora, expedientsRDTO.descUnitatGestora) &&
        Objects.equals(this.diesTerminiAllegacio, expedientsRDTO.diesTerminiAllegacio) &&
        Objects.equals(this.diesTerminiRequeriment, expedientsRDTO.diesTerminiRequeriment) &&
        Objects.equals(this.documentacioIdext, expedientsRDTO.documentacioIdext) &&
        Objects.equals(this.editable, expedientsRDTO.editable) &&
        Objects.equals(this.estat, expedientsRDTO.estat) &&
        Objects.equals(this.estatActual, expedientsRDTO.estatActual) &&
        Objects.equals(this.id, expedientsRDTO.id) &&
        Objects.equals(this.idEstat, expedientsRDTO.idEstat) &&
        Objects.equals(this.isOge, expedientsRDTO.isOge) &&
        Objects.equals(this.nomDescUGConvidada, expedientsRDTO.nomDescUGConvidada) &&
        Objects.equals(this.nomDescUnitatGestora, expedientsRDTO.nomDescUnitatGestora) &&
        Objects.equals(this.nomProcediment, expedientsRDTO.nomProcediment) &&
        Objects.equals(this.nomProcedimentCastella, expedientsRDTO.nomProcedimentCastella) &&
        Objects.equals(this.numeroDocumentSollicitant, expedientsRDTO.numeroDocumentSollicitant) &&
        Objects.equals(this.numeroDocumentSollicitantEstricte, expedientsRDTO.numeroDocumentSollicitantEstricte) &&
        Objects.equals(this.procedimentCodi, expedientsRDTO.procedimentCodi) &&
        Objects.equals(this.procedimentIdext, expedientsRDTO.procedimentIdext) &&
        Objects.equals(this.procedimentVersio, expedientsRDTO.procedimentVersio) &&
        Objects.equals(this.representantPrincipal, expedientsRDTO.representantPrincipal) &&
        Objects.equals(this.seleccionable, expedientsRDTO.seleccionable) &&
        Objects.equals(this.sollicitant, expedientsRDTO.sollicitant) &&
        Objects.equals(this.sollicitantPrincipal, expedientsRDTO.sollicitantPrincipal) &&
        Objects.equals(this.sollicitud, expedientsRDTO.sollicitud) &&
        Objects.equals(this.sollicituds, expedientsRDTO.sollicituds) &&
        Objects.equals(this.tipusAvis, expedientsRDTO.tipusAvis) &&
        Objects.equals(this.tramitador, expedientsRDTO.tramitador) &&
        Objects.equals(this.ugConvidadaIdext, expedientsRDTO.ugConvidadaIdext) &&
        Objects.equals(this.ultimaModificacio, expedientsRDTO.ultimaModificacio) &&
        Objects.equals(this.unitatGestoraIdext, expedientsRDTO.unitatGestoraIdext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accioEstatIdext, acumulador, aplicacioNegoci, bloqueig, bloquejos, codi, configuracioDocumentacioProc, criticitatAvis, darreraModificacio, dataAllegacio, dataEsmena, dataPresentacio, dataPresentacioDes, dataPresentacioFinsA, descEstat, descEstatCastella, descEstatCatala, descEstatCiutada, descEstatCiutadaCastella, descEstatCiutadaCatala, descUGConvidada, descUnitatGestora, diesTerminiAllegacio, diesTerminiRequeriment, documentacioIdext, editable, estat, estatActual, id, idEstat, isOge, nomDescUGConvidada, nomDescUnitatGestora, nomProcediment, nomProcedimentCastella, numeroDocumentSollicitant, numeroDocumentSollicitantEstricte, procedimentCodi, procedimentIdext, procedimentVersio, representantPrincipal, seleccionable, sollicitant, sollicitantPrincipal, sollicitud, sollicituds, tipusAvis, tramitador, ugConvidadaIdext, ultimaModificacio, unitatGestoraIdext);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExpedientsRDTO {\n");
    
    sb.append("    accioEstatIdext: ").append(toIndentedString(accioEstatIdext)).append("\n");
    sb.append("    acumulador: ").append(toIndentedString(acumulador)).append("\n");
    sb.append("    aplicacioNegoci: ").append(toIndentedString(aplicacioNegoci)).append("\n");
    sb.append("    bloqueig: ").append(toIndentedString(bloqueig)).append("\n");
    sb.append("    bloquejos: ").append(toIndentedString(bloquejos)).append("\n");
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    configuracioDocumentacioProc: ").append(toIndentedString(configuracioDocumentacioProc)).append("\n");
    sb.append("    criticitatAvis: ").append(toIndentedString(criticitatAvis)).append("\n");
    sb.append("    darreraModificacio: ").append(toIndentedString(darreraModificacio)).append("\n");
    sb.append("    dataAllegacio: ").append(toIndentedString(dataAllegacio)).append("\n");
    sb.append("    dataEsmena: ").append(toIndentedString(dataEsmena)).append("\n");
    sb.append("    dataPresentacio: ").append(toIndentedString(dataPresentacio)).append("\n");
    sb.append("    dataPresentacioDes: ").append(toIndentedString(dataPresentacioDes)).append("\n");
    sb.append("    dataPresentacioFinsA: ").append(toIndentedString(dataPresentacioFinsA)).append("\n");
    sb.append("    descEstat: ").append(toIndentedString(descEstat)).append("\n");
    sb.append("    descEstatCastella: ").append(toIndentedString(descEstatCastella)).append("\n");
    sb.append("    descEstatCatala: ").append(toIndentedString(descEstatCatala)).append("\n");
    sb.append("    descEstatCiutada: ").append(toIndentedString(descEstatCiutada)).append("\n");
    sb.append("    descEstatCiutadaCastella: ").append(toIndentedString(descEstatCiutadaCastella)).append("\n");
    sb.append("    descEstatCiutadaCatala: ").append(toIndentedString(descEstatCiutadaCatala)).append("\n");
    sb.append("    descUGConvidada: ").append(toIndentedString(descUGConvidada)).append("\n");
    sb.append("    descUnitatGestora: ").append(toIndentedString(descUnitatGestora)).append("\n");
    sb.append("    diesTerminiAllegacio: ").append(toIndentedString(diesTerminiAllegacio)).append("\n");
    sb.append("    diesTerminiRequeriment: ").append(toIndentedString(diesTerminiRequeriment)).append("\n");
    sb.append("    documentacioIdext: ").append(toIndentedString(documentacioIdext)).append("\n");
    sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
    sb.append("    estat: ").append(toIndentedString(estat)).append("\n");
    sb.append("    estatActual: ").append(toIndentedString(estatActual)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idEstat: ").append(toIndentedString(idEstat)).append("\n");
    sb.append("    isOge: ").append(toIndentedString(isOge)).append("\n");
    sb.append("    nomDescUGConvidada: ").append(toIndentedString(nomDescUGConvidada)).append("\n");
    sb.append("    nomDescUnitatGestora: ").append(toIndentedString(nomDescUnitatGestora)).append("\n");
    sb.append("    nomProcediment: ").append(toIndentedString(nomProcediment)).append("\n");
    sb.append("    nomProcedimentCastella: ").append(toIndentedString(nomProcedimentCastella)).append("\n");
    sb.append("    numeroDocumentSollicitant: ").append(toIndentedString(numeroDocumentSollicitant)).append("\n");
    sb.append("    numeroDocumentSollicitantEstricte: ").append(toIndentedString(numeroDocumentSollicitantEstricte)).append("\n");
    sb.append("    procedimentCodi: ").append(toIndentedString(procedimentCodi)).append("\n");
    sb.append("    procedimentIdext: ").append(toIndentedString(procedimentIdext)).append("\n");
    sb.append("    procedimentVersio: ").append(toIndentedString(procedimentVersio)).append("\n");
    sb.append("    representantPrincipal: ").append(toIndentedString(representantPrincipal)).append("\n");
    sb.append("    seleccionable: ").append(toIndentedString(seleccionable)).append("\n");
    sb.append("    sollicitant: ").append(toIndentedString(sollicitant)).append("\n");
    sb.append("    sollicitantPrincipal: ").append(toIndentedString(sollicitantPrincipal)).append("\n");
    sb.append("    sollicitud: ").append(toIndentedString(sollicitud)).append("\n");
    sb.append("    sollicituds: ").append(toIndentedString(sollicituds)).append("\n");
    sb.append("    tipusAvis: ").append(toIndentedString(tipusAvis)).append("\n");
    sb.append("    tramitador: ").append(toIndentedString(tramitador)).append("\n");
    sb.append("    ugConvidadaIdext: ").append(toIndentedString(ugConvidadaIdext)).append("\n");
    sb.append("    ultimaModificacio: ").append(toIndentedString(ultimaModificacio)).append("\n");
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

