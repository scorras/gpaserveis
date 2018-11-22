package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="ProcedimentCerca")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "descripcio",
    "ugr",
    "ugo",
    "organResolutori",
    "inici",
    "versio",
    "estat"
})
@Getter
@Setter
public class ProcedimentsCercaRDTO {
	
	@ApiModelProperty(value="Identificador del procediment")
	private BigDecimal id;
	@ApiModelProperty(value="Codi del procediment")
	private String codi;
	@ApiModelProperty(value="Descripci� del procediment")
	private String descripcio;
	@ApiModelProperty(value="Unitat gestora responsable")
	private UnitatGestoraRDTO ugr;
	@ApiModelProperty(value="Llista d'unitats gestores operatives")
	private List<UnitatGestoraRDTO> ugo;
	@ApiModelProperty(value="�rgan resolutori")
	private String organResolutori;
	@ApiModelProperty(value="Tipus d'inici del procediment",
		allowableValues="OFICI, SOLICITUD, ADMINISTRACIO, ALTRES")
	private List<String> inici;
	@ApiModelProperty(value="Versi� del procediment")
	private String versio;
	@ApiModelProperty(value="Estat actual del procediment",
			allowableValues="EN_ELABORACIO, PUBLICAT, FINALITZAT")
		private String estat;
	
}
