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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DropdownItemBDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * RetornarLaTramitacioRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-14T18:24:51.718+02:00")
public class RetornarLaTramitacioRDTO {
  @JsonProperty("idExpedientList")
  private List<BigDecimal> idExpedientList = null;

  @JsonProperty("unitatGestoraConvidada")
  private DropdownItemBDTO unitatGestoraConvidada = null;

  public RetornarLaTramitacioRDTO idExpedientList(List<BigDecimal> idExpedientList) {
    this.idExpedientList = idExpedientList;
    return this;
  }

  public RetornarLaTramitacioRDTO addIdExpedientListItem(BigDecimal idExpedientListItem) {
    if (this.idExpedientList == null) {
      this.idExpedientList = new ArrayList<BigDecimal>();
    }
    this.idExpedientList.add(idExpedientListItem);
    return this;
  }

   /**
   * Get idExpedientList
   * @return idExpedientList
  **/
  @ApiModelProperty(value = "")
  public List<BigDecimal> getIdExpedientList() {
    return idExpedientList;
  }

  public void setIdExpedientList(List<BigDecimal> idExpedientList) {
    this.idExpedientList = idExpedientList;
  }

  public RetornarLaTramitacioRDTO unitatGestoraConvidada(DropdownItemBDTO unitatGestoraConvidada) {
    this.unitatGestoraConvidada = unitatGestoraConvidada;
    return this;
  }

   /**
   * Get unitatGestoraConvidada
   * @return unitatGestoraConvidada
  **/
  @ApiModelProperty(value = "")
  public DropdownItemBDTO getUnitatGestoraConvidada() {
    return unitatGestoraConvidada;
  }

  public void setUnitatGestoraConvidada(DropdownItemBDTO unitatGestoraConvidada) {
    this.unitatGestoraConvidada = unitatGestoraConvidada;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RetornarLaTramitacioRDTO retornarLaTramitacioRDTO = (RetornarLaTramitacioRDTO) o;
    return Objects.equals(this.idExpedientList, retornarLaTramitacioRDTO.idExpedientList) &&
        Objects.equals(this.unitatGestoraConvidada, retornarLaTramitacioRDTO.unitatGestoraConvidada);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idExpedientList, unitatGestoraConvidada);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetornarLaTramitacioRDTO {\n");
    
    sb.append("    idExpedientList: ").append(toIndentedString(idExpedientList)).append("\n");
    sb.append("    unitatGestoraConvidada: ").append(toIndentedString(unitatGestoraConvidada)).append("\n");
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

