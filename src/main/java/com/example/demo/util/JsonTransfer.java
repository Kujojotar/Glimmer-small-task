package com.example.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTransfer {
    public static String ObjectToJason(Object object){
        ObjectMapper mapper=new ObjectMapper();
        String json=null;
        try{
            json= mapper.writeValueAsString(object);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public static Object readJSONString(String json,Class<?> clazz)throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.readValue(json,clazz);
    }
}
