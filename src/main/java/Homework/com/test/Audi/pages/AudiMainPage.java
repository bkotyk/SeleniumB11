package Homework.com.test.Audi.pages;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Locale;

public class AudiMainPage {
    public  AudiMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//div[@id='onetrust-close-btn-container']//button[@aria-label='Close']")
    WebElement cookiesbutton;
        @FindBy(xpath = "//label[@for='nm-model-band-4380005-types-0']//span[.='SUVs & Wagons']")
        WebElement SUVandWagon;
        @FindBy(xpath = "//span[.='SUVs & Wagons']/parent::div/following-sibling::ul[@class='nm-model-band-container-item-list']//a")
        public List<WebElement> allSuvandWagons;
        //Why don't we extend the page classesnfor getting element?
    //Main reason is not beeing to use constructor.
    @FindBy(xpath = "//a[contains(text(), 'Starting at $')]")
    public  WebElement startingPrice;
        @FindBy(xpath = "//li[4]//div[@class='nm-model-band-container-item-car-info']//span[.='2022 Audi Q5']")
        WebElement Q52022button;
       // @FindBy(xpath = "//div[@class='HeadlineContainer--ykgbzn faoXzd']//h1//span[.='2022 Audi Q5']")
       // WebElement audiName;
        @FindBy(xpath = "//span[@class='sc-fznKkj gkZFmA']/preceding::a[@class='sc-fzqBZW jkEZoQ']")
        WebElement buildButton;
        @FindBy(xpath = "//span[@class='nm-module-trimline-engine-price-tag'][.='$ 43,300']")
        WebElement startPrice;
        @FindBy()
        WebElement versionOfTheCar;

        public  void  clickCookieButton(){
           cookiesbutton.click();
        }

    public  void cLickSUVbutton() {
           SUVandWagon.click();


    }
public void  clickQ5Button() throws InterruptedException {

            Q52022button.click();
            Thread.sleep(100);
}
//public boolean nameValidation(){
//            audiName.getText();
//            String audiNameQ=audiName.getText().toLowerCase().trim();
//            if(audiNameQ.contains("2022")||audiNameQ.contains("Q5")){
//              return true;
//            }
//            return false;
//}
public void clickBuildButton(){
            buildButton.click();
}
public void startingPriceValidation(){
            startingPrice.getText().trim();
    System.out.println(startingPrice.getText().trim());
}
}





