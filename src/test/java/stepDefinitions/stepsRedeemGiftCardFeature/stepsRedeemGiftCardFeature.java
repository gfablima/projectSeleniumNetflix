package stepDefinitions.stepsRedeemGiftCardFeature;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.RedeemGiftCardPage;

public class stepsRedeemGiftCardFeature {

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

    @Given("the user is at Redeem Gift Card page")
    public void the_user_is_at_Redeem_Gift_Card_page() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnRedeemGiftCardLink();
    }

    @When("the user redeems the invalid gift card code {string}")
    public void the_user_redeems_the_invalid_gift_card_code(String giftCardCode) throws InterruptedException {
        RedeemGiftCardPage redeemGiftCard = new RedeemGiftCardPage(driver);
        redeemGiftCard.inputGiftCardCode(giftCardCode);
    }

    @Then("the error message {string} is shown")
    public void the_error_message_is_shown(String expectedInvalidCodeMessage) {
        RedeemGiftCardPage redeemGiftCard = new RedeemGiftCardPage(driver);
        String actualInvalidCodeMessage = redeemGiftCard.getActualInvalidCodeMessage();
        Assert.assertEquals(expectedInvalidCodeMessage, actualInvalidCodeMessage);
    }

}
