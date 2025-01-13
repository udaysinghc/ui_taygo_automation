//package com.taygo.utility;
//
//
//import io.appium.java_client.android.*;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.TimeoutException;
//
//import org.openqa.selenium.support.ui.*;
//
//import java.io.*;
//import java.net.*;
//import java.time.*;
//import java.util.concurrent.*;
//
//public class AppiumSauceLabs {
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
//        // caps.setCapability("appium:platformVersion", "current_major");
//        caps.setCapability("appium:automationName", "UiAutomator2");
//        caps.setCapability("appium:appPackage", "com.sec.android.gallery3d");
//        caps.setCapability("appium:appActivity", "com.samsung.android.gallery.app.activity.GalleryActivity");
//
//        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("username", "shadabqa");
//        sauceOptions.setCapability("accessKey", "0e2a3434-3913-4cbc-b2c2-cf97cde765aa");
//        sauceOptions.setCapability("build", "upload file");
//        sauceOptions.setCapability("name", "image");
//        // sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
//
//        caps.setCapability("sauce:options", sauceOptions);
//
//        // Start the session
//        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        AndroidDriver driver = new AndroidDriver (url, caps);
//
//        // Path to the image to upload
//        String imagePath = "C:\\Users\\Admin\\Downloads\\taygo_logo.jpeg"; // Adjust this path as needed
//        File imageFile = new File(imagePath);
//
//        // Upload the image to the device
//        driver.pushFile("/sdcard/DCIM/Camera/uploaded_image.jpg", imageFile);
//        Thread.sleep(5000);
//
//        // Open the gallery app to check for the uploaded image
//        // Uncomment the line below if you need to launch the gallery app again
//        // driver.startActivity("com.sec.android.gallery3d", "com.samsung.android.gallery.app.activity.GalleryActivity");
//
//        // Wait for the image to be displayed
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try {
//            WebElement uploadedImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='taygo_logo.jpeg']"))); // Adjust as needed
//            System.out.println("Image uploaded successfully: " + uploadedImage);
//        } catch (TimeoutException e) {
//            System.out.println("Image upload failed or image not found: " + e.getMessage());
//        } finally {
//            driver.quit(); // Ensure the driver quits at the end of the test
//        }
//    }
//}
