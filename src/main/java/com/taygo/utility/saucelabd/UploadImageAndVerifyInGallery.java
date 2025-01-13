//package com.taygo.utility;
//
//import io.appium.java_client.android.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;
//
//public class UploadImageAndVerifyInGallery {
//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
//        // Set Android capabilities
//        MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("appium:deviceName", "emulator-5554"); // Adjust device name as needed (check the device name via 'adb devices')
//        caps.setCapability("appium:automationName", "UiAutomator2");
//        caps.setCapability("appium:appPackage", "com.sec.android.gallery3d");
//        caps.setCapability("appium:appActivity", "com.samsung.android.gallery.app.activity.GalleryActivity");
//
//        // Start the session with the local Appium server
//        URL url = new URL("http://localhost:4723/wd/hub");
//        AndroidDriver driver = new AndroidDriver(url, caps);
//
//        // Path to the image to upload (ensure the image exists at this path)
//        String imagePath = "C:\\Users\\Admin\\Downloads\\taygo_logo.jpeg";
//        File imageFile = new File(imagePath);
//
//        try {
//            // Upload the image to the Android device's gallery
//            driver.pushFile("/sdcard/DCIM/Camera/uploaded_image.jpg", imageFile);
//            System.out.println("Image uploaded to device.");
//
//            // Wait for a few seconds to ensure image upload
//            Thread.sleep(5000);
//
//            // Launch the gallery app
//            Activity galleryActivity = new Activity("com.sec.android.gallery3d", "com.samsung.android.gallery.app.activity.GalleryActivity");
//            driver.startActivity(galleryActivity);
//            System.out.println("Gallery app launched.");
//
//            // Wait and check for the uploaded image in the gallery
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement uploadedImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='uploaded_image.jpg']")));
//            System.out.println("Image found in the gallery.");
//
//        } catch (WebDriverException e) {
//            System.out.println("Error during the test: " + e.getMessage());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            // End the session
//            driver.quit();
//            System.out.println("Test completed.");
//        }
//    }
//}
