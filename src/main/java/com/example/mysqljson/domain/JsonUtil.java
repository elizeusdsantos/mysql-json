package com.example.mysqljson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = true)
public class JsonUtil implements AttributeConverter<Object, String> {

    private final static ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object meta){
        try {
            return MAPPER.writeValueAsString(meta);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        try {
            return MAPPER.readValue(dbData, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
