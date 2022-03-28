package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookPractice {
    public static void main(String[] args) throws InterruptedException {
           /*
    Facebook Sign up:
Scenario:
Open a Chrome browser.
Navigate to "http://www.fb.com"
Verify that the page is redirected to "http://www.facebook.com", by getting the current URL. (use Assertion)
Verify that there is a "Create an account" section on the page.
Fill in the text boxes: First Name, Surname, Mobile Number or email address, "Re-enter mobile number", new password.
Update the date of birth in the drop-down.
Select gender.
Click on "Create an account".
Verify that the account is not created.
     */


        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();


        String currentURL= driver.getCurrentUrl();
        String expectedUrl="http://www.facebook.com";
        if(currentURL.equals(expectedUrl)){
            System.out.println("This website is correct");
        }else{
            System.out.println("The website is wrong");
        }

        WebElement createAccountButton= driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        boolean validationButton=createAccountButton.isDisplayed();
        //How do you deal with dynamic elements?
        boolean expectedValidationButton=true;
        if(validationButton==expectedValidationButton){
            System.out.println("Button is displayed");
        }else{
            System.out.println("Button is not displayed");
        }
        createAccountButton.click();
       Thread.sleep(1000);



       WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Bogdana");

       WebElement lastnamename= driver.findElement(By.name("lastname"));
        lastnamename.sendKeys("Kotyk");


        WebElement email= driver.findElement(By.name("reg_email__"));
        email.sendKeys("dana@gmail.com");

        WebElement confirmationEmail=driver.findElement(By.name("reg_email_confirmation__"));
        confirmationEmail.sendKeys("dana@gmail.com");

        WebElement password= driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("dana12345");


        WebElement month=driver.findElement(By.id("month"));
        month.sendKeys("Jul");

        WebElement date=driver.findElement(By.name("birthday_day"));
        date.sendKeys("15");

        WebElement year=driver.findElement(By.name("birthday_year"));
        year.sendKeys("2020");


WebElement gender= driver.findElement(By.xpath("//input[@name='sex']"));
gender.click();

WebElement signUpButton=driver.findElement(By.name("websubmit"));
signUpButton.click();





    }


}
