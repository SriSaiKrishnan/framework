package utility;

import constants.AppConstants;
import enums.ConfigProperties;
import exceptions.InvalidPropertyFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private static Properties properties;
    private static final Logger logger = LogManager.getLogger(PropertyUtils.class);
    private static final Map<String,String> CONFIGMAP = new HashMap<>();

    private PropertyUtils(){}

    static {
        // String environment = System.getProperty("env");
        String environment = "qa";
        String filepath = "";

        if (Objects.isNull(environment)) {
            logger.info("Environment name is not given, hence running it on QA environment....");
            filepath = AppConstants.getQAFilePath();
        }
        else if(environment.toLowerCase().trim().equalsIgnoreCase("dev"))
        {
            logger.info("Running the test in the dev environment....");
            filepath = AppConstants.getDevFilePath();
        }
        else if(environment.toLowerCase().trim().equalsIgnoreCase("qa"))
        {
            logger.info("Running the test in the qa environment....");
            filepath = AppConstants.getQAFilePath();
        }
        properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream(filepath)){
            properties.load(fileInputStream);
            properties.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue())));
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    public static String get(ConfigProperties key) {
        if(Objects.isNull(key.name().toLowerCase()) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
            throw new InvalidPropertyFileException("Property name : " + key.name().toLowerCase() + " is not found. Please check the property files");
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
