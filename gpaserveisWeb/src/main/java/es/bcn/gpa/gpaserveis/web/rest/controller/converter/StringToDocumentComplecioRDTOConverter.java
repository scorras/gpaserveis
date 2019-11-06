package es.bcn.gpa.gpaserveis.web.rest.controller.converter;

import java.io.IOException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.completar.DocumentComplecioRDTO;

@Component
public class StringToDocumentComplecioRDTOConverter implements Converter<String, DocumentComplecioRDTO> {

	@Override
	public DocumentComplecioRDTO convert(String from) {
		DocumentComplecioRDTO documentComplecioRDTO = null;
		try {
			documentComplecioRDTO = new ObjectMapper().readValue(from.getBytes(), DocumentComplecioRDTO.class);
		} catch (IOException e) {
			throw new GPAServeisRuntimeException(e);
		}
		return documentComplecioRDTO;
	}
}
