package com.sai.utility;

public final class RandomUtils {

    private RandomUtils() {}

    public static int getRandomNumber() {
        return FakerUtils.getNumber(100, 1000);
    }

    public static String getFirstname() {
        return FakerUtils.getFirstname();
    }

    public static String getLastname() {
        return FakerUtils.getLastname();
    }

    public static String getEmail() { return FakerUtils.getEmail(); }

    public static String getPhonenumber() { return FakerUtils.getPhonenumber(); }

}
