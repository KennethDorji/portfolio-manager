package com.mountainview.portfoliomanager.model;

public enum TransactionType {
    PURCHASED("Buy"),
    SOLD("Sell");

    private final String displayName;

    TransactionType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}