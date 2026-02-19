package com.mountainview.portfoliomanager.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public abstract class EquitySecurity {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquitySecurity.class);

    private final String instrumentSymbol;
    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal totalCost = BigDecimal.ZERO;
    private BigDecimal avgCost = BigDecimal.ZERO;

    public EquitySecurity(TransactionType transactionType, String instrumentSymbol, BigDecimal quantity, BigDecimal purchasePrice) {
        this.instrumentSymbol = instrumentSymbol;
        updatePosition(transactionType, quantity, purchasePrice);
    }

    public String getInstrumentSymbol() {
        return instrumentSymbol;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getAvgCost() {
        return avgCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void calQuantity(TransactionType transactionType, BigDecimal quantity) {
        if (quantity.compareTo(BigDecimal.ZERO) <= 0) {
            LOGGER.warn("Share quantity must be greater than 0");
            throw new IllegalArgumentException("Share quantity must be greater than 0");
        }
        if (transactionType.equals(TransactionType.PURCHASE)) {
            this.quantity = this.quantity.add(quantity);
        } else {
            if(quantity.compareTo(this.quantity) > 0) {
                LOGGER.warn("Trying to sell more shares than you own");
                throw new IllegalArgumentException("Shares being sold must be equal or less than the shares owned.");
            }
            this.quantity = this.quantity.subtract(quantity);
        }
    }

    public void calTotalCost(TransactionType transactionType, BigDecimal purchasePrice, BigDecimal quantity) {
        if(transactionType.equals(TransactionType.PURCHASE)) {
            this.totalCost = this.totalCost.add(quantity.multiply(purchasePrice));
        } else {
            this.totalCost = this.totalCost.subtract(quantity.multiply(purchasePrice));
        }
    }

    public void calAvgCost() {
        this.avgCost = Objects.requireNonNull(this.totalCost.divide(this.quantity, 2, RoundingMode.HALF_UP));
    }

    public void updatePosition(TransactionType transactionType, BigDecimal quantity, BigDecimal purchasePrice) {
        calQuantity(transactionType, quantity);
        calTotalCost(transactionType, purchasePrice, quantity);
        calAvgCost();
    }

    @Override
    public String toString() {
        return "EquitySecurity: {" +
                "instrumentSymbol='" + instrumentSymbol + '\'' +
                ", quantity=" + quantity +
                ", costBasis=" + avgCost +
                ", totalCost=" + totalCost +
                '}';
    }
}
