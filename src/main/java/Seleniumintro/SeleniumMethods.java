package Seleniumintro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException {
        //Interview Question.WHAT IS THE DIFFERENCE BETWEEN DRIVER.GET AND DRIVER.NAVIGATE().TO
        //navigate();

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.navigate().to("https://www.amazon.com/");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
       System.out.println(driver.getPageSource());
       //driver.getPage
       //
        driver.navigate().to("https://www.google.com/");

       driver.navigate().back();//amazon
       driver.navigate().forward();//techtorial again
        driver.navigate().refresh();//refresh
        driver.close();


    }
}
