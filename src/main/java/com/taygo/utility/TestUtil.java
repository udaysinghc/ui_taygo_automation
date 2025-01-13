package com.taygo.utility;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

import com.taygo.base.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends DriverFactory {
    public WebElement webelement;
    private Actions actions;
    public static long PAGE_LOAD_TIMEOUT = 180;
    public static long IMPLICIT_WAIT = 60;

    public void presenceOfElementWait (WebElement elemen) {
        webelement =
                (new WebDriverWait (driver , Duration.ofSeconds (PAGE_LOAD_TIMEOUT))
                        .until (ExpectedConditions.visibilityOf (elemen)));
    }

    public void invisibleOfElementWait (WebElement element) {
        new WebDriverWait (driver , Duration.ofSeconds (PAGE_LOAD_TIMEOUT))
                .until (ExpectedConditions.invisibilityOf (element));
    }

    public WebElement elementToBeClickableWait (By locator) {
        webelement =
                (new WebDriverWait (driver , Duration.ofSeconds (PAGE_LOAD_TIMEOUT))
                        .until (ExpectedConditions.elementToBeClickable (locator)));
        return webelement;
    }

    public void click (WebElement element1) {
        element1.click ();
    }

    public String getElement (WebElement element1) {
        return element1.getText ();
    }


    public void switchToIframe (WebElement iframe) {
        driver.switchTo ().frame (iframe);
    }

    public void switchToIframe (String iframeNameOrId) {
        driver.switchTo ().frame (iframeNameOrId);
    }

    public void switchToIframe (int index) {
        driver.switchTo ().frame (index);
    }

    public void switchToDefaultContent () {
        driver.switchTo ().defaultContent ();
    }

    // Custom method for double-clicking on an element
    public void doubleClickWithHighlight (WebElement element) {
        if (element instanceof HighlightedWebElement) {
            // Highlight the element
            ((HighlightedWebElement) element).highlight ();
        }
        actions.moveToElement (element).doubleClick ().perform ();  // Perform the double-click action
    }

    // Custom method for dragging an element to a target element
    public void dragAndDropWithHighlight (WebElement source , WebElement target) {
        if (source instanceof HighlightedWebElement) {
            // Highlight the source element
            ((HighlightedWebElement) source).highlight ();
        }
        if (target instanceof HighlightedWebElement) {
            // Highlight the target element
            ((HighlightedWebElement) target).highlight ();
        }
        actions.clickAndHold (source).moveToElement (target).release ().perform ();  // Perform drag-and-drop action
    }

    // Custom method to drag an element to a specific offset
    public void dragAndDropWithOffset (WebElement element , int xOffset , int yOffset) {
        if (element instanceof HighlightedWebElement) {
            ((HighlightedWebElement) element).highlight ();
        }
        actions.clickAndHold (element).moveByOffset (xOffset , yOffset).release ().perform ();  // Drag to offset
    }

    // Custom method to hover over an element
    public void hoverOver (WebElement element) {
        actions.moveToElement (element).perform ();  // Move to the element
    }

    // Custom method to right-click on an element
    public void rightClick (WebElement element) {
        if (element instanceof HighlightedWebElement) {
            ((HighlightedWebElement) element).highlight ();
        }
        actions.contextClick (element).perform ();  // Perform right-click
    }

    // Custom method to scroll to an element
    public void scrollToElement (WebElement element) {
        actions.moveToElement (element).perform ();  // Move to the element
        // You might also want to use JavaScript to scroll if needed
        ((JavascriptExecutor) driver).executeScript ("arguments[0].scrollIntoView(true);" , element);
    }

    // Custom method to simulate key press on an element
    public void keyPress (WebElement element , CharSequence key) {
        actions.moveToElement (element).sendKeys (key).perform ();  // Simulate key press
    }


}
