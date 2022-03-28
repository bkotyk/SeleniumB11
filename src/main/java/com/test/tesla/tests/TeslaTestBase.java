package com.test.tesla.tests;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TeslaTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get("https://www.tesla.com/");


    }
    @AfterMethod
    public  void tearDown(){
       // DriverHelper.tearDown();
        //  driver.quit();


    }}



