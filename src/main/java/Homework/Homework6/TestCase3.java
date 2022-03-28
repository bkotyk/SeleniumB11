package Homework.Homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase3 {
    /*Highlight District Green metallic
 Validate color name is "District Green metallic"
Validate exterior color price is "$595"
 Click District Green metallic color
 Validate total price is equals to Color Price+MSRP+Destination
Charge
 Click 19" wheel
 Validate is displayed "19" 5-double-arm design wheels, bi-
color finish, with all-season tires $800"*/
    @Test
    public  void TestCase3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.audiusa.com/");
        driver.manage().window().maximize();

    }}
