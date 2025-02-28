package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager() {}

    private static ThreadLocal<ExtentTest> tlExtentTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
        return tlExtentTest.get();
    }

    public static void setExtentTest(ExtentTest extentTest){
            tlExtentTest.set(extentTest);
    }

    public static void unload(){
            tlExtentTest.remove();
    }

}
