package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPopupPage {
    private WebDriver driver;

    private final WebDriverWait wait;
    private final By closeButtonLocator = By.cssSelector(".signin-modal-content > .close-modal");
    private final By popupLocator = By.cssSelector(".signin-modal");

    public SignInPopupPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 3);
    }

    //Method to close sign in pop-up at Help Center page
    public HelpCenterPage closePopupHelpCenterPage() {
        if (isDisplayed()) {
            WebElement closePopup = wait.until(visibilityOfElementLocated(closeButtonLocator));
            closePopup.click();
        }
        return new HelpCenterPage(driver);
    }

    //Method to close sign in pop-up at Contact Us page
    public ContactUsPage closePopupContactUsPage() {
        if (isDisplayed()) {
            WebElement closePopup = wait.until(visibilityOfElementLocated(closeButtonLocator));
            closePopup.click();
        }
        return new ContactUsPage(driver);
    }

    //Method to check if pop-up is displayed in the page
    private Boolean isDisplayed() {
        try {
            WebElement popup = wait.until(visibilityOfElementLocated(popupLocator));
            return popup.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}
