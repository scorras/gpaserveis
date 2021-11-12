/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 2.10.0
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * SignarCriptograficaDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-04T14:21:11.408+01:00")
public class SignarCriptograficaDocument {
  @JsonProperty("idDocuments")
  private List<BigDecimal> idDocuments = null;

  @JsonProperty("idPeticio")
  private String idPeticio = null;

  public SignarCriptograficaDocument idDocuments(List<BigDecimal> idDocuments) {
    this.idDocuments = idDocuments;
    return this;
  }

  public SignarCriptograficaDocument addIdDocumentsItem(BigDecimal idDocumentsItem) {
    if (this.idDocuments == null) {
      this.idDocuments = new ArrayList<BigDecimal>();
    }
    this.idDocuments.add(idDocumentsItem);
    return this;
  }

   /**
   * Llista d&#39;identificadors dels documents signats amb èxit
   * @return idDocuments
  **/
  @ApiModelProperty(value = "Llista d'identificadors dels documents signats amb èxit")
  public List<BigDecimal> getIdDocuments() {
    return idDocuments;
  }

  public void setIdDocuments(List<BigDecimal> idDocuments) {
    this.idDocuments = idDocuments;
  }

  public SignarCriptograficaDocument idPeticio(String idPeticio) {
    this.idPeticio = idPeticio;
    return this;
  }

   /**
   * Identificador de la petició de signatura a MCI Signatures
   * @return idPeticio
  **/
  @ApiModelProperty(value = "Identificador de la petició de signatura a MCI Signatures")
  public String getIdPeticio() {
    return idPeticio;
  }

  public void setIdPeticio(String idPeticio) {
    this.idPeticio = idPeticio;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignarCriptograficaDocument signarCriptograficaDocument = (SignarCriptograficaDocument) o;
    return Objects.equals(this.idDocuments, signarCriptograficaDocument.idDocuments) &&
        Objects.equals(this.idPeticio, signarCriptograficaDocument.idPeticio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idDocuments, idPeticio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignarCriptograficaDocument {\n");
    
    sb.append("    idDocuments: ").append(toIndentedString(idDocuments)).append("\n");
    sb.append("    idPeticio: ").append(toIndentedString(idPeticio)).append("\n");
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

