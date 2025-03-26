package runner;

import com.luma.Utility.SetupClass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@CucumberOptions(
        features = "target/test-classes/features",
        tags ="@TestEndToEnd",
        glue={"com.luma.Utility","com.luma.stepDefinitions"},
        plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class ScriptRunner  extends AbstractTestNGCucumberTests {

}
