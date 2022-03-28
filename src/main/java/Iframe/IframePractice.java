package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice {

    @Test
    public void IframeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
       //do not forget to change the frame before looking tfor element.
        WebElement sentence= driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        sentence.clear();
        sentence.sendKeys("I love Selenium.");//does not pass

        driver.switchTo().parentFrame();
        WebElement text= driver.findElement(By.tagName("h3"));
        String actualT= BrowserUtils.getTextMethod(text);
        String exp="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualT, exp);
    }
}
