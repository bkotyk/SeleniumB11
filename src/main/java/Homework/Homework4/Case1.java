package Homework.Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class Case1 {

    /*
    Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Click on top of Shiromi picture
Click > arrow
validate next item is Tekka maki
Click < arrow
Validate the item is Shiromi
Validate number of item 0 in the cart*/

    @Test
    public  void TestCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");

        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement Shiromi= driver.findElement(By.xpath("//strong[.='Shiromi']"));
        Shiromi.click();


        WebElement arrow= driver.findElement(By.xpath("//a[@id='navigate-next']"));
        actions.moveToElement(arrow).doubleClick().keyDown(Keys.COMMAND).sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND).perform();WebElement TekkaMaki= driver.findElement(By.xpath("//h1[.='Tekka maki']"));
       TekkaMaki.click();
       String actualTekkaMakiValidation=TekkaMaki.getText();
       String expectedTekkaMakiValidation="Tekka maki";
       Assert.assertEquals(actualTekkaMakiValidation, expectedTekkaMakiValidation);
       WebElement arrowleft= driver.findElement(By.xpath("//a[@href='#/menu/8']"));
       actions.moveToElement(arrowleft).perform();
       BrowserUtils.ClickWithJS(driver, arrowleft);
       WebElement shiromiValidation= driver.findElement(By.xpath("//h1[contains(text(),'Shiromi')]"));
       Thread.sleep(1000);
       System.out.println(BrowserUtils.getTextMethod(shiromiValidation));
       String actualShiromiValidation=shiromiValidation.getText();
       String expectedShiromiValidation="Shiromi";
       Assert.assertEquals(actualShiromiValidation,expectedShiromiValidation);
       WebElement numberOfItems= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
       String actualNumberOfItems=BrowserUtils.getTextMethod(numberOfItems);
       String expectedNumerOfItems="0";
       Assert.assertEquals(actualNumberOfItems,expectedNumerOfItems);




    }
}
