package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.AccioCiutadaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.SollicitudsExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.ConfiguracioDocumentacioRequeridaConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentAportatConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentGeneratConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.ProcedimentsConsultaRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "accionsDisponibles", "dataPresentacio", "dataModificacio", "dataLimitAllegacions", "dataLimitEsmena",
		"unitatGestora", "estat", "estatCastella", "tancamentAutomatic", "historics", "procediment", "registre", "sollicitant", "representant",
		"personesInteressades", "personesImplicades", "documentsAportats", "configuracioDocumentacioRequerida", "documentsGenerats",
		"dadesOperacio", "sollicituds", "pathGestorDocumental", "idGestorDocumental", "idioma" })
@Getter
@Setter
public class ExpedientConsultaRDTO {

	@ApiModelProperty(value = "Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty(value = "Codi de l'expedient")
	private String codi;
	@ApiModelProperty(value = "Accions disponibles", allowableValues = AccioCiutadaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private List<String> accionsDisponibles;
	@ApiModelProperty(value = "Data de presentació de l'expedient")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataPresentacio;
	@ApiModelProperty(value = "Data de l'última modificació de l'expedient")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataModificacio;
	@ApiModelProperty(value = "Data límit per presentar les al·legacions")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataLimitAllegacions;
	@ApiModelProperty(value = "Data límit per presentar els requeriments")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataLimitEsmena;
	@ApiModelProperty(value = "Unitat gestora")
	private UnitatGestoraRDTO unitatGestora;
	@ApiModelProperty(value = "Estat actual del expedient")
	private String estat;
	@ApiModelProperty(value = "Estat actual del expedient en castellà")
	private String estatCastella;
	@ApiModelProperty(value = "És tancament automatic")
	private Boolean tancamentAutomatic;
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
	@ApiModelProperty(value = "Documents aportats a l'expedient agrupats per tràmit")
	private List<DocumentAportatConsultaRDTO> documentsAportats;
	@ApiModelProperty(value = "Documentació requerida per l'expedient")
	private List<ConfiguracioDocumentacioRequeridaConsultaRDTO> configuracioDocumentacioRequerida;
	@ApiModelProperty(value = "Documents generats en l'expedient")
	private List<DocumentGeneratConsultaRDTO> documentsGenerats;
	@ApiModelProperty(value = "Dades d'operació de l'expedient")
	private List<DadesAtributsExpedientsRDTO> dadesOperacio;
	@ApiModelProperty(value = "Atributs requerits per l'expedient")
	private List<DadesAtributsRequeritsRDTO> atributsRequerits;
	@ApiModelProperty(value = "Sol·licituds de l'expedient")
	private List<SollicitudsExpedientRDTO> sollicituds;
	@ApiModelProperty(value = "Path Gestor Documental")
	private String pathGestorDocumental;
	@ApiModelProperty(value = "Id Gestor Documental")
	private String idGestorDocumental;
	@ApiModelProperty(value = "Idioma")
	private String idioma;
	@ApiModelProperty(value = "Rol")
	private String rol;
}
