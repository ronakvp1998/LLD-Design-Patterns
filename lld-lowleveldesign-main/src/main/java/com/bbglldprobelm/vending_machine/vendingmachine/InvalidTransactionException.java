package com.bbglldprobelm.vending_machine.vendingmachine;

public class InvalidTransactionException extends Throwable {
    public InvalidTransactionException(String message) {
        super(message);
    }
}
