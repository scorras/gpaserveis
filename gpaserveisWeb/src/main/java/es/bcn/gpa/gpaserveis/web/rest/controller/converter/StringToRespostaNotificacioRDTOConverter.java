package es.bcn.gpa.gpaserveis.web.rest.controller.converter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.notificacions.estat.RespostaNotificacioRDTO;

@Component
public class StringToRespostaNotificacioRDTOConverter implements Converter<String, RespostaNotificacioRDTO> {

	@Override
	public RespostaNotificacioRDTO convert(String from) {
		RespostaNotificacioRDTO respostaNotificacioRDTO = null;
		try {
			respostaNotificacioRDTO = new ObjectMapper().readValue(from.getBytes(StandardCharsets.UTF_8), RespostaNotificacioRDTO.class);
		} catch (IOException e) {
			throw new GPAServeisRuntimeException(e);
		}
		return respostaNotificacioRDTO;
	}
}
