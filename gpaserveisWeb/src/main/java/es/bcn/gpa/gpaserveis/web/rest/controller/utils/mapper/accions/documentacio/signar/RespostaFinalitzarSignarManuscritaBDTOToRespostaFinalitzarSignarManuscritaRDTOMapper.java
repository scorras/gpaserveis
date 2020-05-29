package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.signar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaFinalitzarSignarManuscritaDocumentBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.RespostaFinalitzarSignarManuscritaDocumentRDTO;

/**
 * The Class
 * RespostaFinalitzarSignarManuscritaBDTOToRespostaFinalitzarSignarManuscritaRDTOMapper.
 */
@Component("respostaFinalitzarSignarManuscritaBDTOToRespostaFinalitzarSignarManuscritaRDTOMapper")
public class RespostaFinalitzarSignarManuscritaBDTOToRespostaFinalitzarSignarManuscritaRDTOMapper
        extends PropertyMap<RespostaFinalitzarSignarManuscritaDocumentBDTO, RespostaFinalitzarSignarManuscritaDocumentRDTO> {

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	/**
	 * Instantiates a new resposta finalitzar signar manuscrita BDTO to resposta
	 * finalitzar signar manuscrita RDTO mapper.
	 *
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaFinalitzarSignarManuscritaBDTOToRespostaFinalitzarSignarManuscritaRDTOMapper(
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToResultatRespostaConverter = internalToResultatRespostaConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);

	}

}
