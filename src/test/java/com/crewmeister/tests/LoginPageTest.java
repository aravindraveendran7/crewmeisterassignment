package com.crewmeister.tests;

import com.crewmeister.pages.LoginPage;
import com.crewmeister.testdata.TestData;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(description = "To validate whether user can successfully sign out from the application")
    public void  validateUserCanSignOut(){
        String welcomemsg = new LoginPage()
                .loginToApplication("crewmeister-qa5@mailinator.com", "apxm963d")
                .clickOnSignOut().getTitle();
        Assertions.assertThat(welcomemsg).containsIgnoringCase("welcome");
    }
}
