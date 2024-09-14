package com.practice.observerpattern;

import com.practice.observerpattern.observable.IphoneObservableImpl;
import com.practice.observerpattern.observable.StockObservable;
import com.practice.observerpattern.observer.EmailObserver;
import com.practice.observerpattern.observer.NotifyAlertObserver;

public class Main {
    public static void main(String[] args) {
        StockObservable iphoneObserver = new IphoneObservableImpl();

        NotifyAlertObserver observer1 = new EmailObserver("asa1",iphoneObserver);
        NotifyAlertObserver observer2 = new EmailObserver("asa2",iphoneObserver);

        observer1.update();
        observer2.update();

        iphoneObserver.setStockCount(10);
        iphoneObserver.setStockCount(10);

    }
}
