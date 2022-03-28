package Homework.Homework5;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase4 {
    /*Navigate to "https://www.cars.com/"
Select "Certified Cars" from drop down
Select "Lexus" from All Makes
Select "ES 350" from drop down
Select max price is "$50000"
Select 50 miles from drop down box
Insert 60016 as zip code
Click search button
Get count of all the cars which is displayed on first
page
Validate count of the cars is not more than 20*/
@Test
        public void TestCase4(){
 WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();

    WebElement newAndCertifiedCars = driver.findElement(By.id("make-model-search-stocktype"));
    Select select = new Select(newAndCertifiedCars);
       // select.getOptions();
        BrowserUtils.selectBy(newAndCertifiedCars,"new_cpo","value");
    WebElement makes=driver.findElement(By.xpath("//select[@id='makes']"));
    BrowserUtils.selectBy(makes,"Lexus","text");

    WebElement model= driver.findElement(By.xpath("//select[@id='models']"));
    BrowserUtils.selectBy(model,"ES 350","text");

    WebElement price= driver.findElement(By.id("make-model-max-price"));
    BrowserUtils.selectBy(price,"$50,000","text");

    WebElement miles= driver.findElement(By.id("make-model-maximum-distance"));
    BrowserUtils.selectBy(miles,"50 miles","text");

    WebElement zip= driver.findElement(By.xpath("//input[@id='make-model-zip']"));
    zip.sendKeys("60016");

    WebElement searchButton= driver.findElement(By.xpath("//button[@data-searchtype='make']"));
    searchButton.click();

    List<WebElement> allCars= driver.findElements(By.xpath("//div[@class='vehicle-card-main js-gallery-click-card']"));
    System.out.println(allCars.size());



    Assert.assertTrue(!((allCars.size()) >20));
    WebElement carsNames= driver.findElement(By.xpath("//div[@class='vehicle-card-main js-gallery-click-card']"));

        List<WebElement> allCarsNames= driver.findElements(By.xpath("//div[@class='vehicle-card-main js-gallery-click-card']"));
        for(int x=0; x<allCars.size();x++){
            System.out.println(allCarsNames.get(x).getText().trim());
            String Names=allCarsNames.get(x).getText().trim();
            Assert.assertTrue(Names.contains("Lexus ES 350"));

           List<WebElement> allItemsPrice= driver.findElements(By.className("vehicle-details"));
           List<WebElement>displayedPrice=new ArrayList<>();
           List<Double> prices=new ArrayList<>();
           double sum=0;
           for(int i=0; i<allCars.size();i++){
               if(allItemsPrice.get(i).isDisplayed()) {

                   displayedPrice.add(allItemsPrice.get(i));
                   sum += Double.parseDouble(allItemsPrice.get(i).getText().trim().replace("$", ""));
                   prices.add(Double.parseDouble(allItemsPrice.get(i).getText().trim().replace("$", "")));
                   Collections.sort(prices);


               }
           }
        }
}

/*Part2.
    * Get all car names in first page
Validate All car names has "Lexus ES 350"
Get the Mile distance from zip code for every car
Validate mile distance is no more than 50mil in first page
Select Sort By --> Price:Highest in drop down
Validate highest price is not more than $50000
 */
}