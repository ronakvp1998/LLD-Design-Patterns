package com.ashishprataplldproblems.hard.onlineshoppingservice.exceptions;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }
}
