package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement yes = driver.findElement(By.id("//input[@id='yesRadio']"));
        yes.click();

    }
}
