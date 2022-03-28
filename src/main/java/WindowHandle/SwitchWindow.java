package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {
    @Test
    public void practice1(){
        //it is failing because my driver is still pointing the last tab. That is way it throws NoSuchElementException.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        WebElement clickButton= driver.findElement(By.xpath("//a[.='Click Here']"));
        clickButton.click();
        WebElement text= driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(text.getText());
    }
    @Test
    public void switchingWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle());
        WebElement clickButton= driver.findElement(By.xpath("//a[.='Click Here']"));
        clickButton.click();
        System.out.println(driver.getWindowHandles());
       // WebElement header= driver.findElement(By.className("example"));
        String mainPageID= driver.getWindowHandle();
        Set<String> allPagesID= driver.getWindowHandles();

        //this implementation is only for 2 tabs.
        for(String id:allPagesID){
            System.out.println(id);
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);}}
                WebElement text= driver.findElement(By.xpath("//h3[.='New Window']"));
                System.out.println(text.getText());
                String actualText=text.getText();
                String expectedText="New Window";
                Assert.assertEquals(actualText,expectedText);

            }
            @Test
    public void practice2(){
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
                driver.manage().window().maximize();
                String mainPageID= driver.getWindowHandle();


                WebElement openNewTab= driver.findElement(By.id("newTabBtn"));
                openNewTab.click();
                System.out.println(driver.getWindowHandles());
               // Set<String> allPagesID= driver.getWindowHandles();
                // for(String id:allPagesID){
                //    System.out.println(id);
                  //  if(!id.equals(mainPageID)){
                      //  driver.switchTo().window(id);}}
                BrowserUtils.SwitchOnlyFor2Tabs(driver,mainPageID);
                WebElement alertDemo= driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
                System.out.println(alertDemo.getText());
                String actualText=BrowserUtils.getTextMethod(alertDemo).trim();
                String expectedText="AlertsDemo";
                Assert.assertEquals(actualText,expectedText);
                WebElement clickHere= driver.findElement(By.id("alertBox"));
                clickHere.click();


            }
        }





