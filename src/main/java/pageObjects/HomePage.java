package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private String pageUrl = "https://www.netflix.com/br-en/";
    private final By helpCenterLinkLocator = By.cssSelector(".footer-links > li:nth-child(2) > a");
    private final By contactUsLinkLocator = By.cssSelector(".footer-links > [placeholder = 'footer_responsive_link_contact_us_item'] > a");
    private final By redeemGiftCardLinkLocator = By.cssSelector(".footer-links > li:nth-child(7) > a");
    private final By privacyLinkLocator = By.cssSelector(".footer-links > li:nth-child(11) > a");
    private final By accountLinkLocator = By.cssSelector(".footer-links > li:nth-child(3) > a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to access home page
    public HomePage accessPage() {
        driver.get(this.pageUrl);
        return this;
    }

    //Method to click on button "Help Center" in the footnote
    public HelpCenterPage clickOnHelpCenterButton() {
        driver.findElement(helpCenterLinkLocator).click();
        return new HelpCenterPage(driver);
    }

    //Method to click on Contact footnote link
    public ContactUsPage clickOnContactUsLink() {
        driver.findElement(contactUsLinkLocator).click();
        return new ContactUsPage(driver);
    }

    //Method to click on Redeem gift card footnote link
    public RedeemGiftCardPage clickOnRedeemGiftCardLink() {
        driver.findElement(redeemGiftCardLinkLocator).click();
        return new RedeemGiftCardPage(driver);
    }

    //Method to click on Privacy footnote link
    public PrivacyStatementPage clickOnPrivacyLink() {
        driver.findElement(privacyLinkLocator).click();
        return new PrivacyStatementPage(driver);
    }

    //Method to click on Account footnote link
    public SignInPage clickOnAccountLink() {
        driver.findElement(accountLinkLocator).click();
        return new SignInPage(driver);
    }
}
