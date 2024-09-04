package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html"
        },
        features = "src/test/resources/features",
        glue = "step_definitions",
        dryRun = true,
        tags = ""
)
public class CukesRunner {
}
