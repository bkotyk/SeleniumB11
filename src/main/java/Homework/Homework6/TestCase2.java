package Homework.Homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase2 {
    /*Select Premium Plus 45 TFSI
 Click View "View key MSRP info" button
 Validate MSRP is $44,100
Validate Additional Options is $595
Validate Destination Charge is $1,095
 Validate Total price is Base price + Additonal Options +
Destination Charge
Close the MSRP Info*/

    @Test
    public  void TestCase2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.audiusa.com/");
        driver.manage().window().maximize();

    }}
