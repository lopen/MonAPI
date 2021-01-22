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
    public ServiceResponse response(@RequestParam(value = "id", defaultValue = "Nothing found!") String id) {

        Parser parser = new Parser();

        Pokemon pokemon = parser.getAllPokemon().get(id);



        return new ServiceResponse(counter.incrementAndGet(), String.format(template, pokemon.getName()));
    }
}
 