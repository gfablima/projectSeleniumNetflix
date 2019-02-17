package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {

    private WebDriver driver;
    By startLiveChatButtonLocator = By.className("start-chat-button");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to click on Start Live Chat button
    public LiveChatPopUpPage clickOnStartLiveChatButton() throws InterruptedException {

        WebElement startLiveChatbutton = driver.findElement(startLiveChatButtonLocator);
        startLiveChatbutton.click();
        return new LiveChatPopUpPage(driver);
    }

}
