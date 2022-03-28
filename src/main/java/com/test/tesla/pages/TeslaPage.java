package com.test.tesla.pages;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TeslaPage {
   /* Positive scenario:
           Test Case 1:
Positive scenario:
1. Navigate to Tesla.com.
  2.Click Tesla modelX Button .
3. Click on order now Button
4. Navigate to paint section, on the right side of the page.
  6. Click on Deep Blue Metallic color option.
 Expected result:  Picture of the car in Deep Blue Metallic Color isDisplayed on the page.

.*/

    public TeslaPage(WebDriver driver){

        PageFactory.initElements(driver,this);}

  @FindBy(xpath ="//span[@class='tds-site-nav-item-text'][.='Model X']")
  WebElement modelXButton;
    @FindBy(xpath ="//p[contains(text(), 'Peak Power')]//..//following-sibling::div/a")
  WebElement orderNowButton;
  @FindBy(xpath = "//div[@data-group-id='PAINT']")
  WebElement paintSection;
  @FindBy(xpath = "//span[.='Deep Blue Metallic']//..//..//label")
   WebElement deepBlueMetallicColorOption;
  @FindBy(xpath = "//div[@class='child-group--selected_option_details']//span[.='Deep Blue Metallic']")
  WebElement color;
   @FindBy(xpath = "//div[@data-group-id='PAINT']//preceding-sibling::span")
    List<WebElement> paintOption;

   public void clickTeslaModelXButton(){
     modelXButton.click();
   }

    public  void  clickOrderNowButton(){
       orderNowButton.click();}

   public void moveToPaintSection(){
       Actions actions=new Actions(DriverHelper.getDriver());
       actions.moveToElement(paintSection).perform();}

       public boolean clickBlueColorButton(){
           deepBlueMetallicColorOption.click();
           if(!deepBlueMetallicColorOption.isSelected()) {
               return false;
           }
           return true;}

   public boolean colorValidation() {
       deepBlueMetallicColorOption.click();
       String actualColorName = color.getText().trim();
       if (actualColorName.contains("Deep Blue Metallic")) {

           return true;
       }
       return false;
   }
   public  boolean colorOptions(){
       for(WebElement opt:paintOption){
          opt.getText().trim();
          List<String> colorOptions=new ArrayList<>();
          colorOptions.add(opt.getText().trim());
           System.out.println(colorOptions);

           if(opt.getText().trim().toLowerCase().contains("purple")){
               return true;
           }}
           return false;
       }}









