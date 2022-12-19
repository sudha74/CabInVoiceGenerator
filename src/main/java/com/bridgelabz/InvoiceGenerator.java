package com.bridgelabz;

public class InvoiceGenerator {
    public static double calculateFare(double distance, double time) {
        double totalFare = distance * Ride.RideCategory.NORMAL_RIDE.costPerKm + time * Ride.RideCategory.NORMAL_RIDE.costPerMinute;
        if (totalFare < Ride.RideCategory.NORMAL_RIDE.minimumFarePerRide) {
            return Ride.RideCategory.NORMAL_RIDE.minimumFarePerRide;
        } else return totalFare;
    }

    public static double calculatePremiumFare(double distance, double time) {
        double totalFare = distance * Ride.RideCategory.PREMIUM_RIDE.costPerKm + time * Ride.RideCategory.PREMIUM_RIDE.costPerMinute;
        if (totalFare < Ride.RideCategory.PREMIUM_RIDE.minimumFarePerRide) {
            return Ride.RideCategory.PREMIUM_RIDE.minimumFarePerRide;
        } else {
            return totalFare;
        }
    }

    public static double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            if (ride.getRideCategory() == Ride.RideCategory.PREMIUM_RIDE) {
                totalFare += calculatePremiumFare(ride.getDistance(), ride.getTime());
            } else {
                totalFare += calculateFare(ride.getDistance(), ride.getTime());
            }
        }
        return totalFare;
    }

    public static Invoice generateInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int totalNumberOfRides = rides.length;
        double averageFarePerRide = totalFare / totalNumberOfRides;
        return new Invoice(totalNumberOfRides, totalFare, averageFarePerRide);
    }
}

