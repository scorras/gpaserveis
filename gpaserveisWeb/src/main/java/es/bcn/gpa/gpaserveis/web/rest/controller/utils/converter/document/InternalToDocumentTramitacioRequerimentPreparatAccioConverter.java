package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.RequerimentPreparatAccioRDTO;

/**
 * The Class InternalToDocumentTramitacioIncorporatNouAccioConverter.
 */
@Component("internalToDocumentTramitacioRequerimentPreparatAccioConverter")
public class InternalToDocumentTramitacioRequerimentPreparatAccioConverter
		extends AbstractConverter<DocsTramitacioRDTO, RequerimentPreparatAccioRDTO> {

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
	protected RequerimentPreparatAccioRDTO convert(DocsTramitacioRDTO docsTramitacioRDTO) {
		return ConverterHelper.buildRequerimentPreparatAccioRDTOExpedient(docsTramitacioRDTO, origenApiParamValueTranslator);
	}
}