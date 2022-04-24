package com.crewmeister.pages.pageComponents;

import com.crewmeister.pages.SettingsPage;
import com.crewmeister.utils.SeleniumUtils;
import org.openqa.selenium.By;

public final class AddNewEmployeeComponent {

    private  static final By TXT_EMPLOYEE_NAME= By.xpath("//input[contains(@id,'create-1-name')]");
    private  static final By TXT_EMPLOYEE_EMAIL = By.xpath("//input[contains(@id,'create-1-email')]");
    private  static final By SELECT_LANGUAGE = By.xpath("//select[contains(@id,'create-1-language')]");
    private  static final By BTN_SAVE= By.xpath("//button[contains(@id,'create-1-button-save')]");


    private AddNewEmployeeComponent setEmployeeName(String employeeName){
        SeleniumUtils.sendKeys(TXT_EMPLOYEE_NAME,employeeName,"Employee Name");
        return  this;
    }

    private AddNewEmployeeComponent setEmployeeEmail(String employeeEmail){
        SeleniumUtils.sendKeys(TXT_EMPLOYEE_EMAIL,employeeEmail,"Employee Email");
        return  this;
    }

    private AddNewEmployeeComponent selectLanguage(String selectLanguage){
        SeleniumUtils.selectValueInDropDown(SELECT_LANGUAGE, select -> select.selectByValue(selectLanguage),selectLanguage);
        return  this;
    }
    private SettingsPage clickOnSaveBtn(){
        SeleniumUtils.click(BTN_SAVE,"Save Button");
        return  new SettingsPage();
    }

    public SettingsPage AddNewEmployee(String employeeName,String employeeEmail,String language){
        return setEmployeeName(employeeName)
                .setEmployeeEmail(employeeEmail)
                .selectLanguage(language)
                .clickOnSaveBtn();
    }


}
