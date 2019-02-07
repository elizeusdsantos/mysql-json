package com.example.mysqljson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = true)
public class JsonUtil implements AttributeConverter<Query, String> {

    private final static ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Query query){
        try {
            return MAPPER.writeValueAsString(query);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public Query convertToEntityAttribute(String dbData) {
        try {
            return MAPPER.readValue(dbData, Query.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
