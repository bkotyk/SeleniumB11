package Homework.Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6 {
    /*Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Add Shiromi and Ebi Rolls into the cart
Click checkout button
Validate total price is 17
Increase the count of Ebi Roll with 2
Validate total is $25
Click order now
Validate cart is 0*/

    @Test
    public  void TestCase() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

        WebElement ShiromeButton= driver.findElement(By.xpath("//div/li[8]/button"));
        ShiromeButton.click();

        WebElement EbiRolls= driver.findElement(By.xpath("//*[@id='main']/div/li[14]/button"));
        EbiRolls.click();
        WebElement checkOut= driver.findElement(By.xpath("//a[@id='checkout']"));
        checkOut.click();

        WebElement totalPrice= driver.findElement(By.xpath("//span[@data-bind='text: totalPrice']"));

        double actualPrice=Double.parseDouble(BrowserUtils.getTextMethod(totalPrice).replace("$",""));
        double expectedPrice= 17;

        Assert.assertEquals(actualPrice,expectedPrice);

        WebElement updatedEbiRollsCount= driver.findElement(By.xpath("//*[@id='details-checkout']/table/tbody/div/tr[2]/td[2]/span/span[2]/button[1]"));
        updatedEbiRollsCount.click();

        WebElement total= driver.findElement(By.xpath("//span[@data-bind='text: totalPrice']"));
        total.click();

        String actualTP=BrowserUtils.getTextMethod(total).replace("00","").replace(".","");
        String expectedTP="$25";
        Assert.assertEquals(actualTP,expectedTP);

       WebElement orderNowButton= driver.findElement(By.xpath("//button[@class='order-now']"));
       orderNowButton.click();

       WebElement cartInfo= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));

       String actualCartInfo=BrowserUtils.getTextMethod(cartInfo);
       String expectedCartInfo="0";

       Assert.assertEquals(actualCartInfo,expectedCartInfo);

        }
}
