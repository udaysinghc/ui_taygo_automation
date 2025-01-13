package com.taygo.utility;

import com.taygo.base.*;
import org.jspecify.annotations.*;
import org.openqa.selenium.*;

import java.io.*;
import java.util.*;

public class WebEventListener extends DriverFactory implements WebDriver {

    public void beforeNavigateTo (String url , WebDriver driver) {
        System.out.println ("Before navigating to: '" + url + "'");
    }

    public void afterNavigateTo (String url , WebDriver driver) {
        System.out.println ("Navigated to:'" + url + "'");
    }

    public void beforeChangeValueOf (WebElement element , WebDriver driver) {
        System.out.println ("Value of the:" + element.toString () + " before any changes made");
    }

    public void afterChangeValueOf (WebElement element , WebDriver driver) {
        System.out.println ("Element value changed to: " + element.toString ());
    }

    public void beforeClickOn (WebElement element , WebDriver driver) {
        System.out.println ("Trying to click on: " + element.toString ());
    }

    public void afterClickOn (WebElement element , WebDriver driver) {
        System.out.println ("Clicked on: " + element.toString ());
    }

    public void beforeNavigateBack (WebDriver driver) {
        System.out.println ("Navigating back to previous page");
    }

    public void afterNavigateBack (WebDriver driver) {
        System.out.println ("Navigated back to previous page");
    }

    public void beforeNavigateForward (WebDriver driver) {
        System.out.println ("Navigating forward to next page");
    }

    public void afterNavigateForward (WebDriver driver) {
        System.out.println ("Navigated forward to next page");
    }


    public void beforeFindBy (By by , WebElement element , WebDriver driver) {
        System.out.println ("Trying to find Element By : " + by.toString ());
    }

    public void afterFindBy (By by , WebElement element , WebDriver driver) {
        System.out.println ("Found Element By : " + by.toString ());
    }

    /*
     * non overridden methods of WebListener class
     */
    public void beforeScript (String script , WebDriver driver) {
    }

    public void afterScript (String script , WebDriver driver) {
    }

    public void beforeAlertAccept (WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterAlertAccept (WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterAlertDismiss (WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeAlertDismiss (WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateRefresh (WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterNavigateRefresh (WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeChangeValueOf (WebElement element , WebDriver driver , CharSequence[] keysToSend) {
        // TODO Auto-generated method stub

    }

    public void afterChangeValueOf (WebElement element , WebDriver driver , CharSequence[] keysToSend) {
        // TODO Auto-generated method stub

    }

    public <X> void afterGetScreenshotAs (OutputType <X> arg0 , X arg1) {
        // TODO Auto-generated method stub

    }

    public void afterGetText (WebElement arg0 , WebDriver arg1 , String arg2) {
        // TODO Auto-generated method stub

    }

    public void afterSwitchToWindow (String arg0 , WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public <X> void beforeGetScreenshotAs (OutputType <X> arg0) {
        // TODO Auto-generated method stub

    }

    public void beforeGetText (WebElement arg0 , WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void beforeSwitchToWindow (String arg0 , WebDriver arg1) {
        // TODO Auto-generated method stub
    }

    @Override
    public void get (String url) {

    }

    @Override
    public @Nullable String getCurrentUrl () {
        return "";
    }

    @Override
    public @Nullable String getTitle () {
        return "";
    }

    @Override
    public List <WebElement> findElements (By by) {
        return List.of ();
    }

    @Override
    public WebElement findElement (By by) {
        return null;
    }

    @Override
    public @Nullable String getPageSource () {
        return "";
    }

    @Override
    public void close () {

    }

    @Override
    public void quit () {

    }

    @Override
    public Set <String> getWindowHandles () {
        return Set.of ();
    }

    @Override
    public String getWindowHandle () {
        return "";
    }

    @Override
    public TargetLocator switchTo () {
        return null;
    }

    @Override
    public Navigation navigate () {
        return null;
    }

    @Override
    public Options manage () {
        return null;
    }
}