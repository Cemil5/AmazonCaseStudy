package com.amazon.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"json:target/cucumber.json",          // our report file gets the test data from cucumber.json file
// json: xml file, keeps data in key and value structure, this plugin creates target / cucumber.json file
                "html:target/default-html-reports", // default cucumber html report
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/amazon/step_definitions",
     // dryRun = true,
        tags = "@wip"
)
public class CukesRunner {

}
