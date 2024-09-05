package com.romanotech.learning.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HomeController {
    
    @GetMapping
    public String greeting(@RequestParam(required = false, defaultValue = "") String name) {
        return name.equals("") ? "Salve Irmaooo" : "Salve porra tu e pika em " + name+ "!";
    }
    
}
