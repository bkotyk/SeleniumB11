package com.test.orangehrm.tests;

import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PimPage;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PimPage pimPage;
    @BeforeMethod
    public  void  initializingPages(){

        loginPage=new LoginPage(driver);
        mainPage=new MainPage(driver);
        pimPage=new PimPage(driver);
    }
    @Test
    public  void ValidateTheCreationOfEmployee() throws InterruptedException {

        loginPage.login("Admin","admin123");
        mainPage.clickPIMButton();
        pimPage.addEmployyeForPIM("ahmet", "baldir", "1991", "/Users/dana/Desktop/usa.png");

        Assert.assertEquals(pimPage.validateFirstName(),"ahmet");
        Assert.assertEquals(pimPage.validateLastName(),"baldir");
        Assert.assertTrue(pimPage.validateEmployeeId("1991"));
    }
    @ Test
    public void  ValidatePersonalDetail() throws InterruptedException {
        loginPage.login("Admin","admin123");
        mainPage.clickPIMButton();
        pimPage.addEmployyeForPIM("ahmet", "baldir", "1991", "/Users/dana/Desktop/usa.png");
        pimPage.editPersonalDetails("Ukrainian","1986-07-17","Married");
   Assert.assertEquals(pimPage.ValidateTheNationality(),"Ukrainian");
    }


}
