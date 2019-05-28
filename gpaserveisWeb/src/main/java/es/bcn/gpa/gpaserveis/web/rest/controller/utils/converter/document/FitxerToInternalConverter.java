package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsFisics;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusMime;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusMimeApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.FitxerRDTO;

/**
 * The Class FitxerToInternalConverter.
 */
@Component("documentFitxerToInternalConverter")
public class FitxerToInternalConverter extends AbstractConverter<FitxerRDTO, DocsFisics> {

	@Autowired
	@Qualifier("documentTipusMimeApiParamValueTranslator")
	private TipusMimeApiParamValueTranslator tipusMimeApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected DocsFisics convert(FitxerRDTO source) {

		DocsFisics docsFisics = null;
		if (source != null) {
			docsFisics = new DocsFisics();
			docsFisics.setNom(source.getNom());
			TipusMime tipusMime = new TipusMime();
			tipusMime.setId(tipusMimeApiParamValueTranslator.getInternalValueByApiParamValue(source.getFormat()));
			docsFisics.setTipusMime(tipusMime);
		}
		return docsFisics;
	}
}