package page;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class MainLogoPage extends Driver {
    private final By buttonSamokat = By.xpath(".//img[@alt = 'Scooter']");
    private final By buttonYandex = By.xpath(".//img[@alt = 'Yandex']");


    public String clickButtonService(int buttonLogo) {
        if (buttonLogo == 1) {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(buttonYandex));
            driver.findElement(buttonYandex).click();
            ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
            if (!availableWindows.isEmpty()) {
                driver.switchTo().window(availableWindows.get(1));
            }
            return driver.getCurrentUrl();

        } else
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(buttonSamokat));
        driver.findElement(buttonSamokat).click();
        return driver.getCurrentUrl();
    }
}