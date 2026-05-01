package com.practice.observerpattern.observable;

import com.practice.observerpattern.observer.NotifyAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{

    public int stockCount = 0;
    public List<NotifyAlertObserver> observerList = new ArrayList<>();
    @Override
    public void add(NotifyAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotifyAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifysubscriubers() {
        for(NotifyAlertObserver observer : observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newCount) {
        if(stockCount == 0){
            notifysubscriubers();
        }
        stockCount = stockCount + newCount;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
