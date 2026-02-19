package com.mountainview.portfoliomanager.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public class Stock extends EquitySecurity {

    private static final Logger LOGGER = LoggerFactory.getLogger(Stock.class);

    public Stock(TransactionType transactionType, String instrumentSymbol, BigDecimal quantity, BigDecimal purchasePrice) {
        super(transactionType, instrumentSymbol, quantity, purchasePrice);
    }

}
