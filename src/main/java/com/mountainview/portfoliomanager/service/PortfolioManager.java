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
        return new Portfolio(user.getUserId(), portfolioName);
    }
}
