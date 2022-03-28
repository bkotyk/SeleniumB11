package Homework.Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.internal.MathUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase4 {
    /*Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Validate price of all the products are less than $25*/

    @Test
    public  void TestCase3(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

       List<WebElement> allItemsPrice= driver.findElements(By.xpath("//li/a/span"));
       List<WebElement> displayedPrices=new ArrayList<>();
       List<Double> prices=new ArrayList<>();
        double sum=0;
         for(int i=0; i<allItemsPrice.size();i++){
             if(allItemsPrice.get(i).isDisplayed()){
                 displayedPrices.add(allItemsPrice.get(i));
                 sum+=Double.parseDouble(allItemsPrice.get(i).getText().trim().replace("$",""));
                 prices.add(Double.parseDouble(allItemsPrice.get(i).getText().trim().replace("$","")));
                 System.out.println(sum);

               Assert.assertTrue(sum<25.00);



             }







         }

       }}




