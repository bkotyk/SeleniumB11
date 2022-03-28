package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "btnAdd")
    WebElement AddButton;

    @FindBy(id = "systemUser_userType")
    WebElement userRole;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement userName;

    @FindBy(name = "systemUser[status]")
    WebElement status;


    @FindBy(name = "systemUser[password]")
    WebElement password;

    @FindBy(name = "systemUser[confirmPassword]")
    WebElement confirmPassword;

    @FindBy(className = "addbutton")
    WebElement saveButton;

    //   @FindBy(xpath = )
  //  WebElement allnames;
    @FindBy(id = "searchSystemUser_userType")
    WebElement userroleBox;
    @FindBy(xpath = "//td[3]")
    List<WebElement> allTheRoles;



    public  void  sendingAllInformationForEmployee() throws InterruptedException {
        AddButton.click();
        BrowserUtils.selectBy(userRole,"Admin","text");
     employeeName.sendKeys("Alice Duval");
     userName.sendKeys("AhmetBal");
     BrowserUtils.selectBy(status,"0","value");
     password.sendKeys("ahmet12345");
     confirmPassword.sendKeys("ahmet12345");
     saveButton.click();
     Thread.sleep(1000);
    }
 //  public boolean ValidationTheEmployeeIsCreated(String Username){

  // for(WebElement name: allNames){
        //  if(name.getText().trim().){


  //  return true;

public  void validateTheSelectRoleFunction(String roleName, WebDriver driver){
    BrowserUtils.selectBy(userroleBox,roleName,"text");
   // BrowserUtils.ClickWithJS(AdminPage);


}
public  boolean validateRoleText(){
        for(WebElement role:allTheRoles){
            if(!role.getText().trim().equals("Admin")){
                return false;
            }
        }
 return true;
}
}
