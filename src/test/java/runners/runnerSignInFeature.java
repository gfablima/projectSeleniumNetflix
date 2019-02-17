package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"stepDefinitions/stepsSignInFeature"},
        tags = {"@scenarioLoginWithInvalidCredentials"})

public class runnerSignInFeature {
}
