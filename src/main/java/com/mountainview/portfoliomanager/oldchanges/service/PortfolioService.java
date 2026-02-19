package com.mountainview.portfoliomanager.oldchanges.service;

import com.mountainview.portfoliomanager.oldchanges.model.Portfolio;
import com.mountainview.portfoliomanager.oldchanges.model.User;

import java.util.Collections;
import java.util.List;

public class PortfolioService {

    public static Portfolio createPortfolio(User user) {
        Portfolio portfolio = new Portfolio(user);
        user.addPortfolio(portfolio);
        return portfolio;
    }

    public static void removePortfolio(User user, Portfolio portfolio) {
        user.removePortfolio(portfolio);
    }

    public static List<Portfolio> getPortfolios(User user) {
        return Collections.unmodifiableList(user.getPortfolios());
    }
}