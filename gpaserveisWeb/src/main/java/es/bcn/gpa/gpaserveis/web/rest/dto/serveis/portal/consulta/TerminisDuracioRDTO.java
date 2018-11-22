package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="TerminisDuracio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "terminiMaxim",
    "unitat",
    "periodicitat",
    "dataIniciVigencia",
    "dataFiVigencia"
})
@Getter
@Setter
public class TerminisDuracioRDTO {
	
	@ApiModelProperty(value="Termini m�xim de duraci� del procediment")
    private String terminiMaxim;
    @ApiModelProperty(value="Unitat de mesura del termini de duraci�",
    		allowableValues="DIES_HABILS, DIES_NATURALS, MESOS ,ANYS, HORES, INMEDIAT")
    private String unitat;
    @ApiModelProperty(value="Periodicitat del procediment",
    		allowableValues="CONTINU, ESTACIONAL, PUNTUAL, ESPORADIC")
    private String periodicitat;
    @ApiModelProperty(value="Data inici vig�ncia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dataIniciVigencia;
    @ApiModelProperty(value="Data fi vig�ncia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dataFiVigencia;
    
}