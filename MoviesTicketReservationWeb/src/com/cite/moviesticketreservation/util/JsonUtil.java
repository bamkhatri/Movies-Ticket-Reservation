package com.cite.moviesticketreservation.util;

import java.io.InputStream;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();
    
    static {
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.setSerializationInclusion(Include.NON_NULL);
        
    }
    public static <T>  T parseJSON(InputStream input, Class<T> clazz){
        if (input == null) return null;
        try {
            return mapper.readValue(input, clazz);
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static <T>  T parseJSON(String json, Class<T> clazz){
        if (json == null) return null;
        try {
            return mapper.readValue(json, clazz);
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String getJSONString(Object object){
        return getJSONString(object, false);
    }
    
    public static String getJSONString(Object object, boolean prettyPrint){
        if(object == null) return null;
        try {
            if(prettyPrint)
                return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            else
                return mapper.writeValueAsString(object);
            
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
