package Homework.Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Case4 {
    /*Steps Part1
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Find the highest priced two product on the page
Add them to the cart
Click cart button
Click CheckOut Button
Steps*/

    @Test
    public void ProductsOrderFromLowtoHight(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement username= driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton= driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement highestProduct1= driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket"));
         highestProduct1.click();

       WebElement highestProduct2= driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
       highestProduct2.click();
       WebElement cartButton= driver.findElement(By.id("shopping_cart_container"));
       cartButton.click();

       WebElement checkOutButton= driver.findElement(By.id("checkout"));
      checkOutButton.click();

      //part 2
         /*Part2 Steps
      Fill out First Name, Last Name and Zip Code
      Click continue button
      Validate Item total price is equals to total price of
      selected product
      Validate Total is equals to Item Total price plus Tax
      amount
      Validate the Url contains "checkout"
      Click finish button
      Validate "THANK YOU FOR YOUR ORDER" message is
     displayed
    */

        WebElement fistName= driver.findElement(By.id("first-name"));
        fistName.sendKeys("Bogdana");

        WebElement lastname= driver.findElement(By.id("last-name"));
        lastname.sendKeys("Kotyk");


        WebElement zipCode= driver.findElement(By.id("postal-code"));
        zipCode.sendKeys("60101");

        WebElement continueButton= driver.findElement(By.id("continue"));
        continueButton.click();

        List<WebElement> totalprice=driver.findElements(By.className("summary_subtotal_label"));
        for(WebElement price:totalprice){
            System.out.println(price.getText());

            String actualItemTotalPriceBeforeTax=price.getText().trim();
            String expectedItemTotalPriceBeforeTax="Item total: $79.98";

            Assert.assertEquals(actualItemTotalPriceBeforeTax,expectedItemTotalPriceBeforeTax);


           // WebElement tax= driver.findElement(By.className("summary_tax_label"));

            String currentURL = driver.getCurrentUrl();
            Assert.assertTrue(driver.getCurrentUrl().contains("checkout"));


            WebElement finishButton= driver.findElement(By.id("finish"));
            finishButton.click();

            WebElement message=driver.findElement(By.xpath("//h2[.='THANK YOU FOR YOUR ORDER']"));
            System.out.println(message.getText());

            String actualDisplayedMessage=message.getText();
            String  expectedDisplayedMessage="THANK YOU FOR YOUR ORDER";

            Assert.assertEquals(actualDisplayedMessage,expectedDisplayedMessage);


        }
    }

}
