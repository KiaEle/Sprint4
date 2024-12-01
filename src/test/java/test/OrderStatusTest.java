package test;

import core.Annotations;
import org.junit.Test;
import page.OrderStatusPage;

import static org.junit.Assert.assertTrue;

public class OrderStatusTest extends Annotations {
    @Test
    public void compareStatusOrder() {
        OrderStatusPage statusOrderPage = new OrderStatusPage();
        assertTrue("Самокат с таким номером уже забронирован!", statusOrderPage.statusOrderSamokat("4756435"));
    }
}