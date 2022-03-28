package Homework.Homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase2 {
   /* Navigate to Navigate to
"http://uitestpractice.com/Students/Select#"
    Validate the values for Multiple Select are :
    India
    United States of America
    China
            England
    Select China and England
    Validate "China England" is displayed
    Deselect all the countries
    Select All the countries
    Validate "India United states of America China
    England" is
    displayed
    Deselect the China with index number
    Deselect the England with value.*/

    @Test
    public void TestCase1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Select");
        driver.manage().window().maximize();

        WebElement MultiSelectBox = driver.findElement(By.id("countriesMultiple"));


        String actMSValue = MultiSelectBox.getText();
        String expMSValue = "India\n" +
                "United states of America\n" +
                "China\n" +
                "England";
        Assert.assertEquals(actMSValue, expMSValue);

        Select select = new Select(driver.findElement(By.id("countriesMultiple")));
        select.selectByVisibleText("China");
        select.selectByVisibleText("England");
        // List<String> twoCountries=select.isMultiple();


         WebElement firstCountry= driver.findElement(By.xpath("//select[@id='countriesSingle']//option[.='China']"));
        boolean act=firstCountry.isDisplayed();

        Assert.assertTrue(act);

        WebElement England= driver.findElement(By.xpath("//select[@id='countriesSingle']//option[.='England']"));
        boolean actE=England.isDisplayed();

        Assert.assertTrue(actE);

        select.deselectAll();
         List<WebElement> countries = select.getOptions();


        for (int i = 0; i < countries.size(); i++) {
            select.selectByIndex(i);
            boolean actSelection = MultiSelectBox.isDisplayed();

            Assert.assertTrue(actSelection);
        }

      select.deselectByIndex(2);
      select.deselectByValue("england");}}
