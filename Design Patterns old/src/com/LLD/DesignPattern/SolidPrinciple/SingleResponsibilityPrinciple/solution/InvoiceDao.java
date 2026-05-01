package com.LLD.DesignPattern.SolidPrinciple.SingleResponsibilityPrinciple.solution;

public class InvoiceDao {
    InvoiceCalculateTotal invoiceCalculateTotal;

    public InvoiceDao(InvoiceCalculateTotal invoiceCalculateTotal) {
        this.invoiceCalculateTotal = invoiceCalculateTotal;
    }

    // 1 responsibility
    public void saveToDB(){

    }
}
