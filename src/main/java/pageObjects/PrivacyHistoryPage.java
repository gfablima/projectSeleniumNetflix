package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyHistoryPage {

    private WebDriver driver;
    private final By downloadLinkLocator = By.cssSelector(".legal-docs-item > a");

    public PrivacyHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to check if download link is enabled
    public Boolean checkDownloadLinkAvailabity() {
        if (driver.findElement(downloadLinkLocator).isEnabled()) {
            return true;
        }
        return false;
    }

}
