package com.test.openChart.tests;

import com.test.openChart.pages.OpenChartLoginPage;
import com.test.openChart.pages.OpenChartMainPage;
import org.testng.annotations.Test;

public class OpenChartMainPageTest extends TestBaseOpenChart{
    @Test
    public void validationOfMainPageInfo(){

        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.loginToOpenChart("demo", "demo");

        OpenChartMainPage openChartMainPage=new OpenChartMainPage(driver);
        openChartMainPage.totalOrdersValidation();
        openChartMainPage.totalSalesValidation();
        openChartMainPage.totalCustomerValidation();

    }
}
