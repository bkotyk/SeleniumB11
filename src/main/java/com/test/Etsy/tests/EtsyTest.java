package com.test.Etsy.tests;

import com.test.Etsy.pages.EtsyMainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyTest extends EtsyTestBase{
    @Parameters("itemSearch")
    @Test
    public void EtsySearchTest(String item){
        EtsyMainPage etsyMainPage=new EtsyMainPage(driver);
        etsyMainPage.searItem(item);
        Assert.assertTrue(etsyMainPage.validateHeader());
    }
}
