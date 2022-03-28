package Homework.Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
    /* Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Click picture of the Salmon Teriyaki
Click Add to cart button 2 times
Validate total price is $26
Validate item number is 1
Click > arrow button
Click add to cart for Gohan
Validate total price is $29
Validate total items 2*/


    @Test
    public  void TestCase3(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        WebElement SalmonTeriyaki= driver.findElement(By.xpath("//img[@title='Salmon Teriyaki']"));
       Actions actions = new Actions(driver);
       BrowserUtils.ClickWithJS(driver, SalmonTeriyaki);
        WebElement addSTtoCart= driver.findElement(By.xpath("//button[@class='buy']"));
       addSTtoCart.click();
       addSTtoCart.click();
       WebElement totalPrice= driver.findElement(By.xpath("//p[@class='total-price']"));
       String actualTotalPrice=BrowserUtils.getTextMethod(totalPrice);
       String expectedTotalPrice="$26.00";
        Assert.assertEquals(actualTotalPrice,expectedTotalPrice);
        WebElement itemValidation= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualItemNumber=BrowserUtils.getTextMethod(itemValidation);
        System.out.println(itemValidation.getText());
        String expectedItemNumber="1";
        Assert.assertEquals(actualItemNumber,expectedItemNumber);
        WebElement rightArrowButton= driver.findElement(By.xpath("//a[@id='navigate-next']"));
        rightArrowButton.click();
        WebElement addToCartforGohan= driver.findElement(By.xpath("//button[@class='buy']"));
        addToCartforGohan.click();
        WebElement totalPriceOfItems= driver.findElement(By.xpath("//p[@class='total-price']"));
        String actualTP=BrowserUtils.getTextMethod(totalPriceOfItems);
        String expectedTP="$29.00";
        Assert.assertEquals(actualTP,expectedTP);
        WebElement totalItemsN= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualTOfI=BrowserUtils.getTextMethod(totalItemsN);
        String expectedTOfI="2";


    }




}
