package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


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

	public String getCodiProcediment() {
		return codiProcediment;
	}
	public void setCodiProcediment(String codiProcediment) {
		this.codiProcediment = codiProcediment;
	}
	public String getVersioProcediment() {
		return versioProcediment;
	}
	public void setVersioProcediment(String versioProcediment) {
		this.versioProcediment = versioProcediment;
	}
	public String getCodiUnitatGestora() {
		return codiUnitatGestora;
	}
	public void setCodiUnitatGestora(String codiUnitatGestora) {
		this.codiUnitatGestora = codiUnitatGestora;
	}
	public String getInici() {
		return inici;
	}
	public void setInici(String inici) {
		this.inici = inici;
	}
	public PersonesRDTO getSolicitant() {
		return solicitant;
	}
	public void setSolicitant(PersonesRDTO solicitant) {
		this.solicitant = solicitant;
	}
	public PersonesRDTO getRepresentant() {
		return representant;
	}
	public void setRepresentant(PersonesRDTO representant) {
		this.representant = representant;
	}
	public List<DocumentsActualitzarRDTO> getDocuments() {
		return documents;
	}
	public void setDocuments(List<DocumentsActualitzarRDTO> documents) {
		this.documents = documents;
	}
	public List<AtributsActualitzarRDTO> getAtributs() {
		return atributs;
	}
	public void setAtributs(List<AtributsActualitzarRDTO> atributs) {
		this.atributs = atributs;
	}	
	
}


