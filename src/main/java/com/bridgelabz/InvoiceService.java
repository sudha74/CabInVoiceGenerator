package com.bridgelabz;

public class InvoiceService {
    static Invoice generateInvoiceById(int userId) {

        for (Customer customer : RideRepository.customerList) {
            if (customer.getId() == userId) {
                return InvoiceGenerator.generateInvoice(customer.getRides());
            }
        }
        return null;
    }
}

