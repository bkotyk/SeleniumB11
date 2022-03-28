package com.test.orangehrm.tests;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




   public class LoginTest extends TestBase{
       LoginPage loginPage;
       @BeforeMethod
       public void initializePage(){
           loginPage=new LoginPage(driver);
       }

    @Test
    public void validateLoghinPositive(){
        //shorter code example:
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("oragehrmpassword"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }


    @Test(dataProvider = "LoginNegativeTestScenario",dataProviderClass = DataForNegativeLogin.class)
    public  void validateLoginNegative(String username, String password, String expectedMessage){

        LoginPage loginPage= new LoginPage(driver);
        loginPage.login(username, password);

        Assert.assertEquals(loginPage.getErrorMessage(),expectedMessage);
    }

//create two more negative scenarios(wrong username, correct password,//(wrong username, wrong password))
//    @Test
//    public  void validateLoginNegative2(){
//
//        LoginPage loginPage= new LoginPage(driver);
//        loginPage.login("", "");
//        String actualErrorMessage=loginPage.getErrorMessage();
//        String expectedErrorMessage="Username cannot be empty";
//        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
//
//   String actualColorOfErrorMessage=loginPage.getColorOftheErrorMessage();
//   String expectedColorOfErrorMessage="rgba(221, 119, 0, 1)";
//   Assert.assertEquals(actualColorOfErrorMessage,expectedColorOfErrorMessage);


    }
  //modify this page according to page model





