package com.luma.Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public class SetupClass  {

    public static WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();  }
    }

    @After()
    public void TearDown()   {
        try {
            driver.quit();
        }
        catch (Exception error){
            System.out.println("Something went wrong."+error);

        }
    }

    @AfterTest()
    public void addScreenshot(Scenario scenario) throws IOException {
        String screenshotPath = null;
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        File destinationFile = new File(System.getProperty("user.dir") + "/ScriptResult/Screenshots/" + "Capture_" + System.currentTimeMillis() + ".png");
        FileHandler.copy(screenshot, destinationFile);
        String relatvePath = destinationFile.toString();
        screenshotPath = ".\\" + relatvePath;
        screenshotPath = relatvePath;
        scenario.attach(fileContent, "image/png", "ScreenShot:");
    }

    @BeforeSuite()
    public void deleteOldScreenshots() throws IOException {
        final String SCREENSHOT_DIR = System.getProperty("user.dir") + "/ScriptResult/Screenshots/";
        File screenshotDir = new File(SCREENSHOT_DIR);

        if (screenshotDir.exists()) {
            FileUtils.cleanDirectory(screenshotDir);
            System.out.println("Old screenshots deleted successfully.");
        } else {
            System.out.println("Screenshot directory does not exist.");
        }
    }

}
