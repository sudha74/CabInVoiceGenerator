package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    @Test
    void givenDistanceAndTime_ShouldReturn_Fare() {
        double totalFare = InvoiceGenerator.calculateFare(5, 10);
        Assertions.assertEquals(60, totalFare);
    }

    @Test
    void givenDistanceAndTime_ShouldReturn_MinimumFare() {
        double totalFare = InvoiceGenerator.calculateFare(0.2, 2);
        Assertions.assertEquals(5, totalFare);
    }

    @Test
    void givenMultipleRides_ShouldReturn_TotalFare() {
        Ride ride1 = new Ride(10, 6);
        Ride ride2 = new Ride(15, 8);
        Ride ride3 = new Ride(0.2, 2);
        Ride[] rides = new Ride[]{ride1, ride2, ride3};
        double totalFare = InvoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(269, totalFare);
    }

    @Test
    void givenMultipleRides_ShouldReturn_Invoice() {
        Ride ride1 = new Ride(10, 6);
        Ride ride2 = new Ride(15, 8);
        Ride ride3 = new Ride(0.2, 2);
        Ride[] rides = new Ride[]{ride1, ride2, ride3};
        Invoice actualInvoice = InvoiceGenerator.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(3, 269, 269.0 / 3);
        Assertions.assertEquals(actualInvoice, expectedInvoice);
    }

    @Test
    void givenUserId_ShouldReturn_Invoice() {
        RideRepository.customerList.clear();
        Ride ride1 = new Ride(10, 6);
        Ride ride2 = new Ride(15, 8);
        Ride ride3 = new Ride(0.2, 2);
        Ride[] rides1 = new Ride[]{ride1, ride2, ride3};
        RideRepository.customerList.add(new Customer(1, rides1));

        Ride ride4 = new Ride(12, 4);
        Ride ride5 = new Ride(8, 8);
        Ride ride6 = new Ride(0.2, 2);
        Ride[] rides2 = new Ride[]{ride4, ride5, ride6};
        RideRepository.customerList.add(new Customer(1, rides2));

        Invoice actualInvoice = InvoiceService.generateInvoiceById(1);
        Invoice expectedInvoice = new Invoice(3, 269, 269.0 / 3);
        Assertions.assertEquals(expectedInvoice, actualInvoice);
    }

    @Test
    void givenUserIdHavingPremiumRides_ShouldReturn_Invoice() {
        Ride ride1 = new Ride(10, 6, Ride.RideCategory.PREMIUM_RIDE);
        Ride ride2 = new Ride(15, 8);
        Ride ride3 = new Ride(0.2, 2);
        Ride[] rides1 = new Ride[]{ride1, ride2, ride3};
        RideRepository.customerList.add(new Customer(1, rides1));

        Ride ride4 = new Ride(12, 4);
        Ride ride5 = new Ride(8, 8);
        Ride ride6 = new Ride(0.2, 2);
        Ride[] rides2 = new Ride[]{ride4, ride5, ride6};
        RideRepository.customerList.add(new Customer(1, rides2));

        Invoice actualInvoice = InvoiceService.generateInvoiceById(1);
        Invoice expectedInvoice = new Invoice(3, 325, 325.0 / 3);
        Assertions.assertEquals(actualInvoice, expectedInvoice);
    }
}
