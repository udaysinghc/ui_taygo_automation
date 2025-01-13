package com.taygo.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
        import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
        import java.lang.reflect.Field;

public class HighlightElementLocatorFactory implements ElementLocatorFactory {

    private final WebDriver driver;

    // Constructor to initialize the driver
    public HighlightElementLocatorFactory(WebDriver driver) {
        this.driver = driver;
    }

    // Overriding the createLocator method to return our custom HighlightElementLocator
    @Override
    public ElementLocator createLocator(Field field) {
        return new HighlightElementLocator(driver, new DefaultElementLocator(driver, field));
    }
}
