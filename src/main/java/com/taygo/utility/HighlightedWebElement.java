package com.taygo.utility;

import org.openqa.selenium.*;

import java.util.List;

public class HighlightedWebElement implements WebElement {
    private final WebDriver driver;
    private final WebElement element;

    public HighlightedWebElement(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
    }

    // Add a highlight method
    void highlight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 4px solid yellow;");
        try {
            Thread.sleep(500);  // Just to make the highlight visible (adjust as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Revert to the original style
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
    }

    // Now override WebElement methods to inject the highlight before each interaction

    @Override
    public void click() {
        highlight();
        element.click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        highlight();
        element.sendKeys(keysToSend);
    }

    @Override
    public String getText() {
        highlight();
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    // Delegate other WebElement methods without modifying them
    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }
}
