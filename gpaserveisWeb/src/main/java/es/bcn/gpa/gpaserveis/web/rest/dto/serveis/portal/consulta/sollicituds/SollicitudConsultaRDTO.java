package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentAportatConsultaRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "SollicitudConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "tramit", "dataSollicitud", "dataPresentacio", "expedient", "registre", "sollicitant", "representant",
        "personesInteressades", "personesImplicades", "documentsAportats", "dadesOperacio", "comentari", "hash" })
@XmlRootElement(name = "sollicitud")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class SollicitudConsultaRDTO {

	@ApiModelProperty(value = "Identificador de la sol·licitud")
	@XmlElement(name = "id")
	private BigDecimal id;
	@ApiModelProperty(value = "Dades del tràmit")
	@XmlElement(name = "tramit")
	private TramitsOvtRDTO tramit;
	@ApiModelProperty(value = "Data de recepció de la sol·licitud")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	@XmlElement(name = "dataSollicitud")
	private String dataSollicitud;
	@ApiModelProperty(value = "Data de presentació de la sol·licitud")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	@XmlElement(name = "dataPresentacio")
	private String dataPresentacio;
	@ApiModelProperty("Expedient objecte de la sol·licitud")
	@XmlElement(name = "expedient")
	private ExpedientAccioRDTO expedient;
	@ApiModelProperty(value = "Registre de la sol·licitud")
	@XmlElement(name = "registre")
	private RegistreRDTO registre;
	@ApiModelProperty(value = "Sol·licitant principal de la sol·licitud")
	@XmlElement(name = "sollicitant")
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "Representant principal de la sol·licitud")
	@XmlElement(name = "representant")
	private PersonesRDTO representant;
	@ApiModelProperty(value = "Altres persones interessades")
	@XmlElementWrapper(name = "personesInteressades")
	@XmlElement(name = "personaInteressada")
	private List<PersonesRDTO> personesInteressades;
	@ApiModelProperty(value = "Persones implicades")
	@XmlElementWrapper(name = "personesImplicades")
	@XmlElement(name = "personaImplicada")
	private List<PersonesRDTO> personesImplicades;
	@ApiModelProperty(value = "Documents aportats a la sol·licitud")
	@XmlElementWrapper(name = "documentsAportats")
	@XmlElement(name = "document")
	private List<DocumentAportatConsultaRDTO> documentsAportats;
	@ApiModelProperty(value = "Dades d'operació de la sol·licitud")
	@XmlElementWrapper(name = "dadesOperacio")
	@XmlElement(name = "dadaOperacio")
	private List<DadesAtributsSollicitudsRDTO> dadesOperacio;
	@ApiModelProperty(value = "Comentari associat a la sol·licitud")
	@XmlElement(name = "comentari")
	private String comentari;
	@ApiModelProperty(value = "Hash del xml associat a la sol·licitud")
	@XmlElement(name = "hash")
	private String hash;

}
