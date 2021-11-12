/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 2.10.1
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
import org.joda.time.DateTime;

/**
 * CapcaleraProcediment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-08T16:49:56.830+01:00")
public class CapcaleraProcediment {
  @JsonProperty("darreraModificacio")
  private DateTime darreraModificacio = null;

  public CapcaleraProcediment darreraModificacio(DateTime darreraModificacio) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CapcaleraProcediment capcaleraProcediment = (CapcaleraProcediment) o;
    return Objects.equals(this.darreraModificacio, capcaleraProcediment.darreraModificacio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(darreraModificacio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CapcaleraProcediment {\n");
    
    sb.append("    darreraModificacio: ").append(toIndentedString(darreraModificacio)).append("\n");
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

