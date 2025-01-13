package com.taygo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import java.util.*;

public class DriverFactory {

    protected static WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--use-fake-ui-for-media-stream");

                // Disable popup blocking
                chromeOptions.setExperimentalOption("excludeSwitches", List.of ("disable-popup-blocking"));

                tlDriver.set(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("permissions.default.microphone", 1);
                profile.setPreference("dom.webnotifications.enabled", false);
                profile.setPreference("signon.rememberSignons", false);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(profile);
                tlDriver.set(new FirefoxDriver(firefoxOptions));
                break;
            case "safari":
                tlDriver.set(new SafariDriver());
                break;
            default:
                System.out.println("Please pass the correct browser value: " + browser);
                break;
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static  WebDriver getDriver() {
        return tlDriver.get();
    }

}
