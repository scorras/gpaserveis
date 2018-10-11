package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="DadesIdentificacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "informacioCiutada",
    "nivellAutenticacio",
    "terminisDuracio"
})
public class DadesIdentificacioRDTO {
	
	@ApiModelProperty(value="Informació complementària per a mostrar al ciutadà")
    private String informacioCiutada;
	@ApiModelProperty(value="Nivell d'autenticació requerit")
    private String nivellAutenticacio;
    private TerminisDuracioRDTO terminisDuracio;
    
    
	public String getInformacioCiutada() {
		return informacioCiutada;
	}
	public void setInformacioCiutada(String informacioCiutada) {
		this.informacioCiutada = informacioCiutada;
	}
	public String getNivellAutenticacio() {
		return nivellAutenticacio;
	}
	public void setNivellAutenticacio(String nivellAutenticacio) {
		this.nivellAutenticacio = nivellAutenticacio;
	}
	public TerminisDuracioRDTO getTerminisDuracio() {
		return terminisDuracio;
	}
	public void setTerminisDuracio(TerminisDuracioRDTO terminisDuracio) {
		this.terminisDuracio = terminisDuracio;
	}
    
}