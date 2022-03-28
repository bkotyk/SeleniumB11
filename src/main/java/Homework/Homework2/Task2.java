package Homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.sql.SQLOutput;

public class Task2 {
    public static void main(String[] args) {

/*TASK 2:Creating an account for nopcommerce and validation
1-NAVIGATE TO THE WEBSITE https://demo.nopcommerce.com/
2-Click Register
3-Fill the information
4-Newsletter box should be left unclicked
5-Click Register
6-Validate “Your registration completed”
7-Click Continue (edited)
demo.nopcommerce.comdemo.nopcommerce.com
nopCommerce demo store
nopCommerce is the open-source eCommerce solution. nopCommerce is available for free.
It has everything you need to get started in selling physical and digital goods over the internet.*/


        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

       WebElement register = driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2F']"));
        register.click();

        WebElement gender= driver.findElement(By.xpath("//input[@id='gender-female']"));
        gender.click();

        WebElement fistName= driver.findElement(By.xpath("//input[@id='FirstName']"));
        fistName.sendKeys("Bogdana");

        WebElement lastName=driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Kotyk");

        WebElement date=driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        date.sendKeys("12");

        WebElement monthOfBirth= driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        monthOfBirth.sendKeys("05");

        WebElement yearOfBirth= driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        yearOfBirth.sendKeys("1995");

        WebElement email= driver.findElement(By.xpath("//input[@name='Email']"));
        email.sendKeys("bogdanakotyk11@gmail.com");

        WebElement companyName= driver.findElement(By.xpath("//input[@id='Company']"));
        companyName.sendKeys("Medline");

        WebElement password= driver.findElement(By.xpath("//input[@name='Password']"));
        password.sendKeys("dana123!");
        WebElement passVerification= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        passVerification.sendKeys("dana123!");

        WebElement newsLetter=driver.findElement(By.xpath("//input[@id='Newsletter']"));
        boolean actual=newsLetter.isSelected();
        boolean expected=false;
        if(actual!=expected){
            newsLetter.click();
        }


        WebElement registerButton= driver.findElement(By.id("register-button"));
        registerButton.click();

      WebElement validationOfText= driver.findElement(By.xpath("//div[@class='result']"));
        System.out.println(validationOfText.getText());

        String actualResult=validationOfText.getText();
        String expectedResult="Your registration completed";
        if(actualResult.equals(expectedResult)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        WebElement continueButton= driver.findElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        continueButton.click();


    }
}
