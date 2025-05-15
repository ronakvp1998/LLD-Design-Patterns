package com.LLD.DesignPattern.SolidPrinciple.OpenClosedPrinciple.solution;

import com.LLD.DesignPattern.SolidPrinciple.SingleResponsibilityPrinciple.solution.InvoiceCalculateTotal;

public interface InvoiceDAO {

    public void save(InvoiceCalculateTotal invoiceCalculateTotal);
}
