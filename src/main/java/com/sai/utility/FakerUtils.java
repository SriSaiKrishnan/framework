package com.sai.utility;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils() {}

    private static final Faker faker = new Faker();

    public static int getNumber(int startValue, int endValue) {
        return faker.number().numberBetween(startValue,endValue);
    }

    public static String getFirstname() {
        return faker.name().firstName();
    }

    public static String getLastname() {
        return faker.name().lastName();
    }

    public static String getEmail() { return faker.name() + "@abc.com"; }

    public static String getPhonenumber() { return faker.phoneNumber().phoneNumber(); }

}
