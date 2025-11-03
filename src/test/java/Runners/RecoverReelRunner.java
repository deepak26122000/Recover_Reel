package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "/Users/softsuave/Desktop/Recovary_Reel/Feature",
        glue = {"StepDefinitions", "Hooks"},
        plugin = {"pretty",
                "html:target/cucumber-reports/index.html",
                "json:target/cucumber-reports/cucumber.json"},
        tags = "@signUp or @exercise"
)

public class RecoverReelRunner extends AbstractTestNGCucumberTests {

}
