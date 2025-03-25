package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
//import static com.luma.stepDefinitions.CreateAnOrderSteps.driver;

@CucumberOptions(
        features = "target/test-classes/features",
        tags ="@Test01",
        glue={"com.luma.stepDefinitions"}
//        plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//        }
)
public class ScriptRunner extends AbstractTestNGCucumberTests {

//    @AfterTest(alwaysRun=true)
//    public void TearDown()   {
//        try {
//            driver.quit();
//        }
//        catch (Exception error){
//            System.out.println("Something went wrong."+error);
//
//        }
//    }
}
