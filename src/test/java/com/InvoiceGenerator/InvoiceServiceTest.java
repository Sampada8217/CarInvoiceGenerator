package com.InvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

    InvoiceService invoiceService;
    @Before
    public void setUp() throws Exception {
        invoiceService=new InvoiceService();
    }
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
    @Test
    public void givenMultipleRides_shouldReturnSummary () {
        InvoiceService invoiceGenerator = new InvoiceService();
        Ride[] rides={ new Ride(2.0,5),
                new Ride(0.1,1),

        };
        InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
        InvoiceSummary invoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(invoiceSummary,summary);
    }
    @Test
    public void givenUserIdAndWrite_shouldReturnInvoiceSummary() {

        String userId="abc.com";
        Ride[] rides={
                new Ride(2.0,5),
                new Ride(0.1,1),

        };
        invoiceService.addRide(userId,rides);
        InvoiceSummary summary=invoiceService.getInvoiceSummary(userId);
        InvoiceSummary invoiceSummary=new InvoiceSummary(2,30.0);
        Assert.assertEquals(invoiceSummary,summary);
    }
}
