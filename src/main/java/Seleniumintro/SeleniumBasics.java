package Seleniumintro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
//STEP1. We need to define the chrome driver into the project as a property.
        System.setProperty("webdriver.chrome.driver","chromedriver");
        //Windows:
        //STEP2. We need to instanciate of declare our driver.
        WebDriver driver=new ChromeDriver();
        //NOTE: driver is a reference name. WeDriver- ->Interface
        //new ChromeDriver() - - new Object.
        //INTERVIEW QUESTION:
        //Where do you use polymorphism in your testing framework.
        //I USE IT TO INSTANSIATE OR START MY DRIVER LIKE.
       // WebDriver driver = new WebDriver() {


        //First Method
        //GET() - -> method navigates to the given url.
        driver.get("https://www.techtorialacademy.com/");
        //getTitle
        String title=driver.getTitle();
        System.out.println(title);
        if(title.equals("Home Page - Techtorial")){
            System.out.println("Your test is passed");}
            else{
                System.out.println("You test failed");
            }
            //getCurrentUrl() it is a method
            String actual= driver.getCurrentUrl();
            String expected="https://www.techtorialacademy.com/";
            if(actual.equals(expected)){
                System.out.println("Passed");
            }else{
                System.out.println("Failed");
            }
        }



    }

