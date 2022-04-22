package com.crewmeister.pages.pageComponents;

import com.crewmeister.driver.DriverManager;
import com.crewmeister.enums.WaitType;
import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.pages.LoginPage;
import com.crewmeister.utils.SeleniumUtils;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class TopMenuComponent {
    private  String  menuItem="//div[text()='%s']/../parent::a";
    private  static By notifierLabel= By.xpath("//div[@component='label']/span");
    private  static final By LINK_SIGNOUT= By.id("navigation-sign-out");



    @SneakyThrows
    public <T> T clickOnTopMenuItem(String locator, String topMenuName, Class<T> tClass){
        SeleniumUtils.click(LocatorFactory.getLocator(locator, String.format(menuItem,topMenuName)),topMenuName);
        return tClass.newInstance();

    }

    public String getNotifierLabelText(){
       return SeleniumUtils.getText(notifierLabel);
    }
    public LoginPage clickOnSignOut(){
        SeleniumUtils.clickElementByJS(LINK_SIGNOUT,"Sign-Out");
        return new LoginPage();
    }

}
