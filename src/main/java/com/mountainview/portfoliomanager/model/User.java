package com.mountainview.portfoliomanager.model;

import com.mountainview.portfoliomanager.service.PortfolioManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
    private static final AtomicInteger userCount = new AtomicInteger();
    private final PortfolioManager portfolioManager;

    private final UUID userId;
    private final long userNum;

    public User(PortfolioManager portfolioManager) {
        LOGGER.info("Inside 'User' constructor.");
        this.userId = UUID.randomUUID();
        userNum = userCount.incrementAndGet();
        this.portfolioManager = portfolioManager;
    }

    public UUID getUserId() { return this.userId; }

    public long getUserNum() { return this.userNum; }

    public Portfolio createPortfolio(String portfolioName) {
        return portfolioManager.createPortfolio(this, portfolioName);
    }

    public Map<UUID, Portfolio> getPortfolio() {
        return portfolioManager.getPortfolio(this);
    }

    public void deletePortfolio(Portfolio portfolio) {
        portfolioManager.deletePortfolio(this, portfolio);
    }

    @Override
    public String toString() {
        return "User: {" + this.userId + "}";
    }

}

