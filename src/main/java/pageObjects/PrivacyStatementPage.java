package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyStatementPage {

    private WebDriver driver;
    private final By priorVersionLinkLocator = By.cssSelector(".kb-article-variant > p:nth-child(45) > a");

    public PrivacyStatementPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to click on Prior Version link
    public PrivacyHistoryPage clickOnPriorVersionLink(){
        driver.findElement(priorVersionLinkLocator).click();
        return new PrivacyHistoryPage(driver);

    }
}
