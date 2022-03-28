package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MultipleWindows {
    @Test
    public void MultipleWindowsTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        WebElement clickHere= driver.findElement(By.xpath("//a[.='Click Here']"));
              clickHere .click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");
        //js.executeScript


        BrowserUtils.switchByTitle(driver,"Home Page-Techtorial");
        //store pages in a Set
     //   Set<String> allPagesId=driver.getWindowHandles();
        //loop through pages
     //   for(String id:allPagesId){//intermet- ->new Window
           // driver.switchTo().window(id);
            //use if condition (if title contains About Us-Techtorial, then break(stop)
          //  if(driver.getTitle().contains("About Us - Techtorial")){
             //   continue;
        BrowserUtils.switchByTitle(driver,"Contact Us - Techtorial");
         //   for(String iD:allPagesId){
            //    driver.switchTo().window(iD);
             //   if(driver.getTitle().contains("Contact Us - Techtorial")){
               //     break;
                }
            }

