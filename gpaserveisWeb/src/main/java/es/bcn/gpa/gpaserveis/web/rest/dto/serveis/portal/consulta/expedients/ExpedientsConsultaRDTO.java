package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.math.BigDecimal;
import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.EstatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.ProcedimentsConsultaRDTO;

@ApiModel(value = "ExpedientsConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "permetAportacio", "permetEsmena", "permetAlegacio", "dataPresentacio", "dataModificacio",
        "unitatGestora", "estat", "historics", "procediment", "registre", "sollicitant", "representant", "personesInteressades",
        "personesImplicades" })
@Getter
@Setter
public class ExpedientsConsultaRDTO {

	@ApiModelProperty(value = "Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty(value = "Codi de l'expedient")
	private String codi;
	@ApiModelProperty(value = "Indica si l'expedient permet aportar documentació sense requerir")
	private boolean permetAportacio;
	@ApiModelProperty(value = "Indica si l'expedient permet realitzar esmenes")
	private boolean permetEsmena;
	@ApiModelProperty(value = "Indica si l'expedient permet realitzar al·legacions")
	private boolean permetAlegacio;
	@ApiModelProperty(value = "Data de presentació de l'expedient")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataPresentacio;
	@ApiModelProperty(value = "Data de l'última modificació de l'expedient")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataModificacio;
	@ApiModelProperty(value = "Unitat gestora")
	private UnitatGestoraRDTO unitatGestora;
	@ApiModelProperty(value = "Estat actual del expedient", allowableValues = EstatApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String estat;
	@ApiModelProperty(value = "Llista d'històrics de l'expedient")
	private List<HistoricsRDTO> historics;
	@ApiModelProperty(value = "Dades del procediment")
	private ProcedimentsConsultaRDTO procediment;
	@ApiModelProperty(value = "Registre del expedient")
	private RegistreRDTO registre;
	@ApiModelProperty(value = "Sol·licitant principal de l'expedient")
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "Representant principal de l'expedient")
	private PersonesRDTO representant;
	@ApiModelProperty(value = "Altres persones interessades")
	private List<PersonesRDTO> personesInteressades;
	@ApiModelProperty(value = "Persones implicades")
	private List<PersonesRDTO> personesImplicades;

}
