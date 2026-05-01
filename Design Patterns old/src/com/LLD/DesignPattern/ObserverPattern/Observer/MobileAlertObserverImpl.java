package com.LLD.DesignPattern.ObserverPattern.Observer;

import com.LLD.DesignPattern.ObserverPattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String userName;
    StocksObservable observable;

    public MobileAlertObserverImpl(String userName, StocksObservable observable){
        this.observable = observable;
        this.userName = userName;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName, "Product is in stock hurry up!");
    }

    private void sendMsgOnMobile(String userName, String msg){
        System.out.println("msg send to: " + userName);
    }
}
