package com.crewmeister.utils;

import com.crewmeister.configs.ConfigFactory;
import com.crewmeister.driver.DriverManager;
import com.crewmeister.enums.WaitType;
import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Consumer;

public final class SeleniumUtils {

    private SeleniumUtils() {
    }

    public static void click(By by, String elementName) {
        waitUntilElementVisible(by).click();
        ExtentLogger.pass(elementName + " is clicked successfully");
    }

    public static void click(By by, WaitType waitType, String elementName) {
        if (waitType == WaitType.PRESENCE) {
            waitUntilElementPresent(by).click();
        } else if (waitType == WaitType.CLICKABLE) {
            waitUntilElementClickable(by).click();
        } else if (waitType == WaitType.VISIBLE) {
            waitUntilElementVisible(by).click();
        }
        ExtentLogger.pass(elementName + " is clicked successfully");
    }

    public static void sendKeys(By by, String requiredUserData, String elementName) {
        waitUntilElementPresent(by).sendKeys(requiredUserData);
        ExtentLogger.pass(requiredUserData + " is entered successfully in " + elementName);
    }

    public static void sendKeys(By by, WaitType waitType, String requiredUserData, String elementName) {
        if (waitType == WaitType.VISIBLE) {
            waitUntilElementClickable(by).sendKeys(requiredUserData);
        }
        ExtentLogger.pass(requiredUserData + " is entered successfully in " + elementName);
    }

    public static String getText(By by) {
        return waitUntilElementVisible(by).getText();
    }

    public static void selectValueInDropDown(By by, Consumer<Select> consumer) {
        WebElement element = waitUntilElementPresent(by);
        Select select = new Select(element);
        consumer.accept(select);
        ExtentLogger.pass(consumer + " is selected from DropDown");
    }

    public static void clickElementByJS(By by, String elementName) {
        WebElement webElement = waitUntilElementPresent(by);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", webElement);
        ExtentLogger.pass(elementName + " is clicked successfully");
    }

    public static void clearElementByJS(By by) {
        WebElement webElement = waitUntilElementPresent(by);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value = '';", "");
    }

    public static boolean getTableData(By tableRow, By tableColumn, String xpathCellData, String valueToFind) {
        int rowCount = waitUntilElementVisible(tableRow).findElements(tableRow).size();
        int colcount = waitUntilElementVisible(tableColumn).findElements(tableColumn).size();
        boolean flag = false;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 2; j <= colcount; j++) {
                String capturedText = waitUntilElementVisible(LocatorFactory.getLocator("xpath", String.format(xpathCellData, i, j))).getText();
                if (capturedText.equalsIgnoreCase(valueToFind)) {
                    flag = true;
                    ExtentLogger.pass(valueToFind + " is found in the table");
                    break;
                }
            }
            if (flag) {
                break;
            }
            ExtentLogger.fail(valueToFind + " is not found in the table");
            return flag;

        }
        return flag;
    }

        private static WebElement waitUntilElementPresent (By by){
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
        private static WebElement waitUntilElementClickable (By by){
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        }
        private static WebElement waitUntilElementVisible (By by){
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }


    public static void clickOnTableCellByName(By tableRow, By tableColumn, String xpathCellData, String valueToFind) {
        int rowCount = waitUntilElementVisible(tableRow).findElements(tableRow).size();
        int colcount = waitUntilElementVisible(tableColumn).findElements(tableColumn).size();
        boolean flag = false;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 2; j <= colcount; j++) {
                String capturedText = waitUntilElementVisible(LocatorFactory.getLocator("xpath", String.format(xpathCellData, i, j))).getText();
                if (capturedText.equalsIgnoreCase(valueToFind)) {
                    flag = true;
                    ExtentLogger.pass(valueToFind + " is found in the table");
                    break;
                }
            }
            if (flag) {
                break;
            }
            ExtentLogger.fail(valueToFind + " is not found in the table");
        }

    }

    }
