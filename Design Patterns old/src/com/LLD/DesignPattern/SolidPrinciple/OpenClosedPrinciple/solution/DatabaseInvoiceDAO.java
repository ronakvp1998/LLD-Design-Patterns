package com.LLD.DesignPattern.SolidPrinciple.OpenClosedPrinciple.solution;

import com.LLD.DesignPattern.SolidPrinciple.SingleResponsibilityPrinciple.solution.InvoiceCalculateTotal;

public class DatabaseInvoiceDAO implements InvoiceDAO{


    @Override
    public void save(InvoiceCalculateTotal invoiceCalculateTotal) {
        //save to DB
    }
}
