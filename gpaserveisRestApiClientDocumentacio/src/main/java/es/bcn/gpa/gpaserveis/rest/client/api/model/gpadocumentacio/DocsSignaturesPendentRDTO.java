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
import org.joda.time.DateTime;

/**
 * DocsSignaturesPendentRDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-04T14:21:11.408+01:00")
public class DocsSignaturesPendentRDTO {
  @JsonProperty("dataSignatura")
  private DateTime dataSignatura = null;

  @JsonProperty("modalitatIdext")
  private BigDecimal modalitatIdext = null;

  @JsonProperty("ordre")
  private BigDecimal ordre = null;

  @JsonProperty("politicaSignatura")
  private String politicaSignatura = null;

  @JsonProperty("signat")
  private Integer signat = null;

  @JsonProperty("usuariSignaturaNom")
  private String usuariSignaturaNom = null;

  public DocsSignaturesPendentRDTO dataSignatura(DateTime dataSignatura) {
    this.dataSignatura = dataSignatura;
    return this;
  }

   /**
   * Get dataSignatura
   * @return dataSignatura
  **/
  @ApiModelProperty(value = "")
  public DateTime getDataSignatura() {
    return dataSignatura;
  }

  public void setDataSignatura(DateTime dataSignatura) {
    this.dataSignatura = dataSignatura;
  }

  public DocsSignaturesPendentRDTO modalitatIdext(BigDecimal modalitatIdext) {
    this.modalitatIdext = modalitatIdext;
    return this;
  }

   /**
   * Get modalitatIdext
   * @return modalitatIdext
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getModalitatIdext() {
    return modalitatIdext;
  }

  public void setModalitatIdext(BigDecimal modalitatIdext) {
    this.modalitatIdext = modalitatIdext;
  }

  public DocsSignaturesPendentRDTO ordre(BigDecimal ordre) {
    this.ordre = ordre;
    return this;
  }

   /**
   * Get ordre
   * @return ordre
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getOrdre() {
    return ordre;
  }

  public void setOrdre(BigDecimal ordre) {
    this.ordre = ordre;
  }

  public DocsSignaturesPendentRDTO politicaSignatura(String politicaSignatura) {
    this.politicaSignatura = politicaSignatura;
    return this;
  }

   /**
   * Get politicaSignatura
   * @return politicaSignatura
  **/
  @ApiModelProperty(value = "")
  public String getPoliticaSignatura() {
    return politicaSignatura;
  }

  public void setPoliticaSignatura(String politicaSignatura) {
    this.politicaSignatura = politicaSignatura;
  }

  public DocsSignaturesPendentRDTO signat(Integer signat) {
    this.signat = signat;
    return this;
  }

   /**
   * Get signat
   * @return signat
  **/
  @ApiModelProperty(value = "")
  public Integer getSignat() {
    return signat;
  }

  public void setSignat(Integer signat) {
    this.signat = signat;
  }

  public DocsSignaturesPendentRDTO usuariSignaturaNom(String usuariSignaturaNom) {
    this.usuariSignaturaNom = usuariSignaturaNom;
    return this;
  }

   /**
   * Get usuariSignaturaNom
   * @return usuariSignaturaNom
  **/
  @ApiModelProperty(value = "")
  public String getUsuariSignaturaNom() {
    return usuariSignaturaNom;
  }

  public void setUsuariSignaturaNom(String usuariSignaturaNom) {
    this.usuariSignaturaNom = usuariSignaturaNom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocsSignaturesPendentRDTO docsSignaturesPendentRDTO = (DocsSignaturesPendentRDTO) o;
    return Objects.equals(this.dataSignatura, docsSignaturesPendentRDTO.dataSignatura) &&
        Objects.equals(this.modalitatIdext, docsSignaturesPendentRDTO.modalitatIdext) &&
        Objects.equals(this.ordre, docsSignaturesPendentRDTO.ordre) &&
        Objects.equals(this.politicaSignatura, docsSignaturesPendentRDTO.politicaSignatura) &&
        Objects.equals(this.signat, docsSignaturesPendentRDTO.signat) &&
        Objects.equals(this.usuariSignaturaNom, docsSignaturesPendentRDTO.usuariSignaturaNom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataSignatura, modalitatIdext, ordre, politicaSignatura, signat, usuariSignaturaNom);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocsSignaturesPendentRDTO {\n");
    
    sb.append("    dataSignatura: ").append(toIndentedString(dataSignatura)).append("\n");
    sb.append("    modalitatIdext: ").append(toIndentedString(modalitatIdext)).append("\n");
    sb.append("    ordre: ").append(toIndentedString(ordre)).append("\n");
    sb.append("    politicaSignatura: ").append(toIndentedString(politicaSignatura)).append("\n");
    sb.append("    signat: ").append(toIndentedString(signat)).append("\n");
    sb.append("    usuariSignaturaNom: ").append(toIndentedString(usuariSignaturaNom)).append("\n");
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

