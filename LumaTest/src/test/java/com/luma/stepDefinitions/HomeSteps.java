package com.luma.stepDefinitions;

import com.luma.Utility.SetupClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class HomeSteps { ;
    final String url = "https://magento.softwaretestingboard.com/";
    WebDriver driver = SetupClass.driver;

    Duration wait = Duration.ofSeconds(10);

    WebDriverWait webDriverWaiting = new WebDriverWait(driver, wait);


    @When("I navigate to  luma home page")
    public void iNavigateToLumaHomePage() {
        try {
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
                    webDriverWaiting.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//span[text()=\"Home Page\"]")));
                    break;
                case "Customer Login":
                    webDriverWaiting.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//span[text()='Customer Login']")));
                    break;
                case "Create New Customer Account":
                    webDriverWaiting.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//span[text()=\"Create New Customer Account\"]")));
                    break;
                case "My Account":
                    webDriverWaiting.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//span[text()=\"My Account\"]")));
                    break;
                default:
                    System.out.println("UnImplemented Case");
                    break;
            }
        }
        catch(Exception error){
            System.out.println("Something went wrong."+error);
        }
    }

    @And("I click on the {string} link")
    public void iClickOnTheLink(String button) {
        try {
            switch (button) {
                case "Sign In":
                    driver.findElement(new By.ByXPath("//p[contains(text(),\"This is a demo\")]/following::div[1]/header/div[1]/div/ul/li[2]")).click();
                    break;
                case "Create an Account":
                    driver.findElement(new By.ByXPath("//p[contains(text(),\"This is a demo\")]/following::div[1]/header/div[1]/div/ul/li[3]")).click();
                    break;
                default:
                    System.out.println("UnImplemented Case");
                    break;
            }
        }  catch(Exception error){
                System.out.println("Something went wrong."+error);
            }
        }
}
