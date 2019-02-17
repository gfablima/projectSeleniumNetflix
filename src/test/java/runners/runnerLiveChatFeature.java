package runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"stepDefinitions/stepsLiveChatFeature"},
        tags = {"@scenarioStartLiveChat"})

public class runnerLiveChatFeature {
}