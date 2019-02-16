package com.example.mysqljson;

import com.example.mysqljson.domain.UserQuery;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  @Autowired
  public ObjectMapper objectMapper;

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @Bean
  public CommandLineRunner demo(UserQueryRepository repository, ObjectMapper objectMapper) {
    return args -> {
      final UserQuery user;

      try (InputStream is = getClass().getResourceAsStream("/example.json")) {
        Objects.requireNonNull(is, "inputStream");
        List<UserQuery> users = objectMapper
            .readValue(is, new TypeReference<ArrayList<UserQuery>>() {
            });
        user = users.get(0);
        log.info("Loaded user {}", user.getUserId());
      }
      repository.save(user);

            Iterable<UserQuery> allUsers = repository.findAll();

            for (UserQuery foundUser : allUsers) {

                log.info("User: {} == {} ? {}", foundUser, user, Objects.equals(user, foundUser));
            }
    };
  }

}
