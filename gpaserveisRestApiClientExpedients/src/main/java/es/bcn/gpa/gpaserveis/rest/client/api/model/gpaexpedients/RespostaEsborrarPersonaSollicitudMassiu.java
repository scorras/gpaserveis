/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 2.10.3
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonaSollicitudEsborrada;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * RespostaEsborrarPersonaSollicitudMassiu
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-08T15:53:07.446+01:00")
public class RespostaEsborrarPersonaSollicitudMassiu {
  @JsonProperty("personaSollicitudEsborradaErrorList")
  private List<PersonaSollicitudEsborrada> personaSollicitudEsborradaErrorList = null;

  @JsonProperty("personaSollicitudEsborradaOKList")
  private List<PersonaSollicitudEsborrada> personaSollicitudEsborradaOKList = null;

  public RespostaEsborrarPersonaSollicitudMassiu personaSollicitudEsborradaErrorList(List<PersonaSollicitudEsborrada> personaSollicitudEsborradaErrorList) {
    this.personaSollicitudEsborradaErrorList = personaSollicitudEsborradaErrorList;
    return this;
  }

  public RespostaEsborrarPersonaSollicitudMassiu addPersonaSollicitudEsborradaErrorListItem(PersonaSollicitudEsborrada personaSollicitudEsborradaErrorListItem) {
    if (this.personaSollicitudEsborradaErrorList == null) {
      this.personaSollicitudEsborradaErrorList = new ArrayList<PersonaSollicitudEsborrada>();
    }
    this.personaSollicitudEsborradaErrorList.add(personaSollicitudEsborradaErrorListItem);
    return this;
  }

   /**
   * Get personaSollicitudEsborradaErrorList
   * @return personaSollicitudEsborradaErrorList
  **/
  @ApiModelProperty(value = "")
  public List<PersonaSollicitudEsborrada> getPersonaSollicitudEsborradaErrorList() {
    return personaSollicitudEsborradaErrorList;
  }

  public void setPersonaSollicitudEsborradaErrorList(List<PersonaSollicitudEsborrada> personaSollicitudEsborradaErrorList) {
    this.personaSollicitudEsborradaErrorList = personaSollicitudEsborradaErrorList;
  }

  public RespostaEsborrarPersonaSollicitudMassiu personaSollicitudEsborradaOKList(List<PersonaSollicitudEsborrada> personaSollicitudEsborradaOKList) {
    this.personaSollicitudEsborradaOKList = personaSollicitudEsborradaOKList;
    return this;
  }

  public RespostaEsborrarPersonaSollicitudMassiu addPersonaSollicitudEsborradaOKListItem(PersonaSollicitudEsborrada personaSollicitudEsborradaOKListItem) {
    if (this.personaSollicitudEsborradaOKList == null) {
      this.personaSollicitudEsborradaOKList = new ArrayList<PersonaSollicitudEsborrada>();
    }
    this.personaSollicitudEsborradaOKList.add(personaSollicitudEsborradaOKListItem);
    return this;
  }

   /**
   * Get personaSollicitudEsborradaOKList
   * @return personaSollicitudEsborradaOKList
  **/
  @ApiModelProperty(value = "")
  public List<PersonaSollicitudEsborrada> getPersonaSollicitudEsborradaOKList() {
    return personaSollicitudEsborradaOKList;
  }

  public void setPersonaSollicitudEsborradaOKList(List<PersonaSollicitudEsborrada> personaSollicitudEsborradaOKList) {
    this.personaSollicitudEsborradaOKList = personaSollicitudEsborradaOKList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespostaEsborrarPersonaSollicitudMassiu respostaEsborrarPersonaSollicitudMassiu = (RespostaEsborrarPersonaSollicitudMassiu) o;
    return Objects.equals(this.personaSollicitudEsborradaErrorList, respostaEsborrarPersonaSollicitudMassiu.personaSollicitudEsborradaErrorList) &&
        Objects.equals(this.personaSollicitudEsborradaOKList, respostaEsborrarPersonaSollicitudMassiu.personaSollicitudEsborradaOKList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personaSollicitudEsborradaErrorList, personaSollicitudEsborradaOKList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespostaEsborrarPersonaSollicitudMassiu {\n");
    
    sb.append("    personaSollicitudEsborradaErrorList: ").append(toIndentedString(personaSollicitudEsborradaErrorList)).append("\n");
    sb.append("    personaSollicitudEsborradaOKList: ").append(toIndentedString(personaSollicitudEsborradaOKList)).append("\n");
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

