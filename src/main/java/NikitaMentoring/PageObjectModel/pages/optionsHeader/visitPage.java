package NikitaMentoring.PageObjectModel.pages.optionsHeader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class visitPage {

    public void visitPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
//    @FindBy (xpath = "//div[@class='promo-content promo-parallel']")
   // public List<WebElement> promoContent;
}
