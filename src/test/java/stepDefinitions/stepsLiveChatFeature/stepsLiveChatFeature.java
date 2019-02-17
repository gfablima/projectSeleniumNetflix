package stepDefinitions.stepsLiveChatFeature;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;

public class stepsLiveChatFeature {

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

    @Given("the user is at Contact Us page")
    public void the_user_is_at_Contact_Us_page() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnContactUsLink();
    }

    @When("the user chooses to start a live chat")
    public void the_user_chooses_to_start_a_live_chat() throws InterruptedException {
        SignInPopupPage signInPopup = new SignInPopupPage(driver);
        signInPopup.closePopupContactUsPage();
        ContactUsPage contactUs = new ContactUsPage(driver);
        contactUs.clickOnStartLiveChatButton();
    }

    @And("the user inserts the issue {string}")
    public void the_user_inserts_the_issue(String issue) {
        StartLiveChatPage startLiveChat = new StartLiveChatPage(driver);
        startLiveChat.clickTellUsWhatYourIssueIsButton();
        startLiveChat.insertTextInDescribeYourIssueTextArea(issue);
        startLiveChat.clickOnSubmitButton();
    }

    @And("the user is not a member")
    public void the_user_is_not_a_member() {
        StartLiveChatPage startLiveChat = new StartLiveChatPage(driver);
        startLiveChat.clickOnNonMemberButton();
    }

    @Then("the live chat pops up displaying the title {string}")
    public void the_live_chat_pops_up_displaying_the_title(String title) throws InterruptedException {
        LiveChatPopUpPage liveChatPopUp = new LiveChatPopUpPage(driver);
        String titleInChat = liveChatPopUp.getChatTitle();
        Assert.assertEquals(title, titleInChat);
    }

}