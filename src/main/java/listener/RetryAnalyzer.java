package listener;

import enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utility.PropertyUtils;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int RETRIES = 1;

    @Override
    public boolean retry(ITestResult result) {
        try {
            if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes") && count < RETRIES){
                    count++;
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
