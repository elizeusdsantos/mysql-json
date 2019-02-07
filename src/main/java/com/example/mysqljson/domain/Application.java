package com.example.mysqljson.domain;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class Application implements CommandLineRunner{
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(UserQueryRepository repository) {
        return (args) -> {
            ClassLoader classLoader = getClass().getClassLoader();

            ObjectMapper mapper = new ObjectMapper();

            UserQuery user = mapper.readValue(new File("c:\\example.json"), UserQuery.class);

            repository.save(user);
            repository.findAll();
        };
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
