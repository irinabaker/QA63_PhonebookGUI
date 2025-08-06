package com.phonebook.tests;

import com.phonebook.core.TestBase;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.MyDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Karl")
                .setLastName("Adam")
                .setPhone("1234567890")
                .setEmail("karl@gm.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @Test(dataProvider = "addNewContact", dataProviderClass = MyDataProvider.class)
    public void addContactFromDataProviderPositiveTest(String name, String lastName, String phone,
                                                       String email, String address, String desc) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(desc));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated(name));
    }

    @Test(dataProvider = "addNewContactFromCsv",dataProviderClass = MyDataProvider.class)
    public void addContactFromDataProviderWithCsvFilePositiveTest(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated(contact.getName()));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

}
