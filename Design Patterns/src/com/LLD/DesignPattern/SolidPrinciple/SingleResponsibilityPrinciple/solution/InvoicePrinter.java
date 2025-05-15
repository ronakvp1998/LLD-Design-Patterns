package com.LLD.DesignPattern.SolidPrinciple.SingleResponsibilityPrinciple.solution;

public class InvoicePrinter {
    private InvoiceCalculateTotal invoiceCalculateTotal;

    public InvoicePrinter(InvoiceCalculateTotal invoiceCalculateTotal) {
        this.invoiceCalculateTotal = invoiceCalculateTotal;
    }

    // 1 responsibility
    public void print(){

    }
}
