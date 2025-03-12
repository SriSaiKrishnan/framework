package com.sai.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sai.constants.AppConstants;
import com.sai.enums.Categories;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {}

    private static ExtentReports extentReports;
    private static String resourceFilePath = AppConstants.getReportsFilePath();

    public static void createReport() {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = null;
            extentSparkReporter = new ExtentSparkReporter(resourceFilePath);
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setDocumentTitle("Automation Test Report");
            extentSparkReporter.config().setReportName("Execution Report");

        }
    }

    public static void createTest(String testcaseName) {
        ExtentManager.setExtentTest(extentReports.createTest(testcaseName));
    }

    public static void addInfo(String information){
        ExtentManager.getExtentTest().info(information);
    }

    public static void addAuthors(String[] authors){
        for( String author : authors ){
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategories(Categories[] categories){
        for( Categories category : categories ){
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }

    public static void flushReport() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
        ExtentManager.unload();
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new File(resourceFilePath).toURI());
            } else {
                new ProcessBuilder("open", new File(resourceFilePath).getAbsolutePath()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
