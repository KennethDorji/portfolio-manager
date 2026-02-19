package com.mountainview.portfoliomanager.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CashEquivalent {

    private static final Logger logger = LoggerFactory.getLogger(CashEquivalent.class);
    
    private String instrumentSymbol;
    private double amount;
    private double interestRate;

    CashEquivalent(String instrumentSymbol, double amount, double interestRate) {
        logger.info("Inside CashEquivalent abstract class constructor");
        this.instrumentSymbol = instrumentSymbol;
        this.amount = amount;
        this.interestRate = interestRate;
    }

    public String getInstrumentSymbol() {
        return instrumentSymbol;
    }

    public void setInstrumentSymbol(String instrumentSymbol) {
        this.instrumentSymbol = instrumentSymbol;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "CashEquivalent: {" +
                "Instrument Symbol='" + instrumentSymbol + '\'' +
                ", Amount=$" + amount +
                ", Interest Rate=" + interestRate + '%' +
                '}';
    }
}