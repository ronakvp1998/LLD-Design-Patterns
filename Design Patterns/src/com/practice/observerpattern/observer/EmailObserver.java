package com.practice.observerpattern.observer;

import com.practice.observerpattern.observable.StockObservable;

public class EmailObserver implements NotifyAlertObserver{

    String emailId;
    StockObservable stockObservable;


    public EmailObserver(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendEmail(emailId, "stock available");
    }

    public void sendEmail(String emailId, String msg){
        System.out.println("Message seng to : " +emailId);
    }
}
