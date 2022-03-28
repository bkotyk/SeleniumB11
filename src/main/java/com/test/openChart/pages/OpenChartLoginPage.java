package com.test.openChart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OpenChartLoginPage {

        public OpenChartLoginPage(WebDriver driver){

            PageFactory.initElements(driver, this);
        }
        @FindBy(xpath = "//input[@id='input-username']")
    WebElement username;
        @FindBy(xpath = "//input[@id='input-password']")
        WebElement password;
        @FindBy(xpath= "//button[@type='submit']")
    WebElement loginButton;

        public void  loginToOpenChart(String username, String password){
            this.username.clear();
             this.password.clear();
           this.username.sendKeys(username);
           this.password.sendKeys(password);
            this.loginButton.click();

        }





    }

