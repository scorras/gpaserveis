package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.EstatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.ProcedimentsConsultaRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientsConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "permetAportacio", "permetEsmena", "permetAlegacio", "dataPresentacio", "dataModificacio",
        "unitatGestora", "estat", "historics", "procediment", "registre", "solicitant", "representant", "documents", "atributs" })
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
	private List<HistoricsRDTO> historics = Collections.emptyList();
	private ProcedimentsConsultaRDTO procediment;
	private RegistreRDTO registre;
	private PersonesRDTO solicitant;
	private PersonesRDTO representant;
	// TODO
	// private List<PersonesRDTO> personesImplicats
	// private List<PersonesRDTO> personesInteresats
	private List<DocumentsExpedientsRDTO> documents = Collections.emptyList();
	private List<DadesAtributsExpedientsRDTO> atributs = Collections.emptyList();

}
