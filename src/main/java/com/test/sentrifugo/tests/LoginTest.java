package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPageSntr;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    //  @Test
    //  public  void ValidateSuperAdmin(){
      /*  WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();


        WebElement username= driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("EM01");

        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("sentrifugo");
        WebElement login= driver.findElement(By.id("loginsubmit"));
        login.submit();*/

    //  }
    @Test
    public void ValidateSuperAdmin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPageSntr loginPage = new LoginPageSntr(driver);
        loginPage.dynamicLogin("EM05", "sentrifugo");
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualURL, expectedURL);


    }

    @Test
    public void ValidateManagement() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPageSntr loginPage = new LoginPageSntr(driver);
        loginPage.dynamicLogin("EM02", "sentrifugo");
        String actualURL = driver.getTitle();
        String expectedURL = "Sentrifugo - Open Source HRMS";
        Assert.assertEquals(actualURL, expectedURL);


    }
}