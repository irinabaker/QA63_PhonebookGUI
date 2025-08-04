package com.phonebook.core;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

   // @BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }

   // @AfterMethod(enabled = true)
    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
