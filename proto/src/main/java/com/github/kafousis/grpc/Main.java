package com.github.kafousis.grpc;

import com.github.kafousis.proto.PersonOuterClass.Person;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, gRPC!");

        Person person = Person.newBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(30)
                .build();
    }
}