package com.crewmeister.driver;
import com.crewmeister.configs.ConfigFactory;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public final class Driver {

    private Driver(){}

    public static void initDriver(){
        String browser = ConfigFactory.getConfig().browser();
        String runmode= ConfigFactory.getConfig().runmode();
        WebDriver driver = DriverFactory.getDriver(runmode,browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(), TimeUnit.SECONDS);
        DriverManager.getDriver().get(ConfigFactory.getConfig().url());
    }
    public static void quitDriver(){
        DriverManager.getDriver().quit();
    }
}