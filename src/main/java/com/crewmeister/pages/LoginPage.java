package com.crewmeister.pages;

import com.crewmeister.utils.SeleniumUtils;
import org.openqa.selenium.By;

public final class LoginPage {

    private static final By TXT_USERNAME=By.name("identifier");
    private static final By TXT_PASSWORD=By.name("password");
    private static final By BTN_SIGNIN      =By.id("user-sign-in");
    private static final By TITLE_MSG=By.xpath("//h1");


    private LoginPage setUserName(String userName){
        SeleniumUtils.sendKeys(TXT_USERNAME,userName,"username");
        return this;
    }

    private LoginPage setPassword(String password){
        SeleniumUtils.sendKeys(TXT_PASSWORD,password,"password");
        return this;
    }

    public String getTitle(){
        return  SeleniumUtils.getText(TITLE_MSG);

    }
    private   TimeOverViewPage clickOnSignInBtn(){
        SeleniumUtils.click(BTN_SIGNIN,"signin button");
        return new TimeOverViewPage();
    }

    public TimeOverViewPage loginToApplication(String userName,String password){
        return setUserName(userName).setPassword(password).clickOnSignInBtn();
    }
//    public String getNotifierLabelText(){
//        return SeleniumUtils.getText(LINK_SIGNOUT);
//    }

}
