package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {
    @Test
    public  void ValidateFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();

        WebElement chooseFile= driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/dana/Desktop/usa.png");
        WebElement uploadButton= driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement message= driver.findElement(By.tagName("h3"));
        String actualText1= BrowserUtils.getTextMethod(message);
        String expText1="File Uploaded!";
        Assert.assertEquals(actualText1,expText1);

        WebElement message2= driver.findElement(By.id("uploaded-files"));
        String actualText2=BrowserUtils.getTextMethod(message2);
        String expectedText2="usa.png";
        Assert.assertEquals(actualText2,expectedText2);
      //  Assert.assertTrue(actualText2.equals("usa.png"));
    }
}

