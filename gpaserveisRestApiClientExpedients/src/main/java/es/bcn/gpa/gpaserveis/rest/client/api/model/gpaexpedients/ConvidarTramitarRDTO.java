/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.17.0
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Comentaris;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DropdownItemBDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * ConvidarTramitarRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-02-11T09:54:05.532+01:00")
public class ConvidarTramitarRDTO {
  @JsonProperty("codiUnitatGestoraList")
  private List<DropdownItemBDTO> codiUnitatGestoraList = null;

  @JsonProperty("comentari")
  private Comentaris comentari = null;

  public ConvidarTramitarRDTO codiUnitatGestoraList(List<DropdownItemBDTO> codiUnitatGestoraList) {
    this.codiUnitatGestoraList = codiUnitatGestoraList;
    return this;
  }

  public ConvidarTramitarRDTO addCodiUnitatGestoraListItem(DropdownItemBDTO codiUnitatGestoraListItem) {
    if (this.codiUnitatGestoraList == null) {
      this.codiUnitatGestoraList = new ArrayList<DropdownItemBDTO>();
    }
    this.codiUnitatGestoraList.add(codiUnitatGestoraListItem);
    return this;
  }

   /**
   * Get codiUnitatGestoraList
   * @return codiUnitatGestoraList
  **/
  @ApiModelProperty(value = "")
  public List<DropdownItemBDTO> getCodiUnitatGestoraList() {
    return codiUnitatGestoraList;
  }

  public void setCodiUnitatGestoraList(List<DropdownItemBDTO> codiUnitatGestoraList) {
    this.codiUnitatGestoraList = codiUnitatGestoraList;
  }

  public ConvidarTramitarRDTO comentari(Comentaris comentari) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConvidarTramitarRDTO convidarTramitarRDTO = (ConvidarTramitarRDTO) o;
    return Objects.equals(this.codiUnitatGestoraList, convidarTramitarRDTO.codiUnitatGestoraList) &&
        Objects.equals(this.comentari, convidarTramitarRDTO.comentari);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiUnitatGestoraList, comentari);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConvidarTramitarRDTO {\n");
    
    sb.append("    codiUnitatGestoraList: ").append(toIndentedString(codiUnitatGestoraList)).append("\n");
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
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

