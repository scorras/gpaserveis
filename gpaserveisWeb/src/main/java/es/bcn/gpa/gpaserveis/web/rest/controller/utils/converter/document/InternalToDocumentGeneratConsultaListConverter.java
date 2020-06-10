package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentGeneratConsultaRDTO;

/**
 * The Class InternalToDocumentGeneratConsultaListConverter.
 */
@Component("internalToDocumentGeneratConsultaListConverter")
public class InternalToDocumentGeneratConsultaListConverter
        extends AbstractConverter<List<DocsTramitacioRDTO>, List<DocumentGeneratConsultaRDTO>> {

	/** The origen api param value translator. */
	@Autowired
	@Qualifier("documentOrigenApiParamValueTranslator")
	private BaseApiParamValueTranslator origenApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<DocumentGeneratConsultaRDTO> convert(List<DocsTramitacioRDTO> docsTramitacioRDTOList) {
		ArrayList<DocumentGeneratConsultaRDTO> documentGeneratConsultaRDTOList = null;
		if (CollectionUtils.isNotEmpty(docsTramitacioRDTOList)) {
			documentGeneratConsultaRDTOList = ConverterHelper.buildDocumentsGeneratsConsultaRDTOListExpedient(docsTramitacioRDTOList,
			        origenApiParamValueTranslator);
		}

		return documentGeneratConsultaRDTOList;
	}
}