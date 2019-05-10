package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.GuardarRequerimentExpedient;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class PrepararRequerimentExpedientBDTO.
 */
@Getter
@Setter
public class PrepararRequerimentExpedientBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The guardar requeriment expedient. */
	private GuardarRequerimentExpedient guardarRequerimentExpedient;

}
