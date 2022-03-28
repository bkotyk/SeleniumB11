package Seleniumintro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettAttribute {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchText= driver.findElement(By.name("btnK"));
        System.out.print(searchText.getAttribute("value"));
        System.out.print(searchText.getAttribute("aria-label"));

        if(searchText.getAttribute("value").equals("Google Search")){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }


    }
}
