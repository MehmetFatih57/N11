package N11.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/default-cucumber-reports.html",
        "json:target/json-reports/cucumber1.json",
        "junit:target/xml-report/cucumber.xml",
        "rerun:TestOutput/failed_scenario.txt"},
        features = "src/test/resources/features",
        glue = {"N11/stepdefinition"},
        tags = "@N11",
        dryRun = false,
        monochrome = true

)


public class Runner {
}





