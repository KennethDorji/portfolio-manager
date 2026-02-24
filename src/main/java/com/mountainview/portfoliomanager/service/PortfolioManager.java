package com.mountainview.portfoliomanager.service;

import com.mountainview.portfoliomanager.model.Portfolio;
import com.mountainview.portfoliomanager.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PortfolioManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioManager.class);
    private final HashMap<UUID, HashMap<UUID, Portfolio>> userPortfolioHM = new HashMap<>();

    public Portfolio createPortfolio(User user, String portfolioName) {
        if (portfolioName == null || portfolioName.isEmpty()) {
            throw new IllegalArgumentException("Portfolio name is either null or empty");
        }

        Portfolio portfolio = new Portfolio(user.getUserId(), portfolioName);
        userPortfolioHM
                .computeIfAbsent(user.getUserId(), k-> new HashMap<>())
                .put(portfolio.getPortfolioId(), portfolio);

        return portfolio;
    }

    public Map<UUID, Portfolio> getPortfolio(User user) {
        HashMap<UUID, Portfolio> portfolioHM = userPortfolioHM.get(user.getUserId());
        if(portfolioHM == null) {
            throw new IllegalArgumentException("User doesn't exist");
        }
        return Map.copyOf(portfolioHM);
    }

    public void deletePortfolio(User user, Portfolio portfolio) {
        HashMap<UUID, Portfolio> portfolioHM = userPortfolioHM.get(user.getUserId());
        if (portfolioHM == null) {
            throw new IllegalArgumentException("User doesn't exist");
        } else if (portfolioHM.get(portfolio.getPortfolioId()) == null) {
            throw new IllegalArgumentException("Portfolio doesn't exist");
        }
        portfolioHM.remove(portfolio.getPortfolioId());
    }

}
