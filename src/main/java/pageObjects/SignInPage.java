package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver driver;
    private final By emailTextAreaLocator = By.cssSelector(".input_id > #id_userLoginId");
    private final By passwordTextAreaLocator = By.cssSelector(".input_id > #id_password");
    private final By signInButtonLocator = By.cssSelector(".login-button");
    private final By failedSignInMessageLocator = By.cssSelector(".ui-message-error > .ui-message-contents");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to input email address in the login area
    public SignInPage inputEmail(String email) {
        driver.findElement(emailTextAreaLocator).clear();
        driver.findElement(emailTextAreaLocator).sendKeys(email);
        return new SignInPage(driver);
    }

    ////Method to input the password in the login area
    public SignInPage inputPassword(String password) {
        driver.findElement(passwordTextAreaLocator).sendKeys(password);
        return new SignInPage(driver);
    }

    //Method to click on Sign in button
    public SignInPage clickOnSignInButton() {
        driver.findElement(signInButtonLocator).click();
        return new SignInPage(driver);
    }

    //Method to get error message when login fails
    public String getFailedSignInMessage() {
        return driver.findElement(failedSignInMessageLocator).getText();
    }

}