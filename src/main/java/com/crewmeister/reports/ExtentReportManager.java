package com.crewmeister.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

    private ExtentReportManager(){}

    private static final ThreadLocal<ExtentTest>threadLocal=new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return threadLocal.get();
    }
    static void setExtentTest(ExtentTest test) {
        threadLocal.set(test);
    }
}