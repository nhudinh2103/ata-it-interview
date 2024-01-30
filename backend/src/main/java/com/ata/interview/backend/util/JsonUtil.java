package com.ata.interview.backend.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author dinhnn
 *
 */
public class JsonUtil {
	
	private JsonUtil() {}
	
	private static final ThreadLocal<ObjectMapper> om = new ThreadLocal<ObjectMapper>() {
	    @Override
	    protected ObjectMapper initialValue() {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        return objectMapper;
	    }
	};

	public static ObjectMapper getObjectMapper() {
	    return om.get();
	}
	
}
