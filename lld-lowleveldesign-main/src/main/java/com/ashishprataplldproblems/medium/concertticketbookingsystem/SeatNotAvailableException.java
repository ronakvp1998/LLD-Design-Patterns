package com.ashishprataplldproblems.medium.concertticketbookingsystem;

public class SeatNotAvailableException extends RuntimeException {
    public SeatNotAvailableException(String message) {
        super(message);
    }
}
