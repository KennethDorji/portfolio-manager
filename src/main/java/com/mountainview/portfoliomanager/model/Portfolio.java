package com.mountainview.portfoliomanager.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Portfolio {

    private static final Logger LOGGER = LoggerFactory.getLogger(Portfolio.class);

    private final UUID userId;
    private final UUID portfolioId;
    private String portfolioName;
    private DisposalMethod disposalMethod;

    private final Map<String, Stock> stockHashMap = new HashMap<>();
    private final List<Transaction> transactionHistory = new ArrayList<>();

    public Portfolio(UUID userId, String portfolioName) {
        this.userId = userId;
        this.portfolioId = UUID.randomUUID();
        this.portfolioName = portfolioName;
        this.disposalMethod = DisposalMethod.DEFAULT;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getPortfolioId() {
        return portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public DisposalMethod getDisposalMethod() {
        return disposalMethod;
    }

    public void setDisposalMethod(DisposalMethod disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public Collection<Stock> getStockHashMap() {
        return Collections.unmodifiableCollection(stockHashMap.values());
    }

    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }

    public void updateStockPosition(TransactionType transactionType, String instrumentSymbol, LocalDate acquiredDate, BigDecimal quantity, BigDecimal purchasePrice) {
        if (!stockHashMap.containsKey(instrumentSymbol)) {
            if (transactionType.equals(TransactionType.SOLD)) {
                System.out.println();
                LOGGER.error("Cannot perform sale of {} security that isn't owned", instrumentSymbol);
                throw new IllegalArgumentException("Cannot sell a position that has not been purchased: " + instrumentSymbol);
            }
            else {
                stockHashMap.put(instrumentSymbol, new Stock(transactionType, instrumentSymbol, quantity, purchasePrice));
            }
        } else {
            stockHashMap.get(instrumentSymbol).updatePosition(transactionType, quantity, purchasePrice);
        }

        updateTransactionHistory(instrumentSymbol, acquiredDate, quantity, purchasePrice, transactionType);
    }

    private void updateTransactionHistory(String instrumentSymbol, LocalDate acquiredDate, BigDecimal quantity, BigDecimal purchasePrice, TransactionType transactionType) {
        if (transactionType.equals(TransactionType.PURCHASE)) {
            Transaction transaction = new Transaction(instrumentSymbol, acquiredDate, quantity, purchasePrice);
            transactionHistory.add(transaction);
        } else {
            // SOLD shares need to be deducted here according to the portfolio disposal method.
        }

    }

    @Override
    public String toString() {
        return "Portfolio: {" +
                "User Id=" + userId +
                "Portfolio Id=" + portfolioId +
                "Portfolio Name=" + portfolioName +
                "Stock Holdings=" + stockHashMap +
                "}";
    }
}
