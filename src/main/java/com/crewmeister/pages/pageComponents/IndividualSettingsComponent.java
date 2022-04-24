package com.crewmeister.pages.pageComponents;

import com.crewmeister.driver.DriverManager;
import com.crewmeister.driver.LocalDriverFactory;
import com.crewmeister.enums.WaitType;
import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.utils.SeleniumUtils;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

public final class IndividualSettingsComponent {

    private String toggleBar="//*[text()='%s']/../parent::div";
    private static final  By saveButton=By.xpath("//*[text()='Save']/parent::button");

    public void toggleToDesiredTeam(String locator, String value){
        DriverManager.getDriver().navigate().refresh();
        SeleniumUtils.clickElementByJS(LocatorFactory.getLocator(locator,String.format(toggleBar,value)),value);
        SeleniumUtils.click(saveButton,"Save Button");

    }
}
