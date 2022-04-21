package com.crewmeister.pages;

import com.crewmeister.pages.pageComponents.TopMenu;

public final class TimeOverViewPage {
    TopMenu topMenu;
    public TimeOverViewPage(){
        topMenu=new TopMenu();
    }

    public void clickOnTopMenuItem(String locator,String topMenuItemName){
        topMenu.clickOnTopMenuItem(locator,topMenuItemName);

    }
}
