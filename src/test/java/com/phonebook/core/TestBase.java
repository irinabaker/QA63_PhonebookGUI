package com.phonebook.core;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));

   // @BeforeMethod
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.init();
    }

   // @AfterMethod(enabled = true)
    @AfterSuite(enabled = true,alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
