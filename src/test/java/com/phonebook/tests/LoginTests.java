package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234@"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setPassword("Manuel1234@"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());
    }

}
