package Homework.Homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class TestCase4 {
    /*Add Convenience package
Validate Remove text is displayed
Click Add for Rear side thoracic airbags
 Verify it is selected
 Verify Optional Equipment price is equals to Color Price
+ Black Option Package Price +  Convenience package +
Rear Side Airbags
 Verify Total price is equals to MSRP+Optional
Equipment + Destination Charge
 */
    @Test
    public  void TestCase4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.audiusa.com/");
        driver.manage().window().maximize();

    }
}
