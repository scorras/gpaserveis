package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.math.BigDecimal;

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
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.OrigenApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ConfiguracioDocumentacioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Document")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "idGestorDocumental", "nom", "configuracioDocumentacio", "dataCreacio", "origen", "hash", "codiCSV" })
@XmlRootElement(name = "DOCUMENT")
@XmlType(name = "Document", propOrder = { "id", "idGestorDocumental", "nom", "configuracioDocumentacio", "dataCreacio", "origen", "hash",
		"codiCSV" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class DocumentRDTO {

	@ApiModelProperty(value = "Id del document")
	@XmlElement(name = "ID", required = true, type = BigDecimal.class)
	private BigDecimal id;
	@ApiModelProperty(value = "Id del gestor documental")
	@XmlElement(name = "ID_GESTOR_DOCUMENTAL", required = false, type = String.class)
	private String idGestorDocumental;
	@ApiModelProperty(value = "Nom del document")
	@XmlElement(name = "NOM", required = false, type = String.class)
	private String nom;
	@ApiModelProperty(value = "Categoria a la qual pertany el document")
	@XmlElement(name = "CONFIGURACIO_DOCUMENTACIO", required = true, type = ConfiguracioDocumentacioRDTO.class)
	private ConfiguracioDocumentacioRDTO configuracioDocumentacio;
	@ApiModelProperty(value = "Data de creació del document")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	@XmlElement(name = "DATA_CREACIO", required = false)
	@XmlJavaTypeAdapter(DataHoraAdapter.class)
	private String dataCreacio;
	@ApiModelProperty(value = "Origen del tipus de documentació.", allowableValues = OrigenApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	@XmlElement(name = "ORIGEN", required = true, type = String.class)
	private String origen;
	@ApiModelProperty(value = "Hash del document")
	@XmlElement(name = "HASH", required = false, type = String.class)
	private String hash;
	@ApiModelProperty(value = "Codi CSV del document")
	@XmlElement(name = "CODI_CSV", required = false, type = String.class)
	private String codiCSV;

}
