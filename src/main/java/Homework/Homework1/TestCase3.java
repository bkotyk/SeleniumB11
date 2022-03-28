package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.StandardCharsets;

public class TestCase3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.saucedemo.com");

        WebElement userName= driver.findElement(By.name("user-name"));
        userName.sendKeys("Java");

        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("Selenium");

      WebElement login= driver.findElement(By.id("login-button"));
      login.click();

      WebElement errorValidation =driver.findElement(By.className("error-button"));
        System.out.println(errorValidation.getText());
        String expectedResult="Epic sadface: Username and password do not match any user in this service";
        String actualResult =errorValidation.getText();
        if(expectedResult.equals(actualResult)){
            System.out.println("pass");
        }else{
            System.out.println("fail");


        }
    }
}
