package com.crewmeister.tests;

import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.pages.LoginPage;
import com.crewmeister.pages.TimeOverViewPage;
import org.testng.annotations.Test;

public class TimeOverViewPageTests extends BaseTest {

   @Test
    public void test2(){
       new LoginPage()
               .loginToApplication("crewmeister-qa5@mailinator.com","apxm963d")
               .clickOnTopMenuItem("xpath","Time Tracking Reports");
   }
}
