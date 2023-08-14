package ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HamburgerMenu {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HamburgerMenu.class);

    private By settings = By.id("hbsettings");

    private By moreOption = By.xpath("//div[@class='hb_title_col' and text()='More']");

    public HamburgerMenu(WebDriver driver) {
        this.driver = driver;
        logger.info("Hamburger menu is opened");
    }

    public HamburgerMenu clickSettingsButton() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(settings)).click();
        return this;
    }

    public SettingsPage clickMoreOption() {
        driver.findElement(moreOption).click();
        return new SettingsPage(driver);
    }

}
