package com.example.mysqljson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Multimap;
import java.io.IOException;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Converter(autoApply = true)
@Component
public class StringMultimapConverter implements
    AttributeConverter<Multimap<String, String>, String> {

  private ObjectMapper objectMapper;

  @Autowired
  public void setObjectMapper(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public String convertToDatabaseColumn(Multimap<String, String> query) {

    try {
      return objectMapper.writeValueAsString(query);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return "";
  }

  @Override
  public Multimap<String, String> convertToEntityAttribute(String dbData) {
    try {
      Multimap<String, String> navs = objectMapper.readValue(
          objectMapper.treeAsTokens(objectMapper.readTree(dbData)),
          objectMapper.getTypeFactory().constructMapLikeType(
              Multimap.class, String.class, String.class));

      return navs;
    } catch (IOException e) {
      return null;
    }

  }

}
