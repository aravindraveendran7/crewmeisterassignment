package com.crewmeister.tests;

import com.crewmeister.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void  test1(){
        new LoginPage()
                .loginToApplication("crewmeister-qa5@mailinator.com","apxm963d");
    }
}
