package com.mountainview.portfoliomanager.service;

import com.mountainview.portfoliomanager.model.Portfolio;
import com.mountainview.portfoliomanager.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PortfolioManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioManager.class);

    public Portfolio createPortfolio(User user, String portfolioName) {
        return new Portfolio(user.getUserId(), portfolioName);
    }
}
