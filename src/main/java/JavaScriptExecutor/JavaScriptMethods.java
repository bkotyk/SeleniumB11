package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptMethods {
    //wheever normal method are nt working the last decision should be javaScript
    //Title Method
    @Test

    public  void  tittleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());

       // JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
      //  String title = javascriptExecutor.executeScript("return document.title").toString();
      //  System.out.println(title+"from javaScript");

        String actualTitle= BrowserUtils.GetTitleWithJS(driver);
        String expectedTitle="Home Page - Techtorial";

        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test//I use this methods often.

    public  void  ClickWithJS(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement courseBrouse = driver.findElement(By.xpath("//a[.='Browse Course']"));

      //  JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        //  javascriptExecutor.executeScript("agruments[0].click()", helloSign);
       BrowserUtils.ClickWithJS(driver, courseBrouse);


    }
    @Test
     public  void  ClickWithJSPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        Thread.sleep(1000);
        BrowserUtils.ClickWithJS(driver,loginButton);

}
      @Test
      public  void ScrollIntoView() {
          WebDriverManager.chromedriver().setup();
          WebDriver driver = new ChromeDriver();
          driver.get("http://www.techtorialacademy.com/");

          WebElement copyright = driver.findElement(By.xpath("//p[contains(text(), 'Copy')]"));

          JavascriptExecutor js = (JavascriptExecutor) driver;
          //  js.executeScript("arguments[0].scrollIntoView(true)",copyright);
      }
//TASK1

    @Test
            public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

           WebElement browsecourse= driver.findElement(By.xpath("//a[contains(text(), 'Browse Course')]"));
           BrowserUtils.ClickWithJS(driver, browsecourse);

              WebElement getStartedButton= driver.findElement(By.xpath("//a[.='Get Started']"));

               //  js.executeScript("arguments[0].scrollIntoView(true)",getStartedButton);
              BrowserUtils.ScrollWithJS(driver,getStartedButton);
                  BrowserUtils.ClickWithJS(driver,getStartedButton);
    }
    @Test
    public void ScrollWithXandYCoordinantText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");

        WebElement copyright = driver.findElement(By.xpath("//p[contains(text(), 'Copy')]"));

      //  JavascriptExecutor js = (JavascriptExecutor) driver;
      //  Point location =copyright.getLocation();
     //   System.out.println(location.getX());
     //   System.out.println(location.getY());
      //  int xCord= location.getX();
      //  int yCord= location.getY();
     //   js.executeScript("window.scrollTo("+xCord+","+yCord+")");

        BrowserUtils.ScrollWithXandYCord(driver,copyright);
    }
}
