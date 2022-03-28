package com.test.openChart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.SQLOutput;

public class OpenChartMainPage {
    public   OpenChartMainPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[.='12K']")
    WebElement totalOrders;
    @FindBy(xpath = "//h2[.='11.8M']")
    WebElement totalSales;
    @FindBy(xpath = "//h2[.='145.3K']")
    WebElement totalCustomers;
    @FindBy(xpath = "menu-customer")
    WebElement customersPage;

    public  void  totalOrdersValidation(){
    totalOrders.getText().trim();
    String orders=totalOrders.getText().trim();
        System.out.println(totalOrders.getText().trim());
        Assert.assertTrue(orders.contains("12K"));
    }
    public boolean totalSalesValidation(){
        totalSales.getText().trim();
        if(totalSales.equals("11.8M")){
            return true;
        }
        return false;
    }
    public boolean totalCustomerValidation(){
        totalCustomers.getText().trim();
        if(totalCustomers.equals("145.3K")){
        return true;
        }
        return false;
    }


      }









