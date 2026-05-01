package com.LLD.DesignPattern.ObserverPattern;

import com.LLD.DesignPattern.ObserverPattern.Observable.IphoneObservableImpl;
import com.LLD.DesignPattern.ObserverPattern.Observable.StocksObservable;
import com.LLD.DesignPattern.ObserverPattern.Observer.EmailAlertObserverImpl;
import com.LLD.DesignPattern.ObserverPattern.Observer.MobileAlertObserverImpl;
import com.LLD.DesignPattern.ObserverPattern.Observer.NotificationAlertObserver;

public class Store {

    public static void main(String[] args) {
        StocksObservable iphoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz1@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz3_username.com",iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);

//        output
//        Mail send to: xyz1@gmail.com
//        Mail send to: xyz2@gmail.com
//        msg send to: xyz3_username.com

    }
}


