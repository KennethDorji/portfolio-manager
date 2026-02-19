package com.mountainview.portfoliomanager.exception;

public class InsufficientSharesException extends InvalidTransactionException {

    public InsufficientSharesException(String message) {
        super(message);
    }
}
