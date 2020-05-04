/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.20.1
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AtributsDocs;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfdocsentEstatsExp;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfdocsentTramitsOvt;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ConfiguracioDocsEntrada
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-30T19:13:23.947+02:00")
public class ConfiguracioDocsEntrada {
  @JsonProperty("atributDoc")
  private BigDecimal atributDoc = null;

  @JsonProperty("atributsDocs")
  private AtributsDocs atributsDocs = null;

  @JsonProperty("codiNti")
  private String codiNti = null;

  @JsonProperty("confdocsentEstatsExpList")
  private List<ConfdocsentEstatsExp> confdocsentEstatsExpList = null;

  @JsonProperty("confdocsentTramitsOvtList")
  private List<ConfdocsentTramitsOvt> confdocsentTramitsOvtList = null;

  @JsonProperty("configuracioDocumentacio")
  private BigDecimal configuracioDocumentacio = null;

  @JsonProperty("descripcioAmpliada")
  private String descripcioAmpliada = null;

  @JsonProperty("detallOrigen")
  private String detallOrigen = null;

  @JsonProperty("editable")
  private Boolean editable = null;

  @JsonProperty("fase")
  private Integer fase = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("nom")
  private String nom = null;

  @JsonProperty("nomCastella")
  private String nomCastella = null;

  @JsonProperty("nomNti")
  private String nomNti = null;

  @JsonProperty("origen")
  private Integer origen = null;

  @JsonProperty("seleccionable")
  private Boolean seleccionable = null;

  @JsonProperty("suportConfeccio")
  private Integer suportConfeccio = null;

  @JsonProperty("suportEnllac")
  private String suportEnllac = null;

  @JsonProperty("tipusDocumental")
  private String tipusDocumental = null;

  @JsonProperty("tractament")
  private String tractament = null;

  @JsonProperty("uniqueId")
  private BigDecimal uniqueId = null;

  public ConfiguracioDocsEntrada atributDoc(BigDecimal atributDoc) {
    this.atributDoc = atributDoc;
    return this;
  }

   /**
   * Get atributDoc
   * @return atributDoc
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getAtributDoc() {
    return atributDoc;
  }

  public void setAtributDoc(BigDecimal atributDoc) {
    this.atributDoc = atributDoc;
  }

  public ConfiguracioDocsEntrada atributsDocs(AtributsDocs atributsDocs) {
    this.atributsDocs = atributsDocs;
    return this;
  }

   /**
   * Get atributsDocs
   * @return atributsDocs
  **/
  @ApiModelProperty(value = "")
  public AtributsDocs getAtributsDocs() {
    return atributsDocs;
  }

  public void setAtributsDocs(AtributsDocs atributsDocs) {
    this.atributsDocs = atributsDocs;
  }

  public ConfiguracioDocsEntrada codiNti(String codiNti) {
    this.codiNti = codiNti;
    return this;
  }

   /**
   * Get codiNti
   * @return codiNti
  **/
  @ApiModelProperty(value = "")
  public String getCodiNti() {
    return codiNti;
  }

  public void setCodiNti(String codiNti) {
    this.codiNti = codiNti;
  }

  public ConfiguracioDocsEntrada confdocsentEstatsExpList(List<ConfdocsentEstatsExp> confdocsentEstatsExpList) {
    this.confdocsentEstatsExpList = confdocsentEstatsExpList;
    return this;
  }

  public ConfiguracioDocsEntrada addConfdocsentEstatsExpListItem(ConfdocsentEstatsExp confdocsentEstatsExpListItem) {
    if (this.confdocsentEstatsExpList == null) {
      this.confdocsentEstatsExpList = new ArrayList<ConfdocsentEstatsExp>();
    }
    this.confdocsentEstatsExpList.add(confdocsentEstatsExpListItem);
    return this;
  }

   /**
   * Get confdocsentEstatsExpList
   * @return confdocsentEstatsExpList
  **/
  @ApiModelProperty(value = "")
  public List<ConfdocsentEstatsExp> getConfdocsentEstatsExpList() {
    return confdocsentEstatsExpList;
  }

  public void setConfdocsentEstatsExpList(List<ConfdocsentEstatsExp> confdocsentEstatsExpList) {
    this.confdocsentEstatsExpList = confdocsentEstatsExpList;
  }

  public ConfiguracioDocsEntrada confdocsentTramitsOvtList(List<ConfdocsentTramitsOvt> confdocsentTramitsOvtList) {
    this.confdocsentTramitsOvtList = confdocsentTramitsOvtList;
    return this;
  }

  public ConfiguracioDocsEntrada addConfdocsentTramitsOvtListItem(ConfdocsentTramitsOvt confdocsentTramitsOvtListItem) {
    if (this.confdocsentTramitsOvtList == null) {
      this.confdocsentTramitsOvtList = new ArrayList<ConfdocsentTramitsOvt>();
    }
    this.confdocsentTramitsOvtList.add(confdocsentTramitsOvtListItem);
    return this;
  }

   /**
   * Get confdocsentTramitsOvtList
   * @return confdocsentTramitsOvtList
  **/
  @ApiModelProperty(value = "")
  public List<ConfdocsentTramitsOvt> getConfdocsentTramitsOvtList() {
    return confdocsentTramitsOvtList;
  }

  public void setConfdocsentTramitsOvtList(List<ConfdocsentTramitsOvt> confdocsentTramitsOvtList) {
    this.confdocsentTramitsOvtList = confdocsentTramitsOvtList;
  }

  public ConfiguracioDocsEntrada configuracioDocumentacio(BigDecimal configuracioDocumentacio) {
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

  public ConfiguracioDocsEntrada descripcioAmpliada(String descripcioAmpliada) {
    this.descripcioAmpliada = descripcioAmpliada;
    return this;
  }

   /**
   * Get descripcioAmpliada
   * @return descripcioAmpliada
  **/
  @ApiModelProperty(value = "")
  public String getDescripcioAmpliada() {
    return descripcioAmpliada;
  }

  public void setDescripcioAmpliada(String descripcioAmpliada) {
    this.descripcioAmpliada = descripcioAmpliada;
  }

  public ConfiguracioDocsEntrada detallOrigen(String detallOrigen) {
    this.detallOrigen = detallOrigen;
    return this;
  }

   /**
   * Get detallOrigen
   * @return detallOrigen
  **/
  @ApiModelProperty(value = "")
  public String getDetallOrigen() {
    return detallOrigen;
  }

  public void setDetallOrigen(String detallOrigen) {
    this.detallOrigen = detallOrigen;
  }

  public ConfiguracioDocsEntrada editable(Boolean editable) {
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

  public ConfiguracioDocsEntrada fase(Integer fase) {
    this.fase = fase;
    return this;
  }

   /**
   * Get fase
   * @return fase
  **/
  @ApiModelProperty(value = "")
  public Integer getFase() {
    return fase;
  }

  public void setFase(Integer fase) {
    this.fase = fase;
  }

  public ConfiguracioDocsEntrada id(BigDecimal id) {
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

  public ConfiguracioDocsEntrada nom(String nom) {
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

  public ConfiguracioDocsEntrada nomCastella(String nomCastella) {
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

  public ConfiguracioDocsEntrada nomNti(String nomNti) {
    this.nomNti = nomNti;
    return this;
  }

   /**
   * Get nomNti
   * @return nomNti
  **/
  @ApiModelProperty(value = "")
  public String getNomNti() {
    return nomNti;
  }

  public void setNomNti(String nomNti) {
    this.nomNti = nomNti;
  }

  public ConfiguracioDocsEntrada origen(Integer origen) {
    this.origen = origen;
    return this;
  }

   /**
   * Get origen
   * @return origen
  **/
  @ApiModelProperty(value = "")
  public Integer getOrigen() {
    return origen;
  }

  public void setOrigen(Integer origen) {
    this.origen = origen;
  }

  public ConfiguracioDocsEntrada seleccionable(Boolean seleccionable) {
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

  public ConfiguracioDocsEntrada suportConfeccio(Integer suportConfeccio) {
    this.suportConfeccio = suportConfeccio;
    return this;
  }

   /**
   * Get suportConfeccio
   * @return suportConfeccio
  **/
  @ApiModelProperty(value = "")
  public Integer getSuportConfeccio() {
    return suportConfeccio;
  }

  public void setSuportConfeccio(Integer suportConfeccio) {
    this.suportConfeccio = suportConfeccio;
  }

  public ConfiguracioDocsEntrada suportEnllac(String suportEnllac) {
    this.suportEnllac = suportEnllac;
    return this;
  }

   /**
   * Get suportEnllac
   * @return suportEnllac
  **/
  @ApiModelProperty(value = "")
  public String getSuportEnllac() {
    return suportEnllac;
  }

  public void setSuportEnllac(String suportEnllac) {
    this.suportEnllac = suportEnllac;
  }

  public ConfiguracioDocsEntrada tipusDocumental(String tipusDocumental) {
    this.tipusDocumental = tipusDocumental;
    return this;
  }

   /**
   * Get tipusDocumental
   * @return tipusDocumental
  **/
  @ApiModelProperty(value = "")
  public String getTipusDocumental() {
    return tipusDocumental;
  }

  public void setTipusDocumental(String tipusDocumental) {
    this.tipusDocumental = tipusDocumental;
  }

  public ConfiguracioDocsEntrada tractament(String tractament) {
    this.tractament = tractament;
    return this;
  }

   /**
   * Get tractament
   * @return tractament
  **/
  @ApiModelProperty(value = "")
  public String getTractament() {
    return tractament;
  }

  public void setTractament(String tractament) {
    this.tractament = tractament;
  }

  public ConfiguracioDocsEntrada uniqueId(BigDecimal uniqueId) {
    this.uniqueId = uniqueId;
    return this;
  }

   /**
   * Get uniqueId
   * @return uniqueId
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(BigDecimal uniqueId) {
    this.uniqueId = uniqueId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfiguracioDocsEntrada configuracioDocsEntrada = (ConfiguracioDocsEntrada) o;
    return Objects.equals(this.atributDoc, configuracioDocsEntrada.atributDoc) &&
        Objects.equals(this.atributsDocs, configuracioDocsEntrada.atributsDocs) &&
        Objects.equals(this.codiNti, configuracioDocsEntrada.codiNti) &&
        Objects.equals(this.confdocsentEstatsExpList, configuracioDocsEntrada.confdocsentEstatsExpList) &&
        Objects.equals(this.confdocsentTramitsOvtList, configuracioDocsEntrada.confdocsentTramitsOvtList) &&
        Objects.equals(this.configuracioDocumentacio, configuracioDocsEntrada.configuracioDocumentacio) &&
        Objects.equals(this.descripcioAmpliada, configuracioDocsEntrada.descripcioAmpliada) &&
        Objects.equals(this.detallOrigen, configuracioDocsEntrada.detallOrigen) &&
        Objects.equals(this.editable, configuracioDocsEntrada.editable) &&
        Objects.equals(this.fase, configuracioDocsEntrada.fase) &&
        Objects.equals(this.id, configuracioDocsEntrada.id) &&
        Objects.equals(this.nom, configuracioDocsEntrada.nom) &&
        Objects.equals(this.nomCastella, configuracioDocsEntrada.nomCastella) &&
        Objects.equals(this.nomNti, configuracioDocsEntrada.nomNti) &&
        Objects.equals(this.origen, configuracioDocsEntrada.origen) &&
        Objects.equals(this.seleccionable, configuracioDocsEntrada.seleccionable) &&
        Objects.equals(this.suportConfeccio, configuracioDocsEntrada.suportConfeccio) &&
        Objects.equals(this.suportEnllac, configuracioDocsEntrada.suportEnllac) &&
        Objects.equals(this.tipusDocumental, configuracioDocsEntrada.tipusDocumental) &&
        Objects.equals(this.tractament, configuracioDocsEntrada.tractament) &&
        Objects.equals(this.uniqueId, configuracioDocsEntrada.uniqueId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(atributDoc, atributsDocs, codiNti, confdocsentEstatsExpList, confdocsentTramitsOvtList, configuracioDocumentacio, descripcioAmpliada, detallOrigen, editable, fase, id, nom, nomCastella, nomNti, origen, seleccionable, suportConfeccio, suportEnllac, tipusDocumental, tractament, uniqueId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfiguracioDocsEntrada {\n");
    
    sb.append("    atributDoc: ").append(toIndentedString(atributDoc)).append("\n");
    sb.append("    atributsDocs: ").append(toIndentedString(atributsDocs)).append("\n");
    sb.append("    codiNti: ").append(toIndentedString(codiNti)).append("\n");
    sb.append("    confdocsentEstatsExpList: ").append(toIndentedString(confdocsentEstatsExpList)).append("\n");
    sb.append("    confdocsentTramitsOvtList: ").append(toIndentedString(confdocsentTramitsOvtList)).append("\n");
    sb.append("    configuracioDocumentacio: ").append(toIndentedString(configuracioDocumentacio)).append("\n");
    sb.append("    descripcioAmpliada: ").append(toIndentedString(descripcioAmpliada)).append("\n");
    sb.append("    detallOrigen: ").append(toIndentedString(detallOrigen)).append("\n");
    sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
    sb.append("    fase: ").append(toIndentedString(fase)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    nomCastella: ").append(toIndentedString(nomCastella)).append("\n");
    sb.append("    nomNti: ").append(toIndentedString(nomNti)).append("\n");
    sb.append("    origen: ").append(toIndentedString(origen)).append("\n");
    sb.append("    seleccionable: ").append(toIndentedString(seleccionable)).append("\n");
    sb.append("    suportConfeccio: ").append(toIndentedString(suportConfeccio)).append("\n");
    sb.append("    suportEnllac: ").append(toIndentedString(suportEnllac)).append("\n");
    sb.append("    tipusDocumental: ").append(toIndentedString(tipusDocumental)).append("\n");
    sb.append("    tractament: ").append(toIndentedString(tractament)).append("\n");
    sb.append("    uniqueId: ").append(toIndentedString(uniqueId)).append("\n");
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

