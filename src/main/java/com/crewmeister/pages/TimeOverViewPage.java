package com.crewmeister.pages;

import com.crewmeister.pages.pageComponents.TopMenu;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public final class TimeOverViewPage {

    TopMenu topMenu;
    public TimeOverViewPage(){
        topMenu=new TopMenu();
    }

    public TimeOverViewPage clickOnTopMenuItem(String locator,String topMenuItemName){
        topMenu.clickOnTopMenuItem(locator,topMenuItemName);
        return this;
    }
    public String getNotifierLabelText(){
        return topMenu.getNotifierLabelText();
    }


}
