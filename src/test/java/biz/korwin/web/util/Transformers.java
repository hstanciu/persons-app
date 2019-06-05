package biz.korwin.web.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Transformers {

	public static byte[] objectToByte(Object object) throws IOException {
		
		if(object == null ) {
			throw new IllegalArgumentException("Object to be transformed into bytes can't be null.");
		}
		
        ObjectMapper mapper = new ObjectMapper();
        
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        
        return mapper.writeValueAsBytes(object);
    }
}
