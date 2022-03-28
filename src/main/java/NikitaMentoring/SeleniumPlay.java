package NikitaMentoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class SeleniumPlay {
    public static void playNotes(String[] notes, HashMap<String, WebElement>instrument){
        for(String note:notes){
            instrument.get(note).click();
        }}


    public  static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.musicca.com/piano");
        driver.manage().window().maximize();

       List<WebElement> keys= driver.findElements(By.xpath("//span[@data-key]"));
        HashMap<String, WebElement> keaboard= new HashMap<>();
        for(WebElement key:keys){
            keaboard.put(key.getAttribute("data-note"),key);

        }
      //  for(WebElement note:keaboard.values()){
           // Thread.sleep(1000);
          //  note.click();
        String[] test={"2g","2g","2e","2e","2d"};
        String[] surprise= {"2g","2g","2g","2d","2e","2e","2d","3b","3b","3a","3a","2g"};
        playNotes(surprise,keaboard);
        Thread.sleep(5000);
        driver.quit();

        }
}
