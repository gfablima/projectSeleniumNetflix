package stepDefinitions.stepsHelpCenterFeature;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ArticlePage;
import pageObjects.HelpCenterPage;
import pageObjects.HomePage;
import pageObjects.SignInPopupPage;

public class stepsHelpCenterFeature {

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

    @Given("the user is at Help Center page")
    public void the_user_is_at_Help_Center_page() {
        HomePage netflixHomePage = new HomePage(driver);
        netflixHomePage.clickOnHelpCenterButton();
        SignInPopupPage signInPopup = new SignInPopupPage(driver);
        signInPopup.closePopupHelpCenterPage();
    }

    @When("the user searches for keyword {string}")
    public void the_user_searches_for_keyword(String keyword) {
        HelpCenterPage helpCenter = new HelpCenterPage(driver);
        helpCenter.searchKeyword(keyword);
        helpCenter.selectFirstResult();
        helpCenter.clickArticleTitle();
    }

    @And("the user evaluates the first result as not helpful")
    public void the_user_evaluates_the_first_result_as_not_helpful() {
        ArticlePage article = new ArticlePage(driver);
        article.clickButtonNo();
        article.sendFeedback();
    }

    @Then("the message {string} is shown")
    public void the_message_is_shown(String expectedFeedbackMsg) {
        ArticlePage article = new ArticlePage(driver);
        String actualFeedbackMsg = article.msgFeedbackSent();
        Assert.assertEquals(expectedFeedbackMsg, actualFeedbackMsg);
    }
}
