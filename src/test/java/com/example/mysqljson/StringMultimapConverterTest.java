package com.example.mysqljson;

import com.example.mysqljson.config.ObjectMapperConfig;
import com.example.mysqljson.domain.Query;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.collect.Multimap;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StringMultimapConverterTest {

  private ObjectMapper objectMapper;

  @Before
  public void setup() {
    objectMapper = new ObjectMapper();
    objectMapper.registerModule(new GuavaModule());
  }

  @Test
  public void shouldReturnCorrectStructure() throws IOException {

    try (InputStream stream = getClass().getResourceAsStream("/example.json")) {
      Multimap<String, String> navs = objectMapper.readValue(
          objectMapper.treeAsTokens(objectMapper.readTree(stream)),
          objectMapper.getTypeFactory().constructMapLikeType(
              Multimap.class, String.class, String.class));
    }
  }
}