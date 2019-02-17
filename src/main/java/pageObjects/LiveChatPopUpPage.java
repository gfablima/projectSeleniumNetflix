package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LiveChatPopUpPage {

    private WebDriver driver;
    private final By chatTitleLocator = By.className("cse-chat-title");
    private String liveChatTitle = "";

    public LiveChatPopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to get chat title
    public String getChatTitle() throws InterruptedException {

        if (driver.findElements(By.tagName("iframe")).size() > 0) {
            driver.switchTo().frame(0);
            Thread.sleep(5000); //explicit and implicit wait didn't work
            liveChatTitle = driver.findElement(chatTitleLocator).getText();
            System.out.println("titulo:" + liveChatTitle);
        }

        return liveChatTitle;
    }


}
