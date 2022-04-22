package com.crewmeister.tests;

import com.crewmeister.locatorFactories.LocatorFactory;
import com.crewmeister.pages.LoginPage;
import com.crewmeister.pages.TimeOverViewPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TimeOverViewPageTests extends BaseTest {

   @Test
    public void validateUserAbleToSignIn(){
       String notifierLabelText = new LoginPage()
               .loginToApplication("crewmeister-qa5@mailinator.com", "apxm963d")
               .getNotifierLabelText();
       Assertions.assertThat(notifierLabelText).isEqualTo("Signed in successfully.");

   }
}
