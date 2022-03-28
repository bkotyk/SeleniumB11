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

import java.util.List;

public class TestCase1 {
    /*Navigate to
"http://uitestpractice.com/Students/Select#"
Validate India is selected by default on drop down
box
Validate the size of the Drop down box is 4
Validate the values for Drop down box are :
          India
United States of America
China
England
          Select the China with index number
Select the England with value
Select the United States with visible text.*/
    @Test
    public void TestCase1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Select");
        driver.manage().window().maximize();

        WebElement India = driver.findElement(By.xpath("//select[@id='countriesSingle']//option[@value='india']"));
        String actualCountry = BrowserUtils.getTextMethod(India);
        String expectedCountry = "India";

        Assert.assertEquals(actualCountry, expectedCountry);


        WebElement dropDown = driver.findElement(By.id("countriesSingle"));
        Select select = new Select(driver.findElement(By.id("countriesSingle")));
        List<WebElement> selectCounties = select.getOptions();
        System.out.println(selectCounties.size());
        int actualSizeOfDropBox = selectCounties.size();
        int expectedSizeOfDropBox = 4;
        Assert.assertTrue(actualSizeOfDropBox == 4);

        List<WebElement> countries = driver.findElements(By.id("countriesSingle"));

        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i).getText().trim());

            String actualCountries = countries.get(i).getText().trim();
            String expectedCounties = "India\n" +
                    "        United states of America\n" +
                    "        China\n" +
                    "        England";

            Assert.assertEquals(actualCountries, expectedCounties);


            Select se = new Select(dropDown);
            se.selectByIndex(2);
            se.selectByValue("england");
            se.selectByVisibleText("United states of America");


        }
    }}





