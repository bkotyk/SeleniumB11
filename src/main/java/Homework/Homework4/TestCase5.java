package Homework.Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class TestCase5 {
    /*Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Add 3 items to your cart
Click X button on the top added items
Validate items number is 2
Steps*/

    @Test public  void TestCase() throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        WebElement SashimiSalad= driver.findElement(By.xpath("//div/li[1]/button"));
        SashimiSalad.click();
        WebElement MisoSoup= driver.findElement(By.xpath("//div/li[5]/button"));
       MisoSoup.click();
       WebElement SeaweedSalad= driver.findElement(By.xpath("//div/li[3]/button"));
       SeaweedSalad.click();
       WebElement firsItem= driver.findElement(By.xpath("//div/li[1]/a[@data-bind='click: removeFromCart']"));
        WebElement secondItem= driver.findElement(By.xpath("//div/li[2]/a[@data-bind='click: removeFromCart']"));
       WebElement item3= driver.findElement(By.xpath("//div/li[3]/a[@data-bind='click: removeFromCart']"));
       Thread.sleep(5000);
       Actions actions = new Actions(driver);
       actions.moveToElement(firsItem).click().click().click().perform();
       WebElement itemNumber= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
      String actualItemNumberValidation= BrowserUtils.getTextMethod(itemNumber);
      String expectedItemNumberValidation="2";
      Assert.assertEquals(actualItemNumberValidation,expectedItemNumberValidation);
    }
}
