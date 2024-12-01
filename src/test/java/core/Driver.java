package core;

import org.openqa.selenium.WebDriver;

public abstract class Driver {
    protected static WebDriver driver;

    public void Driver(WebDriver driver) {
        this.driver = driver;
    }
}