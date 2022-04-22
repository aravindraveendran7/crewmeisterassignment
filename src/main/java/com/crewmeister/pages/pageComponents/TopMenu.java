package com.crewmeister.pages.pageComponents;

import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.utils.SeleniumUtils;
import org.openqa.selenium.By;

public final class TopMenu {
    private  String  menuItem="//div[text()='%s']/../parent::a";
    private  static By notifierLabel= By.xpath("//div[@component='label']/span");


    public void clickOnTopMenuItem(String locator,String topMenuName){
        SeleniumUtils.click(LocatorFactory.getLocator(locator, String.format(menuItem,topMenuName)),topMenuName);
    }

    public String getNotifierLabelText(){
       return SeleniumUtils.getText(notifierLabel);
    }

}
