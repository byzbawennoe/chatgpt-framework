package ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(SearchResultsPage.class);

    // Locators
    private By weatherWidget = By.xpath("//a[@class='withPointerEvents']");

    private By chatWidgetTitle = By.xpath("//*[@id='waitListDefaultPayWall']//div//div[@class='description']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        logger.info("Navigated to Search results page: " + driver.getCurrentUrl());
    }

    public String getWidgetTitle() {
        return driver.findElement(weatherWidget).getText();
    }

    public String getChatWidgetTitle() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(chatWidgetTitle));
        return driver.findElement(chatWidgetTitle).getText();
    }
}
