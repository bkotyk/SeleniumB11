package com.test.mercedes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercedesPage {
    public MercedesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html/body/div[1]/div[1]/cmm-cookie-banner//div/div/div[2]/div[2]/div/button[3]")
    WebElement cookieButton;

}
