package com.sai.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.constants.AppConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JsonUtils {

    private JsonUtils(){}

    public static Object[] readJson(){

        List<Map<String,String>> data = new ArrayList<>();
        try {
            Map<String,String> map = new ObjectMapper()
                    .readValue(new File(AppConstants.getJsonFilePath()), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toArray();

    }

}
