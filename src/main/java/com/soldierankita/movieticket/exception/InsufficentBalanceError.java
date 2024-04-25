package com.soldierankita.movieticket.exception;

public class InsufficentBalanceError extends RuntimeException {
    public InsufficentBalanceError(String message) {
        super(message);
    }
}
