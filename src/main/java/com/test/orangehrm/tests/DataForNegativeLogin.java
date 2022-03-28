package com.test.orangehrm.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.jws.Oneway;

public class DataForNegativeLogin {
    @DataProvider(name = "loginNegativeTestScenario")
    public  Object[][] getNegativeScenarioData(){
        return new Object[][]{
                {"Admin", "wrongPassword","Invalid Credentials"},
                {"wrongusername","admin123","Invalid Credentials"},
                {"wrongusername","wrongpassword","Invalid Credentials"}
        };

   }

}
