package es.bcn.gpa.gpaserveis.web.exception;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GPAApiParamValidationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The resultat. */
	private Resultat resultat;

	/** The error principal. */
	private ErrorPrincipal errorPrincipal;

	/** The missatge addicional. */
	private String missatgeAddicional;

	/**
	 * Instantiates a new GPA api param validation exception.
	 *
	 * @param resultat
	 *            the resultat
	 * @param errorPrincipal
	 *            the error principal
	 */
	public GPAApiParamValidationException(Resultat resultat, ErrorPrincipal errorPrincipal) {
		super();
		this.resultat = resultat;
		this.errorPrincipal = errorPrincipal;
	}

	/**
	 * Instantiates a new GPA api param validation exception.
	 *
	 * @param resultat
	 *            the resultat
	 * @param errorPrincipal
	 *            the error principal
	 * @param throwable
	 *            the throwable
	 */
	public GPAApiParamValidationException(Resultat resultat, ErrorPrincipal errorPrincipal, Throwable throwable) {
		super(throwable);
		this.resultat = resultat;
		this.errorPrincipal = errorPrincipal;
	}

	/**
	 * Instantiates a new GPA api param validation exception.
	 *
	 * @param resultat
	 *            the resultat
	 * @param errorPrincipal
	 *            the error principal
	 * @param missatgeAddicional
	 *            the missatge addicional
	 */
	public GPAApiParamValidationException(Resultat resultat, ErrorPrincipal errorPrincipal, String missatgeAddicional) {
		super();
		this.resultat = resultat;
		this.errorPrincipal = errorPrincipal;
		this.missatgeAddicional = missatgeAddicional;
	}

	/**
	 * Instantiates a new GPA api param validation exception.
	 *
	 * @param resultat
	 *            the resultat
	 * @param errorPrincipal
	 *            the error principal
	 * @param missatgeAddicional
	 *            the missatge addicional
	 * @param throwable
	 *            the throwable
	 */
	public GPAApiParamValidationException(Resultat resultat, ErrorPrincipal errorPrincipal, String missatgeAddicional,
	        Throwable throwable) {
		super(throwable);
		this.resultat = resultat;
		this.errorPrincipal = errorPrincipal;
		this.missatgeAddicional = missatgeAddicional;
	}

}
