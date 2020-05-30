package com.InvoiceGenerator;

public class RideInformation {


    public static final double PREMIUM_RIDE_COST = 15;
    public static final int PREMIUM_RIDE_COST_PER_MIN = 2;
    public static final int PREMIUM_RIDE_MINIMUM_FARE = 20;
    public static final double NORMAL_RIDE_COST = 10;
    public static final int NORMAL_RIDE_COST_PER_MIN = 1;
    public static final int NORMAL_RIDE_MINIMUM_FARE = 5;

    public double getNormalRide(double distance, int time) {
        double totalFare = distance * NORMAL_RIDE_COST+ time * NORMAL_RIDE_COST_PER_MIN;
        if (totalFare <= NORMAL_RIDE_MINIMUM_FARE)
            return NORMAL_RIDE_MINIMUM_FARE;
        return totalFare;
    }

    public double getPremiumRide(double distance, int time) {
        double totalFare = distance * PREMIUM_RIDE_COST + time * PREMIUM_RIDE_COST_PER_MIN;
        if (totalFare <= PREMIUM_RIDE_MINIMUM_FARE)
            return PREMIUM_RIDE_MINIMUM_FARE;
        return totalFare;
    }
}

