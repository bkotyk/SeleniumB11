package Homework.Homework5;

import Utils.BrowserUtils;
import com.sun.org.apache.xpath.internal.axes.AttributeIterator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.soap.SAAJResult;

public class TestCase3 {
    /*Navigate to "https://www.cars.com/"
Select "Certified Cars" from drop down
Select "Toyota" from All Makes
Select "Corolla" from drop down
Select max price is "$30000"
Select 40 miles from drop down box
Insert 60018 as zip code
Click search button
Validate title has Certified Used
Validate "Certified Used Toyota Corolla for Sale" is
displayed. */
    @Test
    public void TestCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement certifiedCars = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        Select select = new Select(certifiedCars);
        select.getOptions();
        select.selectByVisibleText("Certified cars");

        WebElement allMakes = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(allMakes, "toyota", "value");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(dropDown, "toyota-corolla", "value");
        WebElement price = driver.findElement(By.id("make-model-max-price"));
        BrowserUtils.selectBy(price, "$30,000", "text");
        WebElement distance = driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(distance, "40", "value");
        Thread.sleep(1000);

        WebElement zip = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zip.sendKeys("60018");

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-cpo-make']"));
        searchButton.click();


       // WebElement title=driver.findElement()
        Assert.assertTrue(driver.getTitle().contains("Certified Used"));


        WebElement header = driver.findElement(By.xpath("//h1[.='Certified used Toyota Corolla for sale']"));

        String actHeader = header.getText();
        String expHeader = "Certified used Toyota Corolla for sale";
        Assert.assertEquals(actHeader, expHeader);





    /*Validate 40 miles selected in dropdown once you click
search button
Validate Certified Pre-Owned selected in radio button
Validate Toyota is selected in checkbox
Validate Corolla is selected in drop down
*/
      WebElement milesValidation= driver.findElement(By.xpath("//select[@id='location-distance']"));
      boolean actualMilesValidation= milesValidation.isSelected();

      Assert.assertTrue(actualMilesValidation);

     //  WebElement PreOwnedCarsvalidation=driver.findElement(By.xpath("//select[@name='stock_type']"));
     //  boolean actualCertified=PreOwnedCarsvalidation.isSelected();
     //  Assert.assertTrue(actualCertified);

       WebElement Toyota=driver.findElement(By.xpath("//label[@for='active_filter_tags-makes-toyota']"));
       boolean actualToyotaValidation=Toyota.isSelected();
       Assert.assertTrue(actualToyotaValidation);


       WebElement Corolla=driver.findElement(By.xpath("//label[@for='model_toyota-corolla']"));
       boolean CorolaValidation=Corolla.isSelected();
       Assert.assertTrue(CorolaValidation);



    }
}