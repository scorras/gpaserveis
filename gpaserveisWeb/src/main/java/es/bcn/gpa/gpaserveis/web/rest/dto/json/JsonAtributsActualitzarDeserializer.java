package es.bcn.gpa.gpaserveis.web.rest.dto.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.actualitzar.AtributsActualitzarRDTO;

@Component
public class JsonAtributsActualitzarDeserializer extends JsonDeserializer<AtributsActualitzarRDTO> {

	@Override
	public AtributsActualitzarRDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
	        throws IOException, JsonProcessingException {

		ObjectCodec objectCodec = jsonParser.getCodec();
		JsonNode jsonNode = objectCodec.readTree(jsonParser);

		AtributsActualitzarRDTO atributsActualitzarRDTO = new AtributsActualitzarRDTO();
		List<String> valorList = new ArrayList<String>();
		String codi = jsonNode.get("codi").textValue();
		JsonNode jsonNodeValor = jsonNode.get("valor");

		atributsActualitzarRDTO.setCodi(codi);
		if (StringUtils.equals(codi, Constants.CODI_DADA_OPERACIO_DADES_EXTERNES)) {
			valorList.add(jsonNodeValor.toString());
		} else {
			Iterator<JsonNode> jsonNodeIterator = jsonNodeValor.elements();
			JsonNode jsonNodeAux = null;
			while (jsonNodeIterator.hasNext()) {
				jsonNodeAux = jsonNodeIterator.next();
				valorList.add(jsonNodeAux.asText());
			}
		}
		atributsActualitzarRDTO.setValor(valorList);

		return atributsActualitzarRDTO;
	}

}
