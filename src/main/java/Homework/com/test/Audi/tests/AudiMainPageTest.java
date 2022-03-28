package Homework.com.test.Audi.tests;

import Homework.com.test.Audi.pages.AudiMainPage;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AudiMainPageTest extends AudiTestBase {
    @Test
    public void testStartingPage(){
        AudiMainPage audiMainPage=new AudiMainPage(driver);
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://www.audiusa.com/");
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        List<WebElement> wagonsandSuv=audiMainPage.allSuvandWagons;
        for(int i=0; i<wagonsandSuv.size();i++){
            wagonsandSuv.get(i).click();
            System.out.println(wagonsandSuv.get(i).getText());
            driver.navigate().back();
            driver.navigate().refresh();

    }}
    @Test
    public  void productValidation() throws InterruptedException {
        AudiMainPage audiMainPage=new AudiMainPage(driver);
        audiMainPage.clickCookieButton();
        audiMainPage.cLickSUVbutton();
        audiMainPage.clickQ5Button();
       // Assert.assertTrue(audiMainPage.nameValidation());
        audiMainPage.clickBuildButton();
        audiMainPage.startingPriceValidation();



        }
    }

