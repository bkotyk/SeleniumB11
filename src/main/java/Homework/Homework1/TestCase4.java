package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();

        WebElement username=driver.findElement(By.name("user-name"));
        username.sendKeys("standard_user");

        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("fail");
        }



    }
}
