package com.InvoiceGenerator;

public class CabInvoiceFacility {

    public static double givenRideType(double distance, int time, InvoiceService.RideInformation services){

        RideInformation rideInformation = new RideInformation();
        if (rideInformation == null || rideInformation.equals(InvoiceService.RideInformation.NORMAL))
            return rideInformation.getNormalRide(distance,time);
        else if (rideInformation.equals(InvoiceService.RideInformation.PREMIUM))
            return rideInformation.getPremiumRide(distance,time);
        else
            return 0;
    }
}

