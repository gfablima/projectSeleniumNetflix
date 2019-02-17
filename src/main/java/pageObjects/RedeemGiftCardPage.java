package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedeemGiftCardPage {

    private WebDriver driver;
    private final By giftCodeTextAreaLocator = By.cssSelector(".cta-gift .cta-smallForm .nfTextField");
    private final By redeemButtonLocator = By.cssSelector(".cta-gift .btn-bar > button");
    private final By invalidCodeMessageLocator = By.cssSelector(".cta-gift .cta-smallForm .inputError");

    public RedeemGiftCardPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to redeem gift card code
    public RedeemGiftCardPage inputGiftCardCode(String giftCode) {
        driver.findElement(giftCodeTextAreaLocator).sendKeys(giftCode);
        driver.findElement(redeemButtonLocator).click();
        return new RedeemGiftCardPage(driver);
    }

    public String getActualInvalidCodeMessage() {
        return driver.findElement(invalidCodeMessageLocator).getText();
    }

}
