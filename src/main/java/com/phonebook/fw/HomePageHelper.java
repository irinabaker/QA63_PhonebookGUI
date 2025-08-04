package com.phonebook.fw;

import com.phonebook.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return  isElementPresent(By.xpath("//h1[.='Home Component']"));
    }

    public void clickOnHomeLink() {
        click(By.cssSelector("[href='/home']"));
    }
}
