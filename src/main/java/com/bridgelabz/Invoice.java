package com.bridgelabz;

import java.util.Objects;

public class Invoice {
    int TotalNumberOfRides;
    double TotalFare;
    double AverageFarePerRide;

    public Invoice(int totalNumberOfRides, double totalFare, double averageFarePerRide) {
        TotalNumberOfRides = totalNumberOfRides;
        TotalFare = totalFare;
        AverageFarePerRide = averageFarePerRide;
    }

    @Override
    public String toString() {
        return "CabInvoice{" +
                "TotalNumberOfRides=" + TotalNumberOfRides +
                ", TotalFare=" + TotalFare +
                ", AverageFarePerRide=" + AverageFarePerRide +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice that = (Invoice) o;
        return TotalNumberOfRides == that.TotalNumberOfRides && Double.compare(that.TotalFare, TotalFare) == 0 && Double.compare(that.AverageFarePerRide, AverageFarePerRide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(TotalNumberOfRides, TotalFare, AverageFarePerRide);
    }
}


