package com.LLD.DesignPattern.SolidPrinciple.OpenClosedPrinciple.problem;

import com.LLD.DesignPattern.SolidPrinciple.SingleResponsibilityPrinciple.solution.InvoiceCalculateTotal;

public class InvoiceDAO {
    InvoiceCalculateTotal invoiceCalculateTotal;

    public InvoiceDAO(InvoiceCalculateTotal invoiceCalculateTotal) {
        this.invoiceCalculateTotal = invoiceCalculateTotal;
    }

    public void saveToDB(){

    }

    // this code is live in PROD i want to update this class to shave a method which will save to file
    // we should not update the class because it might be used by lots of users
    // solution interfaces
}
