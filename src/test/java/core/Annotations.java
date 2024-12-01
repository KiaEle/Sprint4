package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import page.OrderStepOnePage;

public abstract class Annotations extends Driver {
    /**
     * Запуск тестов на Firefox
     */
    @Before
    public void settings() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderStepOnePage closeCookie = new OrderStepOnePage();
        closeCookie.clickOnButtonCookie();
        /**
         * Запуск тестов на Chrome
         */
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox","--disable-dev-shm-usage");
//        driver = new ChromeDriver(options);
//        driver.get("https://qa-scooter.praktikum-services.ru");
//        OrderStepOnePage closeCookie = new OrderStepOnePage();
//        closeCookie.clickOnButtonCookie();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
