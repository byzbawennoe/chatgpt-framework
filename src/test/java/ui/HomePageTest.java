package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.driver.ChromeDriverManager;
import ui.pages.HomePage;

@Epic("Bing Weather Tests")
@Feature("Weather Information")
public class HomePageTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = ChromeDriverManager.getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    @Description("Test 1")
    public void testWeatherInLviv() {
        homePage.navigateTo("https://www.bing.com/");
        String widgetTitle = homePage.search("weather in Lviv").getWidgetTitle();
        Assert.assertEquals(widgetTitle, "Lviv, Ukraine");
    }

    @Test
    @Description("Test 2")
    public void testChatWidget() {
        homePage.navigateTo("https://www.bing.com/");
        String widgetTitle = homePage.clickChatLink().getChatWidgetTitle();
        Assert.assertEquals(widgetTitle, "Bing chat is only available on the Microsoft Edge browser. Download or open Microsoft Edge then navigate to chat.bing.com");
    }

    @Test
    @Description("Test 3")
    public void testSettingsPage() {
        homePage.navigateTo("https://www.bing.com/");
        String pageTitle = homePage.clickHamburgerMenu().clickSettingsButton().clickMoreOption().getPageTitle();
        Assert.assertEquals(pageTitle, "Settings");
    }

    @AfterMethod
    public void tearDown() {
       ChromeDriverManager.quitDriver();
    }

}
