package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.NivellAutenticacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.RequereixNotificacioApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DadesIdentificacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "informacioCiutada", "nivellAutenticacio", "endpointSignatura", "endpointAutenticacio", "terminisDuracio",
        "tractamentGdpr", "requereixNotificacio","procedimentsRelationals" })
@Getter
@Setter
public class DadesIdentificacioRDTO {

	@ApiModelProperty(value = "Informació complementària per a mostrar al ciutadà")
	private String informacioCiutada;
	@ApiModelProperty(value = "Nivell d'autenticació requerit", allowableValues = NivellAutenticacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String nivellAutenticacio;
	@ApiModelProperty(value = "Endpoint de signatura")
	private String endpointSignatura;
	@ApiModelProperty(value = "Endpoint d'autenticació")
	private String endpointAutenticacio;
	@ApiModelProperty(value = "Terminis de duració")
	private TerminisDuracioRDTO terminisDuracio;
	@ApiModelProperty(value = "Tractament GDPR")
	private String tractamentGdpr;
	@ApiModelProperty(value = "Requereix Notificacio", allowableValues = RequereixNotificacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String requereixNotificacio;
	@ApiModelProperty(value = "Procediments relationals")
	private List<ProcedimentsRDTO> procedimentsRelationals;

}