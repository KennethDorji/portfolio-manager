package com.mountainview.portfoliomanager.oldchanges;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class User {
    private static final AtomicLong userNumCounter = new AtomicLong(0);

    private final UUID userId; // globally unique ID
    private List<Portfolio> portfolios = new ArrayList<>();
    private final long userNum; // human-friendly sequential number
    private final String name;
    private String email;

    public User(String name, String email, UUID userId) {
        this.userNum = userNumCounter.incrementAndGet();
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getUserId() {
        return userId;
    }

    public long getUserNum() {
        return userNum;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static long getUserNumCounter() {
        return userNumCounter.get();
    }

    public List<Portfolio> getPortfolios() {
        /*
            Returns: Unmodifiable list. Alternative return copy list.
            Provides safer encapsulation. If i return reference of actual portfolio list.
            Then someone can wipe the whole list -> user.getPortfolios().clear();
            This way, only your addPortfolio() and removePortfolio() methods can change the list.
         */
        return Collections.unmodifiableList(portfolios);
    }

    public void addPortfolio(Portfolio portfolio) {
        portfolios.add(portfolio);
    }

    public void removePortfolio(Portfolio portfolio) {
        if (portfolio != null && portfolios.contains(portfolio)) {
            portfolios.remove(portfolio);
        }
    }

    public boolean hasPortfolio() {
        return !portfolios.isEmpty();
    }

    public int getPortfolioSize() {
        return portfolios.size();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userNum=" + userNum +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return false;
    }

}
