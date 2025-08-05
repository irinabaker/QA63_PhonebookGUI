package com.phonebook.tests;

import com.phonebook.core.TestBase;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.phonebook.core.ApplicationManager.softAssert;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test(priority = 2,groups = "empty")
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().clearEmailField();
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword("Manuel1234$"));
        app.getUser().clearEmailField();
        app.getUser().clickOnLoginButton();
       softAssert.assertTrue(app.getUser().isAlertPresent());
       softAssert.assertTrue(app.getUser().isErrorMessagePresent());
       softAssert.assertAll();
    }

    @Test(priority = 3,groups = "empty")
    public void loginNegativeWithoutPasswordTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com"));
        app.getUser().clearPasswordField();
        app.getUser().clickOnLoginButton();
       softAssert.assertTrue(app.getUser().isAlertPresent());
       softAssert.assertTrue(app.getUser().isErrorMessagePresent());
       softAssert.assertAll();
    }

}
