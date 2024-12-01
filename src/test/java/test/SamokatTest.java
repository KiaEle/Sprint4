package test;

import core.Annotations;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.OrderStepOnePage;
import page.OrderStepTwoPage;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class SamokatTest extends Annotations {
    private final int buttonOrder;
    private final String nameForm;
    private final String lastNameForm;
    private final String adressForm;
    private final int stationMetroForm;
    private final String phoneNumberForm;
    private final int dateCalendar;
    private final String rentalPeriod;
    private final String colorSamokat;
    private final String commentCourier;

    public SamokatTest(int buttonOrder, String nameForm, String lastNameForm, String adressForm, int stationMetroForm, String phoneNumberForm, int dateCalendar, String rentalPeriod, String colorSamokat, String commentCourier) {
        this.buttonOrder = buttonOrder;
        this.nameForm = nameForm;
        this.lastNameForm = lastNameForm;
        this.adressForm = adressForm;
        this.stationMetroForm = stationMetroForm;
        this.phoneNumberForm = phoneNumberForm;
        this.dateCalendar = dateCalendar;
        this.rentalPeriod = rentalPeriod;
        this.colorSamokat = colorSamokat;
        this.commentCourier = commentCourier;

    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {1, "Геннадий", "Лихачев", "ул.Машинная д. 6", 5, "89990100125", 1, "трое суток", "grey", "Валим боком"},
                {2, "Бмв", "Мерседесов", "ул.Бесповоротная д. 9", 4, "89320981101", 1, "двое суток", "black", "Просьба забрать после СТО!"},
        };
    }

    @Test
    public void fillingFormOrder() {
        OrderStepOnePage orderStepOnePage = new OrderStepOnePage();
        orderStepOnePage.createOrderSamokatStepOne(buttonOrder, nameForm, lastNameForm, adressForm, stationMetroForm, phoneNumberForm);
        OrderStepTwoPage orderStepTwoPage = new OrderStepTwoPage();
        orderStepTwoPage.samokatTwoStep(dateCalendar, rentalPeriod, colorSamokat, commentCourier);
        MatcherAssert.assertThat("Не отобразилось модальное окно после заказа", orderStepTwoPage.getStatusOrder(), containsString("Заказ оформлен"));
    }
}