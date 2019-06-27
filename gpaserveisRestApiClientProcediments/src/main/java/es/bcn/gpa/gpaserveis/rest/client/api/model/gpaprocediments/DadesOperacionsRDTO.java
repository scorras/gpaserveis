/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 1.12.0
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
 * DadesOperacionsRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-17T14:27:24.410+02:00")
public class DadesOperacionsRDTO {
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

  @JsonProperty("vigent")
  private Integer vigent = null;

  public DadesOperacionsRDTO cercable(Integer cercable) {
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

  public DadesOperacionsRDTO codi(String codi) {
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

  public DadesOperacionsRDTO comentari(String comentari) {
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

  public DadesOperacionsRDTO dadesOperTramitsOvtList(List<DadesOperTramitsOvt> dadesOperTramitsOvtList) {
    this.dadesOperTramitsOvtList = dadesOperTramitsOvtList;
    return this;
  }

  public DadesOperacionsRDTO addDadesOperTramitsOvtListItem(DadesOperTramitsOvt dadesOperTramitsOvtListItem) {
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

  public DadesOperacionsRDTO dadesOperacionsValidacio(List<DadesOperacionsValidacio> dadesOperacionsValidacio) {
    this.dadesOperacionsValidacio = dadesOperacionsValidacio;
    return this;
  }

  public DadesOperacionsRDTO addDadesOperacionsValidacioItem(DadesOperacionsValidacio dadesOperacionsValidacioItem) {
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

  public DadesOperacionsRDTO dadesoperEstatsExpList(List<DadesoperEstatsExp> dadesoperEstatsExpList) {
    this.dadesoperEstatsExpList = dadesoperEstatsExpList;
    return this;
  }

  public DadesOperacionsRDTO addDadesoperEstatsExpListItem(DadesoperEstatsExp dadesoperEstatsExpListItem) {
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

  public DadesOperacionsRDTO desTipusCamp(String desTipusCamp) {
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

  public DadesOperacionsRDTO descripcio(String descripcio) {
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

  public DadesOperacionsRDTO descripcioCastella(String descripcioCastella) {
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

  public DadesOperacionsRDTO editable(Boolean editable) {
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

  public DadesOperacionsRDTO grup(BigDecimal grup) {
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

  public DadesOperacionsRDTO id(BigDecimal id) {
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

  public DadesOperacionsRDTO itemsList(List<Items> itemsList) {
    this.itemsList = itemsList;
    return this;
  }

  public DadesOperacionsRDTO addItemsListItem(Items itemsListItem) {
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

  public DadesOperacionsRDTO obligatoriEnEstat(Boolean obligatoriEnEstat) {
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

  public DadesOperacionsRDTO ordre(Integer ordre) {
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

  public DadesOperacionsRDTO procediment(BigDecimal procediment) {
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

  public DadesOperacionsRDTO seleccionable(Boolean seleccionable) {
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

  public DadesOperacionsRDTO tipus(Integer tipus) {
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

  public DadesOperacionsRDTO titol(String titol) {
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

  public DadesOperacionsRDTO titolCastella(String titolCastella) {
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

  public DadesOperacionsRDTO titolGrup(String titolGrup) {
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

  public DadesOperacionsRDTO urlOrigen(String urlOrigen) {
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

  public DadesOperacionsRDTO vigent(Integer vigent) {
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
    DadesOperacionsRDTO dadesOperacionsRDTO = (DadesOperacionsRDTO) o;
    return Objects.equals(this.cercable, dadesOperacionsRDTO.cercable) &&
        Objects.equals(this.codi, dadesOperacionsRDTO.codi) &&
        Objects.equals(this.comentari, dadesOperacionsRDTO.comentari) &&
        Objects.equals(this.dadesOperTramitsOvtList, dadesOperacionsRDTO.dadesOperTramitsOvtList) &&
        Objects.equals(this.dadesOperacionsValidacio, dadesOperacionsRDTO.dadesOperacionsValidacio) &&
        Objects.equals(this.dadesoperEstatsExpList, dadesOperacionsRDTO.dadesoperEstatsExpList) &&
        Objects.equals(this.desTipusCamp, dadesOperacionsRDTO.desTipusCamp) &&
        Objects.equals(this.descripcio, dadesOperacionsRDTO.descripcio) &&
        Objects.equals(this.descripcioCastella, dadesOperacionsRDTO.descripcioCastella) &&
        Objects.equals(this.editable, dadesOperacionsRDTO.editable) &&
        Objects.equals(this.grup, dadesOperacionsRDTO.grup) &&
        Objects.equals(this.id, dadesOperacionsRDTO.id) &&
        Objects.equals(this.itemsList, dadesOperacionsRDTO.itemsList) &&
        Objects.equals(this.obligatoriEnEstat, dadesOperacionsRDTO.obligatoriEnEstat) &&
        Objects.equals(this.ordre, dadesOperacionsRDTO.ordre) &&
        Objects.equals(this.procediment, dadesOperacionsRDTO.procediment) &&
        Objects.equals(this.seleccionable, dadesOperacionsRDTO.seleccionable) &&
        Objects.equals(this.tipus, dadesOperacionsRDTO.tipus) &&
        Objects.equals(this.titol, dadesOperacionsRDTO.titol) &&
        Objects.equals(this.titolCastella, dadesOperacionsRDTO.titolCastella) &&
        Objects.equals(this.titolGrup, dadesOperacionsRDTO.titolGrup) &&
        Objects.equals(this.urlOrigen, dadesOperacionsRDTO.urlOrigen) &&
        Objects.equals(this.vigent, dadesOperacionsRDTO.vigent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cercable, codi, comentari, dadesOperTramitsOvtList, dadesOperacionsValidacio, dadesoperEstatsExpList, desTipusCamp, descripcio, descripcioCastella, editable, grup, id, itemsList, obligatoriEnEstat, ordre, procediment, seleccionable, tipus, titol, titolCastella, titolGrup, urlOrigen, vigent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesOperacionsRDTO {\n");
    
    sb.append("    cercable: ").append(toIndentedString(cercable)).append("\n");
    sb.append("    codi: ").append(toIndentedString(codi)).append("\n");
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
    sb.append("    dadesOperTramitsOvtList: ").append(toIndentedString(dadesOperTramitsOvtList)).append("\n");
    sb.append("    dadesOperacionsValidacio: ").append(toIndentedString(dadesOperacionsValidacio)).append("\n");
    sb.append("    dadesoperEstatsExpList: ").append(toIndentedString(dadesoperEstatsExpList)).append("\n");
    sb.append("    desTipusCamp: ").append(toIndentedString(desTipusCamp)).append("\n");
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
    sb.append("    descripcioCastella: ").append(toIndentedString(descripcioCastella)).append("\n");
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

