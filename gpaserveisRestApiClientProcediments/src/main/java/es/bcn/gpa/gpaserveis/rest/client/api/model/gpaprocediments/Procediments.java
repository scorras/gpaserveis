/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 1.5.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Bloquejos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Comentaris;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrups;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.EstatsProcediment;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Historics;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Identificacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Procediments;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsIniciacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRelacionats;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.RequerimentsOperatius;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Procediments
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-07T17:22:31.104+01:00")
public class Procediments {
  @JsonProperty("bloqueig")
  private BigDecimal bloqueig = null;

  @JsonProperty("bloquejos")
  private Bloquejos bloquejos = null;

  @JsonProperty("codi")
  private String codi = null;

  @JsonProperty("codiNom")
  private String codiNom = null;

  @JsonProperty("comentarisList")
  private List<Comentaris> comentarisList = null;

  @JsonProperty("configuracioAvisos")
  private BigDecimal configuracioAvisos = null;

  @JsonProperty("configuracioDocumentacio")
  private BigDecimal configuracioDocumentacio = null;

  @JsonProperty("dadesGrupsList")
  private List<DadesGrups> dadesGrupsList = null;

  @JsonProperty("darreraModificacio")
  private DateTime darreraModificacio = null;

  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("descripcioCastella")
  private String descripcioCastella = null;

  @JsonProperty("descripcioEstat")
  private String descripcioEstat = null;

  @JsonProperty("descripcioRelacio")
  private String descripcioRelacio = null;

  @JsonProperty("estatProcediment")
  private BigDecimal estatProcediment = null;

  @JsonProperty("estatsProcediment")
  private EstatsProcediment estatsProcediment = null;

  @JsonProperty("historicsList")
  private List<Historics> historicsList = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("identificacio")
  private BigDecimal identificacio = null;

  @JsonProperty("identificacions")
  private Identificacions identificacions = null;

  @JsonProperty("iniciacionsList")
  private List<ProcedimentsIniciacions> iniciacionsList = null;

  @JsonProperty("nom")
  private String nom = null;

  @JsonProperty("nomCastella")
  private String nomCastella = null;

  @JsonProperty("numerador")
  private BigDecimal numerador = null;

  @JsonProperty("procedimentsAssociatsList")
  private List<Procediments> procedimentsAssociatsList = null;

  @JsonProperty("procedimentsRelacionatsList")
  private List<ProcedimentsRelacionats> procedimentsRelacionatsList = null;

  @JsonProperty("reqOperatius")
  private RequerimentsOperatius reqOperatius = null;

  @JsonProperty("requerimentsOperatius")
  private BigDecimal requerimentsOperatius = null;

  @JsonProperty("serieDocumental")
  private String serieDocumental = null;

  @JsonProperty("tramitador")
  private String tramitador = null;

  @JsonProperty("ugosList")
  private List<ProcedimentsUgos> ugosList = null;

  @JsonProperty("ugosNoms")
  private String ugosNoms = null;

  @JsonProperty("ugrIdext")
  private BigDecimal ugrIdext = null;

  @JsonProperty("ugrNom")
  private String ugrNom = null;

  @JsonProperty("ultimaModificacio")
  private BigDecimal ultimaModificacio = null;

  @JsonProperty("unitat")
  private String unitat = null;

  @JsonProperty("versio")
  private String versio = null;

  @JsonProperty("versioDocumental")
  private BigDecimal versioDocumental = null;

  public Procediments bloqueig(BigDecimal bloqueig) {
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

  public Procediments bloquejos(Bloquejos bloquejos) {
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

  public Procediments codi(String codi) {
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

  public Procediments codiNom(String codiNom) {
    this.codiNom = codiNom;
    return this;
  }

   /**
   * Get codiNom
   * @return codiNom
  **/
  @ApiModelProperty(value = "")
  public String getCodiNom() {
    return codiNom;
  }

  public void setCodiNom(String codiNom) {
    this.codiNom = codiNom;
  }

  public Procediments comentarisList(List<Comentaris> comentarisList) {
    this.comentarisList = comentarisList;
    return this;
  }

  public Procediments addComentarisListItem(Comentaris comentarisListItem) {
    if (this.comentarisList == null) {
      this.comentarisList = new ArrayList<Comentaris>();
    }
    this.comentarisList.add(comentarisListItem);
    return this;
  }

   /**
   * Get comentarisList
   * @return comentarisList
  **/
  @ApiModelProperty(value = "")
  public List<Comentaris> getComentarisList() {
    return comentarisList;
  }

  public void setComentarisList(List<Comentaris> comentarisList) {
    this.comentarisList = comentarisList;
  }

  public Procediments configuracioAvisos(BigDecimal configuracioAvisos) {
    this.configuracioAvisos = configuracioAvisos;
    return this;
  }

   /**
   * Get configuracioAvisos
   * @return configuracioAvisos
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getConfiguracioAvisos() {
    return configuracioAvisos;
  }

  public void setConfiguracioAvisos(BigDecimal configuracioAvisos) {
    this.configuracioAvisos = configuracioAvisos;
  }

  public Procediments configuracioDocumentacio(BigDecimal configuracioDocumentacio) {
    this.configuracioDocumentacio = configuracioDocumentacio;
    return this;
  }

   /**
   * Get configuracioDocumentacio
   * @return configuracioDocumentacio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getConfiguracioDocumentacio() {
    return configuracioDocumentacio;
  }

  public void setConfiguracioDocumentacio(BigDecimal configuracioDocumentacio) {
    this.configuracioDocumentacio = configuracioDocumentacio;
  }

  public Procediments dadesGrupsList(List<DadesGrups> dadesGrupsList) {
    this.dadesGrupsList = dadesGrupsList;
    return this;
  }

  public Procediments addDadesGrupsListItem(DadesGrups dadesGrupsListItem) {
    if (this.dadesGrupsList == null) {
      this.dadesGrupsList = new ArrayList<DadesGrups>();
    }
    this.dadesGrupsList.add(dadesGrupsListItem);
    return this;
  }

   /**
   * Get dadesGrupsList
   * @return dadesGrupsList
  **/
  @ApiModelProperty(value = "")
  public List<DadesGrups> getDadesGrupsList() {
    return dadesGrupsList;
  }

  public void setDadesGrupsList(List<DadesGrups> dadesGrupsList) {
    this.dadesGrupsList = dadesGrupsList;
  }

  public Procediments darreraModificacio(DateTime darreraModificacio) {
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

  public Procediments descripcio(String descripcio) {
    this.descripcio = descripcio;
    return this;
  }

   /**
   * Get descripcio
   * @return descripcio
  **/
  @ApiModelProperty(value = "")
  public String getDescripcio() {
    return descripcio;
  }

  public void setDescripcio(String descripcio) {
    this.descripcio = descripcio;
  }

  public Procediments descripcioCastella(String descripcioCastella) {
    this.descripcioCastella = descripcioCastella;
    return this;
  }

   /**
   * Get descripcioCastella
   * @return descripcioCastella
  **/
  @ApiModelProperty(value = "")
  public String getDescripcioCastella() {
    return descripcioCastella;
  }

  public void setDescripcioCastella(String descripcioCastella) {
    this.descripcioCastella = descripcioCastella;
  }

  public Procediments descripcioEstat(String descripcioEstat) {
    this.descripcioEstat = descripcioEstat;
    return this;
  }

   /**
   * Get descripcioEstat
   * @return descripcioEstat
  **/
  @ApiModelProperty(value = "")
  public String getDescripcioEstat() {
    return descripcioEstat;
  }

  public void setDescripcioEstat(String descripcioEstat) {
    this.descripcioEstat = descripcioEstat;
  }

  public Procediments descripcioRelacio(String descripcioRelacio) {
    this.descripcioRelacio = descripcioRelacio;
    return this;
  }

   /**
   * Get descripcioRelacio
   * @return descripcioRelacio
  **/
  @ApiModelProperty(value = "")
  public String getDescripcioRelacio() {
    return descripcioRelacio;
  }

  public void setDescripcioRelacio(String descripcioRelacio) {
    this.descripcioRelacio = descripcioRelacio;
  }

  public Procediments estatProcediment(BigDecimal estatProcediment) {
    this.estatProcediment = estatProcediment;
    return this;
  }

   /**
   * Get estatProcediment
   * @return estatProcediment
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getEstatProcediment() {
    return estatProcediment;
  }

  public void setEstatProcediment(BigDecimal estatProcediment) {
    this.estatProcediment = estatProcediment;
  }

  public Procediments estatsProcediment(EstatsProcediment estatsProcediment) {
    this.estatsProcediment = estatsProcediment;
    return this;
  }

   /**
   * Get estatsProcediment
   * @return estatsProcediment
  **/
  @ApiModelProperty(value = "")
  public EstatsProcediment getEstatsProcediment() {
    return estatsProcediment;
  }

  public void setEstatsProcediment(EstatsProcediment estatsProcediment) {
    this.estatsProcediment = estatsProcediment;
  }

  public Procediments historicsList(List<Historics> historicsList) {
    this.historicsList = historicsList;
    return this;
  }

  public Procediments addHistoricsListItem(Historics historicsListItem) {
    if (this.historicsList == null) {
      this.historicsList = new ArrayList<Historics>();
    }
    this.historicsList.add(historicsListItem);
    return this;
  }

   /**
   * Get historicsList
   * @return historicsList
  **/
  @ApiModelProperty(value = "")
  public List<Historics> getHistoricsList() {
    return historicsList;
  }

  public void setHistoricsList(List<Historics> historicsList) {
    this.historicsList = historicsList;
  }

  public Procediments id(BigDecimal id) {
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

  public Procediments identificacio(BigDecimal identificacio) {
    this.identificacio = identificacio;
    return this;
  }

   /**
   * Get identificacio
   * @return identificacio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIdentificacio() {
    return identificacio;
  }

  public void setIdentificacio(BigDecimal identificacio) {
    this.identificacio = identificacio;
  }

  public Procediments identificacions(Identificacions identificacions) {
    this.identificacions = identificacions;
    return this;
  }

   /**
   * Get identificacions
   * @return identificacions
  **/
  @ApiModelProperty(value = "")
  public Identificacions getIdentificacions() {
    return identificacions;
  }

  public void setIdentificacions(Identificacions identificacions) {
    this.identificacions = identificacions;
  }

  public Procediments iniciacionsList(List<ProcedimentsIniciacions> iniciacionsList) {
    this.iniciacionsList = iniciacionsList;
    return this;
  }

  public Procediments addIniciacionsListItem(ProcedimentsIniciacions iniciacionsListItem) {
    if (this.iniciacionsList == null) {
      this.iniciacionsList = new ArrayList<ProcedimentsIniciacions>();
    }
    this.iniciacionsList.add(iniciacionsListItem);
    return this;
  }

   /**
   * Get iniciacionsList
   * @return iniciacionsList
  **/
  @ApiModelProperty(value = "")
  public List<ProcedimentsIniciacions> getIniciacionsList() {
    return iniciacionsList;
  }

  public void setIniciacionsList(List<ProcedimentsIniciacions> iniciacionsList) {
    this.iniciacionsList = iniciacionsList;
  }

  public Procediments nom(String nom) {
    this.nom = nom;
    return this;
  }

   /**
   * Get nom
   * @return nom
  **/
  @ApiModelProperty(value = "")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Procediments nomCastella(String nomCastella) {
    this.nomCastella = nomCastella;
    return this;
  }

   /**
   * Get nomCastella
   * @return nomCastella
  **/
  @ApiModelProperty(value = "")
  public String getNomCastella() {
    return nomCastella;
  }

  public void setNomCastella(String nomCastella) {
    this.nomCastella = nomCastella;
  }

  public Procediments numerador(BigDecimal numerador) {
    this.numerador = numerador;
    return this;
  }

   /**
   * Get numerador
   * @return numerador
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getNumerador() {
    return numerador;
  }

  public void setNumerador(BigDecimal numerador) {
    this.numerador = numerador;
  }

  public Procediments procedimentsAssociatsList(List<Procediments> procedimentsAssociatsList) {
    this.procedimentsAssociatsList = procedimentsAssociatsList;
    return this;
  }

  public Procediments addProcedimentsAssociatsListItem(Procediments procedimentsAssociatsListItem) {
    if (this.procedimentsAssociatsList == null) {
      this.procedimentsAssociatsList = new ArrayList<Procediments>();
    }
    this.procedimentsAssociatsList.add(procedimentsAssociatsListItem);
    return this;
  }

   /**
   * Get procedimentsAssociatsList
   * @return procedimentsAssociatsList
  **/
  @ApiModelProperty(value = "")
  public List<Procediments> getProcedimentsAssociatsList() {
    return procedimentsAssociatsList;
  }

  public void setProcedimentsAssociatsList(List<Procediments> procedimentsAssociatsList) {
    this.procedimentsAssociatsList = procedimentsAssociatsList;
  }

  public Procediments procedimentsRelacionatsList(List<ProcedimentsRelacionats> procedimentsRelacionatsList) {
    this.procedimentsRelacionatsList = procedimentsRelacionatsList;
    return this;
  }

  public Procediments addProcedimentsRelacionatsListItem(ProcedimentsRelacionats procedimentsRelacionatsListItem) {
    if (this.procedimentsRelacionatsList == null) {
      this.procedimentsRelacionatsList = new ArrayList<ProcedimentsRelacionats>();
    }
    this.procedimentsRelacionatsList.add(procedimentsRelacionatsListItem);
    return this;
  }

   /**
   * Get procedimentsRelacionatsList
   * @return procedimentsRelacionatsList
  **/
  @ApiModelProperty(value = "")
  public List<ProcedimentsRelacionats> getProcedimentsRelacionatsList() {
    return procedimentsRelacionatsList;
  }

  public void setProcedimentsRelacionatsList(List<ProcedimentsRelacionats> procedimentsRelacionatsList) {
    this.procedimentsRelacionatsList = procedimentsRelacionatsList;
  }

  public Procediments reqOperatius(RequerimentsOperatius reqOperatius) {
    this.reqOperatius = reqOperatius;
    return this;
  }

   /**
   * Get reqOperatius
   * @return reqOperatius
  **/
  @ApiModelProperty(value = "")
  public RequerimentsOperatius getReqOperatius() {
    return reqOperatius;
  }

  public void setReqOperatius(RequerimentsOperatius reqOperatius) {
    this.reqOperatius = reqOperatius;
  }

  public Procediments requerimentsOperatius(BigDecimal requerimentsOperatius) {
    this.requerimentsOperatius = requerimentsOperatius;
    return this;
  }

   /**
   * Get requerimentsOperatius
   * @return requerimentsOperatius
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getRequerimentsOperatius() {
    return requerimentsOperatius;
  }

  public void setRequerimentsOperatius(BigDecimal requerimentsOperatius) {
    this.requerimentsOperatius = requerimentsOperatius;
  }

  public Procediments serieDocumental(String serieDocumental) {
    this.serieDocumental = serieDocumental;
    return this;
  }

   /**
   * Get serieDocumental
   * @return serieDocumental
  **/
  @ApiModelProperty(value = "")
  public String getSerieDocumental() {
    return serieDocumental;
  }

  public void setSerieDocumental(String serieDocumental) {
    this.serieDocumental = serieDocumental;
  }

  public Procediments tramitador(String tramitador) {
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

  public Procediments ugosList(List<ProcedimentsUgos> ugosList) {
    this.ugosList = ugosList;
    return this;
  }

  public Procediments addUgosListItem(ProcedimentsUgos ugosListItem) {
    if (this.ugosList == null) {
      this.ugosList = new ArrayList<ProcedimentsUgos>();
    }
    this.ugosList.add(ugosListItem);
    return this;
  }

   /**
   * Get ugosList
   * @return ugosList
  **/
  @ApiModelProperty(value = "")
  public List<ProcedimentsUgos> getUgosList() {
    return ugosList;
  }

  public void setUgosList(List<ProcedimentsUgos> ugosList) {
    this.ugosList = ugosList;
  }

  public Procediments ugosNoms(String ugosNoms) {
    this.ugosNoms = ugosNoms;
    return this;
  }

   /**
   * Get ugosNoms
   * @return ugosNoms
  **/
  @ApiModelProperty(value = "")
  public String getUgosNoms() {
    return ugosNoms;
  }

  public void setUgosNoms(String ugosNoms) {
    this.ugosNoms = ugosNoms;
  }

  public Procediments ugrIdext(BigDecimal ugrIdext) {
    this.ugrIdext = ugrIdext;
    return this;
  }

   /**
   * Get ugrIdext
   * @return ugrIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUgrIdext() {
    return ugrIdext;
  }

  public void setUgrIdext(BigDecimal ugrIdext) {
    this.ugrIdext = ugrIdext;
  }

  public Procediments ugrNom(String ugrNom) {
    this.ugrNom = ugrNom;
    return this;
  }

   /**
   * Get ugrNom
   * @return ugrNom
  **/
  @ApiModelProperty(value = "")
  public String getUgrNom() {
    return ugrNom;
  }

  public void setUgrNom(String ugrNom) {
    this.ugrNom = ugrNom;
  }

  public Procediments ultimaModificacio(BigDecimal ultimaModificacio) {
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

  public Procediments unitat(String unitat) {
    this.unitat = unitat;
    return this;
  }

   /**
   * Get unitat
   * @return unitat
  **/
  @ApiModelProperty(value = "")
  public String getUnitat() {
    return unitat;
  }

  public void setUnitat(String unitat) {
    this.unitat = unitat;
  }

  public Procediments versio(String versio) {
    this.versio = versio;
    return this;
  }

   /**
   * Get versio
   * @return versio
  **/
  @ApiModelProperty(value = "")
  public String getVersio() {
    return versio;
  }

  public void setVersio(String versio) {
    this.versio = versio;
  }

  public Procediments versioDocumental(BigDecimal versioDocumental) {
    this.versioDocumental = versioDocumental;
    return this;
  }

   /**
   * Get versioDocumental
   * @return versioDocumental
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getVersioDocumental() {
    return versioDocumental;
  }

  public void setVersioDocumental(BigDecimal versioDocumental) {
    this.versioDocumental = versioDocumental;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Procediments procediments = (Procediments) o;
    return Objects.equals(this.bloqueig, procediments.bloqueig) &&
        Objects.equals(this.bloquejos, procediments.bloquejos) &&
        Objects.equals(this.codi, procediments.codi) &&
        Objects.equals(this.codiNom, procediments.codiNom) &&
        Objects.equals(this.comentarisList, procediments.comentarisList) &&
        Objects.equals(this.configuracioAvisos, procediments.configuracioAvisos) &&
        Objects.equals(this.configuracioDocumentacio, procediments.configuracioDocumentacio) &&
        Objects.equals(this.dadesGrupsList, procediments.dadesGrupsList) &&
        Objects.equals(this.darreraModificacio, procediments.darreraModificacio) &&
        Objects.equals(this.descripcio, procediments.descripcio) &&
        Objects.equals(this.descripcioCastella, procediments.descripcioCastella) &&
        Objects.equals(this.descripcioEstat, procediments.descripcioEstat) &&
        Objects.equals(this.descripcioRelacio, procediments.descripcioRelacio) &&
        Objects.equals(this.estatProcediment, procediments.estatProcediment) &&
        Objects.equals(this.estatsProcediment, procediments.estatsProcediment) &&
        Objects.equals(this.historicsList, procediments.historicsList) &&
        Objects.equals(this.id, procediments.id) &&
        Objects.equals(this.identificacio, procediments.identificacio) &&
        Objects.equals(this.identificacions, procediments.identificacions) &&
        Objects.equals(this.iniciacionsList, procediments.iniciacionsList) &&
        Objects.equals(this.nom, procediments.nom) &&
        Objects.equals(this.nomCastella, procediments.nomCastella) &&
        Objects.equals(this.numerador, procediments.numerador) &&
        Objects.equals(this.procedimentsAssociatsList, procediments.procedimentsAssociatsList) &&
        Objects.equals(this.procedimentsRelacionatsList, procediments.procedimentsRelacionatsList) &&
        Objects.equals(this.reqOperatius, procediments.reqOperatius) &&
        Objects.equals(this.requerimentsOperatius, procediments.requerimentsOperatius) &&
        Objects.equals(this.serieDocumental, procediments.serieDocumental) &&
        Objects.equals(this.tramitador, procediments.tramitador) &&
        Objects.equals(this.ugosList, procediments.ugosList) &&
        Objects.equals(this.ugosNoms, procediments.ugosNoms) &&
        Objects.equals(this.ugrIdext, procediments.ugrIdext) &&
        Objects.equals(this.ugrNom, procediments.ugrNom) &&
        Objects.equals(this.ultimaModificacio, procediments.ultimaModificacio) &&
        Objects.equals(this.unitat, procediments.unitat) &&
        Objects.equals(this.versio, procediments.versio) &&
        Objects.equals(this.versioDocumental, procediments.versioDocumental);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bloqueig, bloquejos, codi, codiNom, comentarisList, configuracioAvisos, configuracioDocumentacio, dadesGrupsList, darreraModificacio, descripcio, descripcioCastella, descripcioEstat, descripcioRelacio, estatProcediment, estatsProcediment, historicsList, id, identificacio, identificacions, iniciacionsList, nom, nomCastella, numerador, procedimentsAssociatsList, procedimentsRelacionatsList, reqOperatius, requerimentsOperatius, serieDocumental, tramitador, ugosList, ugosNoms, ugrIdext, ugrNom, ultimaModificacio, unitat, versio, versioDocumental);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Procediments {\n");
    
    sb.append("    bloqueig: ").append(toIndentedString(bloqueig)).append("\n");
    sb.append("    bloquejos: ").append(toIndentedString(bloquejos)).append("\n");
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    codiNom: ").append(toIndentedString(codiNom)).append("\n");
    sb.append("    comentarisList: ").append(toIndentedString(comentarisList)).append("\n");
    sb.append("    configuracioAvisos: ").append(toIndentedString(configuracioAvisos)).append("\n");
    sb.append("    configuracioDocumentacio: ").append(toIndentedString(configuracioDocumentacio)).append("\n");
    sb.append("    dadesGrupsList: ").append(toIndentedString(dadesGrupsList)).append("\n");
    sb.append("    darreraModificacio: ").append(toIndentedString(darreraModificacio)).append("\n");
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
    sb.append("    descripcioCastella: ").append(toIndentedString(descripcioCastella)).append("\n");
    sb.append("    descripcioEstat: ").append(toIndentedString(descripcioEstat)).append("\n");
    sb.append("    descripcioRelacio: ").append(toIndentedString(descripcioRelacio)).append("\n");
    sb.append("    estatProcediment: ").append(toIndentedString(estatProcediment)).append("\n");
    sb.append("    estatsProcediment: ").append(toIndentedString(estatsProcediment)).append("\n");
    sb.append("    historicsList: ").append(toIndentedString(historicsList)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    identificacio: ").append(toIndentedString(identificacio)).append("\n");
    sb.append("    identificacions: ").append(toIndentedString(identificacions)).append("\n");
    sb.append("    iniciacionsList: ").append(toIndentedString(iniciacionsList)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    nomCastella: ").append(toIndentedString(nomCastella)).append("\n");
    sb.append("    numerador: ").append(toIndentedString(numerador)).append("\n");
    sb.append("    procedimentsAssociatsList: ").append(toIndentedString(procedimentsAssociatsList)).append("\n");
    sb.append("    procedimentsRelacionatsList: ").append(toIndentedString(procedimentsRelacionatsList)).append("\n");
    sb.append("    reqOperatius: ").append(toIndentedString(reqOperatius)).append("\n");
    sb.append("    requerimentsOperatius: ").append(toIndentedString(requerimentsOperatius)).append("\n");
    sb.append("    serieDocumental: ").append(toIndentedString(serieDocumental)).append("\n");
    sb.append("    tramitador: ").append(toIndentedString(tramitador)).append("\n");
    sb.append("    ugosList: ").append(toIndentedString(ugosList)).append("\n");
    sb.append("    ugosNoms: ").append(toIndentedString(ugosNoms)).append("\n");
    sb.append("    ugrIdext: ").append(toIndentedString(ugrIdext)).append("\n");
    sb.append("    ugrNom: ").append(toIndentedString(ugrNom)).append("\n");
    sb.append("    ultimaModificacio: ").append(toIndentedString(ultimaModificacio)).append("\n");
    sb.append("    unitat: ").append(toIndentedString(unitat)).append("\n");
    sb.append("    versio: ").append(toIndentedString(versio)).append("\n");
    sb.append("    versioDocumental: ").append(toIndentedString(versioDocumental)).append("\n");
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

