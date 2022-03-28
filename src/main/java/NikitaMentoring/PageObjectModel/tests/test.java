package NikitaMentoring.PageObjectModel.tests;

import NikitaMentoring.PageObjectModel.pages.HomePage;
import NikitaMentoring.PageObjectModel.pages.optionsHeader.collectionPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test {
    @Test
    public void test1() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.nga.gov/");
        driver.manage().window().maximize();

        HomePage homePage=new HomePage(driver);
        homePage.choseOptionMenu("collection");
         Thread.sleep(5000);

         collectionPage collectionPage=new collectionPage();
        // scrollToElement(driver,clooction)

         homePage.choseOptionMenu("visit");

        }
    }

