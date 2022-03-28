package Seleniumintro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Locale;

public class FindElementsPractice {
    public static void main(String[] args) {

        //
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.yahoo.com/?guccounter=1");
        driver.manage().window().maximize();

        WebElement news=driver.findElement(By.id("root_2"));
        news.click();

     List<WebElement> headers= driver.findElements(By.xpath("//h3"));
     int counter=0;
     for(int i =0; i<headers.size(); i++){
        if(headers.get(i).getText().toUpperCase().contains("Covid")){
            System.out.println(headers.get(i).getText());
            counter++;
        }
         System.out.println(counter);
     }




    }
}
