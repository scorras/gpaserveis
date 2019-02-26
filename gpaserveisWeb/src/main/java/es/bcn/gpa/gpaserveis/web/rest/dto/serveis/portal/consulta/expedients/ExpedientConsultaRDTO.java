package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.AccioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.EstatCiutadaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.ConfiguracioDocumentacioRequeridaConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentAportatConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.ProcedimentsConsultaRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "accionsDisponibles", "dataPresentacio", "dataModificacio", "unitatGestora", "estat", "historics",
        "procediment", "registre", "sollicitant", "representant", "personesInteressades", "personesImplicades", "documentsAportats",
        "configuracioDocumentacioRequerida", "dadesOperacio" })
@Getter
@Setter
public class ExpedientConsultaRDTO {

	@ApiModelProperty(value = "Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty(value = "Codi de l'expedient")
	private String codi;
	@ApiModelProperty(value = "Data de presentació de l'expedient")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataPresentacio;
	@ApiModelProperty(value = "Data de l'última modificació de l'expedient")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataModificacio;
	@ApiModelProperty(value = "Unitat gestora")
	private UnitatGestoraRDTO unitatGestora;
	@ApiModelProperty(value = "Estat actual del expedient", allowableValues = EstatCiutadaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
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
	@ApiModelProperty(value = "Accions disponibles", allowableValues = AccioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private List<String> accionsDisponibles;
	@ApiModelProperty(value = "Documents aportats a l'expedient agrupats per tràmit")
	private List<DocumentAportatConsultaRDTO> documentsAportats;
	@ApiModelProperty(value = "Documentació requerida per l'expedient")
	private List<ConfiguracioDocumentacioRequeridaConsultaRDTO> configuracioDocumentacioRequerida;
	@ApiModelProperty(value = "Dades d'operació de l'expedient")
	private List<DadesAtributsExpedientsRDTO> dadesOperacio;
}
