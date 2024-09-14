package com.practice.observerpattern.observable;

import com.practice.observerpattern.observer.NotifyAlertObserver;

public interface StockObservable {

    public void add(NotifyAlertObserver observer);
    public void remove(NotifyAlertObserver observer);
    public void notifysubscriubers();

    public void setStockCount(int newCount);
    public int getStockCount();
}
