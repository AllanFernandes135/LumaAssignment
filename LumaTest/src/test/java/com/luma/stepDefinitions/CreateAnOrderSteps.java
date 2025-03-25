package com.luma.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class CreateAnOrderSteps {
     WebDriver driver; ;
    final String url = "https://magento.softwaretestingboard.com/";


    @Given("I am on luma home page")
    public void iAmOnLumaHomePage() {
        try {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromeDriver/chromedriver.exe");
            driver.manage().window().maximize();
            driver.navigate().to(url);
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        }
        catch(Exception error){
            System.out.println("Something went wrong."+error);
        }
    }

    @Then("I should see {string} header displayed")
    public void iShouldSeeHeaderDisplayed(String header) {
        try {
            switch (header){
                case "Home Page":
                    break;
            }
        }
        catch(Exception error){
            System.out.println("Something went wrong."+error);
        }
    }
}
