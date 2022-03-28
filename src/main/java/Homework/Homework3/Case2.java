package Homework.Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Case2 {

    /*Steps
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Select Price (low-high) from drop down box
Validate the products are displayed according to their price
and they are displayed low price to high price
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


        WebElement nameSelection= driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        WebElement priceLowToHigh =driver.findElement(By.xpath("//option[.='Price (low to high)']"));
        priceLowToHigh.click();



        List<WebElement> ascendingAllOptions = driver.findElements(By.xpath("//option[.='Price (low to high)']"));
        List<String> actualLowtoHightOrder = new LinkedList<>();
        List<String> expectedLowToHighOrder = new ArrayList<>();

        for (int i = 0; i <ascendingAllOptions.size(); i++) {
            actualLowtoHightOrder.add(ascendingAllOptions.get(i).getText().trim());
            expectedLowToHighOrder.add(ascendingAllOptions.get(i).getText().trim());
            Collections.sort(expectedLowToHighOrder);
            Collections.reverse(expectedLowToHighOrder);


        }
        Assert.assertEquals(actualLowtoHightOrder, expectedLowToHighOrder);


    }}
