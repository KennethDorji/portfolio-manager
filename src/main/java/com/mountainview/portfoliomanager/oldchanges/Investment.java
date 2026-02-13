package com.mountainview.portfoliomanager.oldchanges;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public abstract class Investment {

    private static final Logger logger = LoggerFactory.getLogger(Investment.class);

    private final String identifier;
//    protected final String name;
    private LocalDate dateAcquired;
    private BigDecimal price;
    private double quantity;
    private BigDecimal avgCostBasis = BigDecimal.ZERO;
    private BigDecimal totalCostBasis = BigDecimal.ZERO;

    public Investment(String identifier, double quantity, BigDecimal avgCostBasis) {
        this.identifier = identifier;
        this.quantity = quantity;
        this.avgCostBasis = avgCostBasis;
        calcTotalCostBasis();
    }

    public String getIdentifier() {
        return identifier;
    }

    public double getQuantity() {
        return quantity;
    }

    public BigDecimal getAvgCostBasis() {
        return avgCostBasis;
    }

    public BigDecimal getTotalCostBasis() {
        return totalCostBasis;
    }

    public void calcTotalCostBasis() {
        totalCostBasis = avgCostBasis.multiply(BigDecimal.valueOf(quantity));
    }

    public void updateHolding(LocalDate localDate, TransactionType transactionType, double quantity, BigDecimal totalCost) {
        if (transactionType == TransactionType.PURCHASED) {
            increasedHolding(localDate, quantity, totalCost);
        }
        else if (transactionType == TransactionType.SOLD) {
            reducedHolding(quantity, totalCost);
        }
    }

    protected void increasedHolding(LocalDate localDate, double purchasedQty, BigDecimal totalCost) {
        totalCostBasis = totalCostBasis.add(totalCost);
        quantity+= purchasedQty;
        logger.info("Bought {} {} shares on {}. Updated totalCostBasis is {} and updated quantity is {}", purchasedQty,
                identifier,  localDate, totalCostBasis, quantity);
        calcAvgCostBasis();
    }

    protected void reducedHolding(double soldQty, BigDecimal totalCost) {
        if (soldQty > quantity) {
            logger.error("Sold {} shares, but own {} shares only. Considering all shares sold", soldQty, this.quantity);
            quantity = 0;
            totalCostBasis = BigDecimal.ZERO;
        } else {
            totalCostBasis = totalCostBasis.subtract(totalCost);
            quantity-= soldQty;
        }
        calcAvgCostBasis();
    }

    public void calcAvgCostBasis() {
//        this.avgCostBasis = quantity != 0 ? totalCostBasis/quantity : 0;
        if (quantity != 0) {
            this.avgCostBasis = totalCostBasis.divide(BigDecimal.valueOf(quantity), 4, RoundingMode.HALF_UP);
        }
        else {
            avgCostBasis = BigDecimal.ZERO;
        }
    }

    @Override
    public String toString() {
        return "Investment{" +
                "identifier='" + identifier + '\'' +
                ", dateAcquired=" + dateAcquired +
                ", price=" + price +
                ", quantity=" + quantity +
                ", avgCostBasis=" + avgCostBasis +
                ", totalCostBasis=" + totalCostBasis +
                '}';
    }
}
