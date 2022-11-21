package br.com.erudio.controller;

import br.com.erudio.configuration.*;
import br.com.erudio.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.*;

@RestController
public class GreetingController {
    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingConfiguration configuration;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name){
        if(name.isEmpty()) name = configuration.getDefaultValue();

        return new Greeting(counter.incrementAndGet(), String.format(template, configuration.getGreeting(), name));
    }

}
