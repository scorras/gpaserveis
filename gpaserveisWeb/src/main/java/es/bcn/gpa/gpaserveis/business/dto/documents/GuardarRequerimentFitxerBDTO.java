package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.GuardarRequerimentExpedient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GuardarRequerimentFitxerBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The guardar requeriment expedient. */
	private GuardarRequerimentExpedient guardarRequerimentExpedient;

	/** The file. */
	private MultipartFile file;

}
