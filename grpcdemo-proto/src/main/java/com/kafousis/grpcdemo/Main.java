package com.kafousis.grpcdemo;

import java.util.List;

import com.kafousis.grpcdemo.proto.person.Person;
import com.kafousis.grpcdemo.proto.person.Date;
import com.kafousis.grpcdemo.proto.person.EyeColor;
import com.kafousis.grpcdemo.proto.person.Address;

public class Main {
    public static void main(String[] args) {

        Person person = Person.newBuilder()
                .setAge(40)
                .setFirstName("Giannis")
                .setLastName("Kafousis")
                .setHeight(1.87f)
                .addPhoneNumbers("6945123456")
                .addAllPhoneNumbers(List.of("6945123456", "6945123457"))
                .setEyeColor(EyeColor.EYE_BROWN)
                .setBirthday(buildBirthday())
                .setAddress(buildAddress())
                .build();
    }

    private static Date buildBirthday() {
        return Date.newBuilder()
                .setDay(2)
                .setMonth(4)
                .setYear(1987)
                .build();
    }

    private static Address buildAddress() {
        return Address.newBuilder()
                .setAddressLine1("Leoforos Dimokratias 123")
                .setZipCode("71306")
                .setCity("Heraklion")
                .setCountry("Greece")
                .build();
    }
}
