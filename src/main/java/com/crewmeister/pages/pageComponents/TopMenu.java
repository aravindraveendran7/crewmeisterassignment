package com.crewmeister.pages.pageComponents;

import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.utils.SeleniumUtils;

public final class TopMenu {
    private  String  menuItem="//div[text()='%s']/../parent::a";

    public void clickOnTopMenuItem(String locator,String topMenuName){
        SeleniumUtils.click(LocatorFactory.getLocator(locator, String.format(menuItem,topMenuName)),topMenuName);
    }

}
