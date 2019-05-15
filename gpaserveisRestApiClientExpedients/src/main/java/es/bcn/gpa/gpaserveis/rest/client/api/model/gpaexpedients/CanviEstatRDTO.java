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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AccionsEstatsBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Comentaris;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DropdownItemBDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * CanviEstatRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-14T18:24:51.718+02:00")
public class CanviEstatRDTO {
  @JsonProperty("canviUnitatGestora")
  private CanviUnitatGestoraBDTO canviUnitatGestora = null;

  @JsonProperty("comentari")
  private Comentaris comentari = null;

  @JsonProperty("convidarTramitar")
  private ConvidarTramitarBDTO convidarTramitar = null;

  @JsonProperty("estatActual")
  private DropdownItemBDTO estatActual = null;

  @JsonProperty("estatAnterior")
  private DropdownItemBDTO estatAnterior = null;

  @JsonProperty("estatFuturo")
  private DropdownItemBDTO estatFuturo = null;

  @JsonProperty("idExpedientsList")
  private List<BigDecimal> idExpedientsList = null;

  @JsonProperty("respostaAllegacion")
  private BigDecimal respostaAllegacion = null;

  @JsonProperty("respostaRequeriment")
  private BigDecimal respostaRequeriment = null;

  @JsonProperty("transicionsPosibles")
  private List<AccionsEstatsBDTO> transicionsPosibles = null;

  public CanviEstatRDTO canviUnitatGestora(CanviUnitatGestoraBDTO canviUnitatGestora) {
    this.canviUnitatGestora = canviUnitatGestora;
    return this;
  }

   /**
   * Get canviUnitatGestora
   * @return canviUnitatGestora
  **/
  @ApiModelProperty(value = "")
  public CanviUnitatGestoraBDTO getCanviUnitatGestora() {
    return canviUnitatGestora;
  }

  public void setCanviUnitatGestora(CanviUnitatGestoraBDTO canviUnitatGestora) {
    this.canviUnitatGestora = canviUnitatGestora;
  }

  public CanviEstatRDTO comentari(Comentaris comentari) {
    this.comentari = comentari;
    return this;
  }

   /**
   * Get comentari
   * @return comentari
  **/
  @ApiModelProperty(value = "")
  public Comentaris getComentari() {
    return comentari;
  }

  public void setComentari(Comentaris comentari) {
    this.comentari = comentari;
  }

  public CanviEstatRDTO convidarTramitar(ConvidarTramitarBDTO convidarTramitar) {
    this.convidarTramitar = convidarTramitar;
    return this;
  }

   /**
   * Get convidarTramitar
   * @return convidarTramitar
  **/
  @ApiModelProperty(value = "")
  public ConvidarTramitarBDTO getConvidarTramitar() {
    return convidarTramitar;
  }

  public void setConvidarTramitar(ConvidarTramitarBDTO convidarTramitar) {
    this.convidarTramitar = convidarTramitar;
  }

  public CanviEstatRDTO estatActual(DropdownItemBDTO estatActual) {
    this.estatActual = estatActual;
    return this;
  }

   /**
   * Get estatActual
   * @return estatActual
  **/
  @ApiModelProperty(value = "")
  public DropdownItemBDTO getEstatActual() {
    return estatActual;
  }

  public void setEstatActual(DropdownItemBDTO estatActual) {
    this.estatActual = estatActual;
  }

  public CanviEstatRDTO estatAnterior(DropdownItemBDTO estatAnterior) {
    this.estatAnterior = estatAnterior;
    return this;
  }

   /**
   * Get estatAnterior
   * @return estatAnterior
  **/
  @ApiModelProperty(value = "")
  public DropdownItemBDTO getEstatAnterior() {
    return estatAnterior;
  }

  public void setEstatAnterior(DropdownItemBDTO estatAnterior) {
    this.estatAnterior = estatAnterior;
  }

  public CanviEstatRDTO estatFuturo(DropdownItemBDTO estatFuturo) {
    this.estatFuturo = estatFuturo;
    return this;
  }

   /**
   * Get estatFuturo
   * @return estatFuturo
  **/
  @ApiModelProperty(value = "")
  public DropdownItemBDTO getEstatFuturo() {
    return estatFuturo;
  }

  public void setEstatFuturo(DropdownItemBDTO estatFuturo) {
    this.estatFuturo = estatFuturo;
  }

  public CanviEstatRDTO idExpedientsList(List<BigDecimal> idExpedientsList) {
    this.idExpedientsList = idExpedientsList;
    return this;
  }

  public CanviEstatRDTO addIdExpedientsListItem(BigDecimal idExpedientsListItem) {
    if (this.idExpedientsList == null) {
      this.idExpedientsList = new ArrayList<BigDecimal>();
    }
    this.idExpedientsList.add(idExpedientsListItem);
    return this;
  }

   /**
   * Get idExpedientsList
   * @return idExpedientsList
  **/
  @ApiModelProperty(value = "")
  public List<BigDecimal> getIdExpedientsList() {
    return idExpedientsList;
  }

  public void setIdExpedientsList(List<BigDecimal> idExpedientsList) {
    this.idExpedientsList = idExpedientsList;
  }

  public CanviEstatRDTO respostaAllegacion(BigDecimal respostaAllegacion) {
    this.respostaAllegacion = respostaAllegacion;
    return this;
  }

   /**
   * Get respostaAllegacion
   * @return respostaAllegacion
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getRespostaAllegacion() {
    return respostaAllegacion;
  }

  public void setRespostaAllegacion(BigDecimal respostaAllegacion) {
    this.respostaAllegacion = respostaAllegacion;
  }

  public CanviEstatRDTO respostaRequeriment(BigDecimal respostaRequeriment) {
    this.respostaRequeriment = respostaRequeriment;
    return this;
  }

   /**
   * Get respostaRequeriment
   * @return respostaRequeriment
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getRespostaRequeriment() {
    return respostaRequeriment;
  }

  public void setRespostaRequeriment(BigDecimal respostaRequeriment) {
    this.respostaRequeriment = respostaRequeriment;
  }

  public CanviEstatRDTO transicionsPosibles(List<AccionsEstatsBDTO> transicionsPosibles) {
    this.transicionsPosibles = transicionsPosibles;
    return this;
  }

  public CanviEstatRDTO addTransicionsPosiblesItem(AccionsEstatsBDTO transicionsPosiblesItem) {
    if (this.transicionsPosibles == null) {
      this.transicionsPosibles = new ArrayList<AccionsEstatsBDTO>();
    }
    this.transicionsPosibles.add(transicionsPosiblesItem);
    return this;
  }

   /**
   * Get transicionsPosibles
   * @return transicionsPosibles
  **/
  @ApiModelProperty(value = "")
  public List<AccionsEstatsBDTO> getTransicionsPosibles() {
    return transicionsPosibles;
  }

  public void setTransicionsPosibles(List<AccionsEstatsBDTO> transicionsPosibles) {
    this.transicionsPosibles = transicionsPosibles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CanviEstatRDTO canviEstatRDTO = (CanviEstatRDTO) o;
    return Objects.equals(this.canviUnitatGestora, canviEstatRDTO.canviUnitatGestora) &&
        Objects.equals(this.comentari, canviEstatRDTO.comentari) &&
        Objects.equals(this.convidarTramitar, canviEstatRDTO.convidarTramitar) &&
        Objects.equals(this.estatActual, canviEstatRDTO.estatActual) &&
        Objects.equals(this.estatAnterior, canviEstatRDTO.estatAnterior) &&
        Objects.equals(this.estatFuturo, canviEstatRDTO.estatFuturo) &&
        Objects.equals(this.idExpedientsList, canviEstatRDTO.idExpedientsList) &&
        Objects.equals(this.respostaAllegacion, canviEstatRDTO.respostaAllegacion) &&
        Objects.equals(this.respostaRequeriment, canviEstatRDTO.respostaRequeriment) &&
        Objects.equals(this.transicionsPosibles, canviEstatRDTO.transicionsPosibles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(canviUnitatGestora, comentari, convidarTramitar, estatActual, estatAnterior, estatFuturo, idExpedientsList, respostaAllegacion, respostaRequeriment, transicionsPosibles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CanviEstatRDTO {\n");
    
    sb.append("    canviUnitatGestora: ").append(toIndentedString(canviUnitatGestora)).append("\n");
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
    sb.append("    convidarTramitar: ").append(toIndentedString(convidarTramitar)).append("\n");
    sb.append("    estatActual: ").append(toIndentedString(estatActual)).append("\n");
    sb.append("    estatAnterior: ").append(toIndentedString(estatAnterior)).append("\n");
    sb.append("    estatFuturo: ").append(toIndentedString(estatFuturo)).append("\n");
    sb.append("    idExpedientsList: ").append(toIndentedString(idExpedientsList)).append("\n");
    sb.append("    respostaAllegacion: ").append(toIndentedString(respostaAllegacion)).append("\n");
    sb.append("    respostaRequeriment: ").append(toIndentedString(respostaRequeriment)).append("\n");
    sb.append("    transicionsPosibles: ").append(toIndentedString(transicionsPosibles)).append("\n");
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

