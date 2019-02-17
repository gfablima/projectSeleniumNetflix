package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ArticlePage {

    private WebDriver driver;
    private By buttonNoLocator = By.cssSelector(".feedback-prompt > div:nth-child(2) > button:nth-child(2)");
    private String secondOption = "2";
    private By radioButtonFeedbackOptionLocator = By.cssSelector(".article-feedback .problems > div:nth-child(" + secondOption + ") button");
    private By articleFeedbackLocator = By.cssSelector(".article-feedback");
    private By buttonSubmitFeedbackLocator = By.cssSelector(".article-feedback .problems > div:nth-child(" + secondOption + ") > div button");

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to click on button 'NO' that indicates that the article is not helpful
    public ArticlePage clickButtonNo() {
        driver.findElement(buttonNoLocator).click();
        return new ArticlePage(driver);
    }

    //Method sends feedback
    public ArticlePage sendFeedback() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(radioButtonFeedbackOptionLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement buttonSubmitFeedback = wait.until(visibilityOfElementLocated(buttonSubmitFeedbackLocator));
        buttonSubmitFeedback.click();
        return new ArticlePage(driver);
    }

    //Method gets confirmation message that feedback was sent
    public String msgFeedbackSent() {
        String msgFeedback = driver.findElement(articleFeedbackLocator).getText();
        return msgFeedback;
    }
}