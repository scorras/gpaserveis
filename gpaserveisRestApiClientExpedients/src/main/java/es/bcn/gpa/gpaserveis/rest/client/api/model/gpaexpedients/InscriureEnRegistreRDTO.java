/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.12.0
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * InscriureEnRegistreRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-18T17:48:56.871+02:00")
public class InscriureEnRegistreRDTO {
  @JsonProperty("comentari")
  private Comentaris comentari = null;

  @JsonProperty("idExpedientList")
  private List<BigDecimal> idExpedientList = null;

  public InscriureEnRegistreRDTO comentari(Comentaris comentari) {
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

  public InscriureEnRegistreRDTO idExpedientList(List<BigDecimal> idExpedientList) {
    this.idExpedientList = idExpedientList;
    return this;
  }

  public InscriureEnRegistreRDTO addIdExpedientListItem(BigDecimal idExpedientListItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InscriureEnRegistreRDTO inscriureEnRegistreRDTO = (InscriureEnRegistreRDTO) o;
    return Objects.equals(this.comentari, inscriureEnRegistreRDTO.comentari) &&
        Objects.equals(this.idExpedientList, inscriureEnRegistreRDTO.idExpedientList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comentari, idExpedientList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InscriureEnRegistreRDTO {\n");
    
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
    sb.append("    idExpedientList: ").append(toIndentedString(idExpedientList)).append("\n");
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
