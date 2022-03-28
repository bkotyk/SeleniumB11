package Seleniumintro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSeleniumBasics {
    //task: I want you to go to the 3 websides. Get the title, currentURL
    // You decide and going back
    //forward with them lastly refresh
    public static void main(String[] args) {

        System.setProperty("webdrivew.chrome.driver", "chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.zappos.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.ebay.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.zappos.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.zappos.com/");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.quit();

    }
}
