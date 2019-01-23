package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.EstatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.IniciacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.DadesIdentificacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ProcedimentConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "nom", "descripcio", "ugr", "ugo", "organResolutori", "inici", "versio", "estat", "tramits",
        "dadesIdentificacio" })
@Getter
@Setter
public class ProcedimentsConsultaRDTO {

	@ApiModelProperty(value = "Identificador del procediment")
	private BigDecimal id;
	@ApiModelProperty(value = "Codi del procediment")
	private String codi;
	@ApiModelProperty(value = "Nom del procediment")
	private String nom;
	@ApiModelProperty(value = "Descripció del procediment")
	private String descripcio;
	@ApiModelProperty(value = "Unitat gestora responsable")
	private UnitatGestoraRDTO ugr;
	@ApiModelProperty(value = "Llista d'unitats gestores operatives")
	private List<UnitatGestoraRDTO> ugo;
	@ApiModelProperty(value = "Òrgan resolutori")
	private String organResolutori;
	@ApiModelProperty(value = "Tipus d'inici del procediment", allowableValues = IniciacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private List<String> inici;
	@ApiModelProperty(value = "Versió del procediment")
	private String versio;
	@ApiModelProperty(value = "Estat actual del procediment", allowableValues = EstatApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String estat;
	@ApiModelProperty(value = "Llista de tràmits del procediment")
	private List<TramitsRDTO> tramits;
	@ApiModelProperty(value = "Dades d'identificació del procediment")
	private DadesIdentificacioRDTO dadesIdentificacio;

}
