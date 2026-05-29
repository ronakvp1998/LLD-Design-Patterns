package com.bytebytego.shipping_locker.shippinglocker.pkg;

public class NoLockerAvailableException extends RuntimeException {
    public NoLockerAvailableException(String message) {
        super(message);
    }
} 
