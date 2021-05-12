package es.bcn.gpa.gpaserveis.web.rest.dto.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import lombok.extern.apachecommons.CommonsLog;

@Component
@CommonsLog
public class JsonDadesOperacioValorDeserializer extends JsonDeserializer<List<String>> {

	@Override
	public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
	        throws IOException, JsonProcessingException {

		// ObjectMapper mapper = new ObjectMapper();
		// mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		// return mapper.readValue(jsonParser, List.class);

		List<String> valuesList = new ArrayList<>();
		for (JsonToken jsonToken = jsonParser.nextToken(); jsonToken != JsonToken.END_OBJECT; jsonToken = jsonParser.nextToken()) {
			if (jsonToken == JsonToken.VALUE_STRING) {
				String value = jsonParser.getText();
				valuesList.add(value);
			}
		}
		return valuesList;

		/*
		 * TreeNode treeNode = jsonParser.readValueAsTree(); String
		 * treeNodeString = treeNode.toString(); boolean esJson = false;
		 * 
		 * try { ObjectMapper mapper = new ObjectMapper();
		 * mapper.readTree(treeNodeString); } catch (JsonParseException jpe) {
		 * log.error("El valor no té format JSON", jpe); } catch (IOException
		 * ioe) { log.error("El valor no té format JSON", ioe); }
		 * 
		 * if (esJson) { // Si el valor es un JSON se trata de DADES_EXTERNES
		 * return Arrays.asList(treeNodeString); } else { // En cualquier otro
		 * caso se tratará de un array de string treeNodeString =
		 * StringUtils.remove(treeNodeString, "["); treeNodeString =
		 * StringUtils.remove(treeNodeString, "]"); treeNodeString =
		 * StringUtils.remove(treeNodeString, "\""); return new
		 * ArrayList<String>(Arrays.asList(treeNodeString.split(","))); }
		 */
	}

}
