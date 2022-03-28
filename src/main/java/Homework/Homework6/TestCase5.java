package Homework.Homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase5 {
    /*Validate MSRP price is matching under Selected Feature
and Inside the Summary
Validate Total of selected Equipment price is equals to
Color Price+ Wheel Price + Airbag + Convenience package
Validate total price is equals to MSRP + Equipment price +
Destination Charge
Steps*/
    @Test
    public  void TestCase5() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.audiusa.com/");
        driver.manage().window().maximize();
    }
    }
