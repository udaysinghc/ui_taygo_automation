package com.taygo.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.util.List;
import java.util.stream.Collectors;

public class HighlightElementLocator implements ElementLocator {
    private final WebDriver driver;
    private final ElementLocator locator;

    // Constructor to initialize WebDriver and ElementLocator
    public HighlightElementLocator(WebDriver driver, ElementLocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    // Check if the element is an iframe and return accordingly
    private boolean isIframe(WebElement element) {
        return "iframe".equalsIgnoreCase(element.getTagName());
    }

    // Wrap the WebElement returned by the original locator with the highlighted version
    @Override
    public WebElement findElement() {
        WebElement element = locator.findElement();

        if (isIframe(element)) {
            return element;
        }
        return new HighlightedWebElement(driver, element);
    }

    // Wrap the list of WebElements with highlighted versions, skipping iframes
    @Override
    public List<WebElement> findElements() {
        List<WebElement> elements = locator.findElements();
        return elements.stream().map(element -> isIframe(element) ? element : new HighlightedWebElement(driver, element))  // Wrap each non-iframe element
                .collect(Collectors.toList());
    }
}
