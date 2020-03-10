package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.business.xml.bind.adapter.PaisAdapter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusDocumentIdentitatApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentIdentitat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tipusDocument", "numeroDocument", "pais" })
@XmlRootElement(name = "DOCUMENT_INDENTITAT")
@XmlType(name = "DocumentsIdentitat", propOrder = { "tipusDocument", "numeroDocument", "pais" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class DocumentsIdentitatRDTO {

	@ApiModelProperty(value = "Tipus de document d'identitat de la persona", allowableValues = TipusDocumentIdentitatApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = true)
	@XmlElement(name = "TIPUS_DOCUMENT", required = true, type = String.class)
	private String tipusDocument;
	@ApiModelProperty(value = "Número de document d'identitat de la persona", required = true)
	@XmlElement(name = "NUMERO_DOCUMENT", required = true, type = String.class)
	private String numeroDocument;
	@ApiModelProperty(value = "Codi INE del país del document d'identitat de la persona", required = true)
	@XmlElement(name = "PAIS", required = true)
	@XmlJavaTypeAdapter(PaisAdapter.class)
	private String pais;

}