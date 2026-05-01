package com.LLD.DesignPattern.SolidPrinciple.SingleResponsibilityPrinciple.problem;

import com.LLD.DesignPattern.SolidPrinciple.SingleResponsibilityPrinciple.Marker;

public class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    // 1 responsibility
    public int calculateTotal(){
        int price = marker.getPrice() * this.quantity;
        return price;
    }
    // 2 responsibility
    public void printInvoice(){

    }
    // 3 responsibility
    public void saveToDB(){

    }
}
