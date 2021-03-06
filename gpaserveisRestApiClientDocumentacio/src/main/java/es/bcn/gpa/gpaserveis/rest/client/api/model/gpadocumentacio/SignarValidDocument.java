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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * SignarValidDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-24T17:42:42.347+01:00")
public class SignarValidDocument {
  @JsonProperty("documents")
  private List<BigDecimal> documents = null;

  @JsonProperty("informacioToken")
  private String informacioToken = null;

  @JsonProperty("politicaSignatura")
  private String politicaSignatura = null;

  @JsonProperty("valorToken")
  private String valorToken = null;

  public SignarValidDocument documents(List<BigDecimal> documents) {
    this.documents = documents;
    return this;
  }

  public SignarValidDocument addDocumentsItem(BigDecimal documentsItem) {
    if (this.documents == null) {
      this.documents = new ArrayList<BigDecimal>();
    }
    this.documents.add(documentsItem);
    return this;
  }

   /**
   * Identificadors dels documents
   * @return documents
  **/
  @ApiModelProperty(value = "Identificadors dels documents")
  public List<BigDecimal> getDocuments() {
    return documents;
  }

  public void setDocuments(List<BigDecimal> documents) {
    this.documents = documents;
  }

  public SignarValidDocument informacioToken(String informacioToken) {
    this.informacioToken = informacioToken;
    return this;
  }

   /**
   * InformaciĆ³ de token
   * @return informacioToken
  **/
  @ApiModelProperty(value = "InformaciĆ³ de token")
  public String getInformacioToken() {
    return informacioToken;
  }

  public void setInformacioToken(String informacioToken) {
    this.informacioToken = informacioToken;
  }

  public SignarValidDocument politicaSignatura(String politicaSignatura) {
    this.politicaSignatura = politicaSignatura;
    return this;
  }

   /**
   * Nom de la polĆ­tica de signatura
   * @return politicaSignatura
  **/
  @ApiModelProperty(value = "Nom de la polĆ­tica de signatura")
  public String getPoliticaSignatura() {
    return politicaSignatura;
  }

  public void setPoliticaSignatura(String politicaSignatura) {
    this.politicaSignatura = politicaSignatura;
  }

  public SignarValidDocument valorToken(String valorToken) {
    this.valorToken = valorToken;
    return this;
  }

   /**
   * Valor de token
   * @return valorToken
  **/
  @ApiModelProperty(value = "Valor de token")
  public String getValorToken() {
    return valorToken;
  }

  public void setValorToken(String valorToken) {
    this.valorToken = valorToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignarValidDocument signarValidDocument = (SignarValidDocument) o;
    return Objects.equals(this.documents, signarValidDocument.documents) &&
        Objects.equals(this.informacioToken, signarValidDocument.informacioToken) &&
        Objects.equals(this.politicaSignatura, signarValidDocument.politicaSignatura) &&
        Objects.equals(this.valorToken, signarValidDocument.valorToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documents, informacioToken, politicaSignatura, valorToken);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignarValidDocument {\n");
    
    sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
    sb.append("    informacioToken: ").append(toIndentedString(informacioToken)).append("\n");
    sb.append("    politicaSignatura: ").append(toIndentedString(politicaSignatura)).append("\n");
    sb.append("    valorToken: ").append(toIndentedString(valorToken)).append("\n");
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

