package ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(SettingsPage.class);

    private By settingsPageTitle = By.xpath("//h2[@class='pb-title-nav-strip__title']");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        logger.info("Settings page is opened: " + driver.getCurrentUrl());
    }

    public String getPageTitle() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(settingsPageTitle));
        return driver.findElement(settingsPageTitle).getText();
    }

}
