package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class LinksAndTags {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("file:///Users/dana/Desktop/Techtorial%20(2).html");
        driver.manage().window().maximize();

        WebElement javaLink= driver.findElement(By.linkText("Java"));
        javaLink.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();

        WebElement javaLink1= driver.findElement(By.linkText("Selenium"));
        javaLink1.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();

        javaLink= driver.findElement(By.linkText("Java"));
        javaLink.click();

        WebElement javaLink2= driver.findElement(By.linkText("Cucumber"));
        javaLink2.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();

        //partial link text;

        WebElement restApi= driver.findElement(By.partialLinkText("Rest Api"));
        restApi.click();
        driver.navigate().back();

        //tag Name
        WebElement version=driver.findElement(By.tagName("u"));
        System.out.println(version.getText());
        



    }
}
