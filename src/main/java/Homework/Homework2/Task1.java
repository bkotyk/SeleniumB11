package Homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.bind.SchemaOutputResolver;

public class Task1 {

    public static void main(String[] args) {
        /*CREATING AN ACCOUNT FOR AMAZON:
1-NAVIGATE TO THE WEBSITE https://www.amazon.com/
2_Click Hello, Sign in Button
3-Click Create your amazon account button
4-Fill the information and click Continue Button
5-If there is an error or message. Validate it, if not then you completed the task */

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        WebElement helloSignInButton=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        helloSignInButton.click();

        WebElement createAccount= driver.findElement(By.id("createAccountSubmit"));
        createAccount.click();

        WebElement myName=driver.findElement(By.name("customerName"));
        myName.sendKeys("Bogdana Kotyk");

        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("dana@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@name='passwordCheck']"));
        password.sendKeys("Bogdana!!");

        WebElement passwordReeter=driver.findElement(By.xpath("//input[@id='ap_password']"));
        passwordReeter.sendKeys("Bogdana!!");

       WebElement continueBotton=driver.findElement(By.xpath("//input[@id='continue']"));
       continueBotton.click();

       WebElement message=driver.findElement(By.xpath("//h4[contains(text(), 'Email address already in use')]"));
       System.out.println(message.getText());

       String actualMessage=message.getText();
       String expectedMessage= "Email address already in use";
       if(actualMessage.equals(expectedMessage)){
           System.out.println("Pass");
       }else{
           System.out.println("fail");


       }

    }
}
