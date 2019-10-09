/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.15.0
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraBDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * CanviUnitatGestoraMassiuRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-08T13:16:35.843+02:00")
public class CanviUnitatGestoraMassiuRDTO {
  @JsonProperty("canviUnitatGestoraList")
  private List<CanviUnitatGestoraBDTO> canviUnitatGestoraList = null;

  public CanviUnitatGestoraMassiuRDTO canviUnitatGestoraList(List<CanviUnitatGestoraBDTO> canviUnitatGestoraList) {
    this.canviUnitatGestoraList = canviUnitatGestoraList;
    return this;
  }

  public CanviUnitatGestoraMassiuRDTO addCanviUnitatGestoraListItem(CanviUnitatGestoraBDTO canviUnitatGestoraListItem) {
    if (this.canviUnitatGestoraList == null) {
      this.canviUnitatGestoraList = new ArrayList<CanviUnitatGestoraBDTO>();
    }
    this.canviUnitatGestoraList.add(canviUnitatGestoraListItem);
    return this;
  }

   /**
   * Get canviUnitatGestoraList
   * @return canviUnitatGestoraList
  **/
  @ApiModelProperty(value = "")
  public List<CanviUnitatGestoraBDTO> getCanviUnitatGestoraList() {
    return canviUnitatGestoraList;
  }

  public void setCanviUnitatGestoraList(List<CanviUnitatGestoraBDTO> canviUnitatGestoraList) {
    this.canviUnitatGestoraList = canviUnitatGestoraList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CanviUnitatGestoraMassiuRDTO canviUnitatGestoraMassiuRDTO = (CanviUnitatGestoraMassiuRDTO) o;
    return Objects.equals(this.canviUnitatGestoraList, canviUnitatGestoraMassiuRDTO.canviUnitatGestoraList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(canviUnitatGestoraList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CanviUnitatGestoraMassiuRDTO {\n");
    
    sb.append("    canviUnitatGestoraList: ").append(toIndentedString(canviUnitatGestoraList)).append("\n");
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

