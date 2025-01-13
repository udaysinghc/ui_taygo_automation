//package com.taygo.utility;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class UploadImageToGallery {
//    public static void main(String[] args) {
//        AndroidDriver driver = null;
//
//        try {
//            // Desired capabilities for Android device in Sauce Labs
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("platformName", "Android");
//            caps.setCapability("deviceName", "Samsung Galaxy S24"); // Example, use appropriate device
//            caps.setCapability("platformVersion", "14.0");
//            caps.setCapability("username", System.getenv("shadabqa")); // Use environment variable
//            caps.setCapability("accessKey", System.getenv("0e2a3434-3913-4cbc-b2c2-cf97cde765aa")); // Use environment variable
//
//            // Sauce Labs URL
//            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com/wd/hub");
//
//            // Initialize AndroidDriver
//            driver = new AndroidDriver(url, caps);
//
//            // Specify the file path of the image on your local machine or Sauce Storage
//            File imageFile = new File("C:\\Users\\Admin\\Downloads\\taygo_logo.jpeg"); // Or Sauce storage ID
//            if (!imageFile.exists()) {
//                throw new IOException("Image file not found at " + imageFile.getAbsolutePath());
//            }
//
//            // Push file to the Android device's gallery
//            driver.pushFile("/sdcard/DCIM/Camera/uploaded_image.jpg", imageFile);
//
//            System.out.println("Image successfully uploaded to the device.");
//
//            // Optionally, automate opening the gallery app and verifying the image
//            // Add code to launch the gallery app and verify if needed.
//
//        } catch (MalformedURLException e) {
//            System.err.println("Invalid Sauce Labs URL: " + e.getMessage());
//        } catch (IOException e) {
//            System.err.println("Error uploading file: " + e.getMessage());
//        } finally {
//            if (driver != null) {
//                driver.quit();
//            }
//        }
//    }
//}
