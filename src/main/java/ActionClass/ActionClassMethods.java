package ActionClass;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {

   //ContextClick()- ->right click
    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement contextMenu= driver.findElement(By.partialLinkText("Context"));
        contextMenu.click();

        WebElement box= driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        //Action class you must use perform at the end.
        actions.contextClick(box).perform();

    }
    @Test
    public void HoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement hover= driver.findElement(By.linkText("Hovers"));
        hover.click();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);

        List<WebElement> names= driver.findElements(By.tagName("h5"));
        List<WebElement> pictures= driver.findElements(By.xpath("//div[@class='figure']/img"));
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        for(int i=0; i<names.size();i++){

            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform();//hover over here



            Assert.assertEquals(BrowserUtils.getTextMethod(names.get(i)),expectedNames.get(i));
            System.out.println(BrowserUtils.getTextMethod(names.get(i)));//get text here




        }
    }
    @Test
    public  void doubleClick() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.htm");
        driver.manage().window().maximize();
        WebElement doubleClickButton = driver.findElement(By.tagName("button"));
        Actions actions = new Actions(driver);
        // actions.doubleClick(doubleClickButton).perform();
        //actions.doubleClick(driver.findElement(By.tagName("button"))).perform();


    }

    //TASK FOR STUDENTS
        /*
        Scenario to Automate:
1. Launch the Chrome web browser.
2. Open a URL "https://selenium08.blogspot.com/2019/11/double-click.html".
3. Locate the element "Double-click".
4.  click on the current location (i.e. on Double-click element).
5. Close the web browser.
         */
@Test
public void doubleClickPractice(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.navigate().to("https://selenium08.blogspot.com/2019/11/double-click.html");
    driver.manage().window().maximize();
     driver.getCurrentUrl();
     WebElement doubleClickButton= driver.findElement(By.xpath("//button[.='Double-Click me to see Alert message']"));
     Actions actions = new Actions(driver);
     actions.doubleClick(doubleClickButton).perform();
     driver.quit();

    }
@ Test
public void dragAndDrop() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
    driver.manage().window().maximize();
    WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
    Thread.sleep(3000);
    acceptCookies.click();
    Actions actions = new Actions(driver);
    for(int i=0; i<5; i++){
        actions.sendKeys(Keys.ARROW_DOWN);
    }


    WebElement dragable= driver.findElement(By.xpath("//div[@id='draggable']"));
    WebElement orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));
    String actualMessages= BrowserUtils.getTextMethod(orangeBox);
    String expectedMessage="... Or here.";

    Assert.assertEquals(actualMessages,expectedMessage);
    actions.dragAndDrop(dragable,orangeBox).perform();
    Thread.sleep(3000);



    orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));
    String actualAfterDragAndDrop=BrowserUtils.getTextMethod(orangeBox);
    String expectedAfterDRagAndDrop="You did great";

    Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDRagAndDrop);


    String actualcssValue= orangeBox.getCssValue( "background-color");
    String expectedcssValue="rgb(238, 111, 11)";
    System.out.println(actualcssValue);

    Assert.assertEquals(actualcssValue,expectedcssValue);

}
@Test
    public  void ClickAndHold() throws InterruptedException {

    WebDriverManager.chromedriver();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

    driver.manage().window().maximize();

    WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
    Thread.sleep(3000);
    acceptCookies.click();

    WebElement blueBox= driver.findElement(By.xpath("//div[@class='test1']"));

    String actualBlueBoxMessage=BrowserUtils.getTextMethod(blueBox);
    String expectedBoxMessage= "Drag the small circle here ...";

    Assert.assertEquals(actualBlueBoxMessage,expectedBoxMessage);
    WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
    Actions actions = new Actions(driver);
    actions.clickAndHold(draggable).moveToElement(blueBox).release().build().perform();

}
@Test
    public void dragAndDropPractice() throws InterruptedException {
    /*
     1)Navigate to the website;
    2) Drag Drag me box and drop to drop box
    3).Validate the message
     */

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://demoqa.com/droppable");
    driver.manage().window().maximize();

    WebElement dragMeButton=driver.findElement(By.id("draggable"));
    Actions actions = new Actions(driver);


    WebElement drophereButton=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
actions.dragAndDrop(dragMeButton,drophereButton).perform();

    String actualResult=BrowserUtils.getTextMethod(dragMeButton);
    String expectedResult="Drag me";

    Assert.assertEquals(actualResult,expectedResult);

    WebElement text=driver.findElement(By.xpath("//div[@class='drop-box ui-droppable ui-state-highlight']"));

  String actualAfterDragAndDown=text.getText().trim();
  String expectedAfterDragAndDown="Dropped!";
  Thread.sleep(1000);

  Assert.assertEquals(actualAfterDragAndDown,expectedAfterDragAndDown);
  Thread.sleep(1000);


  String cssColorValue=drophereButton.getCssValue("background-color");
  String expectedcssColorValue="rgba(70, 130, 180, 1)";

  Assert.assertEquals(cssColorValue,expectedcssColorValue);



}
@Test
    public void clickAndHoldValidation() throws InterruptedException {

     /*
     1)Navigate to the website;
    2)Click accept
    3) click and hold not aceptal box and release it to Drop box.
    4) validate the background is still white and message is still Drop here
    5)Click and Hold acceptable box and release to Drop box
      6)Validate the background is blue and message is dropped

     */
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://demoqa.com/droppable");
    driver.manage().window().maximize();

   WebElement acceptButton = driver.findElement(By.xpath("//a[.='Accept']"));
   acceptButton.click();

   // Thread.sleep(1000);
    WebElement nonAcceptableBox= driver.findElement(By.id("notAcceptable"));



    Thread.sleep(1000);

    //actions.clickAndHold(nonAcceptableBox).release().perform();
    WebElement dropBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]"));
    Thread.sleep(1000);
    Actions actions = new Actions(driver);
    actions.clickAndHold(nonAcceptableBox).release().perform();

     Thread.sleep(1000);
    actions.dragAndDrop(nonAcceptableBox,dropBox).build().perform();
    Thread.sleep(1000);



    String actualcssColorValue1=dropBox.getCssValue("background-color");
     String expectedcssColorValue1="rgba(255, 255, 255, 1)";

   Assert.assertEquals(actualcssColorValue1,expectedcssColorValue1);


   String actmessage=dropBox.getText().trim();
   String expmessage="Drop here";

   Assert.assertEquals(actmessage, expmessage);


    WebElement AcceptableBox= driver.findElement(By.id("acceptable"));

    actions.clickAndHold(AcceptableBox).release().perform();
   actions.dragAndDrop(AcceptableBox,dropBox).build().perform();



    String actualcssColorValue=dropBox.getCssValue("background-color");
    String expectedcssColorValue="rgba(70, 130, 180, 1)";




   String actualMessage=dropBox.getText().trim();
   String expectedMessage="Dropped!";

   Assert.assertEquals(actualMessage,expectedMessage);
}
@Test
    public  void  moveByOffSet(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        driver.manage().window().maximize();
      WebElement slider= driver.findElement(By.xpath("//input"));
      Actions actions = new Actions(driver);

       actions.clickAndHold(slider).moveByOffset(-30,0).perform();

}
@ Test
public void shortCut() throws InterruptedException {//shortcut for testing slider
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://the-internet.herokuapp.com/horizontal_slider");

    driver.manage().window().maximize();
    WebElement slider= driver.findElement(By.xpath("//input"));

    WebElement range= driver.findElement(By.xpath("//span[@id='range']"));
    String myRange="3.5";

    while(!range.getText().trim().equals(myRange)){
        Thread.sleep(1000);
        slider.sendKeys(Keys.ARROW_RIGHT);
    }}
    /*
    * Task for Students
    *1)Navigate to te website
    *2) Type with the keys- ->"Good Bye Keys"
    * 3)With CTRL(Command)-->A - ->select all text
    *4) Copy this text CTL(Command)+C --> it will copy the text.
    *5)Go to the second box and paste CTRL(COMMAND) + V-->it will paste the text
     6) Validate this two boxes text are matching
     */
    @ Test
            public  void keysTask(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();
        Actions actions= new Actions(driver);

        WebElement firstBox=driver.findElement(By.xpath("//textarea[@name='text1']"));
        actions.moveToElement(firstBox)
                .click().keyDown(Keys.SHIFT)
                .sendKeys("Good Bye Keys")
                .doubleClick().keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ENTER)//Keys.
                .perform();

WebElement secondBox= driver.findElement(By.xpath("//textarea[@name='text2']"));
        actions.moveToElement(secondBox)
              .click().keyDown(Keys.SHIFT)
                .sendKeys("Good Bye Keys")
                .doubleClick().keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ENTER)//Keys.
                .perform();
    }
    @Test
    public void MoveByOffSet() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");

        //By using move by of set and point class
        //click contact class

        WebElement contactUS= driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
        Point location =contactUS.getLocation();
        int xCord=location.getX();
        int yCord=location.getY();
         Actions actions = new Actions(driver);
        actions.moveByOffset(xCord,yCord).click().perform();

    }
}



