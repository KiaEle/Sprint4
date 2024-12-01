package page;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class OrderStepTwoPage extends Driver {
    //Поле выбора дат "Когда привезти самокат" во втором шаге бронирования
    private final By inputDateDelivery = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Открывшейся календарь по клику поля "Когда привезти самокат" во втором шаге бронирования
    private final By blockCalander = By.xpath(".//div[@class = 'react-datepicker']");
    //Поле "Когда привезти самокат" во втором шаге бронирования
    private final By selectTimeRental = By.xpath(".//div[text() = '* Срок аренды']");
    //Выпадающий список срока аренды самоката в поле "Когда привезти самокат" во втором шаге бронирования
    private final By selectRentalPeriod2Days = By.xpath(".//div[text() = 'двое суток']");
    //Поле "Комментарий для курьера" во втором шаге бронирования
    private final By inputCommentCourier = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Кнопка "Заказать" во втором шаге бронирования
    private final By buttonOrderRental = By.xpath(".//div[contains(@class , 'Order_Buttons')]/button[text () = 'Заказать']");
    //Кнопка "Да" в открывшемся модальном окне ,после нажатия на кнопку "Заказать" во втором шаге бронирования
    private final By buttonEndingOrder = By.xpath(".//div[contains(@class , 'Order_Buttons')]/button[text() = 'Да']");
    private final By statusOrder = By.xpath(".//div[starts-with(@class, 'Order_Modal')]//div[(starts-with(@class,'Order_ModalHeader'))]");

    public void setDateDelivery(int date) {
        LocalDate actualDay = LocalDate.now();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(inputDateDelivery));
        driver.findElement(inputDateDelivery).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(blockCalander));
        driver.findElement(By.xpath(String.format(".//div[@class = 'react-datepicker__month']//div[text() = '%s']", actualDay.getDayOfMonth() + date))).click();
    }

    public void setRentalPeriod(String rental) {
        driver.findElement(selectTimeRental).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(selectRentalPeriod2Days));
        driver.findElement(By.xpath(String.format(".//div[text() = '%s']", rental))).click();
    }

    public void setSamokatBlack(String color) {
        driver.findElement(By.id(String.format("%s", color))).click();
    }

    public void setCommentCourier(String commentToCourier) {
        driver.findElement(inputCommentCourier).sendKeys(commentToCourier);
    }

    public void clickButtonOrderRental() {
        driver.findElement(buttonOrderRental).click();
    }

    public void clickButtonEndindOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonEndingOrder));
        driver.findElement(buttonEndingOrder).click();
    }

    public String getStatusOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(statusOrder));
        return driver.findElement(statusOrder).getText();
    }

    public void samokatTwoStep(int date, String rental, String color, String commentToCourier) {
        setDateDelivery(date);
        setRentalPeriod(rental);
        setSamokatBlack(color);
        setCommentCourier(commentToCourier);
        clickButtonOrderRental();
        clickButtonEndindOrder();
    }
}