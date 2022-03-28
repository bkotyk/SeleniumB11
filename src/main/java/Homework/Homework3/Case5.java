package Homework.Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class Case5 {
    /*Navigate to "https://demoqa.com/select-menu"
Select Group 2, option 1
Select Prof. and validate they are selected. */

    @Test
    public void Validation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement optionButton= driver.findElement(By.id("react-select-2-input"));
        Thread.sleep(1000);
        optionButton.sendKeys(""+ Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ENTER);
       // optionButton.click();
        Thread.sleep(1000);

         WebElement titleOption= driver.findElement(By.id("By.id(selectOne"));
        Thread.sleep(1000);
       titleOption.sendKeys(""+ Keys.ARROW_DOWN+Keys.ARROW_DOWN+
               Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ENTER);
       Thread.sleep(1000);

    }
       @Test
     public void ValueSeelctionValidation() throws InterruptedException {
           WebDriverManager.chromedriver().setup();
           WebDriver driver= new ChromeDriver();

           driver.get("https://demoqa.com/select-menu");
           driver.manage().window().maximize();

           WebElement valueSelection= driver.findElement(By.xpath("//div[@aria-hidden='true']"));
           Thread.sleep(1000);
           valueSelection.click();
           Thread.sleep(1000);


          WebElement group2= driver.findElement(By.xpath("//div[contains(text(), 'Group 2, option 1')]"));
          group2.click();


          Thread.sleep(1000);


           WebElement titleOption= driver.findElement(By.id("selectOne"));
           titleOption.click();
           WebElement prof= driver.findElement(By.xpath("//div[contains(text(),'Prof.')]"));
           prof.click();

             String actualGroupValidation=group2.getText().trim();
            String  expectedGroupValidation="Group 2, option 1";

          Assert.assertEquals(actualGroupValidation,expectedGroupValidation);
    }
@Test
    public  void  moveByOffSet(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

driver.manage().window().maximize();
WebElement slider= driver.findElement(By.className(""));

}





}



