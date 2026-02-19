package com.mountainview.portfoliomanager.exception;

public class PositionNotFoundException extends InvalidTransactionException {

    public PositionNotFoundException(String message) {
        super(message);
    }

}
