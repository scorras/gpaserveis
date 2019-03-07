package es.bcn.gpa.gpaserveis.business.dto;

import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaResultatBDTO {

	/** The resultat. */
	private Resultat resultat;

	/** The error principal. */
	private ErrorPrincipal errorPrincipal;

	/** The missatge addicional. */
	private String missatgeAddicional;

	/**
	 * Instantiates a new resposta resultat BDTO.
	 *
	 * @param resultat
	 *            the resultat
	 */
	public RespostaResultatBDTO(Resultat resultat) {
		super();
		this.resultat = resultat;
	}

	/**
	 * Instantiates a new resposta resultat BDTO.
	 *
	 * @param resultat
	 *            the resultat
	 * @param errorPrincipal
	 *            the error principal
	 */
	public RespostaResultatBDTO(Resultat resultat, ErrorPrincipal errorPrincipal) {
		super();
		this.resultat = resultat;
		this.errorPrincipal = errorPrincipal;
	}

	/**
	 * Instantiates a new resposta resultat BDTO.
	 *
	 * @param resultat
	 *            the resultat
	 * @param errorPrincipal
	 *            the error principal
	 * @param missatgeAddicional
	 *            the missatge addicional
	 */
	public RespostaResultatBDTO(Resultat resultat, ErrorPrincipal errorPrincipal, String missatgeAddicional) {
		super();
		this.resultat = resultat;
		this.errorPrincipal = errorPrincipal;
		this.missatgeAddicional = missatgeAddicional;
	}

	/**
	 * Instantiates a new resposta resultat BDTO.
	 *
	 * @param gpaApiParamValidationException
	 *            the gpa api param validation exception
	 */
	public RespostaResultatBDTO(GPAApiParamValidationException gpaApiParamValidationException) {
		super();
		this.resultat = gpaApiParamValidationException.getResultat();
		this.errorPrincipal = gpaApiParamValidationException.getErrorPrincipal();
		this.missatgeAddicional = gpaApiParamValidationException.getMissatgeAddicional();
	}
}
