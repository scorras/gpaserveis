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
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.DadesAtributsSollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.DadesAtributsValorsLlistaRepetibleSollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.DadesAtributsValorsLlistaSollicitudsRDTO;

@Component
public class JsonDadesAtributsSollicitudsSerializer extends JsonSerializer<DadesAtributsSollicitudsRDTO> {

	private RawSerializer<String> rawSerializer = new RawSerializer<String>(String.class);

	@Override
	public void serialize(DadesAtributsSollicitudsRDTO dadesAtributsSollicitudsRDTO, JsonGenerator jsonGenerator,
	        SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("codi", dadesAtributsSollicitudsRDTO.getCodi());
		if (dadesAtributsSollicitudsRDTO.getIndex() != null) {
			jsonGenerator.writeStringField("index", dadesAtributsSollicitudsRDTO.getIndex());
		}
		if (CollectionUtils.isNotEmpty(dadesAtributsSollicitudsRDTO.getValor())) {
			if (StringUtils.equals(dadesAtributsSollicitudsRDTO.getCodi(), Constants.CODI_DADA_OPERACIO_DADES_EXTERNES)) {
				jsonGenerator.writeFieldName("valor");
				rawSerializer.serialize(dadesAtributsSollicitudsRDTO.getValor().get(0), jsonGenerator, serializerProvider);
			} else {
				jsonGenerator.writeArrayFieldStart("valor");
				for (String valor : dadesAtributsSollicitudsRDTO.getValor()) {
					jsonGenerator.writeString(valor);
				}
				jsonGenerator.writeEndArray();
			}
		}
		if (CollectionUtils.isNotEmpty(dadesAtributsSollicitudsRDTO.getValorsLlista())) {
			jsonGenerator.writeArrayFieldStart("valorsLlista");
			for (DadesAtributsValorsLlistaSollicitudsRDTO dadesAtributsValorsLlistaSollicitudsRDTO : dadesAtributsSollicitudsRDTO
			        .getValorsLlista()) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeStringField("index", dadesAtributsValorsLlistaSollicitudsRDTO.getIndex());
				jsonGenerator.writeStringField("valor", dadesAtributsValorsLlistaSollicitudsRDTO.getValor());
				jsonGenerator.writeEndObject();
			}
			jsonGenerator.writeEndArray();
		}
		if (CollectionUtils.isNotEmpty(dadesAtributsSollicitudsRDTO.getValorsLlistaRepetible())) {
			jsonGenerator.writeArrayFieldStart("valorsLlistaRepetible");
			for (DadesAtributsValorsLlistaRepetibleSollicitudsRDTO dadesAtributsValorsLlistaRepetibleSollicitudsRDTO : dadesAtributsSollicitudsRDTO.getValorsLlistaRepetible()) {
				jsonGenerator.writeArrayFieldStart("valorsLlista");
				for (DadesAtributsValorsLlistaSollicitudsRDTO dadesAtributsValorsLlistaSollicitudsRDTO : dadesAtributsValorsLlistaRepetibleSollicitudsRDTO.getValorsLlista()) {
					jsonGenerator.writeStartObject();
					jsonGenerator.writeStringField("index", dadesAtributsValorsLlistaSollicitudsRDTO.getIndex());
					jsonGenerator.writeStringField("valor", dadesAtributsValorsLlistaSollicitudsRDTO.getValor());
					jsonGenerator.writeEndObject();
				}
				jsonGenerator.writeEndArray();
			}
			jsonGenerator.writeEndArray();
			jsonGenerator.writeEndArray();
		}
		jsonGenerator.writeEndObject();
	}

}
