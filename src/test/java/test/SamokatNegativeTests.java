package test;


import core.Annotations;
import org.junit.Test;
import page.OrderStepOnePage;

import static org.junit.Assert.assertEquals;


public class SamokatNegativeTests extends Annotations {
    @Test
    public void comparisonErrorTextFirstName() {
        OrderStepOnePage orderStepOnePage = new OrderStepOnePage();
        orderStepOnePage.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректное имя", orderStepOnePage.getErrorTextName());
    }

    @Test
    public void comparisonErrorTextLastName() {
        OrderStepOnePage orderStepOnePage = new OrderStepOnePage();
        orderStepOnePage.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректную фамилию", orderStepOnePage.getErrorTextLastName());
    }

    @Test
    public void comparisonErrorTextAddress() {
        OrderStepOnePage orderStepOnePage = new OrderStepOnePage();
        orderStepOnePage.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректный адрес", orderStepOnePage.getErrorAddress("d"));
    }

    @Test
    public void comparisonErrorTextStationMetro() {
        OrderStepOnePage orderStepOnePage = new OrderStepOnePage();
        orderStepOnePage.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Выберите станцию", orderStepOnePage.getErrorStationMetro());
    }

    @Test
    public void comparisonErrorTextPhoneNumber() {
        OrderStepOnePage orderStepOnePage = new OrderStepOnePage();
        orderStepOnePage.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректный номер", orderStepOnePage.getErrorPhoneNumber());
    }
}