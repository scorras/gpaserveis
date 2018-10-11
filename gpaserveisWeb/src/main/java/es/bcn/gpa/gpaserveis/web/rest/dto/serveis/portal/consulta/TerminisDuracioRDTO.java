package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="TerminisDuracio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "terminiMaxim",
    "unitat",
    "periodicitat",
    "dataIniciVigencia",
    "dataFiVigencia"
})
public class TerminisDuracioRDTO {
	
	@ApiModelProperty(value="Termini màxim de duració del procediment")
    private String terminiMaxim;
    @ApiModelProperty(value="Unitat de mesura del termini de duració",
    		allowableValues="DIES_HABILS, DIES_NATURALS, MESOS ,ANYS, HORES, INMEDIAT")
    private String unitat;
    @ApiModelProperty(value="Periodicitat del procediment",
    		allowableValues="CONTINU, ESTACIONAL, PUNTUAL, ESPORADIC")
    private String periodicitat;
    @ApiModelProperty(value="Data inici vigència")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dataIniciVigencia;
    @ApiModelProperty(value="Data fi vigència")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dataFiVigencia;
	public String getTerminiMaxim() {
		return terminiMaxim;
	}
	public void setTerminiMaxim(String terminiMaxim) {
		this.terminiMaxim = terminiMaxim;
	}
	public String getUnitat() {
		return unitat;
	}
	public void setUnitat(String unitat) {
		this.unitat = unitat;
	}
	public String getPeriodicitat() {
		return periodicitat;
	}
	public void setPeriodicitat(String periodicitat) {
		this.periodicitat = periodicitat;
	}
	public String getDataIniciVigencia() {
		return dataIniciVigencia;
	}
	public void setDataIniciVigencia(String dataIniciVigencia) {
		this.dataIniciVigencia = dataIniciVigencia;
	}
	public String getDataFiVigencia() {
		return dataFiVigencia;
	}
	public void setDataFiVigencia(String dataFiVigencia) {
		this.dataFiVigencia = dataFiVigencia;
	}
    
}