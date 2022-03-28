package com.test.tesla.tests;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import com.test.orangehrm.pages.MainPage;
import com.test.tesla.pages.TeslaPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeslaTest extends TeslaTestBase{
    @Test
    public void TestCase1(){
        TeslaPage teslaPage=new TeslaPage(driver);
        teslaPage.clickTeslaModelXButton();
        teslaPage.clickOrderNowButton();
        teslaPage.moveToPaintSection();
        teslaPage.clickBlueColorButton();
        teslaPage.colorValidation();
       Assert.assertTrue(teslaPage.colorValidation());

    }
    @Test
    public void TestCase2(){
        //Negative Scenario
        TeslaPage teslaPage=new TeslaPage(driver);
        teslaPage.clickTeslaModelXButton();
        teslaPage.clickOrderNowButton();
        teslaPage.moveToPaintSection();
        teslaPage.colorOptions();
        Assert.assertTrue(teslaPage.colorOptions());


    }
}






