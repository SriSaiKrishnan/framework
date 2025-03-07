package com.sai.listener;

import com.sai.annotations.FrameworkAnnotations;
import com.sai.utility.ELKUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.sai.reports.ExtentLogger;
import com.sai.reports.ExtentReport;
import com.sai.utility.BrowserUtils;

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
        ELKUtils.sendResultsToELK(result.getMethod().getMethodName(),"pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " Failed",true);
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        ELKUtils.sendResultsToELK(result.getMethod().getMethodName(),"fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " Skipped",true);
        ELKUtils.sendResultsToELK(result.getMethod().getMethodName(),"skip");
    }

}
