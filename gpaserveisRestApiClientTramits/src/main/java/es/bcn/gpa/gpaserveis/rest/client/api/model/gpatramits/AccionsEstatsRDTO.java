/*
 * API gpatramits
 * API gpatramits
 *
 * OpenAPI spec version: 1.16.2
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * AccionsEstatsRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-18T13:04:17.163+01:00")
public class AccionsEstatsRDTO {
  @JsonProperty("accio")
  private BigDecimal accio = null;

  @JsonProperty("descTransicio")
  private String descTransicio = null;

  @JsonProperty("esEstatFinal")
  private Integer esEstatFinal = null;

  @JsonProperty("esEstatInicial")
  private Integer esEstatInicial = null;

  @JsonProperty("estat")
  private BigDecimal estat = null;

  @JsonProperty("estatCiutada")
  private String estatCiutada = null;

  @JsonProperty("estatCiutadaCastella")
  private String estatCiutadaCastella = null;

  @JsonProperty("estatCiutadaCatala")
  private String estatCiutadaCatala = null;

  @JsonProperty("estatTramitador")
  private String estatTramitador = null;

  @JsonProperty("estatTramitadorCastella")
  private String estatTramitadorCastella = null;

  @JsonProperty("estatTramitadorCatala")
  private String estatTramitadorCatala = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("nomAccio")
  private String nomAccio = null;

  @JsonProperty("transicio")
  private BigDecimal transicio = null;
  
  public AccionsEstatsRDTO accio(BigDecimal accio) {
    this.accio = accio;
    return this;
  }

   /**
   * Get accio
   * @return accio
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getAccio() {
    return accio;
  }

  public void setAccio(BigDecimal accio) {
    this.accio = accio;
  }

  public AccionsEstatsRDTO descTransicio(String descTransicio) {
    this.descTransicio = descTransicio;
    return this;
  }

   /**
   * Get descTransicio
   * @return descTransicio
  **/
  @ApiModelProperty(value = "")
  public String getDescTransicio() {
    return descTransicio;
  }

  public void setDescTransicio(String descTransicio) {
    this.descTransicio = descTransicio;
  }

  public AccionsEstatsRDTO esEstatFinal(Integer esEstatFinal) {
    this.esEstatFinal = esEstatFinal;
    return this;
  }

   /**
   * Get esEstatFinal
   * @return esEstatFinal
  **/
  @ApiModelProperty(value = "")
  public Integer getEsEstatFinal() {
    return esEstatFinal;
  }

  public void setEsEstatFinal(Integer esEstatFinal) {
    this.esEstatFinal = esEstatFinal;
  }

  public AccionsEstatsRDTO esEstatInicial(Integer esEstatInicial) {
    this.esEstatInicial = esEstatInicial;
    return this;
  }

   /**
   * Get esEstatInicial
   * @return esEstatInicial
  **/
  @ApiModelProperty(value = "")
  public Integer getEsEstatInicial() {
    return esEstatInicial;
  }

  public void setEsEstatInicial(Integer esEstatInicial) {
    this.esEstatInicial = esEstatInicial;
  }

  public AccionsEstatsRDTO estat(BigDecimal estat) {
    this.estat = estat;
    return this;
  }

   /**
   * Get estat
   * @return estat
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getEstat() {
    return estat;
  }

  public void setEstat(BigDecimal estat) {
    this.estat = estat;
  }

  public AccionsEstatsRDTO estatCiutada(String estatCiutada) {
    this.estatCiutada = estatCiutada;
    return this;
  }

   /**
   * Get estatCiutada
   * @return estatCiutada
  **/
  @ApiModelProperty(value = "")
  public String getEstatCiutada() {
    return estatCiutada;
  }

  public void setEstatCiutada(String estatCiutada) {
    this.estatCiutada = estatCiutada;
  }

  public AccionsEstatsRDTO estatCiutadaCastella(String estatCiutadaCastella) {
    this.estatCiutadaCastella = estatCiutadaCastella;
    return this;
  }

   /**
   * Get estatCiutadaCastella
   * @return estatCiutadaCastella
  **/
  @ApiModelProperty(value = "")
  public String getEstatCiutadaCastella() {
    return estatCiutadaCastella;
  }

  public void setEstatCiutadaCastella(String estatCiutadaCastella) {
    this.estatCiutadaCastella = estatCiutadaCastella;
  }

  public AccionsEstatsRDTO estatCiutadaCatala(String estatCiutadaCatala) {
    this.estatCiutadaCatala = estatCiutadaCatala;
    return this;
  }

   /**
   * Get estatCiutadaCatala
   * @return estatCiutadaCatala
  **/
  @ApiModelProperty(value = "")
  public String getEstatCiutadaCatala() {
    return estatCiutadaCatala;
  }

  public void setEstatCiutadaCatala(String estatCiutadaCatala) {
    this.estatCiutadaCatala = estatCiutadaCatala;
  }

  public AccionsEstatsRDTO estatTramitador(String estatTramitador) {
    this.estatTramitador = estatTramitador;
    return this;
  }

   /**
   * Get estatTramitador
   * @return estatTramitador
  **/
  @ApiModelProperty(value = "")
  public String getEstatTramitador() {
    return estatTramitador;
  }

  public void setEstatTramitador(String estatTramitador) {
    this.estatTramitador = estatTramitador;
  }

  public AccionsEstatsRDTO estatTramitadorCastella(String estatTramitadorCastella) {
    this.estatTramitadorCastella = estatTramitadorCastella;
    return this;
  }

   /**
   * Get estatTramitadorCastella
   * @return estatTramitadorCastella
  **/
  @ApiModelProperty(value = "")
  public String getEstatTramitadorCastella() {
    return estatTramitadorCastella;
  }

  public void setEstatTramitadorCastella(String estatTramitadorCastella) {
    this.estatTramitadorCastella = estatTramitadorCastella;
  }

  public AccionsEstatsRDTO estatTramitadorCatala(String estatTramitadorCatala) {
    this.estatTramitadorCatala = estatTramitadorCatala;
    return this;
  }

   /**
   * Get estatTramitadorCatala
   * @return estatTramitadorCatala
  **/
  @ApiModelProperty(value = "")
  public String getEstatTramitadorCatala() {
    return estatTramitadorCatala;
  }

  public void setEstatTramitadorCatala(String estatTramitadorCatala) {
    this.estatTramitadorCatala = estatTramitadorCatala;
  }

  public AccionsEstatsRDTO id(BigDecimal id) {
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

  public AccionsEstatsRDTO nomAccio(String nomAccio) {
    this.nomAccio = nomAccio;
    return this;
  }

   /**
   * Get nomAccio
   * @return nomAccio
  **/
  @ApiModelProperty(value = "")
  public String getNomAccio() {
    return nomAccio;
  }

  public void setNomAccio(String nomAccio) {
    this.nomAccio = nomAccio;
  }

  /**
  * Get transicio
  * @return transicio
 **/
 @ApiModelProperty(value = "")
 public BigDecimal getTransicio() {
   return transicio;
 }

 public void setTransicio(BigDecimal transicio) {
   this.transicio = transicio;
 }

  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccionsEstatsRDTO accionsEstatsRDTO = (AccionsEstatsRDTO) o;
    return Objects.equals(this.accio, accionsEstatsRDTO.accio) &&
        Objects.equals(this.descTransicio, accionsEstatsRDTO.descTransicio) &&
        Objects.equals(this.esEstatFinal, accionsEstatsRDTO.esEstatFinal) &&
        Objects.equals(this.esEstatInicial, accionsEstatsRDTO.esEstatInicial) &&
        Objects.equals(this.estat, accionsEstatsRDTO.estat) &&
        Objects.equals(this.estatCiutada, accionsEstatsRDTO.estatCiutada) &&
        Objects.equals(this.estatCiutadaCastella, accionsEstatsRDTO.estatCiutadaCastella) &&
        Objects.equals(this.estatCiutadaCatala, accionsEstatsRDTO.estatCiutadaCatala) &&
        Objects.equals(this.estatTramitador, accionsEstatsRDTO.estatTramitador) &&
        Objects.equals(this.estatTramitadorCastella, accionsEstatsRDTO.estatTramitadorCastella) &&
        Objects.equals(this.estatTramitadorCatala, accionsEstatsRDTO.estatTramitadorCatala) &&
        Objects.equals(this.id, accionsEstatsRDTO.id) &&
        Objects.equals(this.nomAccio, accionsEstatsRDTO.nomAccio) &&
    	Objects.equals(this.transicio, accionsEstatsRDTO.transicio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accio, descTransicio, esEstatFinal, esEstatInicial, estat, estatCiutada, estatCiutadaCastella, estatCiutadaCatala, estatTramitador, estatTramitadorCastella, estatTramitadorCatala, id, nomAccio, transicio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccionsEstatsRDTO {\n");
    
    sb.append("    accio: ").append(toIndentedString(accio)).append("\n");
    sb.append("    descTransicio: ").append(toIndentedString(descTransicio)).append("\n");
    sb.append("    esEstatFinal: ").append(toIndentedString(esEstatFinal)).append("\n");
    sb.append("    esEstatInicial: ").append(toIndentedString(esEstatInicial)).append("\n");
    sb.append("    estat: ").append(toIndentedString(estat)).append("\n");
    sb.append("    estatCiutada: ").append(toIndentedString(estatCiutada)).append("\n");
    sb.append("    estatCiutadaCastella: ").append(toIndentedString(estatCiutadaCastella)).append("\n");
    sb.append("    estatCiutadaCatala: ").append(toIndentedString(estatCiutadaCatala)).append("\n");
    sb.append("    estatTramitador: ").append(toIndentedString(estatTramitador)).append("\n");
    sb.append("    estatTramitadorCastella: ").append(toIndentedString(estatTramitadorCastella)).append("\n");
    sb.append("    estatTramitadorCatala: ").append(toIndentedString(estatTramitadorCatala)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nomAccio: ").append(toIndentedString(nomAccio)).append("\n");
    sb.append("    transicio: ").append(toIndentedString(transicio)).append("\n");
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

