package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DocumentsAportatsExpedientsRDTO;

/**
 * The Class InternalToDocumentAportatListConverter.
 */
@Component("internalToDocumentAportatListConverter")
public class InternalToDocumentAportatListConverter extends AbstractConverter<List<DocsEntradaRDTO>, DocumentsAportatsExpedientsRDTO> {

	/** The tramit ovt api param value translator. */
	@Autowired
	@Qualifier("procedimentTramitOvtApiParamValueTranslator")
	private BaseApiParamValueTranslator tramitOvtApiParamValueTranslator;

	/** The revisio api param value translator. */
	@Autowired
	@Qualifier("expedientRevisioApiParamValueTranslator")
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected DocumentsAportatsExpedientsRDTO convert(List<DocsEntradaRDTO> docsEntradaRDTOList) {
		DocumentsAportatsExpedientsRDTO documentsAportatsExpedientsRDTO = null;
		if (CollectionUtils.isNotEmpty(docsEntradaRDTOList)) {
			// Los documentos aportados deben ser agrupados por Tràmit OVT. Para
			// ello se crea un map intermedio
			TreeMap<BigDecimal, ArrayList<DocsEntradaRDTO>> docsEntradaRDTOMap = new TreeMap<BigDecimal, ArrayList<DocsEntradaRDTO>>();
			ArrayList<DocsEntradaRDTO> docsEntradaRDTOMapList = null;
			for (DocsEntradaRDTO docsEntradaRDTO : docsEntradaRDTOList) {
				docsEntradaRDTOMapList = docsEntradaRDTOMap.get(docsEntradaRDTO.getTramitOvtIdext());
				if (docsEntradaRDTOMapList == null) {
					docsEntradaRDTOMapList = new ArrayList<DocsEntradaRDTO>();
					docsEntradaRDTOMap.put(docsEntradaRDTO.getTramitOvtIdext(), docsEntradaRDTOMapList);
				}
				docsEntradaRDTOMapList.add(docsEntradaRDTO);
			}

			documentsAportatsExpedientsRDTO = ConverterHelper.buildDocumentsAportatsRDTOExpedient(docsEntradaRDTOMap,
			        tramitOvtApiParamValueTranslator, revisioApiParamValueTranslator, tipusPersonaApiParamValueTranslator,
			        tipusDocumentIdentitatApiParamValueTranslator, tipusSexeApiParamValueTranslator);
		}

		return documentsAportatsExpedientsRDTO;
	}
}