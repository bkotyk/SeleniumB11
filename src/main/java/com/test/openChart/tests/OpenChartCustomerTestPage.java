package com.test.openChart.tests;

import com.test.openChart.pages.OpenChartCustomerPage;
import com.test.openChart.pages.OpenChartLoginPage;
import com.test.openChart.pages.OpenChartMainPage;
import org.testng.annotations.Test;

public class OpenChartCustomerTestPage extends TestBaseOpenChart{
    @Test
    public void customerPageInfoValidation(){
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.loginToOpenChart("demo", "demo");
       OpenChartMainPage openChartMainPage=new OpenChartMainPage(driver);
        OpenChartCustomerPage openChartCustomerPage=new OpenChartCustomerPage(driver);
        openChartCustomerPage.clickCustomerPage();
        openChartCustomerPage.clickCustomerButton();
        openChartCustomerPage.clickAddButton();
        openChartCustomerPage.sendingCustomerInfo();
        openChartCustomerPage.messageValidation();
        openChartCustomerPage.colorValidation();

    }

}
