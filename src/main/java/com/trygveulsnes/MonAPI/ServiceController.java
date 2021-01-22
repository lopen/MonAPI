package com.trygveulsnes.MonAPI;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/response")
    public ServiceResponse response(@RequestParam(value = "id", defaultValue = "1") long id) {

        Parser parser = new Parser();

        String name = parser.getAllPokemon().get(id).getName();

        return new ServiceResponse(counter.incrementAndGet(), String.format(template, name));
    }
}
 