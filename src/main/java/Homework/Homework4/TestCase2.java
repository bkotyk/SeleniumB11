package Homework.Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
    /*Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Click Add to cart for Edamame
Validate Item number is 1
Validate price of the product is $4
Click empty cart
Validate item number is 0*/


    @Test
    public void TestCase2(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        WebElement EdameName= driver.findElement(By.xpath("//strong[.='Edamame']"));
       EdameName.click();
       WebElement addtoCartButton= driver.findElement(By.xpath("//button[@data-bind='click: addToCart']"));
       addtoCartButton.click();
       WebElement itemNumberValidation= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
       String actualitemNumbervalidation=itemNumberValidation.getText();
       // System.out.println(itemNumberValidation.getText());
        String expectedItemNumberValidation="1";
        Assert.assertEquals(actualitemNumbervalidation,expectedItemNumberValidation);
        WebElement priceOfProduct= driver.findElement(By.xpath("//p[@class='total-price']"));
        String actualTP= BrowserUtils.getTextMethod(priceOfProduct);
        String expectedTP="$4.00";
        Assert.assertEquals(actualTP,expectedTP);
        WebElement emptyCardButton= driver.findElement(By.xpath("//a[@id='empty-cart']"));
        emptyCardButton.click();
        WebElement shopingCardInfo= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
       String actualShoppingCartValidation=BrowserUtils.getTextMethod(shopingCardInfo);
       String expectedShppingCartValidation="0";
       Assert.assertEquals(actualShoppingCartValidation,expectedShppingCartValidation);

    }
}
