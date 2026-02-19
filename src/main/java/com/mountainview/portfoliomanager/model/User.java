package com.mountainview.portfoliomanager.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
    private static final AtomicInteger userCount = new AtomicInteger();
    private final PortfolioManager portfolioManager;

    private final UUID userId;
    private final long userNum;
    private final HashMap<UUID, Portfolio> portfolioHashMap = new HashMap<>();

    public User(PortfolioManager portfolioManager) {
        LOGGER.info("Inside 'User' constructor.");
        this.userId = UUID.randomUUID();
        userNum = userCount.incrementAndGet();
        this.portfolioManager = portfolioManager;
    }

    public UUID getUserId() { return this.userId; }

    public long getUserNum() { return this.userNum; }

    public Portfolio createPortfolio(String portfolioName) {
        Portfolio portfolio = portfolioManager.createPortfolio(this, portfolioName);
        addPortfolio(portfolio);

        return portfolio;
    }

    public void addPortfolio(Portfolio portfolio) {
        portfolioHashMap.computeIfAbsent(portfolio.getPortfolioId(), k -> portfolio);
    }

    @Override
    public String toString() {
        return "User: {" + this.userId + "}";
    }

}
