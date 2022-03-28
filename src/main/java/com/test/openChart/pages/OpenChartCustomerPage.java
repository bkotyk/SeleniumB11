package com.test.openChart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OpenChartCustomerPage {
    public OpenChartCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id ="menu-customer" )
    WebElement customerPage;
    @FindBy(xpath = "//a[.='Customers']")
    WebElement customersButton;
    @FindBy(xpath = "//i[@class='fa fa-plus']")
    WebElement addButton;
    @FindBy(id = "input-customer-group")
    WebElement customerGroup;
    @FindBy(name = "firstname")
    WebElement firstName;
    @FindBy(name = "lastname")
    WebElement lastName;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "telephone")
    WebElement telephone;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(name = "confirm")
    WebElement passwordConfirmation;
    @FindBy(id = "input-newsletter")
    WebElement newsletter;
    @FindBy(xpath = "//select[@id='input-status']")
    WebElement status;
    @FindBy(xpath = "//select[@id='input-safe']")
    WebElement safe;
    @FindBy(xpath = "//i[@class='fa fa-save']")
    WebElement saveButton;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//i")
    WebElement message;


    public void clickCustomerPage(){
        customerPage.click();
    }
    public void clickCustomerButton(){
        customersButton.click();
    }
    public  void clickAddButton(){
        addButton.click();
    }
    public void sendingCustomerInfo(){
        BrowserUtils.selectBy(customerGroup,"Default","text");
        firstName.sendKeys("Laura");
        lastName.sendKeys("Cohen");
        email.sendKeys("laurac12@gmail.com");
        telephone.sendKeys("773-906-1212");
        password.sendKeys("laura123!");
        passwordConfirmation.sendKeys("laura123!");
        BrowserUtils.selectBy(newsletter,"Enabled","text");
        BrowserUtils.selectBy(status,"Enabled","text");
        BrowserUtils.selectBy(safe,"Yes","text");
        saveButton.click();
    }
    public void messageValidation(){
        System.out.println(message.getText().trim().replace("!",""));
        String actualMessage=message.getText().trim();
        String expectedMessage="Warning: You do not have permission to modify customers!";
       Assert.assertEquals(actualMessage,expectedMessage);
    }
    public void colorValidation(){
        String actColorOfTheMessage=message.getCssValue("color");
        String expColotOfTheMesage="rgba(199, 47, 29, 1)";

        Assert.assertEquals(actColorOfTheMessage,expColotOfTheMesage);

    }
}