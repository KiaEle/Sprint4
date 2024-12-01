package page;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderStepOnePage extends Driver {
    //Кнопка "Заказать" в заголовке сайта
    private final By orderHeader = By.xpath(".//button[contains(@class , 'Button_Button')]");
    //Блок "Road map" в футере сайта
    private final By blockFooter = By.xpath(".//div[contains(@class , 'Home_ThirdPart')]");
    //Кнопка "Заказать" в футере сайта
    private final By buttonFooter = By.xpath(".//div[contains(@class , 'Home_FinishButton')]/button[text() = 'Заказать']");
    //Поле ввода "Имя" пользователя в первом шаге бронирования
    private final By inputNameForm = By.xpath(".//input[@placeholder = '* Имя']");
    //Поле ввода "Фамилия" пользователя в первом шаге бронирования
    private final By inputLastNameForm = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Поле ввода "Адрес:куда доставить" в первом шаге бронирования
    private final By inputAddressForm = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле "Станция метро" в первом шаге бронирования
    private final By inputStationForm = By.xpath(".//input[@placeholder = '* Станция метро']");
    //Выпадающий список станций метро в первом шаге бронирования
    private final By listStationMetro = By.className("select-search__row");
    //Поле ввода "Телефон:на него позвонить курьер" в первом шаге бронирования
    private final By inputNumberPhoneForm = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее" в первом шаге бронирования
    private final By buttonNextForm = By.xpath(".//div[contains(@class , 'Order_NextButton')]/button[text() = 'Далее']");
    //Элемент шапки сайта на главной странице
    private final By headerPage = By.xpath(".//div[contains(@class , 'Header_Header')]");
    //Подсказка об ошибке в поле "Имя" в первом шаге бронирования
    private final By errorFirstName = By.xpath(".//div[text() = 'Введите корректное имя']");
    //Подсказка об ошибке в поле "Фамилия" в первом шаге бронирования
    private final By errorLastName = By.xpath(".//div[text() = 'Введите корректную фамилию']");
    //Поле ввода "Адрес: куда привезти заказ в первом шаге бронирования
    private final By addressForm = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Подсказка об ошибке в поле "Адрес: куда привезти заказ" в первом шаге бронирования
    private final By errorAddress = By.xpath(".//div[text() = 'Введите корректный адрес']");
    //Подсказка об ошибке в поле "Станция метро" в первом шаге бронирования
    private final By errorStationMetro = By.xpath(".//div[text() = 'Выберите станцию']");
    //Подсказка об ошибке в поле "Телефон: на него позвонит курьер" в первом шаге бронирования
    private final By errorNumberPhone = By.xpath(".//div[text() = 'Введите корректный номер']");
    //Кнопка "Да все привыкли"
    private final By cookie = By.xpath(".//button[contains(@class , 'App_Cookie') and (text() = 'да все привыкли')]");

    public void clickButtonOrder(int button) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerPage));
        if (button == 1) {
            driver.findElement(orderHeader).click();
        } else {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(blockFooter));
            WebElement element = driver.findElement(buttonFooter);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(buttonFooter).click();
        }
    }

    public void setInputNameForm(String name) {
        driver.findElement(inputNameForm).sendKeys(name);
    }

    public void setInputLastNameForm(String lastName) {
        driver.findElement(inputLastNameForm).sendKeys(lastName);
    }

    public void setInputAddressForm(String address) {
        driver.findElement(inputAddressForm).sendKeys(address);
    }

    public void setInputStationForm(int station) {
        driver.findElement(inputStationForm).click();
        WebElement stationMetro1 = driver.findElements(listStationMetro).get(station);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(listStationMetro));
        stationMetro1.click();
    }

    public void setInputNumberPhoneForm(String number) {
        driver.findElement(inputNumberPhoneForm).sendKeys(number);
        driver.findElement(buttonNextForm).click();
    }

    public void createOrderSamokatStepOne(int button, String name, String lastName, String adress, int station, String number) {
        clickButtonOrder(button);
        setInputNameForm(name);
        setInputLastNameForm(lastName);
        setInputAddressForm(adress);
        setInputStationForm(station);
        setInputNumberPhoneForm(number);
    }

    public void openFormOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
        driver.findElement(orderHeader).click();
        driver.findElement(buttonNextForm).click();
    }

    public String getErrorTextName() {
        return driver.findElement(errorFirstName).getText();
    }

    public String getErrorTextLastName() {
        return driver.findElement(errorLastName).getText();
    }

    public String getErrorAddress(String randomString) {
        driver.findElement(addressForm).sendKeys(randomString);
        return driver.findElement(errorAddress).getText();
    }

    public String getErrorStationMetro() {
        return driver.findElement(errorStationMetro).getText();
    }

    public String getErrorPhoneNumber() {
        return driver.findElement(errorNumberPhone).getText();
    }


    public void clickOnButtonCookie() {
        driver.findElement(cookie).click();
    }
}