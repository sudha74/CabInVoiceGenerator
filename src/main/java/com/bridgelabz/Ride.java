package com.bridgelabz;

public class Ride {
    private double distance;
    private double time;
    private RideCategory rideCategory = RideCategory.NORMAL_RIDE;

    public enum RideCategory {
        NORMAL_RIDE(10, 1, 5), PREMIUM_RIDE(15, 2, 20);

        public double costPerKm;
        public int costPerMinute;
        public double minimumFarePerRide;

        RideCategory(double costPerKm, int costPerMinute, double minimumFarePerRide) {
            this.costPerKm = costPerKm;
            this.costPerMinute = costPerMinute;
            this.minimumFarePerRide = minimumFarePerRide;
        }
    }

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(double distance, double time, RideCategory rideCategory) {
        this.distance = distance;
        this.time = time;
        this.rideCategory = rideCategory;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public RideCategory getRideCategory() {
        return rideCategory;
    }

    public void setRideCategory(RideCategory rideCategory) {
        this.rideCategory = rideCategory;
    }
}
