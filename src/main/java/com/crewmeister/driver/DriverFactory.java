package com.crewmeister.driver;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {
    private  DriverFactory(){}
    @SneakyThrows
    public  static WebDriver getDriver(String runmode, String browserName) {
        WebDriver driver = null;
        if (runmode.equalsIgnoreCase("local")) {
             driver = LocalDriverFactory.getLocalDriver(browserName);
        }
        else if(runmode.equalsIgnoreCase("remote")){
             driver = RemoteDriverFactory.getRemoteDriver(browserName);
        }
        return  driver;
    }
}