package com.crewmeister.listeners;

import com.crewmeister.annotations.FrameworkAnnotation;
import com.crewmeister.reports.ExtentLogger;
import com.crewmeister.reports.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListeners implements ITestListener {
    public void onTestStart(ITestResult result) {
        ExtentReport.createNodeInTestReport(result.getName());
        ExtentReport.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.assignCategory(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).catergory());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName()+"is passed");
    }
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName()+"is failed");
        ExtentLogger.fail(result.getThrowable().getMessage());
    }
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }
    public void onFinish(ITestContext context) {
        ExtentReport.flushReports();
    }
}
