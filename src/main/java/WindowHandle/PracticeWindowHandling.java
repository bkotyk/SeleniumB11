package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeWindowHandling {
    @Test
    public  void practiceMultipleWindowHandling(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();


       WebElement multipleButtonTab= driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
       multipleButtonTab.click();

        BrowserUtils.switchByTitle(driver,"\n" +
                "Basic Controls - \n" +
                "                H Y R Tutorials");

       WebElement headerforBC= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));

       String actualText=BrowserUtils.getTextMethod(headerforBC);
       String expectedText="Basic Controls";
        Assert.assertEquals(actualText,expectedText);

        WebElement firstName= driver.findElement(By.id("firstName"));
        firstName.sendKeys("Bogdana");

        WebElement lastName= driver.findElement(By.id("lastName"));
        lastName.sendKeys("Kotyk");

        WebElement gender= driver.findElement(By.id("femalerb"));
        gender.click();

        WebElement language= driver.findElement(By.id("englishchbx"));
        language.click();
        WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("danaK123!");

        WebElement passport= driver.findElement(By.xpath("//input[@id='password']"));
        passport.sendKeys("Love123!!");

        WebElement message = driver.findElement(By.xpath("//label[@id='msg']"));

        String actualMsg=BrowserUtils.getTextMethod(message);
        String expectedMsg="Registration is Successful";

        Assert.assertEquals(actualMsg,expectedMsg);




    }}

