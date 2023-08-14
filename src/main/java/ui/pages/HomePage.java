package ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.ChromeDriverManager;

public class HomePage {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    // Locators
    private By searchBoxLocator = By.name("q");
    private By searchButtonLocator = By.name("go");

    private By chatLink = By.xpath("//div[@class='text' and text()='Chat']");

    private By hamburgerMenu = By.id("id_sc");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
        logger.info("Navigated to: " + url);
    }

    public SearchResultsPage search(String query) {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.sendKeys(query);
        searchBox.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage clickChatLink() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(chatLink)).click();
        return new SearchResultsPage(driver);
    }

    public HamburgerMenu clickHamburgerMenu() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(hamburgerMenu)).click();
        return new HamburgerMenu(driver);
    }

}
