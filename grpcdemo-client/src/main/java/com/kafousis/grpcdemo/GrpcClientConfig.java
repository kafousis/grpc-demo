package com.kafousis.grpcdemo;

import com.kafousis.grpcdemo.proto.greet.GreetServiceGrpc;

import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.ImportGrpcClients;

@Configuration
// Create a gRPC client stub and associate it with the name "greeter"
@ImportGrpcClients(target = "greeter", types = GreetServiceGrpc.GreetServiceBlockingStub.class)
public class GrpcClientConfig {
}
