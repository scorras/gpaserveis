package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.FitxerRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="DocumentAportatSubstituir")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configuracioDocumentacio",
    "origen",
    "registrar",
    "comentari",
    "idioma",
    "fitxer"
})
@Getter
@Setter
public class DocumentAportatSubstituirRDTO {
	
	@ApiModelProperty(value = "Codi corresponent a la configuració del document definit a RPA.", required = true)
	private String configuracioDocumentacio;
	@ApiModelProperty(value = "Origen del tipus de documentació.", required = true, allowableValues = "INTERN, EXTERN")
	private String origen;
	@ApiModelProperty(value = "Indicador per registrar el document aportat.", required = true)
	private boolean registrar;
	@ApiModelProperty(value = "Comentari del document.")
	private String comentari;
	@ApiModelProperty(value = "Idioma del document")
	private String idioma;
	@ApiModelProperty(value = "Estat de revisió del document.", allowableValues = "CORRECTE, INCORRECTE, PENDENT")
	private String revisio;
	@ApiModelProperty(value = "Fitxer", required = true)
	private FitxerRDTO fitxer;

}


