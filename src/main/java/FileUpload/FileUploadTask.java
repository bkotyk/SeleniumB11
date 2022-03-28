package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTask {
  /*  1)Navigate to the "https://demo.guru99.com/test/upload/'
            2)Upload the usa.png file on the website
3)Click the box (I accept terms of service)
4)validate box is selected
5)Click submit button
6)Validate the message "1 file has been successfully uploaded."*/
    @Test
    public  void Task() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        driver.manage().window().maximize();

        WebElement chooseFile= driver.findElement(By.xpath("//input[@type='file']"));
        chooseFile.sendKeys("/Users/dana/Desktop/usa.png");
       WebElement aceptTerms= driver.findElement(By.xpath("//input[@type='checkbox']"));
       aceptTerms.click();
        Assert.assertTrue(aceptTerms.isSelected());
      WebElement submitButton= driver.findElement(By.id("submitbutton"));
      submitButton.click();
      Thread.sleep(1000);
      WebElement message= driver.findElement(By.xpath("//h3"));
        System.out.println(message.getText());
        String actMes= BrowserUtils.getTextMethod(message);
        String expMes="1 file\n" +
                "has been successfully uploaded.\n";
        Assert.assertEquals(actMes,expMes);

    }
}
