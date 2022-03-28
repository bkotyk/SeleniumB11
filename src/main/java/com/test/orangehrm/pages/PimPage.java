package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PimPage {
    /*Click PIM on the mainpage
    2.Click Add button under PIM
    3. Fill the boxes
    4.Click Save Button
    5.Wait for the next direction

    */
    public   PimPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
   @FindBy(id="btnAdd")
    WebElement addButton;
    @FindBy(id = "firstName")
    WebElement firstname;
    @FindBy(id="lastName")
    WebElement lastname;
    @FindBy(id ="employeeId")
    WebElement employeeID;
    @FindBy(id="photofile")
    WebElement chooseFile;

    @FindBy(id ="btnSave" )
    WebElement saveButton;

    @FindBy(name = "personal[txtEmpFirstName]")
    WebElement validationName;
    @FindBy(name = "personal[txtEmpLastName]")
    WebElement validationLastName;
    @FindBy(name = "personal[txtEmployeeId]")
    WebElement validationEmployeeId;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement editButton;
    @FindBy(xpath = "//input[@id='personal_optGender_2']")
    WebElement gender;
    @FindBy(id = "personal_cmbNation")
    WebElement nationality;
    @FindBy(id = "personal_cmbMarital")
    WebElement maritalStatus;
    @FindBy(name = "personal[DOB]")
    WebElement dateOfBirth;



    public  void  addEmployyeForPIM(String name, String lastname,String employeeID, String uploadFile) throws InterruptedException {
        addButton.click();
        this.firstname.sendKeys(name);
        this.lastname.sendKeys(lastname);
                this.employeeID.sendKeys(employeeID);
        this.chooseFile.sendKeys(uploadFile);
        Thread.sleep(1000);
        saveButton.click();

    }
    public void editPersonalDetails(String nation, String dOB, String maritualStatus){
        editButton.click();
        gender.click();
        BrowserUtils.selectBy(nationality,nation,"text");
        dateOfBirth.clear();
        this.dateOfBirth.sendKeys(dOB);
        BrowserUtils.selectBy(this.maritalStatus,maritualStatus,"text");
        saveButton.click();


    }


    public String validateFirstName(){
        return validationName.getAttribute("value");
    }
    public String validateLastName(){
        return validationLastName.getAttribute("value");
    }
    public boolean validateEmployeeId(String employeeId){
        return validationEmployeeId.getAttribute("value").endsWith(employeeId);
    }
    public  String ValidateTheNationality(){
        Select select=new Select(nationality);
        return  select.getFirstSelectedOption().getText().trim();
    }
}











