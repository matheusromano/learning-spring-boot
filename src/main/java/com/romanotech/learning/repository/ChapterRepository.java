package com.romanotech.learning.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.romanotech.learning.data.Chapter;

public interface ChapterRepository extends ReactiveCrudRepository<Chapter, String> { 
    

    
}
