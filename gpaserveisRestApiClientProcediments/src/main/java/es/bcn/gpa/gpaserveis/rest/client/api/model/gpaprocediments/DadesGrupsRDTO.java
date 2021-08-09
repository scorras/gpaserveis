/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 2.8.0
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsCaractGrups;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * DadesGrupsRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-08-06T14:27:02.303+02:00")
public class DadesGrupsRDTO {
  @JsonProperty("dadesGrupsCaractGrupsList")
  private List<DadesGrupsCaractGrups> dadesGrupsCaractGrupsList = null;

  @JsonProperty("dadesOperacionsList")
  private List<DadesOperacions> dadesOperacionsList = null;

  @JsonProperty("desTipusGrup")
  private String desTipusGrup = null;

  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("descripcioCastella")
  private String descripcioCastella = null;

  @JsonProperty("editable")
  private Boolean editable = null;

  @JsonProperty("grupsOrigen")
  private String grupsOrigen = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("interoperabilitat")
  private Integer interoperabilitat = null;

  @JsonProperty("nomColumnes")
  private Integer nomColumnes = null;

  @JsonProperty("ordre")
  private Integer ordre = null;

  @JsonProperty("pantalla")
  private Integer pantalla = null;

  @JsonProperty("procediment")
  private BigDecimal procediment = null;

  @JsonProperty("repeticions")
  private BigDecimal repeticions = null;

  @JsonProperty("seleccionable")
  private Boolean seleccionable = null;

  @JsonProperty("serveiIdext")
  private BigDecimal serveiIdext = null;

  @JsonProperty("tipusGrup")
  private BigDecimal tipusGrup = null;

  @JsonProperty("titol")
  private String titol = null;

  @JsonProperty("titolCastella")
  private String titolCastella = null;

  @JsonProperty("urlValidacio")
  private String urlValidacio = null;

  @JsonProperty("vigent")
  private Integer vigent = null;

  public DadesGrupsRDTO dadesGrupsCaractGrupsList(List<DadesGrupsCaractGrups> dadesGrupsCaractGrupsList) {
    this.dadesGrupsCaractGrupsList = dadesGrupsCaractGrupsList;
    return this;
  }

  public DadesGrupsRDTO addDadesGrupsCaractGrupsListItem(DadesGrupsCaractGrups dadesGrupsCaractGrupsListItem) {
    if (this.dadesGrupsCaractGrupsList == null) {
      this.dadesGrupsCaractGrupsList = new ArrayList<DadesGrupsCaractGrups>();
    }
    this.dadesGrupsCaractGrupsList.add(dadesGrupsCaractGrupsListItem);
    return this;
  }

   /**
   * Get dadesGrupsCaractGrupsList
   * @return dadesGrupsCaractGrupsList
  **/
  @ApiModelProperty(value = "")
  public List<DadesGrupsCaractGrups> getDadesGrupsCaractGrupsList() {
    return dadesGrupsCaractGrupsList;
  }

  public void setDadesGrupsCaractGrupsList(List<DadesGrupsCaractGrups> dadesGrupsCaractGrupsList) {
    this.dadesGrupsCaractGrupsList = dadesGrupsCaractGrupsList;
  }

  public DadesGrupsRDTO dadesOperacionsList(List<DadesOperacions> dadesOperacionsList) {
    this.dadesOperacionsList = dadesOperacionsList;
    return this;
  }

  public DadesGrupsRDTO addDadesOperacionsListItem(DadesOperacions dadesOperacionsListItem) {
    if (this.dadesOperacionsList == null) {
      this.dadesOperacionsList = new ArrayList<DadesOperacions>();
    }
    this.dadesOperacionsList.add(dadesOperacionsListItem);
    return this;
  }

   /**
   * Get dadesOperacionsList
   * @return dadesOperacionsList
  **/
  @ApiModelProperty(value = "")
  public List<DadesOperacions> getDadesOperacionsList() {
    return dadesOperacionsList;
  }

  public void setDadesOperacionsList(List<DadesOperacions> dadesOperacionsList) {
    this.dadesOperacionsList = dadesOperacionsList;
  }

  public DadesGrupsRDTO desTipusGrup(String desTipusGrup) {
    this.desTipusGrup = desTipusGrup;
    return this;
  }

   /**
   * Get desTipusGrup
   * @return desTipusGrup
  **/
  @ApiModelProperty(value = "")
  public String getDesTipusGrup() {
    return desTipusGrup;
  }

  public void setDesTipusGrup(String desTipusGrup) {
    this.desTipusGrup = desTipusGrup;
  }

  public DadesGrupsRDTO descripcio(String descripcio) {
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

  public DadesGrupsRDTO descripcioCastella(String descripcioCastella) {
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

  public DadesGrupsRDTO editable(Boolean editable) {
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

  public DadesGrupsRDTO grupsOrigen(String grupsOrigen) {
    this.grupsOrigen = grupsOrigen;
    return this;
  }

   /**
   * Get grupsOrigen
   * @return grupsOrigen
  **/
  @ApiModelProperty(value = "")
  public String getGrupsOrigen() {
    return grupsOrigen;
  }

  public void setGrupsOrigen(String grupsOrigen) {
    this.grupsOrigen = grupsOrigen;
  }

  public DadesGrupsRDTO id(BigDecimal id) {
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

  public DadesGrupsRDTO interoperabilitat(Integer interoperabilitat) {
    this.interoperabilitat = interoperabilitat;
    return this;
  }

   /**
   * Get interoperabilitat
   * @return interoperabilitat
  **/
  @ApiModelProperty(value = "")
  public Integer getInteroperabilitat() {
    return interoperabilitat;
  }

  public void setInteroperabilitat(Integer interoperabilitat) {
    this.interoperabilitat = interoperabilitat;
  }

  public DadesGrupsRDTO nomColumnes(Integer nomColumnes) {
    this.nomColumnes = nomColumnes;
    return this;
  }

   /**
   * Get nomColumnes
   * @return nomColumnes
  **/
  @ApiModelProperty(value = "")
  public Integer getNomColumnes() {
    return nomColumnes;
  }

  public void setNomColumnes(Integer nomColumnes) {
    this.nomColumnes = nomColumnes;
  }

  public DadesGrupsRDTO ordre(Integer ordre) {
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

  public DadesGrupsRDTO pantalla(Integer pantalla) {
    this.pantalla = pantalla;
    return this;
  }

   /**
   * Get pantalla
   * @return pantalla
  **/
  @ApiModelProperty(value = "")
  public Integer getPantalla() {
    return pantalla;
  }

  public void setPantalla(Integer pantalla) {
    this.pantalla = pantalla;
  }

  public DadesGrupsRDTO procediment(BigDecimal procediment) {
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

  public DadesGrupsRDTO repeticions(BigDecimal repeticions) {
    this.repeticions = repeticions;
    return this;
  }

   /**
   * Get repeticions
   * @return repeticions
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getRepeticions() {
    return repeticions;
  }

  public void setRepeticions(BigDecimal repeticions) {
    this.repeticions = repeticions;
  }

  public DadesGrupsRDTO seleccionable(Boolean seleccionable) {
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

  public DadesGrupsRDTO serveiIdext(BigDecimal serveiIdext) {
    this.serveiIdext = serveiIdext;
    return this;
  }

   /**
   * Get serveiIdext
   * @return serveiIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getServeiIdext() {
    return serveiIdext;
  }

  public void setServeiIdext(BigDecimal serveiIdext) {
    this.serveiIdext = serveiIdext;
  }

  public DadesGrupsRDTO tipusGrup(BigDecimal tipusGrup) {
    this.tipusGrup = tipusGrup;
    return this;
  }

   /**
   * Get tipusGrup
   * @return tipusGrup
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getTipusGrup() {
    return tipusGrup;
  }

  public void setTipusGrup(BigDecimal tipusGrup) {
    this.tipusGrup = tipusGrup;
  }

  public DadesGrupsRDTO titol(String titol) {
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

  public DadesGrupsRDTO titolCastella(String titolCastella) {
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

  public DadesGrupsRDTO urlValidacio(String urlValidacio) {
    this.urlValidacio = urlValidacio;
    return this;
  }

   /**
   * Get urlValidacio
   * @return urlValidacio
  **/
  @ApiModelProperty(value = "")
  public String getUrlValidacio() {
    return urlValidacio;
  }

  public void setUrlValidacio(String urlValidacio) {
    this.urlValidacio = urlValidacio;
  }

  public DadesGrupsRDTO vigent(Integer vigent) {
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
    DadesGrupsRDTO dadesGrupsRDTO = (DadesGrupsRDTO) o;
    return Objects.equals(this.dadesGrupsCaractGrupsList, dadesGrupsRDTO.dadesGrupsCaractGrupsList) &&
        Objects.equals(this.dadesOperacionsList, dadesGrupsRDTO.dadesOperacionsList) &&
        Objects.equals(this.desTipusGrup, dadesGrupsRDTO.desTipusGrup) &&
        Objects.equals(this.descripcio, dadesGrupsRDTO.descripcio) &&
        Objects.equals(this.descripcioCastella, dadesGrupsRDTO.descripcioCastella) &&
        Objects.equals(this.editable, dadesGrupsRDTO.editable) &&
        Objects.equals(this.grupsOrigen, dadesGrupsRDTO.grupsOrigen) &&
        Objects.equals(this.id, dadesGrupsRDTO.id) &&
        Objects.equals(this.interoperabilitat, dadesGrupsRDTO.interoperabilitat) &&
        Objects.equals(this.nomColumnes, dadesGrupsRDTO.nomColumnes) &&
        Objects.equals(this.ordre, dadesGrupsRDTO.ordre) &&
        Objects.equals(this.pantalla, dadesGrupsRDTO.pantalla) &&
        Objects.equals(this.procediment, dadesGrupsRDTO.procediment) &&
        Objects.equals(this.repeticions, dadesGrupsRDTO.repeticions) &&
        Objects.equals(this.seleccionable, dadesGrupsRDTO.seleccionable) &&
        Objects.equals(this.serveiIdext, dadesGrupsRDTO.serveiIdext) &&
        Objects.equals(this.tipusGrup, dadesGrupsRDTO.tipusGrup) &&
        Objects.equals(this.titol, dadesGrupsRDTO.titol) &&
        Objects.equals(this.titolCastella, dadesGrupsRDTO.titolCastella) &&
        Objects.equals(this.urlValidacio, dadesGrupsRDTO.urlValidacio) &&
        Objects.equals(this.vigent, dadesGrupsRDTO.vigent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dadesGrupsCaractGrupsList, dadesOperacionsList, desTipusGrup, descripcio, descripcioCastella, editable, grupsOrigen, id, interoperabilitat, nomColumnes, ordre, pantalla, procediment, repeticions, seleccionable, serveiIdext, tipusGrup, titol, titolCastella, urlValidacio, vigent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesGrupsRDTO {\n");
    
    sb.append("    dadesGrupsCaractGrupsList: ").append(toIndentedString(dadesGrupsCaractGrupsList)).append("\n");
    sb.append("    dadesOperacionsList: ").append(toIndentedString(dadesOperacionsList)).append("\n");
    sb.append("    desTipusGrup: ").append(toIndentedString(desTipusGrup)).append("\n");
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
    sb.append("    descripcioCastella: ").append(toIndentedString(descripcioCastella)).append("\n");
    sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
    sb.append("    grupsOrigen: ").append(toIndentedString(grupsOrigen)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    interoperabilitat: ").append(toIndentedString(interoperabilitat)).append("\n");
    sb.append("    nomColumnes: ").append(toIndentedString(nomColumnes)).append("\n");
    sb.append("    ordre: ").append(toIndentedString(ordre)).append("\n");
    sb.append("    pantalla: ").append(toIndentedString(pantalla)).append("\n");
    sb.append("    procediment: ").append(toIndentedString(procediment)).append("\n");
    sb.append("    repeticions: ").append(toIndentedString(repeticions)).append("\n");
    sb.append("    seleccionable: ").append(toIndentedString(seleccionable)).append("\n");
    sb.append("    serveiIdext: ").append(toIndentedString(serveiIdext)).append("\n");
    sb.append("    tipusGrup: ").append(toIndentedString(tipusGrup)).append("\n");
    sb.append("    titol: ").append(toIndentedString(titol)).append("\n");
    sb.append("    titolCastella: ").append(toIndentedString(titolCastella)).append("\n");
    sb.append("    urlValidacio: ").append(toIndentedString(urlValidacio)).append("\n");
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

