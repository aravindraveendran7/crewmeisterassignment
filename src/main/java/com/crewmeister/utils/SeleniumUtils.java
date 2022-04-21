package com.crewmeister.utils;

import com.crewmeister.configs.ConfigFactory;
import com.crewmeister.driver.DriverManager;
import com.crewmeister.enums.WaitType;
import com.crewmeister.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class SeleniumUtils {

    private  SeleniumUtils(){}

    public  static void click(By by, String elementName){
        waitUntilElementPresent(by).click();
        ExtentLogger.pass(elementName+" is clicked successfully");
    }

    public  static void click(By by, WaitType waitType){
        if (waitType== WaitType.PRESENCE){
            waitUntilElementPresent(by).click();
        }else if (waitType==WaitType.CLICKABLE){
            waitUntilElementClickable(by).click();
        }
    }
    public  static void sendKeys(By by,String requiredUserData,String elementName){
        waitUntilElementPresent(by).sendKeys(requiredUserData);
        ExtentLogger.pass(requiredUserData+" is entered successfully in "+elementName);

    }
    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private static WebElement waitUntilElementClickable(By by) {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}