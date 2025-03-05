package listener;

import annotations.FrameworkAnnotations;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentLogger;
import reports.ExtentReport;
import utility.BrowserUtils;
import utility.ELKUtils;

import java.util.Arrays;

public class Listener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
            ExtentReport.createReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getMethod().getMethodName() + " " + BrowserUtils.getBrowserName() + " " + BrowserUtils.getBrowserVersion());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).authors());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).categories());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " Passed");
        //ELKUtils.sendResultsToELK(result.getMethod().getMethodName(),"Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " Failed",true);
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        //ELKUtils.sendResultsToELK(result.getMethod().getMethodName(),"Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " Skipped",true);
        //ELKUtils.sendResultsToELK(result.getMethod().getMethodName(),"Skipped");
    }

}
