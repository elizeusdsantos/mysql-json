package com.example.mysqljson;

import com.example.mysqljson.domain.Query;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Multimap;
import java.io.IOException;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;

@Converter(autoApply = true)
public class StringMultimapConverter implements AttributeConverter<Query, String> {

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public String convertToDatabaseColumn(Query query) {

    try {
      return objectMapper.writeValueAsString(query);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return "";
  }

  @Override
  public Query convertToEntityAttribute(String dbData) {
    try {
      Multimap m = objectMapper.readValue(dbData, new TypeReference<Multimap<String, String>>() {
      });
      System.out.println(m.entries());
      return null;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new Query();
  }

}
