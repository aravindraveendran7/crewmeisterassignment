package com.crewmeister.pages;

import com.crewmeister.enums.WaitType;
import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.pages.pageComponents.AddNewEmployeeComponent;
import com.crewmeister.utils.SeleniumUtils;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.openqa.selenium.By;

public final class SettingsPage {

    private  static final By TXT_CREW_NAME = By.xpath("//input[contains(@id,'name')]");
    private  static final By BTN_EMPLOYEE_ADD = By.xpath("//button[contains(@id,'members-button-add')]");
    private  static final By BTN_TEAMS_ADD = By.xpath("//button[contains(@id,'teams-button-add')]");
    private  static final By BTN_SAVE= By.xpath("//button[contains(@id,'save')]");
    private  static final By CLOSE= By.xpath("(//*[name()='svg']//*[local-name()='path'])[2]");
    private  String txtNameByLabel="    //label[text()='%s']//following::input";


    private AddNewEmployeeComponent addNewEmployeeComponent;

    public SettingsPage(){
        addNewEmployeeComponent= new AddNewEmployeeComponent();
    }
    public SettingsPage setCrewName(String crewName){
        SeleniumUtils.click(CLOSE,"Clear Input Field");
        SeleniumUtils.sendKeys(TXT_CREW_NAME,WaitType.VISIBLE,crewName,"CrewName");
        SeleniumUtils.click(BTN_SAVE,"Save Button");
        return  this;
    }
    public SettingsPage addEmployeesToCrew(){
        SeleniumUtils.click(BTN_EMPLOYEE_ADD,WaitType.CLICKABLE,"Add Employee Button");
        return  this;
    }
    public SettingsPage addTeams(String locator,String enterLabelName,String teamName){
        SeleniumUtils.click(BTN_TEAMS_ADD,"Add Team Button ");
        SeleniumUtils.sendKeys(LocatorFactory.getLocator(locator,String.format(txtNameByLabel,enterLabelName)),teamName,"Team Name");
        SeleniumUtils.click(BTN_SAVE,"Save Button");
        return  this;
    }

//    public SettingsPage setTeamName(String locator,String teamName){
//        SeleniumUtils.click(LocatorFactory.getLocator(locator,teamName),"Team Name");
//    }
    public SettingsPage AddNewEmployee(String employeeName,String employeeEmail,String language){
        addNewEmployeeComponent.AddNewEmployee(employeeName,employeeEmail,language);
        return this;
    }


}
