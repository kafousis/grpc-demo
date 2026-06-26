package com.kafousis.grpcdemo;

import com.kafousis.grpcdemo.proto.greet.GreetRequest;
import com.kafousis.grpcdemo.proto.greet.GreetResponse;
import com.kafousis.grpcdemo.proto.greet.GreetServiceGrpc.GreetServiceBlockingStub;
import com.kafousis.grpcdemo.proto.greet.Greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetingClientService {

    private static final Logger log = LoggerFactory.getLogger(GreetingClientService.class);

    private final GreetServiceBlockingStub greetService;

    public GreetingClientService(GreetServiceBlockingStub greetService) {
        this.greetService = greetService;
    }

    public String greet(String firstName, String lastName) {
        log.info("Sending greeting request for {} {}", firstName, lastName);

        Greeting greeting = Greeting.newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();

        GreetRequest request = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build();

        GreetResponse response = greetService.greet(request);
        return response.getResult();
    }
}
