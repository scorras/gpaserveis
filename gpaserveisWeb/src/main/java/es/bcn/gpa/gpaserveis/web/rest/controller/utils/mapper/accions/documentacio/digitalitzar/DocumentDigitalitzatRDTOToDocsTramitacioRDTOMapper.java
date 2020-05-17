package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.digitalitzar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.BooleanToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.DataHoraToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToBigDecimalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.FitxerToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.IdiomaToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.OrigenToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.digitalitzar.DocumentDigitalitzatRDTO;

/**
 * The Class DocumentDigitalitzatRDTOToDocsTramitacioRDTOMapper.
 */
@Component("documentDigitalitzatRDTOToDocsTramitacioRDTOMapper")
public class DocumentDigitalitzatRDTOToDocsTramitacioRDTOMapper extends PropertyMap<DocumentDigitalitzatRDTO, DocsTramitacioRDTO> {
	/** The internal to big decimal converter. */
	private InternalToBigDecimalConverter internalToBigDecimalConverter;

	/** The origen to internal converter. */
	private OrigenToInternalConverter origenToInternalConverter;

	/** The idioma to internal converter. */
	private IdiomaToInternalConverter idiomaToInternalConverter;

	/** The fitxer to internal converter. */
	private FitxerToInternalConverter fitxerToInternalConverter;

	/** The boolean to internal converter. */
	private BooleanToInternalConverter booleanToInternalConverter;

	/** The data hora to internal converter. */
	private DataHoraToInternalConverter dataHoraToInternalConverter;

	/**
	 * Instantiates a new document digitalitzat RDTO to docs tramitacio RDTO
	 * mapper.
	 *
	 * @param internalToBigDecimalConverter
	 *            the internal to big decimal converter
	 * @param origenToInternalConverter
	 *            the origen to internal converter
	 */
	@Autowired
	public DocumentDigitalitzatRDTOToDocsTramitacioRDTOMapper(
	        @Qualifier("internalToBigDecimalConverter") InternalToBigDecimalConverter internalToBigDecimalConverter,
	        @Qualifier("origenToInternalConverter") OrigenToInternalConverter origenToInternalConverter,
	        @Qualifier("idiomaToInternalConverter") IdiomaToInternalConverter idiomaToInternalConverter,
	        @Qualifier("documentFitxerToInternalConverter") FitxerToInternalConverter fitxerToInternalConverter,
	        @Qualifier("booleanToInternalConverter") BooleanToInternalConverter booleanToInternalConverter,
	        @Qualifier("dataHoraToInternalConverter") DataHoraToInternalConverter dataHoraToInternalConverter) {
		this.internalToBigDecimalConverter = internalToBigDecimalConverter;
		this.origenToInternalConverter = origenToInternalConverter;
		this.idiomaToInternalConverter = idiomaToInternalConverter;
		this.fitxerToInternalConverter = fitxerToInternalConverter;
		this.booleanToInternalConverter = booleanToInternalConverter;
		this.dataHoraToInternalConverter = dataHoraToInternalConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToBigDecimalConverter).map(source.getConfiguracioDocumentacio()).setConfigDocTramitacio(null);
		using(origenToInternalConverter).map(source.getOrigen()).setOrigen(null);
		map().setComentari(source.getComentari());
		using(idiomaToInternalConverter).map(source.getIdioma()).setIdioma(null);
		using(booleanToInternalConverter).map(source.getDigitalitzat()).setDigitalitzat(null);
		using(idiomaToInternalConverter).map(source.getDigitalitzacio().getIdioma()).setIdiomaDigitalitzacio(null);
		using(dataHoraToInternalConverter).map(source.getDigitalitzacio().getDataDigitalitzacio()).setDataDigitalitzacio(null);
		using(fitxerToInternalConverter).map(source.getFitxer()).setDocsFisics(null);
		// map().setCodi(source.getCodi());
	}
}
