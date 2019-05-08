package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.incorporar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.BooleanToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.DataHoraToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToBigDecimalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.IdiomaToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.OrigenToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.RevisioToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.TipusMimeToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar.DocumentIncorporatNouRDTO;

/**
 * The Class DocumentIncorporatNouRDTOToDocsEntradaRDTOMapper.
 */
@Component("documentIncorporatNouRDTOToDocsEntradaRDTOMapper")
public class DocumentIncorporatNouRDTOToDocsEntradaRDTOMapper extends PropertyMap<DocumentIncorporatNouRDTO, DocsEntradaRDTO> {

	private InternalToBigDecimalConverter internalToBigDecimalConverter;

	private OrigenToInternalConverter origenToInternalConverter;

	private IdiomaToInternalConverter idiomaToInternalConverter;

	private TipusMimeToInternalConverter tipusMimeToInternalConverter;

	private BooleanToInternalConverter booleanToInternalConverter;

	private RevisioToInternalConverter revisioToInternalConverter;

	private DataHoraToInternalConverter dataHoraToInternalConverter;

	@Autowired
	public DocumentIncorporatNouRDTOToDocsEntradaRDTOMapper(
	        @Qualifier("internalToBigDecimalConverter") InternalToBigDecimalConverter internalToBigDecimalConverter,
	        @Qualifier("origenToInternalConverter") OrigenToInternalConverter origenToInternalConverter,
	        @Qualifier("idiomaToInternalConverter") IdiomaToInternalConverter idiomaToInternalConverter,
	        @Qualifier("tipusMimeToInternalConverter") TipusMimeToInternalConverter tipusMimeToInternalConverter,
	        @Qualifier("booleanToInternalConverter") BooleanToInternalConverter booleanToInternalConverter,
	        @Qualifier("revisioToInternalConverter") RevisioToInternalConverter revisioToInternalConverter,
	        @Qualifier("dataHoraToInternalConverter") DataHoraToInternalConverter dataHoraToInternalConverter) {
		this.internalToBigDecimalConverter = internalToBigDecimalConverter;
		this.origenToInternalConverter = origenToInternalConverter;
		this.idiomaToInternalConverter = idiomaToInternalConverter;
		this.tipusMimeToInternalConverter = tipusMimeToInternalConverter;
		this.booleanToInternalConverter = booleanToInternalConverter;
		this.revisioToInternalConverter = revisioToInternalConverter;
		this.dataHoraToInternalConverter = dataHoraToInternalConverter;
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
		using(revisioToInternalConverter).map(source.getRevisio()).setRevisio(null);
		using(booleanToInternalConverter).map(source.getDigitalitzat()).setDigitalitzat(null);
		// TODO ¿Dónde se almacena el idioma de digitalización?
		using(idiomaToInternalConverter).map(source.getDigitalitzacio().getIdioma()).setIdioma(null);
		using(dataHoraToInternalConverter).map(source.getDigitalitzacio().getDataDigitalitzacio()).setDataDigitalitzacio(null);
		map().setFileToUploadName(source.getFitxer().getNom());
		using(tipusMimeToInternalConverter).map(source.getFitxer().getFormat()).setFileToUploadTipus(null);
		map().setRegistreCodi(source.getNumeroRegistre());
	}

}
