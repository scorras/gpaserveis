package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.common.BooleanApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ConfiguracionsDocumentacioRDTO;

/**
 * The Class InternalToDocumentsEntradaListConverter.
 */
@Component("procedimentInternalToDocumentsEntradaListConverter")
public class InternalToDocumentsEntradaListConverter
        extends AbstractConverter<List<ConfiguracioDocsEntradaRDTO>, List<ConfiguracionsDocumentacioRDTO>> {

	/** The boolean api param value translator. */
	@Autowired
	@Qualifier("booleanApiParamValueTranslator")
	private BooleanApiParamValueTranslator booleanApiParamValueTranslator;

	/** The suport confeccio api param value translator. */
	@Autowired
	@Qualifier("procedimentSuportConfeccioApiParamValueTranslator")
	private BaseApiParamValueTranslator suportConfeccioApiParamValueTranslator;

	/** The expedient estat tramitador api param value translator. */
	@Autowired
	@Qualifier("expedientEstatTramitadorApiParamValueTranslator")
	private BaseApiParamValueTranslator expedientEstatTramitadorApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<ConfiguracionsDocumentacioRDTO> convert(List<ConfiguracioDocsEntradaRDTO> source) {
		ArrayList<ConfiguracionsDocumentacioRDTO> configuracionsDocumentacioRDTOList = new ArrayList<ConfiguracionsDocumentacioRDTO>();
		if (CollectionUtils.isNotEmpty(source)) {
			for (ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO : source) {
				configuracionsDocumentacioRDTOList
				        .add(ConverterHelper.buildDocumentsRDTOProcediment(configuracioDocsEntradaRDTO, booleanApiParamValueTranslator,
				                suportConfeccioApiParamValueTranslator, expedientEstatTramitadorApiParamValueTranslator));
			}
		}
		return configuracionsDocumentacioRDTOList;
	}
}