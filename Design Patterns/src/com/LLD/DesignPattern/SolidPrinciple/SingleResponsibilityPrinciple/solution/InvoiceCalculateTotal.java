package com.LLD.DesignPattern.SolidPrinciple.SingleResponsibilityPrinciple.solution;

import com.LLD.DesignPattern.SolidPrinciple.SingleResponsibilityPrinciple.Marker;

public class InvoiceCalculateTotal {
    private Marker marker;
    private int quantity;

    public InvoiceCalculateTotal(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    // 1 responsibility
    public int calculateTotal(){
        int price = marker.getPrice() * this.quantity;
        return price;
    }
}
