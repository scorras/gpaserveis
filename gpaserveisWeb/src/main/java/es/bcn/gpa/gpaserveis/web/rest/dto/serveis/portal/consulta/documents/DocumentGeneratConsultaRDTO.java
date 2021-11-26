package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.DataHoraAdapter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentGeneratConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "idGestorDocumental", "nom", "configuracioDocumentacio", "dataCreacio", "dataComunicat", "registre", "origen",
		"hash", "codiCSV" })
@XmlRootElement(name = "DOCUMENT")
@XmlType(name = "DocumentGeneratConsulta", propOrder = { "dataComunicat", "registre" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class DocumentGeneratConsultaRDTO extends DocumentRDTO {

	@ApiModelProperty(value = "Data de comunicat del document")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	@XmlElement(name = "DATA_COMUNICAT", required = false)
	@XmlJavaTypeAdapter(DataHoraAdapter.class)
	private String dataComunicat;
	@ApiModelProperty(value = "Registre del document")
	@XmlElement(name = "REGISTRE", required = false, type = RegistreRDTO.class)
	private RegistreRDTO registre;
	@ApiModelProperty(value = "Estat del document")
	@XmlElement(name = "ESTAT", required = false)
	private String estat;

}
