package es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


/**
 * The Class CustomDateTimeDeserializer.
 */
public class CustomDateTimeDeserializer extends StdDeserializer<DateTime> {
	  
    
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new custom date serializer.
     */
    public CustomDateTimeDeserializer() {
        this(null);
    }
 

    /**
     * Instantiates a new custom date serializer.
     *
     * @param t the t
     */
    public CustomDateTimeDeserializer(Class<DateTime> t) {
        super(t);
    }

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
	 */
	@Override
	public DateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		DateTime res = null;
		try {
			res =  new DateTime(Long.valueOf(p.getText()), DateTimeZone.getDefault());
		} catch (Exception e) {
			res = null;
		}
		return res;
	}
}