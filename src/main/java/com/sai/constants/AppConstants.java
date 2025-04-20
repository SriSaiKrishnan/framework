package com.sai.constants;

import com.sai.enums.ConfigProperties;
import com.sai.utility.PropertyUtils;

public final class AppConstants {

    private AppConstants(){}

    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCE_PATH + "/config.properties";
    private static final String TESTDATA_FILE_PATH = RESOURCE_PATH + "/testdata.xlsx";
    private static final String REPORTS_FOLDER_PATH = System.getProperty("user.dir") + "/extent-test-output";
    private static final String JSON_TEST_DATA_PATH = RESOURCE_PATH + "/jsons/testdata.json";
    private static final int GLOBAL_WAIT = 30;

    public static String getConfigFilePath(){ return CONFIG_FILE_PATH; }

    public static int getGlobalWait(){ return GLOBAL_WAIT; }

    public static String getTestdataFilePath(){ return TESTDATA_FILE_PATH; }

    public static String getJsonFilePath(){ return JSON_TEST_DATA_PATH; }

    public static String getResourcePath(){ return RESOURCE_PATH; }

    public static String getReportsFilePath() {
        try {
            if(PropertyUtils.get(ConfigProperties.OVERRIDE).equalsIgnoreCase("yes"))
            {
                return REPORTS_FOLDER_PATH + "/index.html";
            }
            else {
                return REPORTS_FOLDER_PATH + System.currentTimeMillis() + "/index.html";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
