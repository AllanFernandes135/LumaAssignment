package com.luma.stepDefinitions;

import com.luma.Utility.SetupClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Random;


public class CreateAnOrderSteps  {
    WebDriver driver = SetupClass.driver;
//    SetupClass setupClass = new SetupClass();
    final String expectedValidationMessage = "This is a required field.";

    final String difTypeOfCombinationValidationMessage ="Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";

    final String minPasswordLength ="Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";

    final String passwordNotMatch = "Please enter the same value again.";

    final String emailFormatingValidation = "Please enter a valid email address (Ex: johndoe@domain.com).";

    final String succesfullyCreatingAccountValidationMessage = "Thank you for registering with Main Website Store.";

    final String invalidLoginCredsValidationMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";

    Duration wait = Duration.ofSeconds(10);

    JavascriptExecutor execute = (JavascriptExecutor) driver;

    WebDriverWait webDriverWaiting = new WebDriverWait(driver, wait);


    @And("I click on the {string} button")
    public void iClickOnTheButton(String button) throws InterruptedException {
        try {
            switch (button) {
                case "Create an Account":
                    execute.executeScript("window.scrollBy(0,400)", "");
                    driver.findElement(new By.ByXPath("//li/a[text()=\"Search Terms\"]/ancestor::div/ancestor::div/main/div[3]/div/form/div/div/button")).click();
                    break;
                case "Sign In":
                    driver.findElement(By.id("send2")).click();
                    break;
                default:
                    System.out.println("UnImplemented Case");
                    break;
            }
        }catch(Exception error){
                System.out.println("Something went wrong."+error);
            }
        }

    @Then("I should see {string} validation message for {string} textbox")
    public void iShouldSeeValidationMessageForTextbox(String message, String textbox) {
        try{
        String validationError ="";
        switch (message) {

            case "This is a required field":
                validationError = driver.findElement(new By.ByXPath("//span[text()='" + textbox + "']/following::div[2]")).getText();
                Assert.assertEquals(validationError, expectedValidationMessage);
                break;
            case "Password not meeting all conditions":
            case "Not Meeting Minimum Type Of Char":
                validationError = driver.findElement(new By.ByXPath("//span[text()='" + textbox + "']/following::div[2]")).getText();
                Assert.assertEquals(validationError, difTypeOfCombinationValidationMessage);
                break;
            case "Password having space":
            case "Not Meeting Minimum length":
                validationError = driver.findElement(new By.ByXPath("//span[text()='" + textbox + "']/following::div[2]")).getText();
                Assert.assertEquals(validationError, minPasswordLength);
                break;
            case "Password Not Matching":
                validationError = driver.findElement(new By.ByXPath("//span[text()='" + textbox + "']/following::div[2]")).getText();
                Assert.assertEquals(validationError, passwordNotMatch);
                break;
            case "Incorrect Email login Format":
                validationError = driver.findElement(new By.ByXPath("//span[text()='Email']/following::div[2]")).getText();
                Assert.assertEquals(validationError, emailFormatingValidation);
                break;
            case "Incorrect Email Format":
                validationError = driver.findElement(new By.ByXPath("//span[text()='" + textbox + "']/following::div[2]")).getText();
                Assert.assertEquals(validationError, emailFormatingValidation);
                break;
            case "Account already exists with current email":
                webDriverWaiting.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//h1/span/following::div[1]//div[text()=contains(text(),'There is already an account with this email address.')]")));
                break;
            default:
                System.out.println("UnImplemented Case");
                break;
        }
        }catch(Exception error){
            System.out.println("Something went wrong."+error);
        }

    }

    @And("I enter {string} in the {string} textbox")
    public void iEnterInTheTextbox(String text, String textbox) throws InterruptedException {
        try{
        switch (textbox){
            case "First Name":
                driver.findElement(By.id("firstname")).click();
                driver.findElement(By.id("firstname")).sendKeys(text);
                break;
            case "Last Name":
                Thread.sleep(1000);
                driver.findElement(By.id("lastname")).click();
                driver.findElement(By.id("lastname")).sendKeys(text);
                break;
            case "Email":
                Thread.sleep(1000);
                driver.findElement(By.id("email_address")).click();
                if(text.contentEquals("Unique")){
                    Random rand = new Random();
                    int randomNumber = rand.nextInt(999);
                    String email= text+"_"+randomNumber+"@gmail.com";
                    driver.findElement(By.id("email_address")).sendKeys(email);

                }
                else {
                    driver.findElement(By.id("email_address")).sendKeys(text);

                }

                execute.executeScript("window.scrollBy(0,400)","");
                break;
            case "Password":
                Thread.sleep(1000);

                driver.findElement(By.id("password")).click();
                driver.findElement(By.id("password")).sendKeys(text);
                break;

            case "Confirm Password":
                driver.findElement(By.id("password-confirmation")).click();;
                driver.findElement(By.id("password-confirmation")).sendKeys(text);
                break;
            case "Email Login":
                if(text.contentEquals("Existing User Email")){
                    String existingUserEmail ="TesterDias@gmail.com";
                    driver.findElement(By.id("email")).click();
                    driver.findElement(By.id("email")).sendKeys(existingUserEmail);
                }
                else {
                    driver.findElement(By.id("email")).click();
                    driver.findElement(By.id("email")).sendKeys(text);
                }
                break;
            case "Password Login":
                if(text.contentEquals("Existing User Password")){
                    String existingUserPassword ="Password@123";
                    driver.findElement(By.id("pass")).click();
                    driver.findElement(By.id("pass")).sendKeys(existingUserPassword);
                }
                else{
                    driver.findElement(By.id("pass")).click();;
                    driver.findElement(By.id("pass")).sendKeys(text);
                }
                break;
            default:
                System.out.println("UnImplemented Case");
                break;
        }
        }catch(Exception error){
            System.out.println("Something went wrong."+error);
        }
    }

    @And("I scroll up")
    public void iScrollUp() throws InterruptedException {
        try{
        execute.executeScript("window.scrollBy(0,-400)","");
        execute.executeScript("window.scrollBy(0,-400)","");
        Thread.sleep(2000);
        }catch(Exception error){
            System.out.println("Something went wrong."+error);
        }
    }

    @Then("I should see the password strength as {string}")
    public void iShouldSeeThePasswordStrengthAs(String passwordStrength) {
        try{
        String uiPasswordStrength =  driver.findElement(new By.ById("password-strength-meter-label")).getText();
        Assert.assertEquals(uiPasswordStrength,passwordStrength);
        }catch(Exception error){
            System.out.println("Something went wrong."+error);
        }
    }

    @And("I clear the {string} textbox")
    public void iClearTheTextbox(String textbox) {
        try{
        switch (textbox){
            case "Password":
                driver.findElement(By.id("password")).click();
                driver.findElement(By.id("password")).clear();
            default:
                System.out.println("UnImplemented Case");
                break;
        }
        }catch(Exception error){
            System.out.println("Something went wrong."+error);
        }
    }


    @Then("I should see {string} validation message")
    public void iShouldSeeValidationMessage(String validationMessage) {
        try{
        switch (validationMessage){
            case "Succefully registered":
                String validationSuccess = driver.findElement(new By.ByXPath("//div[text()='Thank you for registering with Main Website Store.']")).getText();
                Assert.assertEquals(validationSuccess, succesfullyCreatingAccountValidationMessage);
                break;
            case "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later":
                webDriverWaiting.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")));
                String validationError = driver.findElement(new By.ByXPath("//div[text()=\"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.\"]")).getText();
                Assert.assertEquals(validationError, invalidLoginCredsValidationMessage);
                break;
            default:
                System.out.println("UnImplemented Case");
                break;
        }
        }catch(Exception error){
            System.out.println("Something went wrong."+error);
        }

    }

    @Then("I should see welcome user message")
    public void iShouldSeeWelcomeUserMessage() {
        try {
            webDriverWaiting.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//div/p[contains(text(),'This is a demo store')]/following::div[1]/header/div[1]/div/ul/li/span[contains(text(),'Welcome')]")));
            String welcometext = driver.findElement(new By.ByXPath("//div/p[contains(text(),'This is a demo store')]/following::div[1]/header/div[1]/div/ul/li/span[contains(text(),'Welcome')]")).getText();
            Assert.assertTrue("Welcome Message is not displayed", welcometext.contains("Welcome"));
        } catch (Exception error) {
            System.out.println("Something went wrong." + error);
        }
    }


}
