package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager {

    private static ThreadLocal<WebDriver> threadLocalDriver  = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger(ChromeDriverManager.class);

    private ChromeDriverManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            WebDriverManager.chromedriver().setup();
            threadLocalDriver.set(new ChromeDriver());
            logger.info("WebDriver instance created for thread: " + Thread.currentThread().getId());
        }
        return threadLocalDriver.get();
    }

    public static synchronized void quitDriver() {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            driver.quit();
            threadLocalDriver.remove();
            logger.info("WebDriver instance quit for thread: " + Thread.currentThread().getId());
        }
    }
/*
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            WebDriver driver = ChromeDriverManager.getDriver();
            driver.get("https://www.example.com");
            // Use the driver for testing

            ChromeDriverManager.quitDriver();
        });

        Thread thread2 = new Thread(() -> {
            WebDriver driver = ChromeDriverManager.getDriver();
            driver.get("https://www.example2.com");
            // Use the driver for testing

            ChromeDriverManager.quitDriver();
        });

        thread1.start();
        thread2.start();
    }*/

}
