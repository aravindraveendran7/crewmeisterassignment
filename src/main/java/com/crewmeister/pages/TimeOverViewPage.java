package com.crewmeister.pages;

import com.crewmeister.driver.LocalDriverFactory;
import com.crewmeister.enums.WaitType;
import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.pages.pageComponents.TopMenuComponent;
import com.crewmeister.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.xml.sax.Locator;

import javax.rmi.CORBA.Tie;


public final class TimeOverViewPage {

    private  static final By TABLE_ROW=By.xpath("//table[@role='table']//tr");
    private  static final By TABLE_COL= By.xpath("//table[@role='table']//th");
    private  static  String strXpathCell="//table[@role='table']//tr[@id='row-%s']/td[%s]";
    private  static final By DROPDWN_SEARCH_TEAM=By.xpath("//div[@id='time-tracking-team-filter']");
    private  static final By DROPDWN_MEMBER_NAME=By.xpath("//div[@id='time-tracking-member-filter']");
    private String  selectCheckBoxByTeam="//div[@id='time-tracking-team-filter']//following::span[text()='%s']//following::input[@type='checkbox']";
    private String  selectCheckBoxByMember="//div[@id='time-tracking-member-filter']//following::span[text()='%s']//following::input[@type='checkbox']";

    TopMenuComponent topMenuComponent;
    public TimeOverViewPage(){
        topMenuComponent =new TopMenuComponent();
    }

    public SettingsPage navigateToSettingsPage(){
        topMenuComponent.clickOnSettings();
        return new SettingsPage();
    }
    public String getNotifierLabelText(){
        return topMenuComponent.getNotifierLabelText();
    }
    public LoginPage clickOnSignOut(){
         topMenuComponent.clickOnSignOut();
         return new LoginPage();
    }
    public  Boolean validateUserAddedIsAvailableInTable(String valueToFind){
        return SeleniumUtils.getTableData(TABLE_ROW,TABLE_COL,strXpathCell,valueToFind);

    }
    public TimeOverViewPage selectTeamToEnable(String locator,String teamToEnable){
        SeleniumUtils.click(DROPDWN_SEARCH_TEAM,WaitType.VISIBLE,"Team Member DropDown");
        SeleniumUtils.click(LocatorFactory.getLocator(locator,String.format(selectCheckBoxByTeam,teamToEnable)),WaitType.PRESENCE,teamToEnable);
        return this;
    }
    public TimeOverViewPage selectMemberNameToEnable(String locator,String memberToEnable){
        SeleniumUtils.click(DROPDWN_MEMBER_NAME,WaitType.VISIBLE,"Member Name DropDown");
        SeleniumUtils.click(LocatorFactory.getLocator(locator,String.format(selectCheckBoxByMember,memberToEnable)),WaitType.PRESENCE,memberToEnable);
        return this;
    }





}
