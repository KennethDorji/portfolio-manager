package com.mountainview.portfoliomanager.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CashPosition extends CashEquivalent {

    private static final Logger logger = LoggerFactory.getLogger(CashPosition.class);

    public CashPosition(String instrumentSymbol, double amount, double interestRate) {
        super(instrumentSymbol, amount, interestRate);
        logger.info("Inside CashPosition constructor");
    }

}
