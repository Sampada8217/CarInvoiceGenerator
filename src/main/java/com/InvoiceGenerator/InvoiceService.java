package com.InvoiceGenerator;

public class InvoiceService {

    private static final double MIN_COST_PER_KILOMETER =10.0;
    private static final int COST_PER_TIME =1 ;
    private static final double MIN_FARE =5;

   public RideRepository rideRepository=null;
    public InvoiceService() {
      this.rideRepository = new RideRepository();
     }
    public enum RideInformation{
           NORMAL ,PREMIUM ;
    }
     public RideInformation rideInformation;

    public InvoiceService(RideInformation premium){
        this.rideRepository=new RideRepository();
        this.rideInformation=premium;

    }

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

    public void addRide(String userId, Ride[] rides) {

        rideRepository.addRides(userId,rides);
    }


    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

    public InvoiceSummary getInvoiceSummary1(String userId, RideInformation premium) {
        this.rideInformation = premium;
        return this.calculateFare(rideRepository.getRides(userId));
    }
}



