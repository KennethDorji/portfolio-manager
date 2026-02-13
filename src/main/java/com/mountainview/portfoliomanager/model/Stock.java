package com.mountainview.portfoliomanager.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Stock extends Investment{

    private static final Logger logger = LoggerFactory.getLogger(Stock.class);

// Get the data using API
    // Might need to consider BigDecimal as datatype over double for accurate financial calculations when fetching from api.
//    private double closingCost;
//    private double pnL;
//    private double totalCurrentValue;

    public Stock(String identifier, double quantity, BigDecimal avgCostBasis) {
        super(identifier, quantity, avgCostBasis);
    }

}