package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class StartLiveChatPage {

    private WebDriver driver;

    private final By tellUsWhatYourIssueIsButtonLocator = By.className("link-tellus");
    private final By describeYourIssueTextAreaLocator = By.className("chatquestion");
    private final By submitButtonLocator = By.cssSelector(".popover-content.selfHelp-details.col-xs-12 button");
    private final By nonMemberButtonLocator = By.cssSelector(".popover-content.are-you-a-member.chat-details > button");

    public StartLiveChatPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to click on tell more about issue
    public ContactUsPage clickTellUsWhatYourIssueIsButton() {
        driver.findElement(tellUsWhatYourIssueIsButtonLocator).click();
        return new ContactUsPage(driver);
    }

    //Method to insert text describing issue
    public ContactUsPage insertTextInDescribeYourIssueTextArea(String issueText) {
        WebElement describeIssueTextArea = driver.findElement(describeYourIssueTextAreaLocator);
        describeIssueTextArea.sendKeys(issueText);
        return new ContactUsPage(driver);
    }

    //Method to submit issue description
    public ContactUsPage clickOnSubmitButton() {
        driver.findElement(submitButtonLocator).click();
        return new ContactUsPage(driver);
    }

    //Method to indicate that user is a non-member
    public LiveChatPopUpPage clickOnNonMemberButton() {
        driver.findElement(nonMemberButtonLocator).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new LiveChatPopUpPage(driver);
    }
}
