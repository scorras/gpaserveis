package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.ApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.FamiliaApiParamValue;

/**
 * The Class FamiliaApiParamValueConverter.
 */
@SuppressWarnings("unchecked")
@Component
@Qualifier("familiaApiParamValueConverter")
public class FamiliaApiParamValueConverter extends ApiParamValueConverter<FamiliaApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "familia";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "ATENCIO_SOCIAL_I_RESIDENCIAL, AUTORITZACIONS_I_COMUNICATS, CERTAMENS_I_PREMIS, COL_LABORACIO, CONSULTES_I_SUGGERIMENTS, CONTRACTACIO_PUBLICA, DISCIPLINA_INSPECCIO_I_PROTECCIO_DE_LA_LEGALITAT, DRETS_D_ACCES_A_LA_INFORMACIO, DRETS_I_ACTIVITAT_CIVIL, ENS_DEPENDENTS_I_PARTICIPATS, EXECUCIO_URBANISTICA, GESTIO_DEL_PERSONAL, GESTIO_PRESSUPOSTARIA_I_FINANCERA, GESTIO_TRIBUTARIA, INFORMES_I_CERTIFICATS, INSCRIPCIONS_REGISTRALS, MEDIACIO_I_ARBITRATGE, NORMATIVA, OCUPACIO_I_SERVEIS_A_LA_VIA_PUBLICA, PARTICIPACIO, PLANEJAMENT_URBANISTIC, PREVENCIO, QUEIXES_I_RECLAMACIONS, REGIM_DE_BENS_I_PATRIMONI, REGIM_SANCIONADOR, RESPONSABILITAT_PATRIMONIAL, REVISIO_DE_L_ACTUACIO_ADMINISTRATIVA, SUBVENCIONS_I_AJUTS, TARGETES_CARNETS_I_IDENTIFICACIONS, ALTRES";

}
