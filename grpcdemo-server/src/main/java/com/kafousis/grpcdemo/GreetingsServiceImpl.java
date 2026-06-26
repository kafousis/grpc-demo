package com.kafousis.grpcdemo;

import com.kafousis.grpcdemo.proto.greet.GreetRequest;
import com.kafousis.grpcdemo.proto.greet.GreetResponse;
import com.kafousis.grpcdemo.proto.greet.GreetServiceGrpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.grpc.server.service.GrpcService;

import io.grpc.stub.StreamObserver;

@GrpcService
public class GreetingsServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    public static final Logger log = LoggerFactory.getLogger(GreetingsServiceImpl.class);

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {

        log.info("Received greet request for: {} {}",
                request.getGreeting().getFirstName(),
                request.getGreeting().getLastName());

        String greeting = "Hello, "
                + request.getGreeting().getFirstName() + " "
                + request.getGreeting().getLastName() + "!";

        GreetResponse response = GreetResponse.newBuilder()
                .setResult(greeting)
                .build();

        // send the response back to the client
        responseObserver.onNext(response);

        // complete the RPC call
        responseObserver.onCompleted();
    }
}
