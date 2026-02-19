package com.mountainview.portfoliomanager.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private final String instrumentSymbol;
    private final LocalDate acquiredDate;
    private final BigDecimal quantity;
    private final BigDecimal avgCost;
//    private BigDecimal pnl = BigDecimal.ZERO;
    private final BigDecimal cost;
//    private HoldingTerm holdingTerm;

    public Transaction(String instrumentSymbol, LocalDate acquiredDate, BigDecimal quantity, BigDecimal purchasePrice) {
        this.instrumentSymbol = instrumentSymbol;
        this.acquiredDate = acquiredDate;
        this.quantity = quantity;
        this.avgCost = purchasePrice;
        this.cost = calCost(quantity, purchasePrice);
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getAvgCost() {
        return avgCost;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public LocalDate getAcquiredDate() {
        return acquiredDate;
    }

    public String getInstrumentSymbol() {
        return instrumentSymbol;
    }

    private BigDecimal calCost(BigDecimal quantity, BigDecimal purchasePrice) {
        return quantity.multiply(purchasePrice);
    }

    @Override
    public String toString() {
        return "PurchaseHistory{" +
                "instrumentSymbol='" + instrumentSymbol + '\'' +
                ", acquiredDate=" + acquiredDate +
                ", quantity=" + quantity +
                ", avgCost=" + avgCost +
                ", cost=" + cost +
                '}';
    }
}
