package com.crewmeister.tests;

import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.pages.LoginPage;
import com.crewmeister.pages.SettingsPage;
import com.crewmeister.pages.TimeOverViewPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TimeOverViewPageTests extends BaseTest {

   @Test(description = "To validate whether user is able to sign in successfully")
    public void validateUserAbleToSignIn() {
       String notifierLabelText = new LoginPage()
               .loginToApplication("crewmeister-qa5@mailinator.com", "apxm963d")
//               .clickOnTopMenuItem("xpath","Settings")
               .getNotifierLabelText();
       Assertions.assertThat(notifierLabelText).isEqualTo("Signed in successfully.");
   }

       @Test(description = "To validate whether user is able to see the team added in Time Tracking overview")
       public void validateTeamAddedIsDisplayed(){
           new LoginPage()
                   .loginToApplication("crewmeister-qa5@mailinator.com", "apxm963d")
                   .clickOnTopMenuItem("xpath","Settings",SettingsPage.class)
                   .setCrewName("crew2")
                   .addEmployeesToCrew()
                   .AddNewEmployee("testuser3","testuser6@gmail.com","en")
                   .addTeams("xpath","Team name","k2");
       }
   }
