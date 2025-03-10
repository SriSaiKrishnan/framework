package com.sai.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

}

