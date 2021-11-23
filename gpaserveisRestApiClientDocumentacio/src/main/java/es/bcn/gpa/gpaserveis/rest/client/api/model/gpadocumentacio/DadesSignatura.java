/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 2.11.0
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocsTramPolitiquesSig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * DadesSignatura
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-12T13:43:03.162+01:00")
public class DadesSignatura {
  @JsonProperty("confDocsTramPolitiquesSig")
  private ConfDocsTramPolitiquesSig confDocsTramPolitiquesSig = null;

  @JsonProperty("idDocumentacio")
  private BigDecimal idDocumentacio = null;

  public DadesSignatura confDocsTramPolitiquesSig(ConfDocsTramPolitiquesSig confDocsTramPolitiquesSig) {
    this.confDocsTramPolitiquesSig = confDocsTramPolitiquesSig;
    return this;
  }

   /**
   * Configuracio de modalitat i signatura
   * @return confDocsTramPolitiquesSig
  **/
  @ApiModelProperty(value = "Configuracio de modalitat i signatura")
  public ConfDocsTramPolitiquesSig getConfDocsTramPolitiquesSig() {
    return confDocsTramPolitiquesSig;
  }

  public void setConfDocsTramPolitiquesSig(ConfDocsTramPolitiquesSig confDocsTramPolitiquesSig) {
    this.confDocsTramPolitiquesSig = confDocsTramPolitiquesSig;
  }

  public DadesSignatura idDocumentacio(BigDecimal idDocumentacio) {
    this.idDocumentacio = idDocumentacio;
    return this;
  }

   /**
   * Id Documentacio de l&#39;expedient
   * @return idDocumentacio
  **/
  @ApiModelProperty(value = "Id Documentacio de l'expedient")
  public BigDecimal getIdDocumentacio() {
    return idDocumentacio;
  }

  public void setIdDocumentacio(BigDecimal idDocumentacio) {
    this.idDocumentacio = idDocumentacio;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DadesSignatura dadesSignatura = (DadesSignatura) o;
    return Objects.equals(this.confDocsTramPolitiquesSig, dadesSignatura.confDocsTramPolitiquesSig) &&
        Objects.equals(this.idDocumentacio, dadesSignatura.idDocumentacio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(confDocsTramPolitiquesSig, idDocumentacio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DadesSignatura {\n");
    
    sb.append("    confDocsTramPolitiquesSig: ").append(toIndentedString(confDocsTramPolitiquesSig)).append("\n");
    sb.append("    idDocumentacio: ").append(toIndentedString(idDocumentacio)).append("\n");
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

