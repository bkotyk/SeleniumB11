package Seleniumintro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class RealTestCaseExample {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.
//4. Get URL of current page and validate it.
//            5. Close browser.
    public static void main(String[] args) {

       // System.setProperty("webdrive.chrome.driver", "chromedriver");
      /*  WebDriver driver= new ChromeDriver();
        if(driver.equals("https://www.godaddy.com/")){
            driver.navigate().to("https://www.godaddy.com/");
            driver.manage().window().maximize();
            String actualDriver=driver.getTitle();
            String expectedTitle="GoDaddy";
            if(actualDriver.equals(expectedTitle)){
                System.out.println("Passed");
            }else {
                System.out.println("failed");*/

                WebDriver driver = new ChromeDriver();
                driver.get("https://www.godaddy.com/");
                driver.manage().window().maximize();
                String actualTitle=driver.getTitle();
                String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
                if(actualTitle.equals(expectedTitle)){
                    System.out.println("passed");
                }else{
                    System.out.println("failed");
                }
                String actualUrl=driver.getCurrentUrl();
                String expectedUrl="https://www.godaddy.com/";
                if(actualUrl.equals(expectedUrl)){
                    System.out.println("passed");
                }else{
                    System.out.println("failed");
                }
                driver.close();

            }
        }

