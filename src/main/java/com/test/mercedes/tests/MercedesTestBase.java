package com.test.mercedes.tests;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MercedesTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){

        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("urlmercedes"));
    }
    @AfterMethod
    public  void tearDown() {
        // DriverHelper.tearDown();
        //  driver.quit();


    }}