package com.InvoiceGenerator;

public class InvoiceService {

    private static final double MIN_COST_PER_KILOMETER =10.0;
    private static final int COST_PER_TIME =1 ;
    private static final double MIN_FARE =5;

    public double calculateFare(double distance, int time) {
        
         double totalFare = distance * MIN_COST_PER_KILOMETER + time * COST_PER_TIME;
            if (totalFare < MIN_FARE)
                return MIN_FARE;
            return totalFare;
        }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {

            totalFare += calculateFare(ride.distance, ride.time);

        }
        return new InvoiceSummary(rides.length,totalFare);
    }


}

