package bmw;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        format = { "html:target/html/RBI-Reports", "json:target/html/cucumber/cucumber.json"},
        features = {"src/test/scenarios"},
        //glue = {"src/test/java/bmw"},
        tags = {"@ApiTest"}
)
public class RunnerTestApi {
}
