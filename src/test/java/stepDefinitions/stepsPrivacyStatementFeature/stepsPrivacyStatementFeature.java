package stepDefinitions.stepsPrivacyStatementFeature;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.PrivacyHistoryPage;
import pageObjects.PrivacyStatementPage;

public class stepsPrivacyStatementFeature {

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

    @Given("the user is at Privacy page")
    public void the_user_is_at_Privacy_page() {
        HomePage netflixHomePage = new HomePage(driver);
        netflixHomePage.clickOnPrivacyLink();
    }

    @When("the user chooses to see prior version of the privacy statement")
    public void the_user_chooses_to_see_prior_version_of_the_privacy_statement() {
        PrivacyStatementPage privacyStament = new PrivacyStatementPage(driver);
        privacyStament.clickOnPriorVersionLink();
    }

    @Then("the link to download document must be available")
    public void the_link_to_download_document_must_be_available() {
        PrivacyHistoryPage privacyHistory = new PrivacyHistoryPage(driver);
        Assert.assertTrue(privacyHistory.checkDownloadLinkAvailabity());
    }

}
