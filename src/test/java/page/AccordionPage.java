package page;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AccordionPage extends Driver {
    private final By headerPages = By.xpath(".//div[contains(@class , 'Header_Header')]");
    private final By faqBlock = By.xpath(".//div[contains(@class , 'Home_FourPart')]");

    public String getElementsAccordions(int number) {
        List<WebElement> elementOfAccordions = driver.findElements(By.xpath(".//div[contains(@class , 'accordion')]/div[contains(@class ,'accordion__panel')]/p"));
        return elementOfAccordions.get(number).getAttribute("innerHTML");
    }

    public WebElement getButtonAccordion(int number) {
        List<WebElement> elementOfAccordions = driver.findElements(By.xpath(".//div[@class = 'accordion__item']"));
        return elementOfAccordions.get(number);
    }

    public String checkElementAccordion(int number) {
        List<WebElement> getHeadersButtonAccordion = driver.findElements(By.xpath(".//div[contains(@class , 'accordion')]//div[contains(@class , 'accordion__button')]"));
        return getHeadersButtonAccordion.get(number).getAttribute("innerHTML");
    }

    public String getTextAfterClickButton(int number) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerPages));
        WebElement element = getButtonAccordion(number);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(faqBlock));
        return getElementsAccordions(number);
    }
}
