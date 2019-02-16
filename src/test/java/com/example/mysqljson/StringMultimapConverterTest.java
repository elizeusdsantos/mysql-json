package com.example.mysqljson;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Before;
import org.junit.Test;

public class StringMultimapConverterTest {

  private StringMultimapConverter converter;

  @Before
  public void setup() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new GuavaModule());
    converter = new StringMultimapConverter();
    converter.setObjectMapper(objectMapper);
  }

  @Test
  public void shouldReturnCorrectStructure() throws IOException {
    String json = CharStreams.toString(
        new InputStreamReader(getClass().getResourceAsStream("/example_query.json")));

    Multimap<String, String> result = converter.convertToEntityAttribute(json);

    assertThat(result.toString())
        .contains("{nomeFantasia=[IBI]}")
        .doesNotContain("tipoAtividade");
  }

  @Test
  public void shouldReturnAJsonLikeString() {
    Multimap<String, String> multimap = ImmutableMultimap
        .<String, String>builder()
        .put("nomeFantasia", "IBI")
        .build();

    String result = converter.convertToDatabaseColumn(multimap);

    assertThat(result).contains("\"nomeFantasia\":[\"IBI\"]");
  }
}