package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTask {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");



        WebElement title= driver.findElement(By.xpath("//h3"));
        System.out.println(title.getText());

        WebElement paragraph=driver.findElement(By.xpath("//h4[@class='subheader']"));
        System.out.println(paragraph.getText());

        //CONTAINS METHOD: it works with text.
        //tagname[contains(text(),'Horizontalline')]


        WebElement containsMethod=driver.findElement(By.xpath("//h3[contains(text),'Horizontal Slider'])"));
        System.out.println(containsMethod.getText());

        //Text:it works with text as well. This is for simplier than contains method.
        //It looks for the exact text.

        //h3[.='text']

        WebElement text = driver.findElement(By.xpath("//h3[.='Horizontal Slider']"));
        System.out.println(text.getText());


    }
}
