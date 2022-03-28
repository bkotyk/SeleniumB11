package Homework.Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Case3 {
    /*Steps
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Find the cheapest two product on the page
Add them to the cart
Click cart button
Validate these two products is added to the cart
Steps*/

    @Test
    public void TwoProductsInTheCartValidation() throws InterruptedException {
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

        WebElement cheapestProduct1= driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        cheapestProduct1.click();
         Thread.sleep(1000);

        WebElement cheapestProduct2= driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        cheapestProduct2.click();
        Thread.sleep(1000);

     WebElement cartButton= driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
     cartButton.click();

     //Validate this two products were added to the cart
        List<String> shoppingCart= new ArrayList<>();
        for(int i=0; i<shoppingCart.size(); i++){
            Assert.assertTrue(shoppingCart.contains(cheapestProduct1.getText()));
            Assert.assertTrue(shoppingCart.contains(cheapestProduct2.getText()));

        }









}}
