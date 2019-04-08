/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.9.1
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AbandonarExpedient
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-08T18:12:02.441+02:00")
public class AbandonarExpedient {
  @JsonProperty("comentari")
  private String comentari = null;

  @JsonProperty("expedient")
  private ExpedientsRDTO expedient = null;

  public AbandonarExpedient comentari(String comentari) {
    this.comentari = comentari;
    return this;
  }

   /**
   * Comentari associat al desistiment o renuncia.
   * @return comentari
  **/
  @ApiModelProperty(value = "Comentari associat al desistiment o renuncia.")
  public String getComentari() {
    return comentari;
  }

  public void setComentari(String comentari) {
    this.comentari = comentari;
  }

  public AbandonarExpedient expedient(ExpedientsRDTO expedient) {
    this.expedient = expedient;
    return this;
  }

   /**
   * Dades de l&#39;expedient
   * @return expedient
  **/
  @ApiModelProperty(value = "Dades de l'expedient")
  public ExpedientsRDTO getExpedient() {
    return expedient;
  }

  public void setExpedient(ExpedientsRDTO expedient) {
    this.expedient = expedient;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbandonarExpedient abandonarExpedient = (AbandonarExpedient) o;
    return Objects.equals(this.comentari, abandonarExpedient.comentari) &&
        Objects.equals(this.expedient, abandonarExpedient.expedient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comentari, expedient);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbandonarExpedient {\n");
    
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
    sb.append("    expedient: ").append(toIndentedString(expedient)).append("\n");
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

