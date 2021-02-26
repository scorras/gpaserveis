package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.cercar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TramitadorApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientsCercaTramitadorsRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "dataPresentacio", "dataModificacio", "unitatGestora", "procediment", "tramitador", "aplicacioNegoci",
		"estat", "estatCastella", "sollicitant" })
@Getter
@Setter
public class ExpedientsCercaTramitadorsRDTO {

	@ApiModelProperty(value = "Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty(value = "Codi de l'expedient")
	private String codi;
	@ApiModelProperty(value = "Data de presentació de l'expedient (format dd/MM/aaaa HH:mm:ss)")
	private String dataPresentacio;
	@ApiModelProperty(value = "Data de l'última modificació de l'expedient (format dd/MM/aaaa HH:mm:ss)")
	private String dataModificacio;
	@ApiModelProperty(value = "Unitat gestora")
	private UnitatGestoraRDTO unitatGestora;
	@ApiModelProperty(value = "Procediment")
	private ProcedimentsCercaRDTO procediment;
	@ApiModelProperty(value = "Aplicació de tramitació", allowableValues = TramitadorApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tramitador;
	@ApiModelProperty(value = "Nom de l'aplicació, en cas que el tramitador sigui una aplicació de negoci")
	private String aplicacioNegoci;
	@ApiModelProperty(value = "estat actual de l'expedient")
	private String estat;
	@ApiModelProperty(value = "estat actual de l'expedient en castellà")
	private String estatCastella;
	@ApiModelProperty(value = "Sol·licitant de l'expedient")
	private PersonesRDTO sollicitant;
}
