/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.20.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.UsuariPortaSig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DataSignarDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-03-25T13:12:16.537+01:00")
public class DataSignarDocument {
  @JsonProperty("modalitatSignatura")
  private String modalitatSignatura = null;

  @JsonProperty("usuariPortaSig")
  private UsuariPortaSig usuariPortaSig = null;

  public DataSignarDocument modalitatSignatura(String modalitatSignatura) {
    this.modalitatSignatura = modalitatSignatura;
    return this;
  }

   /**
   * Tipus de signatura
   * @return modalitatSignatura
  **/
  @ApiModelProperty(value = "Tipus de signatura")
  public String getModalitatSignatura() {
    return modalitatSignatura;
  }

  public void setModalitatSignatura(String modalitatSignatura) {
    this.modalitatSignatura = modalitatSignatura;
  }

  public DataSignarDocument usuariPortaSig(UsuariPortaSig usuariPortaSig) {
    this.usuariPortaSig = usuariPortaSig;
    return this;
  }

   /**
   * Usuari que va realitzar l&#39;acció
   * @return usuariPortaSig
  **/
  @ApiModelProperty(value = "Usuari que va realitzar l'acció")
  public UsuariPortaSig getUsuariPortaSig() {
    return usuariPortaSig;
  }

  public void setUsuariPortaSig(UsuariPortaSig usuariPortaSig) {
    this.usuariPortaSig = usuariPortaSig;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataSignarDocument dataSignarDocument = (DataSignarDocument) o;
    return Objects.equals(this.modalitatSignatura, dataSignarDocument.modalitatSignatura) &&
        Objects.equals(this.usuariPortaSig, dataSignarDocument.usuariPortaSig);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modalitatSignatura, usuariPortaSig);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataSignarDocument {\n");
    
    sb.append("    modalitatSignatura: ").append(toIndentedString(modalitatSignatura)).append("\n");
    sb.append("    usuariPortaSig: ").append(toIndentedString(usuariPortaSig)).append("\n");
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
