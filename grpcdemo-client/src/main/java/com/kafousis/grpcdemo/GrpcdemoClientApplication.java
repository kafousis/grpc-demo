package com.kafousis.grpcdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GrpcdemoClientApplication {

    private static final Logger log = LoggerFactory.getLogger(GrpcdemoClientApplication.class);

    private final GreetingClientService greetingClientService;

    public GrpcdemoClientApplication(GreetingClientService greetingClientService) {
        this.greetingClientService = greetingClientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(GrpcdemoClientApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            String greeting = greetingClientService.greet("Giannis", "Kafousis");
            log.info("Received greeting: {}", greeting);
        };
    }
}
