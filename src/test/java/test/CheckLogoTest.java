package test;

import core.Annotations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainLogoPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckLogoTest extends Annotations {
    private final int selectButton;
    private final String urlService;

    public CheckLogoTest(int selectButton, String urlService) {
        this.selectButton = selectButton;
        this.urlService = urlService;
    }

    @Parameterized.Parameters
    public static Object[][] getUrlLogo() {
        return new Object[][]{
                {2, "https://qa-scooter.praktikum-services.ru/"},
                {1, "https://ya.ru/"},
        };
    }

    @Test
    public void comparisonUrlAfterClickLogo() {
        MainLogoPage mainLogoPage = new MainLogoPage();
        assertEquals("Url неверный", urlService, mainLogoPage.clickButtonService(selectButton));
    }
}