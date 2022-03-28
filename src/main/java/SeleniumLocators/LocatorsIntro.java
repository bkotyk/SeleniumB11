package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("file:///Users/dana/Desktop/Techtorial%20(2).html");

        //getText()- - it gives you text of the element.
        WebElement header =driver.findElement(By.id("techtorial1"));
       String actualText= header.getText();
       String expectedText="Techtorial Academy";//from the business requirement
        if(actualText.equals(expectedText)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement paragraph= driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());
        if(paragraph.getText().equals("To create your account, we'll need some basic information about you." +
                " This information will be used to send reservation " +
                "confirmation emails, mail tickets when needed and contact you if your travel arrangements change. " +
                "Please fill in the form completely.")){
            System.out.println("passes");
        }else{
            System.out.println("failed");
        }
        //Locator: ClassName();
        WebElement tools= driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());

        //Locator: Name
        WebElement name= driver.findElement(By.name("firstName"));
        name.sendKeys("Bogdana");

        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Kotyk");

        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("773-946-1372");

        WebElement email= driver.findElement(By.name("userName"));
        email.sendKeys("bkotyk@yahoo.com");

        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("675 W Natalie Ln");

        //
        WebElement javaBox=driver.findElement(By.id("cond3"));
        javaBox.click();

        WebElement javaBox1=driver.findElement(By.id("cond4"));
        javaBox1.click();



        System.out.println(javaBox.isDisplayed());//return true;
        System.out.println(javaBox.isSelected());//return true




    }
}
