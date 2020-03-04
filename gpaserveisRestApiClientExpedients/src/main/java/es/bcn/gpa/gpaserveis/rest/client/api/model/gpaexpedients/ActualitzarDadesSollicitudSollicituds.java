/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.18.0
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * ActualitzarDadesSollicitudSollicituds
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-03-03T17:19:08.225+01:00")
public class ActualitzarDadesSollicitudSollicituds {
  @JsonProperty("comentari")
  private String comentari = null;

  @JsonProperty("dadesEspecifiques")
  private List<DadesEspecifiquesRDTO> dadesEspecifiques = null;

  @JsonProperty("sollicitud")
  private SollicitudsRDTO sollicitud = null;

  public ActualitzarDadesSollicitudSollicituds comentari(String comentari) {
    this.comentari = comentari;
    return this;
  }

   /**
   * Comentari associat a l&#39;operació
   * @return comentari
  **/
  @ApiModelProperty(value = "Comentari associat a l'operació")
  public String getComentari() {
    return comentari;
  }

  public void setComentari(String comentari) {
    this.comentari = comentari;
  }

  public ActualitzarDadesSollicitudSollicituds dadesEspecifiques(List<DadesEspecifiquesRDTO> dadesEspecifiques) {
    this.dadesEspecifiques = dadesEspecifiques;
    return this;
  }

  public ActualitzarDadesSollicitudSollicituds addDadesEspecifiquesItem(DadesEspecifiquesRDTO dadesEspecifiquesItem) {
    if (this.dadesEspecifiques == null) {
      this.dadesEspecifiques = new ArrayList<DadesEspecifiquesRDTO>();
    }
    this.dadesEspecifiques.add(dadesEspecifiquesItem);
    return this;
  }

   /**
   * Valors d&#39;atributs de l&#39;expedient
   * @return dadesEspecifiques
  **/
  @ApiModelProperty(value = "Valors d'atributs de l'expedient")
  public List<DadesEspecifiquesRDTO> getDadesEspecifiques() {
    return dadesEspecifiques;
  }

  public void setDadesEspecifiques(List<DadesEspecifiquesRDTO> dadesEspecifiques) {
    this.dadesEspecifiques = dadesEspecifiques;
  }

  public ActualitzarDadesSollicitudSollicituds sollicitud(SollicitudsRDTO sollicitud) {
    this.sollicitud = sollicitud;
    return this;
  }

   /**
   * Dades de la sol·licitud
   * @return sollicitud
  **/
  @ApiModelProperty(value = "Dades de la sol·licitud")
  public SollicitudsRDTO getSollicitud() {
    return sollicitud;
  }

  public void setSollicitud(SollicitudsRDTO sollicitud) {
    this.sollicitud = sollicitud;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActualitzarDadesSollicitudSollicituds actualitzarDadesSollicitudSollicituds = (ActualitzarDadesSollicitudSollicituds) o;
    return Objects.equals(this.comentari, actualitzarDadesSollicitudSollicituds.comentari) &&
        Objects.equals(this.dadesEspecifiques, actualitzarDadesSollicitudSollicituds.dadesEspecifiques) &&
        Objects.equals(this.sollicitud, actualitzarDadesSollicitudSollicituds.sollicitud);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comentari, dadesEspecifiques, sollicitud);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActualitzarDadesSollicitudSollicituds {\n");
    
    sb.append("    comentari: ").append(toIndentedString(comentari)).append("\n");
    sb.append("    dadesEspecifiques: ").append(toIndentedString(dadesEspecifiques)).append("\n");
    sb.append("    sollicitud: ").append(toIndentedString(sollicitud)).append("\n");
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

