package es.bcn.gpa.gpaserveis.web.rest.dto.json;

import java.io.IOException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsValorsLlistaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsValorsLlistaRepetibleExpedientsRDTO;

@Component
public class JsonDadesAtributsExpedientsSerializer extends JsonSerializer<DadesAtributsExpedientsRDTO> {

	private RawSerializer<String> rawSerializer = new RawSerializer<String>(String.class);

	@Override
	public void serialize(DadesAtributsExpedientsRDTO dadesAtributsExpedientsRDTO, JsonGenerator jsonGenerator,
	        SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("codi", dadesAtributsExpedientsRDTO.getCodi());
		if (CollectionUtils.isNotEmpty(dadesAtributsExpedientsRDTO.getValorRepetible()) && StringUtils.isNotEmpty(dadesAtributsExpedientsRDTO.getTitol())) {
			jsonGenerator.writeStringField("titol", dadesAtributsExpedientsRDTO.getTitol());
		}
		if (dadesAtributsExpedientsRDTO.getIndex() != null) {
			jsonGenerator.writeStringField("index", dadesAtributsExpedientsRDTO.getIndex());
		}
		if (CollectionUtils.isNotEmpty(dadesAtributsExpedientsRDTO.getValor())) {
			if (StringUtils.equals(dadesAtributsExpedientsRDTO.getCodi(), Constants.CODI_DADA_OPERACIO_DADES_EXTERNES)) {
				jsonGenerator.writeFieldName("valor");
				rawSerializer.serialize(dadesAtributsExpedientsRDTO.getValor().get(0), jsonGenerator, serializerProvider);
			} else {
				jsonGenerator.writeArrayFieldStart("valor");
				for (String valor : dadesAtributsExpedientsRDTO.getValor()) {
					jsonGenerator.writeString(valor);
				}
				jsonGenerator.writeEndArray();
			}
		}
		if (CollectionUtils.isNotEmpty(dadesAtributsExpedientsRDTO.getValorsLlista())) {
			jsonGenerator.writeArrayFieldStart("valorsLlista");
			for (DadesAtributsValorsLlistaExpedientsRDTO dadesAtributsValorsLlistaExpedientsRDTO : dadesAtributsExpedientsRDTO
			        .getValorsLlista()) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeStringField("index", dadesAtributsValorsLlistaExpedientsRDTO.getIndex());
				jsonGenerator.writeStringField("valor", dadesAtributsValorsLlistaExpedientsRDTO.getValor());
				jsonGenerator.writeEndObject();
			}
			jsonGenerator.writeEndArray();
		}
		if (CollectionUtils.isNotEmpty(dadesAtributsExpedientsRDTO.getValorsLlistaRepetible())) {
			jsonGenerator.writeArrayFieldStart("valorsLlistaRepetible");
			for (DadesAtributsValorsLlistaRepetibleExpedientsRDTO dadesAtributsValorsLlistaRepetibleExpedientsRDTO : dadesAtributsExpedientsRDTO.getValorsLlistaRepetible()) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeArrayFieldStart("valorsLlista");
				for (DadesAtributsValorsLlistaExpedientsRDTO dadesAtributsValorsLlistaExpedientsRDTO : dadesAtributsValorsLlistaRepetibleExpedientsRDTO.getValorsLlista()) {
					jsonGenerator.writeStartObject();
					jsonGenerator.writeStringField("index", dadesAtributsValorsLlistaExpedientsRDTO.getIndex());
					jsonGenerator.writeStringField("valor", dadesAtributsValorsLlistaExpedientsRDTO.getValor());
					jsonGenerator.writeEndObject();
				}
				jsonGenerator.writeEndArray();
				jsonGenerator.writeEndObject();
			}
			jsonGenerator.writeEndArray();
		}
		if (CollectionUtils.isNotEmpty(dadesAtributsExpedientsRDTO.getValorsLlistaMultipleRepetible())) {
			jsonGenerator.writeArrayFieldStart("valorsLlistaRepetible");
			for (DadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO dadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO : dadesAtributsExpedientsRDTO.getValorsLlistaMultipleRepetible()) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeArrayFieldStart("valorsLlista");
				for (DadesAtributsValorsLlistaRepetibleExpedientsRDTO dadesAtributsValorsLlistaRepetibleExpedientsRDTO : dadesAtributsValorsLlistaMultipleRepetibleExpedientsRDTO.getValorsLlistaRepetible()) {
					for (DadesAtributsValorsLlistaExpedientsRDTO dadesAtributsValorsLlistaExpedientsRDTO : dadesAtributsValorsLlistaRepetibleExpedientsRDTO.getValorsLlista()) {
						jsonGenerator.writeStartObject();
						jsonGenerator.writeStringField("index", dadesAtributsValorsLlistaExpedientsRDTO.getIndex());
						jsonGenerator.writeStringField("valor", dadesAtributsValorsLlistaExpedientsRDTO.getValor());
						jsonGenerator.writeEndObject();
					}
				}
				jsonGenerator.writeEndArray();
				jsonGenerator.writeEndObject();
			}
			jsonGenerator.writeEndArray();
		}
		if (CollectionUtils.isNotEmpty(dadesAtributsExpedientsRDTO.getValorRepetible())) {
			jsonGenerator.writeFieldName("valor");
			rawSerializer.serialize(dadesAtributsExpedientsRDTO.getValorRepetible().get(0), jsonGenerator, serializerProvider);
			
		}
		jsonGenerator.writeEndObject();
	}

}
