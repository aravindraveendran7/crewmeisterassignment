package com.crewmeister.pages;

import com.crewmeister.enums.WaitType;
import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.pages.pageComponents.AddNewEmployeeComponent;
import com.crewmeister.pages.pageComponents.IndividualSettingsComponent;
import com.crewmeister.pages.pageComponents.TopMenuComponent;
import com.crewmeister.utils.SeleniumUtils;
import org.openqa.selenium.By;

public final class SettingsPage {

    private  static final By TXT_CREW_NAME = By.xpath("//input[contains(@id,'name')]");
    private  static final By BTN_EMPLOYEE_ADD = By.xpath("//button[contains(@id,'members-button-add')]");
    private  static final By BTN_TEAMS_ADD = By.xpath("//button[contains(@id,'teams-button-add')]");
    private  static final By BTN_SAVE= By.xpath("//button[contains(@id,'save')]");
    private  static final By CLOSE= By.xpath("(//*[name()='svg']//*[local-name()='path'])[2]");
    private  String txtNameByLabel="    //label[text()='%s']//following::input";
    private  static final By TABLE_ROW=By.xpath("(//table[@role='table'])[1]//tr[@role='row']");
    private  static final By TABLE_COL= By.xpath("(//table[@role='table'])[1]//th");
    private  static  String strXpathCell="(//table[@role='table']//tr[@id='row-%s']/td[%s])[1]";


    private AddNewEmployeeComponent addNewEmployeeComponent;
    private TopMenuComponent topMenuComponent;
    private IndividualSettingsComponent individualSettingsComponent;

    public SettingsPage(){
        addNewEmployeeComponent= new AddNewEmployeeComponent();
        topMenuComponent=new TopMenuComponent();
        individualSettingsComponent=new IndividualSettingsComponent();

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
    public SettingsPage AddNewEmployee(String employeeName,String employeeEmail,String language){
        addNewEmployeeComponent.AddNewEmployee(employeeName,employeeEmail,language);
        return this;
    }
    public TimeOverViewPage navigateToTimeTrackingMenu(String locator,String value){
      topMenuComponent.clickOnTimeTracking();
      return new TimeOverViewPage();
    }
    public  SettingsPage clickOnEmployeeByName(String valueToFind){
         SeleniumUtils.clickOnTableCellByName(TABLE_ROW,TABLE_COL,strXpathCell,valueToFind);
         return this;
    }
    public SettingsPage toggleToManageTeam(String locator,String value){
        individualSettingsComponent.toggleToDesiredTeam(locator,value);
        return  this;
    }



}
