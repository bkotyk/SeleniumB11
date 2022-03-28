package Homework.Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Case1 {
    /*Navigate to "https://www.saucedemo.com/"
     Enter username "standard_user"
    Enter password "secret_sauce"
    Click Login button
   Select Name (Z-A) from drop down box
   Validate the products are displayed in descending order
     Steps*/
    @Test
    public void ProductsInDescendingOrder(){
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
        WebElement namesZtoA=driver.findElement(By.xpath("//option[.='Name (Z to A)']"));
        namesZtoA.click();



        List<WebElement> descendingAllOptions = driver.findElements(By.xpath("//option[.='Name (Z to A)']"));
        List<String> actualDescendingOrder = new LinkedList<>();
        List<String> expectedDescendingOrder = new ArrayList<>();

        for (int i = 0; i < descendingAllOptions.size(); i++) {
            actualDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            expectedDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);


        }
        Assert.assertEquals(actualDescendingOrder, expectedDescendingOrder);



    }
}



