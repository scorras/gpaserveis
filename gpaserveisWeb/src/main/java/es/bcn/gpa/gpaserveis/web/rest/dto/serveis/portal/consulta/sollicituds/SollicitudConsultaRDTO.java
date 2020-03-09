package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.DataHoraAdapter;
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
        "personesInteressades", "personesImplicades", "documentsAportats", "dadesOperacio", "comentari" })
@XmlRootElement(name = "SOLLICITUD")
@XmlType(name = "SollicitudConsulta", propOrder = { "id", "tramit", "dataSollicitud", "dataPresentacio", "expedient", "registre",
        "sollicitant", "representant", "personesInteressades", "personesImplicades", "documentsAportats", "dadesOperacio", "comentari",
        "hash" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class SollicitudConsultaRDTO {

	@ApiModelProperty(value = "Identificador de la sol·licitud")
	@XmlElement(name = "ID", required = true, type = BigDecimal.class)
	private BigDecimal id;
	@ApiModelProperty(value = "Dades del tràmit")
	@XmlElement(name = "TRAMIT", required = true, type = TramitsOvtRDTO.class)
	private TramitsOvtRDTO tramit;
	@ApiModelProperty(value = "Data de recepció de la sol·licitud")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	@XmlElement(name = "DATA_SOLLICITUD", required = true)
	@XmlJavaTypeAdapter(DataHoraAdapter.class)
	private String dataSollicitud;
	@ApiModelProperty(value = "Data de presentació de la sol·licitud")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	@XmlElement(name = "DATA_PRESENTACIO", required = false)
	@XmlJavaTypeAdapter(DataHoraAdapter.class)
	private String dataPresentacio;
	@ApiModelProperty("Expedient objecte de la sol·licitud")
	@XmlElement(name = "EXPEDIENT", required = true, type = ExpedientAccioRDTO.class)
	private ExpedientAccioRDTO expedient;
	@ApiModelProperty(value = "Registre de la sol·licitud")
	@XmlElement(name = "REGISTRE", required = false, type = RegistreRDTO.class)
	private RegistreRDTO registre;
	@ApiModelProperty(value = "Sol·licitant principal de la sol·licitud")
	@XmlElement(name = "SOLLICITANT", required = true, type = PersonesRDTO.class)
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "Representant principal de la sol·licitud")
	@XmlElement(name = "REPRESENTANT", required = false, type = PersonesRDTO.class)
	private PersonesRDTO representant;
	@ApiModelProperty(value = "Altres persones interessades")
	@XmlElementWrapper(name = "PERSONES_INTERESSADES")
	@XmlElement(name = "PERSONA_INTERESSADA")
	private List<PersonesRDTO> personesInteressades;
	@ApiModelProperty(value = "Persones implicades")
	@XmlElementWrapper(name = "PERSONES_IMPLICADES")
	@XmlElement(name = "PERSONA_IMPLICADA")
	private List<PersonesRDTO> personesImplicades;
	@ApiModelProperty(value = "Documents aportats a la sol·licitud")
	@XmlElementWrapper(name = "DOCUMENTS_APORTATS")
	@XmlElement(name = "DOCUMENT")
	private List<DocumentAportatConsultaRDTO> documentsAportats;
	@ApiModelProperty(value = "Dades d'operació de la sol·licitud")
	@XmlElementWrapper(name = "DADES_OPERACIO")
	@XmlElement(name = "DADA_OPERACIO")
	private List<DadesAtributsSollicitudsRDTO> dadesOperacio;
	@ApiModelProperty(value = "Comentari associat a la sol·licitud")
	@XmlElement(name = "COMENTARI", required = false, type = String.class)
	private String comentari;
	@ApiModelProperty(value = "Hash del xml associat a la sol·licitud")
	@XmlElement(name = "HASH", required = false, type = String.class)
	private String hash;

}
