package Alert;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class AlertIntro {
    @Test
    public  void  JSBAsicAlertAcceptMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement clickJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickJSAlert.click();
        //  WebElement header= driver.findElement(By.tagName("h3"));//UnhandledAlertException
        //  System.out.println(header.getText());
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualText, expectedText);
        alert.accept();
        WebElement message = driver.findElement(By.id("result"));
        String actualMessage = BrowserUtils.getTextMethod(message);
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @Test
            public  void JSAlertDismissMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement clickJSConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickJSConfirm.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expText = "I am a JS Confirm";
        Assert.assertEquals(actualText, expText);
        alert.dismiss();
        WebElement Message = driver.findElement(By.id("result"));
        String actMessage = BrowserUtils.getTextMethod(Message);
        System.out.println(Message.getText());
        String expMessage = "You clicked: Cancel";
        Assert.assertEquals(actMessage, expMessage);
    }
    @Test
            public void AlertClassSendKeys() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.manage().window().maximize();
            WebElement clickToJSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
          clickToJSPrompt.click();
          Alert alert = driver.switchTo().alert();
          alert.sendKeys("Techtorial");
          alert.accept();
          WebElement message= driver.findElement(By.id("result"));
          String actTextP = BrowserUtils.getTextMethod(message);
        System.out.println(message.getText());
          String extTextP = "You entered: Techtorial";
          Assert.assertEquals(actTextP, extTextP);

    }
    }

