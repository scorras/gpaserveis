package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusViaNotificacioApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DadesContacteNotificacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "email", "telefon", "mobil", "tipusVia", "nomVia", "numero", "bloc", "porta", "pis", "codiPostal", "municipi",
        "provincia", "viaNotificacio" })
@Getter
@Setter
public class DadesContacteNotificacioRDTO {

	@ApiModelProperty(value = "Email de la persona", required = true)
	private String email;
	@ApiModelProperty(value = "Telèfon fixe de la persona", required = true)
	private String telefon;
	@ApiModelProperty(value = "Telèfon mobil de la persona", required = true)
	private String mobil;

	@ApiModelProperty(value = "nom del tipus de via")
	private String tipusVia;
	@ApiModelProperty(value = "Nom de la via")
	private String nomVia;
	@ApiModelProperty(value = "Número")
	private String numero;
	@ApiModelProperty(value = "Bloc")
	private String bloc;
	@ApiModelProperty(value = "Porta")
	private String porta;
	@ApiModelProperty(value = "Pis")
	private String pis;

	@ApiModelProperty(value = "Codi Postal")
	private String codiPostal;
	@ApiModelProperty(value = "Nom del Municipi")
	private String municipi;
	@ApiModelProperty(value = "Nom de la Província")
	private String provincia;

	@ApiModelProperty(value = "Via de notificació a la persona", allowableValues = TipusViaNotificacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = true)
	private String viaNotificacio;

}