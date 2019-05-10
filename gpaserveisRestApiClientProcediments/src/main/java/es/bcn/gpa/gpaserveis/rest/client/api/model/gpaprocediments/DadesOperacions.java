/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 1.11.0
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperTramitsOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsValidacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesoperEstatsExp;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Items;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * DadesOperacions
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-10T10:06:44.423+02:00")
public class DadesOperacions {
  @JsonProperty("cercable")
  private Integer cercable = null;

  @JsonProperty("codi")
  private String codi = null;

  @JsonProperty("comentari")
  private String comentari = null;

  @JsonProperty("dadesOperTramitsOvtList")
  private List<DadesOperTramitsOvt> dadesOperTramitsOvtList = null;

  @JsonProperty("dadesOperacionsValidacio")
  private List<DadesOperacionsValidacio> dadesOperacionsValidacio = null;

  @JsonProperty("dadesoperEstatsExpList")
  private List<DadesoperEstatsExp> dadesoperEstatsExpList = null;

  @JsonProperty("desTipusCamp")
  private String desTipusCamp = null;

  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("descripcioCastella")
  private String descripcioCastella = null;

  @JsonProperty("detallValidacio")
  private String detallValidacio = null;

  @JsonProperty("editable")
  private Boolean editable = null;

  @JsonProperty("grup")
  private BigDecimal grup = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("itemsList")
  private List<Items> itemsList = null;

  @JsonProperty("obligatoriEnEstat")
  private Boolean obligatoriEnEstat = null;

  @JsonProperty("ordre")
  private Integer ordre = null;

  @JsonProperty("procediment")
  private BigDecimal procediment = null;

  @JsonProperty("seleccionable")
  private Boolean seleccionable = null;

  @JsonProperty("tipus")
  private Integer tipus = null;

  @JsonProperty("titol")
  private String titol = null;

  @JsonProperty("titolCastella")
  private String titolCastella = null;

  @JsonProperty("titolGrup")
  private String titolGrup = null;

  @JsonProperty("urlOrigen")
  private String urlOrigen = null;

  @JsonProperty("validacio")
  private Integer validacio = null;

  @JsonProperty("vigent")
  private Integer vigent = null;

  public DadesOperacions cercable(Integer cercable) {
    this.cercable = cercable;
    return this;
  }

   /**
   * Get cercable
   * @return cercable
  **/
  @ApiModelProperty(value = "")
  public Integer getCercable() {
    return cercable;
  }

  public void setCercable(Integer cercable) {
    this.cercable = cercable;
  }

  public DadesOperacions codi(String codi) {
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

  public DadesOperacions comentari(String comentari) {
    this.comentari = comentari;
    return this;
  }

   /**
   * Get comentari
   * @return comentari
  **/
  @ApiModelProperty(value = "")
  public String getComentari() {
    return comentari;
  }

  public void setComentari(String comentari) {
    this.comentari = comentari;
  }

  public DadesOperacions dadesOperTramitsOvtList(List<DadesOperTramitsOvt> dadesOperTramitsOvtList) {
    this.dadesOperTramitsOvtList = dadesOperTramitsOvtList;
    return this;
  }

  public DadesOperacions addDadesOperTramitsOvtListItem(DadesOperTramitsOvt dadesOperTramitsOvtListItem) {
    if (this.dadesOperTramitsOvtList == null) {
      this.dadesOperTramitsOvtList = new ArrayList<DadesOperTramitsOvt>();
    }
    this.dadesOperTramitsOvtList.add(dadesOperTramitsOvtListItem);
    return this;
  }

   /**
   * Get dadesOperTramitsOvtList
   * @return dadesOperTramitsOvtList
  **/
  @ApiModelProperty(value = "")
  public List<DadesOperTramitsOvt> getDadesOperTramitsOvtList() {
    return dadesOperTramitsOvtList;
  }

  public void setDadesOperTramitsOvtList(List<DadesOperTramitsOvt> dadesOperTramitsOvtList) {
    this.dadesOperTramitsOvtList = dadesOperTramitsOvtList;
  }

  public DadesOperacions dadesOperacionsValidacio(List<DadesOperacionsValidacio> dadesOperacionsValidacio) {
    this.dadesOperacionsValidacio = dadesOperacionsValidacio;
    return this;
  }

  public DadesOperacions addDadesOperacionsValidacioItem(DadesOperacionsValidacio dadesOperacionsValidacioItem) {
    if (this.dadesOperacionsValidacio == null) {
      this.dadesOperacionsValidacio = new ArrayList<DadesOperacionsValidacio>();
    }
    this.dadesOperacionsValidacio.add(dadesOperacionsValidacioItem);
    return this;
  }

   /**
   * Get dadesOperacionsValidacio
   * @return dadesOperacionsValidacio
  **/
  @ApiModelProperty(value = "")
  public List<DadesOperacionsValidacio> getDadesOperacionsValidacio() {
    return dadesOperacionsValidacio;
  }

  public void setDadesOperacionsValidacio(List<DadesOperacionsValidacio> dadesOperacionsValidacio) {
    this.dadesOperacionsValidacio = dadesOperacionsValidacio;
  }

  public DadesOperacions dadesoperEstatsExpList(List<DadesoperEstatsExp> dadesoperEstatsExpList) {
    this.dadesoperEstatsExpList = dadesoperEstatsExpList;
    return this;
  }

  public DadesOperacions addDadesoperEstatsExpListItem(DadesoperEstatsExp dadesoperEstatsExpListItem) {
    if (this.dadesoperEstatsExpList == null) {
      this.dadesoperEstatsExpList = new ArrayList<DadesoperEstatsExp>();
    }
    this.dadesoperEstatsExpList.add(dadesoperEstatsExpListItem);
    return this;
  }

   /**
   * Get dadesoperEstatsExpList
   * @return dadesoperEstatsExpList
  **/
  @ApiModelProperty(value = "")
  public List<DadesoperEstatsExp> getDadesoperEstatsExpList() {
    return dadesoperEstatsExpList;
  }

  public void setDadesoperEstatsExpList(List<DadesoperEstatsExp> dadesoperEstatsExpList) {
    this.dadesoperEstatsExpList = dadesoperEstatsExpList;
  }

  public DadesOperacions desTipusCamp(String desTipusCamp) {
    this.desTipusCamp = desTipusCamp;
    return this;
  }

   /**
   * Get desTipusCamp
   * @return desTipusCamp
  **/
  @ApiModelProperty(value = "")
  public String getDesTipusCamp() {
    return desTipusCamp;
  }

  public void setDesTipusCamp(String desTipusCamp) {
    this.desTipusCamp = desTipusCamp;
  }

  public DadesOperacions descripcio(String descripcio) {
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

  public DadesOperacions descripcioCastella(String descripcioCastella) {
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

  public DadesOperacions detallValidacio(String detallValidacio) {
    this.detallValidacio = detallValidacio;
    return this;
  }

   /**
   * Get detallValidacio
   * @return detallValidacio
  **/
  @ApiModelProperty(value = "")
  public String getDetallValidacio() {
    return detallValidacio;
  }

  public void setDetallValidacio(String detallValidacio) {
    this.detallValidacio = detallValidacio;
  }

  public DadesOperacions editable(Boolean editable) {
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

  public DadesOperacions grup(BigDecimal grup) {
    this.grup = grup;
    return this;
  }

   /**
   * Get grup
   * @return grup
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getGrup() {
    return grup;
  }

  public void setGrup(BigDecimal grup) {
    this.grup = grup;
  }

  public DadesOperacions id(BigDecimal id) {
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

  public DadesOperacions itemsList(List<Items> itemsList) {
    this.itemsList = itemsList;
    return this;
  }

  public DadesOperacions addItemsListItem(Items itemsListItem) {
    if (this.itemsList == null) {
      this.itemsList = new ArrayList<Items>();
    }
    this.itemsList.add(itemsListItem);
    return this;
  }

   /**
   * Get itemsList
   * @return itemsList
  **/
  @ApiModelProperty(value = "")
  public List<Items> getItemsList() {
    return itemsList;
  }

  public void setItemsList(List<Items> itemsList) {
    this.itemsList = itemsList;
  }

  public DadesOperacions obligatoriEnEstat(Boolean obligatoriEnEstat) {
    this.obligatoriEnEstat = obligatoriEnEstat;
    return this;
  }

   /**
   * Get obligatoriEnEstat
   * @return obligatoriEnEstat
  **/
  @ApiModelProperty(value = "")
  public Boolean isObligatoriEnEstat() {
    return obligatoriEnEstat;
  }

  public void setObligatoriEnEstat(Boolean obligatoriEnEstat) {
    this.obligatoriEnEstat = obligatoriEnEstat;
  }

  public DadesOperacions ordre(Integer ordre) {
    this.ordre = ordre;
    return this;
  }

   /**
   * Get ordre
   * @return ordre
  **/
  @ApiModelProperty(value = "")
  public Integer getOrdre() {
    return ordre;
  }

  public void setOrdre(Integer ordre) {
    this.ordre = ordre;
  }

  public DadesOperacions procediment(BigDecimal procediment) {
    this.procediment = procediment;
    return this;
  }

   /**
   * Get procediment
   * @return procediment
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getProcediment() {
    return procediment;
  }

  public void setProcediment(BigDecimal procediment) {
    this.procediment = procediment;
  }

  public DadesOperacions seleccionable(Boolean seleccionable) {
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

  public DadesOperacions tipus(Integer tipus) {
    this.tipus = tipus;
    return this;
  }

   /**
   * Get tipus
   * @return tipus
  **/
  @ApiModelProperty(value = "")
  public Integer getTipus() {
    return tipus;
  }

  public void setTipus(Integer tipus) {
    this.tipus = tipus;
  }

  public DadesOperacions titol(String titol) {
    this.titol = titol;
    return this;
  }

   /**
   * Get titol
   * @return titol
  **/
  @ApiModelProperty(value = "")
  public String getTitol() {
    return titol;
  }

  public void setTitol(String titol) {
    this.titol = titol;
  }

  public DadesOperacions titolCastella(String titolCastella) {
    this.titolCastella = titolCastella;
    return this;
  }

   /**
   * Get titolCastella
   * @return titolCastella
  **/
  @ApiModelProperty(value = "")
  public String getTitolCastella() {
    return titolCastella;
  }

  public void setTitolCastella(String titolCastella) {
    this.titolCastella = titolCastella;
  }

  public DadesOperacions titolGrup(String titolGrup) {
    this.titolGrup = titolGrup;
    return this;
  }

   /**
   * Get titolGrup
   * @return titolGrup
  **/
  @ApiModelProperty(value = "")
  public String getTitolGrup() {
    return titolGrup;
  }

  public void setTitolGrup(String titolGrup) {
    this.titolGrup = titolGrup;
  }

  public DadesOperacions urlOrigen(String urlOrigen) {
    this.urlOrigen = urlOrigen;
    return this;
  }

   /**
   * Get urlOrigen
   * @return urlOrigen
  **/
  @ApiModelProperty(value = "")
  public String getUrlOrigen() {
    return urlOrigen;
  }

  public void setUrlOrigen(String urlOrigen) {
    this.urlOrigen = urlOrigen;
  }

  public DadesOperacions validacio(Integer validacio) {
    this.validacio = validacio;
    return this;
  }

   /**
   * Get validacio
   * @return validacio
  **/
  @ApiModelProperty(value = "")
  public Integer getValidacio() {
    return validacio;
  }

  public void setValidacio(Integer validacio) {
    this.validacio = validacio;
  }

  public DadesOperacions vigent(Integer vigent) {
    this.vigent = vigent;
    return this;
  }

   /**
   * Get vigent
   * @return vigent
  **/
  @ApiModelProperty(value = "")
  public Integer getVigent() {
    return vigent;
  }

  public void setVigent(Integer vigent) {
    this.vigent = vigent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DadesOperacions dadesOperacions = (DadesOperacions) o;
    return Objects.equals(this.cercable, dadesOperacions.cercable) &&
        Objects.equals(this.codi, dadesOperacions.codi) &&
        Objects.equals(this.comentari, dadesOperacions.comentari) &&
        Objects.equals(this.dadesOperTramitsOvtList, dadesOperacions.dadesOperTramitsOvtList) &&
        Objects.equals(this.dadesOperacionsValidacio, dadesOperacions.dadesOperacionsValidacio) &&
        Objects.equals(this.dadesoperEstatsExpList, dadesOperacions.dadesoperEstatsExpList) &&
        Objects.equals(this.desTipusCamp, dadesOperacions.desTipusCamp) &&
        Objects.equals(this.descripcio, dadesOperacions.descripcio) &&
        Objects.equals(this.descripcioCastella, dadesOperacions.descripcioCastella) &&
        Objects.equals(this.detallValidacio, dadesOperacions.detallValidacio) &&
        Objects.equals(this.editable, dadesOperacions.editable) &&
        Objects.equals(this.grup, dadesOperacions.grup) &&
        Objects.equals(this.id, dadesOperacions.id) &&
        Objects.equals(this.itemsList, dadesOperacions.itemsList) &&
        Objects.equals(this.obligatoriEnEstat, dadesOperacions.obligatoriEnEstat) &&
        Objects.equals(this.ordre, dadesOperacions.ordre) &&
        Objects.equals(this.procediment, dadesOperacions.procediment) &&
        Objects.equals(this.seleccionable, dadesOperacions.seleccionable) &&
        Objects.equals(this.tipus, dadesOperacions.tipus) &&
        Objects.equals(this.titol, dadesOperacions.titol) &&
        Objects.equals(this.titolCastella, dadesOperacions.titolCastella) &&
        Objects.equals(this.titolGrup, dadesOperacions.titolGrup) &&
        Objects.equals(this.urlOrigen, dadesOperacions.urlOrigen) &&
        Objects.equals(this.validacio, dadesOperacions.validacio) &&
        Objects.equals(this.vigent, dadesOperacions.vigent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cercable, codi, comentari, dadesOperTramitsOvtList, dadesOperacionsValidacio, dadesoperEstatsExpList, desTipusCamp, descripcio, descripcioCastella, detallValidacio, editable, grup, id, itemsList, obligatoriEnEstat, ordre, procediment, seleccionable, tipus, titol, titolCastella, titolGrup, urlOrigen, validacio, vigent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesOperacions {\n");
    
    sb.append("    cercable: ").append(toIndentedString(cercable)).append("\n");
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
    sb.append("    dadesOperTramitsOvtList: ").append(toIndentedString(dadesOperTramitsOvtList)).append("\n");
    sb.append("    dadesOperacionsValidacio: ").append(toIndentedString(dadesOperacionsValidacio)).append("\n");
    sb.append("    dadesoperEstatsExpList: ").append(toIndentedString(dadesoperEstatsExpList)).append("\n");
    sb.append("    desTipusCamp: ").append(toIndentedString(desTipusCamp)).append("\n");
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
    sb.append("    descripcioCastella: ").append(toIndentedString(descripcioCastella)).append("\n");
    sb.append("    detallValidacio: ").append(toIndentedString(detallValidacio)).append("\n");
    sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
    sb.append("    grup: ").append(toIndentedString(grup)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    itemsList: ").append(toIndentedString(itemsList)).append("\n");
    sb.append("    obligatoriEnEstat: ").append(toIndentedString(obligatoriEnEstat)).append("\n");
    sb.append("    ordre: ").append(toIndentedString(ordre)).append("\n");
    sb.append("    procediment: ").append(toIndentedString(procediment)).append("\n");
    sb.append("    seleccionable: ").append(toIndentedString(seleccionable)).append("\n");
    sb.append("    tipus: ").append(toIndentedString(tipus)).append("\n");
    sb.append("    titol: ").append(toIndentedString(titol)).append("\n");
    sb.append("    titolCastella: ").append(toIndentedString(titolCastella)).append("\n");
    sb.append("    titolGrup: ").append(toIndentedString(titolGrup)).append("\n");
    sb.append("    urlOrigen: ").append(toIndentedString(urlOrigen)).append("\n");
    sb.append("    validacio: ").append(toIndentedString(validacio)).append("\n");
    sb.append("    vigent: ").append(toIndentedString(vigent)).append("\n");
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

