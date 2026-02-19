package com.mountainview.portfoliomanager.service;

import com.mountainview.portfoliomanager.model.Portfolio;
import com.mountainview.portfoliomanager.model.User;

public class PortfolioManager {

    public Portfolio createPortfolio(User user, String portfolioName) {
        return new Portfolio(user.getUserId(), portfolioName);
    }
}
