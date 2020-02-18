package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.OrigenApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.RevisioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ConfiguracioDocumentacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentAportatConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "idGestorDocumental", "nom", "configuracioDocumentacio", "dataPresentacio", "registre", "revisio", "tramit" })
@XmlRootElement(name = "document")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class DocumentAportatConsultaRDTO extends DocumentRDTO {

	@ApiModelProperty(value = "Categoria a la qual pertany el document")
	@XmlElement(name = "configuracioDocumentacio")
	private ConfiguracioDocumentacioRDTO configuracioDocumentacio;
	@ApiModelProperty(value = "Data de presentaciódel document")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	@XmlElement(name = "dataPresentacio")
	private String dataPresentacio;
	@ApiModelProperty(value = "Registre del document")
	@XmlElement(name = "registre")
	private RegistreRDTO registre;
	@ApiModelProperty(value = "Estat de revisió del document", allowableValues = RevisioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	@XmlElement(name = "revisio")
	private String revisio;
	@ApiModelProperty(value = "Origen del tipus de documentació.", allowableValues = OrigenApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	@XmlElement(name = "origen")
	private String origen;
	@ApiModelProperty(value = "Tràmit")
	@XmlElement(name = "tramit")
	private TramitsOvtRDTO tramit;

}
