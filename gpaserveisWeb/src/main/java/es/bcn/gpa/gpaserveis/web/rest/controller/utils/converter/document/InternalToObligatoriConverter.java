package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import java.math.BigDecimal;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfdocsentTramitsOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.EstatTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitOvtApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class InternalToObligatoriConverter.
 */
@Component("internalToObligatoriConverter")
public class InternalToObligatoriConverter extends AbstractConverter<ConfiguracioDocsEntradaRDTO, Boolean> {

	/** The estat api param value translator. */
	@Autowired
	@Qualifier("expedientEstatTramitadorApiParamValueTranslator")
	private BaseApiParamValueTranslator expedientEstatTramitadorApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected Boolean convert(ConfiguracioDocsEntradaRDTO source) {
		if (esTramitOvt(source, TramitOvtApiParamValue.SOL) && source.getIniciProcediment() != null
		        && expedientEstatTramitadorApiParamValueTranslator
		                .getApiParamValueByInternalValue(BigDecimal.valueOf(source.getIniciProcediment()))
		                .equals(EstatTramitadorApiParamValue.SOL_LICITUD_EN_REVISIO.getApiParamValue())) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	/**
	 * Es tramit ovt.
	 *
	 * @param configuracioDocsEntradaRDTO
	 *            the configuracio docs entrada RDTO
	 * @param tramitOvtApiParamValue
	 *            the tramit ovt api param value
	 * @return true, if successful
	 */
	private static boolean esTramitOvt(ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO,
	        TramitOvtApiParamValue tramitOvtApiParamValue) {
		if (CollectionUtils.isNotEmpty(configuracioDocsEntradaRDTO.getConfdocsentTramitsOvtList())) {
			for (ConfdocsentTramitsOvt confdocsentTramitsOvt : configuracioDocsEntradaRDTO.getConfdocsentTramitsOvtList()) {
				if (confdocsentTramitsOvt.getTramitOvtIdext()
				        .compareTo(tramitOvtApiParamValue.getInternalValue()) == NumberUtils.INTEGER_ZERO) {
					return true;
				}
			}
		}
		return false;
	}
}