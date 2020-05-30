package com.InvoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance=2.0;
        int time=5;
        double fare= invoiceService.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceAndTime_shouldReturnMinFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance=0.1;
        int time=1;
        double fare= invoiceService.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }
}
