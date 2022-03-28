package com.test.openChart.tests;

import com.test.openChart.pages.OpenChartLoginPage;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends TestBaseOpenChart{



        @Test
        public void validateLogin(){
            //shorter code example:

            OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
            openChartLoginPage.loginToOpenChart("demo", "demo");

        }}

