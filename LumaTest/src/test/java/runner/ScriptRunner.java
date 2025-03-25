package runner;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;

@CucumberOptions(
        features = "target/test-classes/features",
        tags ="@Test01",
        glue={"com.luma.stepDefinitions","src/main/resources/utility"}
//        plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//        }
)
public class ScriptRunner  extends AbstractTestNGCucumberTests {
    protected static WebDriver driver;

    @BeforeTest
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/chromedriver.exe"); // Set the path to your chromedriver
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);  // Initialize the WebDriver
            driver.manage().window().maximize();  // Maximize the browser window
        }
    }

    @AfterTest(alwaysRun=true)
    public void TearDown()   {
        try {
            driver.quit();
        }
        catch (Exception error){
            System.out.println("Something went wrong."+error);

        }
    }
}
