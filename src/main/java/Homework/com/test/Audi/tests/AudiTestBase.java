package Homework.com.test.Audi.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AudiTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.audiusa.com/");
        driver.manage().window().maximize();
        System.out.println(" I am running before every test annotation");
    }
    @AfterMethod
    public  void tearDown(){
        System.out.println(" I am running after test annotation");
        //  driver.quit();
    }

}


