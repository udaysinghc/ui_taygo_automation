//package com.taygo.utility.saucelabd;
//
//import org.openqa.selenium.*;
//
//import java.net.*;
//
//public class uploadappsource {
//
//    public static void main(String[] abc) throws MalformedURLException {
//        MutableCapabilities caps = new MutableCapabilities ();
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("appium:platformVersion", "15.0");
//        caps.setCapability("appium:deviceName", "iPhone .*");
//        caps.setCapability("appium:orientation", "portrait");
//        caps.setCapability("appium:app", "C:\\Users\\Admin\\Downloads\\Android-MyDemoAppRN.1.0.0.build-130 (1).apk");
//        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("username", "shadabqa");
//        sauceOptions.setCapability("accessKey", "0e2a3434-3913-4cbc-b2c2-cf97cde765aa");
//        caps.setCapability("sauce:options", sauceOptions);
//        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        AndroidDriver driver = new AndroidDriver (url, caps);
//    }
//}
