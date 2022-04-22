package com.crewmeister.pages;

import com.crewmeister.pages.pageComponents.TopMenuComponent;
import lombok.SneakyThrows;

public final class TimeOverViewPage {
    TopMenuComponent topMenuComponent;
    public TimeOverViewPage(){
        topMenuComponent =new TopMenuComponent();
    }

    @SneakyThrows
    public <T> T clickOnTopMenuItem(String locator, String topMenuItemName, Class<T> tClass){
        topMenuComponent.clickOnTopMenuItem(locator,topMenuItemName,tClass);
        return tClass.newInstance();

    }
    public String getNotifierLabelText(){
        return topMenuComponent.getNotifierLabelText();
    }
    public LoginPage clickOnSignOut(){
        return topMenuComponent.clickOnSignOut();

    }


}
