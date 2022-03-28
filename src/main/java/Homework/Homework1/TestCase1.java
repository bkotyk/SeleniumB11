package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");



        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Bogdana Kotyk");

        WebElement email= driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("bogdana@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("1800 Hollister Dr, Libertyville, Il 60048");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("4711 W Golf Rd, Skokie, Il, 60076");


        WebElement button= driver.findElement(By.xpath("//button[@id='submit']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
       button.click();

       WebElement nameValidation = driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(nameValidation.getText());
        String expectedValidation = "Name:Bogdana Kotyk";
        String actualValidation = nameValidation.getText();
        if(expectedValidation.equals(actualValidation)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }



    }
}
