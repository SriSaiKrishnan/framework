package com.sai.utility;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils() {}

    private static final Faker faker = new Faker();

    static int getNumber(int startValue, int endValue) {
        return faker.number().numberBetween(startValue,endValue);
    }

    static String getFirstname() {
        return faker.name().firstName();
    }

    static String getLastname() {
        return faker.name().lastName();
    }

    static String getEmail() { return faker.name() + "@abc.com"; }

    static String getPhonenumber() { return faker.phoneNumber().phoneNumber(); }

}
