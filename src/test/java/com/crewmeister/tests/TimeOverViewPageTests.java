package com.crewmeister.tests;

import com.crewmeister.annotations.FrameworkAnnotation;
import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.pages.LoginPage;
import com.crewmeister.pages.SettingsPage;
import com.crewmeister.pages.TimeOverViewPage;
import com.crewmeister.testdata.TestData;
import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TimeOverViewPageTests extends BaseTest {

    @Test(dataProvider = "getData",description = "To validate whether user is able to see Owner of the crew in the in Time Tracking overview Page")
    @FrameworkAnnotation(author = "Aravind",catergory = "Smoke")
    public void validateMemberNameIsDisplayed(TestData testData){
        Boolean flag = new LoginPage()
                .loginToApplication(testData.getUsername(), testData.getPassword())
                .navigateToSettingsPage()
                .setCrewName(testData.getCrewName())
                .addEmployeesToCrew()
                .AddNewEmployee(testData.getEmployeeName(), testData.getEmployeeEmail(), "en")
                .addTeams("xpath", "Team name", testData.getTeamName())
                .navigateToTimeTrackingMenu("xpath", "Time Tracking")
                .validateUserAddedIsAvailableInTable("1407 Test Crew 5");
        Assertions.assertThat(flag).isTrue();
    }

    @Test(dataProvider = "getData",description = "To validate whether user is able to assign employee to a team and is diplayed in Time Tracking Page")
    @FrameworkAnnotation(author = "Aravind",catergory = "Regression")
    public void validateTeamAndMemberIsEnabled(TestData testData){
        Boolean flag = new LoginPage()
                .loginToApplication(testData.getUsername(), testData.getPassword())
                .navigateToSettingsPage()
                .setCrewName(testData.getCrewName())
                .addEmployeesToCrew()
                .AddNewEmployee(testData.getEmployeeName(), testData.getEmployeeEmail(), "en")
                .addTeams("xpath", "Team name", testData.getTeamName())
                .clickOnEmployeeByName(testData.getEmployeeName())
                .toggleToManageTeam("xpath",testData.getTeamName())
                .navigateToTimeTrackingMenu("xpath", "Time Tracking")
                .selectTeamToEnable("xpath", testData.getTeamName())
                .selectMemberNameToEnable("xpath", testData.getEmployeeName())
                .validateUserAddedIsAvailableInTable(testData.getEmployeeName());
        Assertions.assertThat(flag).isTrue();
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {TestData.builder()
                        .setUsername("crewmeister-qa5@mailinator.com")
                        .setPassword("apxm963d")
                        .setCrewName(new Faker().name().firstName())
                        .setEmployeeName(new Faker().name().lastName())
                        .setEmployeeEmail(new Faker().name().firstName()+new Faker().random().nextInt(1,100)+"@gmail.com")
                        .setTeamName("Team"+new Faker().random().nextInt(1,100))
                        .build()

                }

        };
    }
}
