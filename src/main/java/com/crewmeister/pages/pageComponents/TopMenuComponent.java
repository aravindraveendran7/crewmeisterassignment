package com.crewmeister.pages.pageComponents;

import com.crewmeister.enums.WaitType;
import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.pages.LoginPage;
import com.crewmeister.utils.SeleniumUtils;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

public final class TopMenuComponent {
    private  static final By  LINK_SETTINGS=By.xpath("//div[text()='Settings']/../parent::a");
    private  static final By LINK_TIME_TRACKING=By.xpath("//div[text()='Time Tracking']/../parent::a[contains(@href,'time-tracking')]");
    private  static final By NOTIFIER_LABEL = By.xpath("//div[@component='label']/span");
    private  static final By LINK_SIGNOUT= By.id("navigation-sign-out");

//    @SneakyThrows
//    public <T> T clickOnTopMenuItem(String locator, String topMenuName,WaitType waitType,Class<T> tClass){
//        SeleniumUtils.click(LocatorFactory.getLocator(locator, String.format(menuItem,topMenuName)),WaitType.CLICKABLE,topMenuName);
//        return tClass.newInstance();
//    }

    public void clickOnTimeTracking(){
        SeleniumUtils.click(LINK_TIME_TRACKING,"Link Time Tracking Menu");
    }

    public void clickOnSettings(){
        SeleniumUtils.click(LINK_SETTINGS,"Settings Menu");
    }
    public String getNotifierLabelText(){
       return SeleniumUtils.getText(NOTIFIER_LABEL);
    }
    public void clickOnSignOut(){
        SeleniumUtils.clickElementByJS(LINK_SIGNOUT,"Sign-Out");
//        return new LoginPage();
    }

}
