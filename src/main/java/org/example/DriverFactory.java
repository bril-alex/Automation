package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    static WebDriver createDriver(WEBDRIVERS webdrivers){
        WebDriver driver = null;
        switch (webdrivers){
            case CHROMECLEAN -> createCleanChrome();
        }
        return driver;
    }

    static final String BROWSER_DRIVER_PATH = "target/Webdriver/chromedriver_mac64/chromedriver_3/";

    private static WebDriver createCleanChrome() {
        System.setProperty("webdriver.chrome.driver", BROWSER_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }

}
