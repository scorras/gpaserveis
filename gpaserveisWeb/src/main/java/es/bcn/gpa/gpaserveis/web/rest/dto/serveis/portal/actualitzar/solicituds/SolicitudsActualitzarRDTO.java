package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="SolicitudActualitzar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codiProcediment",
    "versioProcediment",
    "codiUnitatGestora",
    "inici",
    "solicitant",
    "representant",
    "documents",
    "atributs"
})
@Getter
@Setter
public class SolicitudsActualitzarRDTO {
    
	@ApiModelProperty("Codi del procediment")
	private String codiProcediment;
	@ApiModelProperty("Versió del procediment")
	private String versioProcediment;	
	@ApiModelProperty("Codi de la Unitat Gestora")
	private String codiUnitatGestora;
	@ApiModelProperty(value = "Tipus d'inici de l'expedient",
			allowableValues = "OFICI, SOLICITUD, ADMINISTRACIO, ALTRES")
	private String inici;
	@ApiModelProperty("Persona sol·licitant")
	private PersonesRDTO solicitant;
	@ApiModelProperty("Persona representant")
	private PersonesRDTO representant;
	@ApiModelProperty("Documents")
	private List<DocumentsActualitzarRDTO> documents = Collections.emptyList();
	@ApiModelProperty("Atributs")
	private List<AtributsActualitzarRDTO> atributs = Collections.emptyList();

}


