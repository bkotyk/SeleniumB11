package Homework.Homework6;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase1 {
    /*Navigate to "https://www.audiusa.com/"
Click SUVs & Wagons
 Get all the product prices for SUVs & Wagons
Select 2022 Q5
 Validate the car year and Q5 is matching
 Click Build button
Validate starting price is "44,100"
 Validate three version of car
Premium starting at 44,100 Premium Plus starting at
49,100 Prestige starting at 54,800
Validate three version has two different options
 45 TFSI
55 TFSI® e Plug-in hybrid*/
    @Test
    public void TestCase1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.audiusa.com/");
        driver.manage().window().maximize();
        WebElement bodyTypes= driver.findElement(By.xpath("//label[@for='nm-model-band-tab-nav-types-1183220']"));
        bodyTypes.click();

        WebElement SUVAndWagons= driver.findElement(By.xpath("//span[.='SUVs & Wagons']//span[.='SUVs & Wagon]"));
        SUVAndWagons.click();





    }
}
