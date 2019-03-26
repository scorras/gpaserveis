package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.substituir;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToBigDecimalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.IdiomaToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.OrigenToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.TipusMimeToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.DocumentAportatSubstituirRDTO;

/**
 * The Class DocumentAportatSubstituirRDTOToDocsEntradaRDTOMapper.
 */
@Component("documentAportatSubstituirRDTOToDocsEntradaRDTOMapper")
public class DocumentAportatSubstituirRDTOToDocsEntradaRDTOMapper extends PropertyMap<DocumentAportatSubstituirRDTO, DocsEntradaRDTO> {

	private InternalToBigDecimalConverter internalToBigDecimalConverter;

	private OrigenToInternalConverter origenToInternalConverter;

	private IdiomaToInternalConverter idiomaToInternalConverter;

	private TipusMimeToInternalConverter tipusMimeToInternalConverter;

	@Autowired
	public DocumentAportatSubstituirRDTOToDocsEntradaRDTOMapper(
	        @Qualifier("internalToBigDecimalConverter") InternalToBigDecimalConverter internalToBigDecimalConverter,
	        @Qualifier("origenToInternalConverter") OrigenToInternalConverter origenToInternalConverter,
	        @Qualifier("idiomaToInternalConverter") IdiomaToInternalConverter idiomaToInternalConverter,
	        @Qualifier("tipusMimeToInternalConverter") TipusMimeToInternalConverter tipusMimeToInternalConverter) {
		this.internalToBigDecimalConverter = internalToBigDecimalConverter;
		this.origenToInternalConverter = origenToInternalConverter;
		this.idiomaToInternalConverter = idiomaToInternalConverter;
		this.tipusMimeToInternalConverter = tipusMimeToInternalConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToBigDecimalConverter).map(source.getConfiguracioDocumentacio()).setConfigDocEntrada(null);
		using(origenToInternalConverter).map(source.getOrigen()).setOrigen(null);
		map().setComentari(source.getComentari());
		using(idiomaToInternalConverter).map(source.getIdioma()).setIdioma(null);
		map().setFileToUploadName(source.getFitxer().getNom());
		using(tipusMimeToInternalConverter).map(source.getFitxer().getFormat()).setFileToUploadTipus(null);
	}

}
