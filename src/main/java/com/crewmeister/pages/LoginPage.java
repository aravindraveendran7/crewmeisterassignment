package com.crewmeister.pages;

import com.crewmeister.utils.SeleniumUtils;
import org.openqa.selenium.By;

public final class LoginPage {

    private static final By TXT_USERNAME=By.name("identifier");
    private static final By TXT_PASSWORD=By.name("password");
    private static final By BTN_SIGNIN      =By.id("user-sign-in");

    public LoginPage setUserName(String userName){
        SeleniumUtils.sendKeys(TXT_USERNAME,userName,"username");
        return this;
    }

    public LoginPage setPassword(String password){
        SeleniumUtils.sendKeys(TXT_PASSWORD,password,"password");
        return this;
    }
    public  TimeOverViewPage clickOnSignInBtn(){
        SeleniumUtils.click(BTN_SIGNIN,"signin button");
        return new TimeOverViewPage();
    }

}
