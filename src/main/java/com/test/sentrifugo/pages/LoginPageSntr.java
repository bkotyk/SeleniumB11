package com.test.sentrifugo.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSntr {
    public LoginPageSntr(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='username']" )
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement pasword;

    @FindBy(id = "loginsubmit")
    WebElement loginButton;

   // public void login() {
     //   username.sendKeys("EM01");
      //  pasword.sendKeys("sentrifugo");
      //  loginButton.click();
   // }
    public  void  dynamicLogin(String username, String password){
        this.username.sendKeys(username);
        this.pasword.sendKeys(password);
        this.loginButton.submit();
    }
}
