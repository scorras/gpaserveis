package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Identificacions;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.DadesIdentificacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TerminisDuracioRDTO;

/**
 * The Class InternalToIdentificacioConverter.
 */
@Component("procedimentInternalToIdentificacioConverter")
public class InternalToIdentificacioConverter extends AbstractConverter<Identificacions, DadesIdentificacioRDTO> {

	@Autowired
	@Qualifier("procedimentNivellAutenticacioApiParamValueTranslator")
	private BaseApiParamValueTranslator nivellAutenticacioApiParamValueTranslator;

	@Autowired
	@Qualifier("procedimentTerminiMaximApiParamValueTranslator")
	private BaseApiParamValueTranslator terminiMaximApiParamValueTranslator;

	@Autowired
	@Qualifier("procedimentPeriodicitatApiParamValueTranslator")
	private BaseApiParamValueTranslator periodicitatApiParamValueTranslator;
	
	@Autowired
	@Qualifier("procedimentRequereixNotificacioApiParamValueTranslator")
	private BaseApiParamValueTranslator requereixNotificacioApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected DadesIdentificacioRDTO convert(Identificacions source) {
		DadesIdentificacioRDTO dadesIdentificacioRDTO = new DadesIdentificacioRDTO();
		dadesIdentificacioRDTO.setInformacioCiutada(source.getInformacioCiutada());
		dadesIdentificacioRDTO.setNivellAutenticacio(
				nivellAutenticacioApiParamValueTranslator.getApiParamValueByInternalValue(source.getNivellAutenticacio()));
		// TODO Valor por determinar
		dadesIdentificacioRDTO.setEndpointSignatura("http://endpoint/signatura");
		// TODO Valor por determinar
		dadesIdentificacioRDTO.setEndpointAutenticacio("http://endpoint/autenticacio");
		dadesIdentificacioRDTO.setTractamentGdpr(source.getTractamentGdpr());
		TerminisDuracioRDTO terminisDuracioRDTO = new TerminisDuracioRDTO();
		terminisDuracioRDTO.setUnitat(terminiMaximApiParamValueTranslator.getApiParamValueByInternalValue(source.getTerminiMaxim()));
		terminisDuracioRDTO.setTerminiMaxim((source.getEspecTerminiMaxim() != null) ? String.valueOf(source.getEspecTerminiMaxim()) : null);
		terminisDuracioRDTO
				.setPeriodicitat(periodicitatApiParamValueTranslator.getApiParamValueByInternalValue(source.getPeriodicitatTermini()));
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
		terminisDuracioRDTO
				.setDataIniciVigencia((source.getVigenciaInici() != null) ? dateTimeFormatter.print(source.getVigenciaInici()) : null);
		terminisDuracioRDTO.setDataFiVigencia((source.getVigenciaFi() != null) ? dateTimeFormatter.print(source.getVigenciaFi()) : null);
		dadesIdentificacioRDTO.setTerminisDuracio(terminisDuracioRDTO);
		dadesIdentificacioRDTO.setRequereixNotificacio(requereixNotificacioApiParamValueTranslator.getApiParamValueByInternalValue(source.getRequereixNotificacio()));

		return dadesIdentificacioRDTO;
	}
}