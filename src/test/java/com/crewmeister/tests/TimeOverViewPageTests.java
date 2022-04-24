package com.crewmeister.tests;

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

//    @Test(description = "To validate whether user is able to see member in Time Tracking overview")
//    public void validateMemberNameIsDisplayed(){
//        Boolean flag = new LoginPage()
//                .loginToApplication("crewmeister-qa5@mailinator.com", "apxm963d")
//                .navigateToSettingsPage()
//                .setCrewName("crew2")
//                .addEmployeesToCrew()
//                .AddNewEmployee("testuser3", "testuse108@gmail.com", "en")
//                .addTeams("xpath", "Team name", "k1")
//                .navigateToTimeTrackingMenu("xpath", "Time Tracking")
//                .validateUserAddedIsAvailableInTable("1407 Test Crew 5");
//        Assertions.assertThat(flag).isTrue();
//    }

    @Test(dataProvider = "getData",description = "To validate whether user is able to enable team and member name from the drop down")
    public void validateTeamAndMemberIsEnabled(TestData testData){
        Boolean flag = new LoginPage()
                .loginToApplication("crewmeister-qa5@mailinator.com", "apxm963d")
                .navigateToSettingsPage()
                .setCrewName(testData.getCrewName())
                .addEmployeesToCrew()
                .AddNewEmployee(testData.getEmployeeName(), testData.getEmployeeEmail(), "en")
                .addTeams("xpath", "Team name", testData.getTeamName())
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
                        .setCrewName(new Faker().name().firstName())
                        .setEmployeeName(new Faker().name().lastName())
                        .setEmployeeEmail(new Faker().name().firstName()+new Faker().random().nextInt(1,100)+"@gmail.com")
                        .setTeamName("Team"+new Faker().random().nextInt(1,100))
                        .build()

                }

        };
    }
}
