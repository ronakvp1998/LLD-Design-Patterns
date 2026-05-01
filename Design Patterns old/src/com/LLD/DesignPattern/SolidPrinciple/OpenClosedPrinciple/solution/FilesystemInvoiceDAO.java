package com.LLD.DesignPattern.SolidPrinciple.OpenClosedPrinciple.solution;

import com.LLD.DesignPattern.SolidPrinciple.SingleResponsibilityPrinciple.solution.InvoiceCalculateTotal;

public class FilesystemInvoiceDAO implements InvoiceDAO{
    @Override
    public void save(InvoiceCalculateTotal invoiceCalculateTotal) {
        // save to file
    }
}
