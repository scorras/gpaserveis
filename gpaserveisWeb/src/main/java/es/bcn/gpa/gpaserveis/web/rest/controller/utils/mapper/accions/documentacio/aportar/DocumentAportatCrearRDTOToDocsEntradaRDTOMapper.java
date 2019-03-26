package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.aportar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.BooleanToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToBigDecimalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.IdiomaToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.OrigenToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.TipusMimeToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentAportatCrearRDTO;

/**
 * The Class DocumentAportatCrearRDTOToDocsEntradaRDTOMapper.
 */
@Component("documentAportatCrearRDTOToDocsEntradaRDTOMapper")
public class DocumentAportatCrearRDTOToDocsEntradaRDTOMapper extends PropertyMap<DocumentAportatCrearRDTO, DocsEntradaRDTO> {

	private InternalToBigDecimalConverter internalToBigDecimalConverter;

	private OrigenToInternalConverter origenToInternalConverter;

	private IdiomaToInternalConverter idiomaToInternalConverter;

	private TipusMimeToInternalConverter tipusMimeToInternalConverter;

	private BooleanToInternalConverter booleanToInternalConverter;

	@Autowired
	public DocumentAportatCrearRDTOToDocsEntradaRDTOMapper(
	        @Qualifier("internalToBigDecimalConverter") InternalToBigDecimalConverter internalToBigDecimalConverter,
	        @Qualifier("origenToInternalConverter") OrigenToInternalConverter origenToInternalConverter,
	        @Qualifier("idiomaToInternalConverter") IdiomaToInternalConverter idiomaToInternalConverter,
	        @Qualifier("tipusMimeToInternalConverter") TipusMimeToInternalConverter tipusMimeToInternalConverter,
	        @Qualifier("booleanToInternalConverter") BooleanToInternalConverter booleanToInternalConverter) {
		this.internalToBigDecimalConverter = internalToBigDecimalConverter;
		this.origenToInternalConverter = origenToInternalConverter;
		this.idiomaToInternalConverter = idiomaToInternalConverter;
		this.tipusMimeToInternalConverter = tipusMimeToInternalConverter;
		this.booleanToInternalConverter = booleanToInternalConverter;
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
		using(booleanToInternalConverter).map(source.getDeclaracioResponsable()).setDeclaracioResponsable(null);
		map().setFileToUploadName(source.getFitxer().getNom());
		using(tipusMimeToInternalConverter).map(source.getFitxer().getFormat()).setFileToUploadTipus(null);
	}

}
