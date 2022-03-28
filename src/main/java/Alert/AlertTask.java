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

public class AlertTask {
    @Test
public void Alert(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        WebElement previewButton= driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')]//..//button"));
        previewButton.click();
        Alert alert =driver.switchTo().alert();
        String actualText=alert.getText();
        String expText="Oops, something went wrong!";
        Assert.assertEquals(actualText,expText);
        alert.accept();


    }
    @Test
    public void TrialForAlertToHandleHTMLpopup(){
    /* TASK 2 (ALERT CLASS)
     1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
    WebElement previewRightButton= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
   previewRightButton.click();
   Alert alert=driver.switchTo().alert();

    alert.accept();
    }
    @Test
    public void HTMLALERT (){
    /*
    TASK 3 (HTML ALERT)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
 WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
    WebElement previewRightButton= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
   previewRightButton.click();
   WebElement Message= driver.findElement(By.xpath("//div[.='Something went wrong!']"));
   String actText= BrowserUtils.getTextMethod(Message);
   String expText="Something went wrong!";
   Assert.assertEquals(actText,expText);

   WebElement okButton= driver.findElement(By.className("swal-button swal-button--confirm"));
   okButton.click();

    }}


