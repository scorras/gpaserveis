package es.bcn.gpa.gpaserveis.business.dto;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespostaResultatBDTO {

	/** The resultat. */
	private Resultat resultat;

	/** The error principal. */
	private ErrorPrincipal errorPrincipal;

}
