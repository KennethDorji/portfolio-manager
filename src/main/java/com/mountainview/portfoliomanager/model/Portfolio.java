package com.mountainview.portfoliomanager.model;

import com.mountainview.portfoliomanager.repository.UserRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Portfolio {
    
    private final UUID portfolioId;
    private final UUID userId;
    private transient User user; 
    private String portfolioName;
//    private HashMap<String, List<Stock>> stock = new HashMap<>();
//    private double portfolioValue;

    public Portfolio(User user) {
        this(user, String.valueOf(user.getPortfolioSize() + 1));
    }

    public Portfolio(User user, String portfolioName) {
        portfolioId = UUID.randomUUID();
        userId = user.getUserId();
        this.user = user;
        this.portfolioName = "Portfolio " + portfolioName;
    }

    public void setPortfolioName(String name) {
        this.portfolioName = name;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void addStock() {

    }

    public UUID getPortfolioId() {
        return portfolioId;
    }

    public UUID getUserId() {
        return userId;
    }

    public User getUser() {
        if (user == null) {
            user = UserRegistry.getUserById(userId);
        }
        return user;
    }

//    public double getPortfolioValue() {
//        return portfolioValue;
//    }
//
//    public void addStock(String stockTicker, double totalQuantity, double avgCost) {
//        stock.computeIfAbsent("Stock", k -> new ArrayList<>()).add(new Stock(stockTicker, totalQuantity, avgCost));
//    }


}