package stepDefinitions.stepsSignInFeature;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import java.util.List;

public class stepsSignInFeature {

    private WebDriver driver;

    @Before
    public void beforeScenario() {
        System.setProperty("webdriver.chrome.driver", "/Users/glorialima/Documents/SeleniumWebDriver/chromedriver");
        this.driver = new ChromeDriver();
    }

    @After
    public void afterScenario() {
        this.driver.quit();
    }

    @Given("the user is at Netflix website")
    public void the_user_is_at_Netflix_website() {
        HomePage netflixHomePage = new HomePage(driver);
        netflixHomePage.accessPage();

    }

    @Given("the user is at Sign In page")
    public void the_user_is_at_Sign_In_page() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAccountLink();
    }

    @When("the user enters invalid credentials to Login")
    public void the_user_enters_invalid_credentials_to_Login(DataTable credentials) {

        SignInPage signIn = new SignInPage(driver);

        List<List<String>> data = credentials.asLists(String.class);

        for (int i = 0; i < data.size(); i++) {
            signIn.inputEmail(data.get(i).get(0));
            signIn.inputPassword(data.get(i).get(1));
            signIn.clickOnSignInButton();
        }
    }

    @Then("the application must display the error message {string}")
    public void after_seven_attempts_the_application_must_display_the_error_message(String expectedErrorMessage) {
        SignInPage signIn = new SignInPage(driver);
        String actualErrorMessage = signIn.getFailedSignInMessage();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

}
