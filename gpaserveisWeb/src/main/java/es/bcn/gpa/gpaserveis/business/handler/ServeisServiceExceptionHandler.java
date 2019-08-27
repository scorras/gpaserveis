package es.bcn.gpa.gpaserveis.business.handler;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class ServeisServiceExceptionHandler {

	public static void handleException(Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("handleException(Throwable) - inici"); //$NON-NLS-1$
		}

		String message = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonFactory factory = mapper.getFactory();
			JsonParser parser = factory.createParser(e.getMessage());
			JsonNode actualObj = mapper.readTree(parser);
			ObjectReader reader = mapper.readerFor(new TypeReference<String>() {
			});
			message = String.valueOf(reader.readValue(actualObj.get("errorMessage")));
		} catch (Exception eAux) {
			log.error("handleException(Throwable)", eAux); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage(), e);
		}
		throw new GPAServeisServiceException(message, e);
	}

}
