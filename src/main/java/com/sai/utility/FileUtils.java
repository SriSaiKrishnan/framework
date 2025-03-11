package com.sai.utility;

import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class FileUtils {

    private FileUtils() {}

    public static String readFile(String filepath){
        String payload = "";
        try {
            payload =  new String( Files.readAllBytes(Paths.get(filepath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return payload;

    }

    public static void writeFile(String filepath, Response response) {

        try {
            Files.write(Paths.get(filepath), response.asByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

