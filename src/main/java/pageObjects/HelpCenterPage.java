package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HelpCenterPage {

    private WebDriver driver;
    private By searchInputLocator = By.cssSelector(".search-control-wrapper > #search-input");
    private By searchSubmitButtonLocator = By.cssSelector(".search-control-wrapper > button");
    private By firstArticleTitleLocator = By.cssSelector(".search-results > div .title > a");

    public HelpCenterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to input keyword in search bar
    public HelpCenterPage searchKeyword(String name) {
        driver.findElement(searchInputLocator).sendKeys(name);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS) ;

        return new HelpCenterPage(driver);
    }

    //Method to select first result in the search list
    public HelpCenterPage selectFirstResult() {
        driver.findElement(searchSubmitButtonLocator).click();
        return new HelpCenterPage(driver);
    }

    //Method to click on article's title
    public ArticlePage clickArticleTitle() {
        driver.findElement(firstArticleTitleLocator).click();
        return new ArticlePage(driver);
    }

}