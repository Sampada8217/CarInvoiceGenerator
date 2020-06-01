package com.InvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceTest {

    @Before
    public void setUp() throws Exception {
        invoiceService=new InvoiceService();
        invoiceService1=new InvoiceService(InvoiceService.RideInformation.PREMIUM);

    }

    @Rule
    public MockitoRule rule= MockitoJUnit.rule();

    InvoiceService invoiceService1=new InvoiceService(InvoiceService.RideInformation.PREMIUM);

    @Mock
    public RideRepository rideRepository;

    @InjectMocks
    public InvoiceService invoiceService;



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
        Mockito.when(rideRepository.getRides(ArgumentMatchers.any())).thenReturn(rides);
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
        Mockito.when(rideRepository.getRides(ArgumentMatchers.any())).thenReturn(rides);
        invoiceService.addRide(userId,rides);
        InvoiceSummary summary=invoiceService.getInvoiceSummary(userId);
        InvoiceSummary invoiceSummary=new InvoiceSummary(2,30.0);
        Assert.assertEquals(invoiceSummary,summary);
    }


    @Test
    public void givenRidesInformation_WhenSelectServiceNormal_shouldReturnInvoiceSummary() {

        String userId = "abc.com";
        Ride[] rides={
                new Ride(2.0,5),
                new Ride(0.1,1),

        };
        invoiceService.addRide(userId,rides);
        Mockito.when(rideRepository.getRides(ArgumentMatchers.any())).thenReturn(rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary invoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(summary,invoiceSummary);
    }

    @Test
    public void givenRidesInformation_WhenSelectServicePremium_shouldReturnInvoiceSummary() {
        String userId = "sam@123";
        Ride[] rides={
                new Ride(2.0,5),
                new Ride(0.1,1),

        };
        invoiceService1.addRide(userId,rides);
        Mockito.when(rideRepository.getRides(ArgumentMatchers.any())).thenReturn(rides);
        InvoiceSummary summary = invoiceService1.getInvoiceSummary1(userId, InvoiceService.RideInformation.PREMIUM);
        InvoiceSummary invoiceSummary = new InvoiceSummary(2,60.0);
        Assert.assertEquals(summary,invoiceSummary);
    }
}
