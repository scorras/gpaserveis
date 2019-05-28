package es.bcn.gpa.gpaserveis.web.rest.controller.converter;

import java.io.IOException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar.DocumentIncorporacioNouRDTO;

@Component
public class StringToDocumentIncorporacioNouRDTOConverter implements Converter<String, DocumentIncorporacioNouRDTO> {

	@Override
	public DocumentIncorporacioNouRDTO convert(String from) {
		DocumentIncorporacioNouRDTO documentIncorporacioNouRDTO = null;
		try {
			documentIncorporacioNouRDTO = new ObjectMapper().readValue(from, DocumentIncorporacioNouRDTO.class);
		} catch (IOException e) {
			throw new GPAServeisRuntimeException(e);
		}
		return documentIncorporacioNouRDTO;
	}
}