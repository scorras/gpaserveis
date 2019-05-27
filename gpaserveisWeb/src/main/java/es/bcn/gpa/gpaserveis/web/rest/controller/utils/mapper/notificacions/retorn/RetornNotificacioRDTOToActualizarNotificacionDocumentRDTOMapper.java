package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.notificacions.retorn;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.DataHoraToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.DataToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.notificacions.estat.RetornNotificacioRDTO;

/**
 * The Class RetornNotificacioRDTOToActualizarNotificacionDocumentRDTOMapper.
 */
@Component("notificacioRetornNotificacioRDTOToActualizarNotificacionDocumentRDTOMapper")
public class RetornNotificacioRDTOToActualizarNotificacionDocumentRDTOMapper
        extends PropertyMap<RetornNotificacioRDTO, /* ActualizarNotificacionDocumentRDTO */ String> {

	private DataToInternalConverter dataToInternalConverter;
	private DataHoraToInternalConverter dataHoraToInternalConverter;

	@Autowired
	public RetornNotificacioRDTOToActualizarNotificacionDocumentRDTOMapper(
	        @Qualifier("dataHoraToInternalConverter") DataHoraToInternalConverter dataHoraToInternalConverter,
	        @Qualifier("dataToInternalConverter") DataToInternalConverter dataToInternalConverter) {

		this.dataHoraToInternalConverter = dataHoraToInternalConverter;
		this.dataToInternalConverter = dataToInternalConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		// map().setNotificacioId(source.getNotificacioId());
		// map().setDocEvidenciaElectronic(source.getDocEvidenciaElectronic());
		// map().setDocEvidenciaPaper(source.getDocEvidenciaPaper());
		// using(dataToInternalConverter).map(source.getDataAcusamentRebuda()).setDataAcusamentRebuda(null);
		// using(dataToInternalConverter).map(source.getDataEnviament()).setDataEnviament(null);
		// using(dataHoraToInternalConverter).map(source.getDataHoraAceptacioRebuig()).setDataHoraAceptacioRebuig(null);
		// using(dataHoraToInternalConverter).map(source.getDataHoraDiposit()).setDataHoraDiposit(null);
		// using(dataHoraToInternalConverter).map(source.getDataHoraVisualitzacio()).setDataHoraVisualitzacio(null);
		// using(dataToInternalConverter).map(source.getDataLimit()).setDataLimit(null);
	}
}