package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentAportatConsultaRDTO;

/**
 * The Class InternalToDocumentAportatConsultaListConverter.
 */
@Component("internalToDocumentAportatConsultaListConverter")
public class InternalToDocumentAportatConsultaListConverter
        extends AbstractConverter<List<DocsEntradaRDTO>, List<DocumentAportatConsultaRDTO>> {

	/** The tramit ovt api param value translator. */
	@Autowired
	@Qualifier("procedimentTramitOvtApiParamValueTranslator")
	private BaseApiParamValueTranslator tramitOvtApiParamValueTranslator;

	/** The revisio api param value translator. */
	@Autowired
	@Qualifier("documentRevisioApiParamValueTranslator")
	private BaseApiParamValueTranslator revisioApiParamValueTranslator;

	/** The tipus persona api param value translator. */
	@Autowired
	@Qualifier("expedientTipusPersonaApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusPersonaApiParamValueTranslator;

	/** The tipus document identitat api param value translator. */
	@Autowired
	@Qualifier("expedientTipusDocumentIdentitatApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator;

	/** The tipus sexe api param value translator. */
	@Autowired
	@Qualifier("expedientTipusSexeApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusSexeApiParamValueTranslator;

	/** The tipus via api param value translator. */
	@Autowired
	@Qualifier("expedientTipusViaApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusViaApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<DocumentAportatConsultaRDTO> convert(List<DocsEntradaRDTO> docsEntradaRDTOList) {
		ArrayList<DocumentAportatConsultaRDTO> documentAportatConsultaRDTOList = null;
		if (CollectionUtils.isNotEmpty(docsEntradaRDTOList)) {
			documentAportatConsultaRDTOList = ConverterHelper.buildDocumentsAportatsConsultaRDTOListExpedient(docsEntradaRDTOList,
			        tramitOvtApiParamValueTranslator, revisioApiParamValueTranslator, tipusPersonaApiParamValueTranslator,
			        tipusDocumentIdentitatApiParamValueTranslator, tipusSexeApiParamValueTranslator, tipusViaApiParamValueTranslator);
		}

		return documentAportatConsultaRDTOList;
	}
}