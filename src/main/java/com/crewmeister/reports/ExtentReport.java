package com.crewmeister.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crewmeister.constants.FrameworkConstants;

public final class ExtentReport {

    private ExtentReport(){}
    public static ExtentReports extentReport;
    public static ExtentTest extentTest;

    public static void initReports(){
        extentReport=new ExtentReports();
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(FrameworkConstants.getREPORT_PATH());
        extentReport.attachReporter(extentSparkReporter);
    }
    public static void  flushReports(){
        extentReport.flush();
    }

    public static void createNodeInTestReport(String testCaseName){
        extentTest = extentReport.createTest(testCaseName);
        ExtentReportManager.setExtentTest(extentTest);
    }
    public static void assignAuthor(String authorName){
        ExtentReportManager.getExtentTest().assignAuthor(authorName);
    }
    public static void assignCategory(String category){
        ExtentReportManager.getExtentTest().assignCategory(category);
    }
}
