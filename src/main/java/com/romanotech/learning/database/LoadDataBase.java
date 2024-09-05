package com.romanotech.learning.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.romanotech.learning.data.Chapter;
import com.romanotech.learning.repository.ChapterRepository;

import reactor.core.publisher.Flux;

@Configuration
public class LoadDataBase {
    

    @Bean
    CommandLineRunner init(ChapterRepository repository) {
        return args -> {
            Flux.just(
                new Chapter("To aprendendo WebFlux"),
                new Chapter("virando o Brabo no Spring"),
                new Chapter("e muito mais ..."))
                .flatMap(repository::save)
                .subscribe(System.out::println);
            };
    }
}
