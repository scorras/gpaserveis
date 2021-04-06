/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 2.0.0
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.joda.time.DateTime;

/**
 * Comentaris
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-06T10:08:09.016+02:00")
public class Comentaris {
  @JsonProperty("darreraModificacio")
  private DateTime darreraModificacio = null;

  @JsonProperty("dataCreacio")
  private DateTime dataCreacio = null;

  @JsonProperty("descripcio")
  private String descripcio = null;

  @JsonProperty("editable")
  private Boolean editable = null;

  @JsonProperty("eliminat")
  private BigDecimal eliminat = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("procediment")
  private BigDecimal procediment = null;

  @JsonProperty("seleccionable")
  private Boolean seleccionable = null;

  @JsonProperty("titol")
  private String titol = null;

  @JsonProperty("ultimaModificacio")
  private BigDecimal ultimaModificacio = null;

  @JsonProperty("usuari")
  private BigDecimal usuari = null;

  @JsonProperty("usuariNom")
  private String usuariNom = null;

  public Comentaris darreraModificacio(DateTime darreraModificacio) {
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

  public Comentaris dataCreacio(DateTime dataCreacio) {
    this.dataCreacio = dataCreacio;
    return this;
  }

   /**
   * Get dataCreacio
   * @return dataCreacio
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataCreacio() {
    return dataCreacio;
  }

  public void setDataCreacio(DateTime dataCreacio) {
    this.dataCreacio = dataCreacio;
  }

  public Comentaris descripcio(String descripcio) {
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

  public Comentaris editable(Boolean editable) {
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

  public Comentaris eliminat(BigDecimal eliminat) {
    this.eliminat = eliminat;
    return this;
  }

   /**
   * Get eliminat
   * @return eliminat
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getEliminat() {
    return eliminat;
  }

  public void setEliminat(BigDecimal eliminat) {
    this.eliminat = eliminat;
  }

  public Comentaris id(BigDecimal id) {
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

  public Comentaris procediment(BigDecimal procediment) {
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

  public Comentaris seleccionable(Boolean seleccionable) {
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

  public Comentaris titol(String titol) {
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

  public Comentaris ultimaModificacio(BigDecimal ultimaModificacio) {
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

  public Comentaris usuari(BigDecimal usuari) {
    this.usuari = usuari;
    return this;
  }

   /**
   * Get usuari
   * @return usuari
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getUsuari() {
    return usuari;
  }

  public void setUsuari(BigDecimal usuari) {
    this.usuari = usuari;
  }

  public Comentaris usuariNom(String usuariNom) {
    this.usuariNom = usuariNom;
    return this;
  }

   /**
   * Get usuariNom
   * @return usuariNom
  **/
  @ApiModelProperty(value = "")
  public String getUsuariNom() {
    return usuariNom;
  }

  public void setUsuariNom(String usuariNom) {
    this.usuariNom = usuariNom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comentaris comentaris = (Comentaris) o;
    return Objects.equals(this.darreraModificacio, comentaris.darreraModificacio) &&
        Objects.equals(this.dataCreacio, comentaris.dataCreacio) &&
        Objects.equals(this.descripcio, comentaris.descripcio) &&
        Objects.equals(this.editable, comentaris.editable) &&
        Objects.equals(this.eliminat, comentaris.eliminat) &&
        Objects.equals(this.id, comentaris.id) &&
        Objects.equals(this.procediment, comentaris.procediment) &&
        Objects.equals(this.seleccionable, comentaris.seleccionable) &&
        Objects.equals(this.titol, comentaris.titol) &&
        Objects.equals(this.ultimaModificacio, comentaris.ultimaModificacio) &&
        Objects.equals(this.usuari, comentaris.usuari) &&
        Objects.equals(this.usuariNom, comentaris.usuariNom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(darreraModificacio, dataCreacio, descripcio, editable, eliminat, id, procediment, seleccionable, titol, ultimaModificacio, usuari, usuariNom);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Comentaris {\n");
    
    sb.append("    darreraModificacio: ").append(toIndentedString(darreraModificacio)).append("\n");
    sb.append("    dataCreacio: ").append(toIndentedString(dataCreacio)).append("\n");
    sb.append("    descripcio: ").append(toIndentedString(descripcio)).append("\n");
    sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
    sb.append("    eliminat: ").append(toIndentedString(eliminat)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    procediment: ").append(toIndentedString(procediment)).append("\n");
    sb.append("    seleccionable: ").append(toIndentedString(seleccionable)).append("\n");
    sb.append("    titol: ").append(toIndentedString(titol)).append("\n");
    sb.append("    ultimaModificacio: ").append(toIndentedString(ultimaModificacio)).append("\n");
    sb.append("    usuari: ").append(toIndentedString(usuari)).append("\n");
    sb.append("    usuariNom: ").append(toIndentedString(usuariNom)).append("\n");
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

