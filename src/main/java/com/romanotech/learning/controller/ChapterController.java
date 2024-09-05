package com.romanotech.learning.controller;

import org.springframework.web.bind.annotation.RestController;

import com.romanotech.learning.data.Chapter;
import com.romanotech.learning.repository.ChapterRepository;

import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ChapterController {
    private final ChapterRepository chapterRepository;

    public ChapterController(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @GetMapping("/chapters")
    public Flux<Chapter> listing() {
        return chapterRepository.findAll();
    }
    
}
