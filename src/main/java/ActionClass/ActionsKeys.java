package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsKeys {
    @Test
    public  void keys(){


    WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/?client=safari&channel=mac_bm");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement googleSearchBox= driver.findElement(By.name("q"));
        actions.moveToElement(googleSearchBox)
                .click().keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("elenium")
                .doubleClick().keyDown(Keys.COMMAND)//for windows do control
                .sendKeys("c")
                .keyUp(Keys.COMMAND)//for windows control
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ENTER)//Keys.RETURN
                .perform();

       // googleSearchBox.sendKeys("SelemiumSelemium");
        //IMPORTANT KEYS
        //KEYS.ENTER/KEYS.RETURN
        //Keys.Arrow right/left/up/down








}}
