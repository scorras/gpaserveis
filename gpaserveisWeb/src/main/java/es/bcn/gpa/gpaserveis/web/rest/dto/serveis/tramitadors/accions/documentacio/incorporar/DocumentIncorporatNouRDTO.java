package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.ConfiguracioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.IdiomaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.OrigenApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.RevisioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DigitalitzacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.FitxerRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentIncorporatNou")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "configuracio", "configuracioDocumentacio", "origen", "comentari", "idioma", "revisio", "digitalitzat",
		"digitalitzacio", "fitxer", "numeroRegistre", "publicarInfoPublica", "plantillaPdf" })
@Getter
@Setter
public class DocumentIncorporatNouRDTO {

	@ApiModelProperty(value = "ConfiguraciĆ³ del document.", required = true, allowableValues = ConfiguracioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String configuracio;
	@ApiModelProperty(value = "Codi corresponent a la configuraciĆ³ del document definit a RPA.", required = true)
	private String configuracioDocumentacio;
	@ApiModelProperty(value = "Origen del tipus de documentaciĆ³.", required = true, allowableValues = OrigenApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String origen;
	@ApiModelProperty(value = "Comentari del document.")
	private String comentari;
	@ApiModelProperty(value = "Idioma del document.", allowableValues = IdiomaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String idioma;
	@ApiModelProperty(value = "RevisiĆ³ del document.", allowableValues = RevisioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String revisio;
	@ApiModelProperty(value = "Document digitalitzat.")
	private Boolean digitalitzat;
	@ApiModelProperty(value = "Dades de digitalitzaciĆ³.")
	private DigitalitzacioRDTO digitalitzacio;
	@ApiModelProperty(value = "Fitxer.", required = true)
	private FitxerRDTO fitxer;
	@ApiModelProperty(value = "NĆŗmero de registre.")
	private String numeroRegistre;
	@ApiModelProperty(value = "Publicar informaciĆ³ pĆŗblica.")
	private Boolean publicarInfoPublica;
	@ApiModelProperty(value = "Document de plantilla.")
	private Boolean plantillaPdf;

}
