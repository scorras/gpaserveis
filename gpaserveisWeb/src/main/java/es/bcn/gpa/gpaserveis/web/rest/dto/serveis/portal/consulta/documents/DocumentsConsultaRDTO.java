package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="DocumentConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "descripcio",
    "descripcioAmpliada",
    "obligatori",
    "repetible",
    "suportConfeccio",
    "suportEnllac"
})
@Getter
@Setter
public class DocumentsConsultaRDTO {
	
	@ApiModelProperty(value="Identificador del document")
	private BigDecimal id;
	@ApiModelProperty(value="Codi del document")
	private String codi;
	@ApiModelProperty(value="Descripci� del document")
	private String descripcio;
	@ApiModelProperty(value="Descripci� ampliada del document")
	private String descripcioAmpliada;
	@ApiModelProperty(value="Obligatori")
	private boolean obligatori;
	@ApiModelProperty(value="Repetible")
	private boolean repetible;
	@ApiModelProperty(value="Suport per a la confecci� del document",
			allowableValues="SENSE_SUPORT, PLANTILLA, GUIA, FORMULARI")
	private String suportConfeccio;
	@ApiModelProperty(value="Enlla� document de suport per a la confecci� del document")
	private String suportEnllac;
	
}
