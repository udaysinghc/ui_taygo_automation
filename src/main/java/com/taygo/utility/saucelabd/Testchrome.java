//package com.taygo.utility;
//
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.remote.*;
//
//import java.net.*;
//import java.util.*;
//
//public class Testchrome {
//
//
//    WebDriver driver;
//
//    public static void main (String[] abc) throws MalformedURLException {
//        ChromeOptions browserOptions = new ChromeOptions ();
//        browserOptions.setPlatformName ("Windows 11");
//        browserOptions.setBrowserVersion ("latest");
//        Map <String, Object> sauceOptions = new HashMap <> ();
//        sauceOptions.put ("username" , "shadabqa");
//        sauceOptions.put ("accessKey" , "0e2a3434-3913-4cbc-b2c2-cf97cde765aa");
////        sauceOptions.put ("build" , "test conection");
////        sauceOptions.put ("name" , "<your test name>");
////        browserOptions.setCapability ("sauce:options" , sauceOptions);
//
//        // start the session
//        URL url = new URL ("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        RemoteWebDriver driver = new RemoteWebDriver (url , browserOptions);
//
//// run commands and assertions
//        driver.get ("https://saucedemo.com");
//        String title = driver.getTitle ();
//        boolean titleIsCorrect = title.contains ("Swag Labs");
//        String jobStatus = titleIsCorrect ? "passed" : "failed";
//
//// end the session
//        driver.executeScript ("sauce:job-result=" + jobStatus);
//        driver.quit ();
//    }
//}
