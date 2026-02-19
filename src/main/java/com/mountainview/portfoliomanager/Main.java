package com.mountainview.portfoliomanager;

import com.mountainview.portfoliomanager.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void printData(Portfolio portfolio) {
        System.out.println();
        System.out.println(portfolio.getTransactionHistory());
        System.out.println(portfolio.getStockHashMap());
    }

    public static void main(String[] args) {
        final PortfolioManager portfolioManager = new PortfolioManager();
        User ben = new User(portfolioManager);
        Portfolio portfolio = ben.createPortfolio("Tech Portfolio");
        printData(portfolio);
        try {
            portfolio.updateStockPosition(TransactionType.PURCHASE, "SPAXX", LocalDate.now(), BigDecimal.valueOf(12), new BigDecimal("1200.23"));
            printData(portfolio);
            portfolio.updateStockPosition(TransactionType.SOLD, "AAPL", LocalDate.now(), BigDecimal.valueOf(10), new BigDecimal("100"));
            printData(portfolio);
        } catch (Exception e) {
            System.out.println(e.getClass() + " - Transaction failed: " + e.getMessage());
        }
        printData(portfolio);




//         User user1 = UserRegistry.createAndRegisterUser("Bryon","bryon@gmail.com");
//         System.out.printf("Initial portfolio size %d %n", user1.getPortfolioSize());
//         Portfolio portfolio1 = PortfolioService.createPortfolio(user1);
//         System.out.printf("Current portfolio size %d %n", user1.getPortfolioSize());
//         List<Portfolio> portfolio = new ArrayList<>();
//         portfolio = PortfolioService.getPortfolios(user1);
//         System.out.println(portfolio.get(0).getPortfolioName());
//         System.out.println(portfolio);
//         System.out.println();
//
//         PortfolioService.createPortfolio(user1);
//         portfolio = PortfolioService.getPortfolios(user1);
//         System.out.println(portfolio);
//         System.out.println();
//
//         PortfolioService.removePortfolio(user1, portfolio1);
//         portfolio = PortfolioService.getPortfolios(user1);
//         System.out.println(portfolio.get(0).getPortfolioName());
//         System.out.println(portfolio);
//         HashMap<User, String> hm = new HashMap<>();

//         User user1 = UserRegistry.createAndRegisterUser("Bryon","bryon@gmail.com");
//         hm.computeIfAbsent(user1, k -> "initial data");
//         System.out.println();
//         System.out.println(hm);
//         System.out.println();
//
//         hm.computeIfAbsent(user1, k-> "second hm");
//         System.out.println();
//         System.out.println(hm);
//         System.out.println();
//
//         User user2 = UserRegistry.createAndRegisterUser("Ken", "happy@gmail.com");
//         hm.computeIfAbsent(user2, k-> "2nd new data");
//         System.out.println();
//         System.out.println(hm);
//         System.out.println();

//         CashPosition cashPosition = new CashPosition("SPAXX", 1200.23, 2.5);
//
//         System.out.println(cashPosition.toString());
//
//         double price = 1.00005;
//         double quantity = 1000000;
//
//         double value = price * quantity;
//         System.out.println(value);
//
//         System.out.println(new BigDecimal("1.00005"));
//         System.out.println(new BigDecimal(1.05)); // Double precision
//
//         System.out.println(BigDecimal.valueOf(5));
//         System.out.println(BigDecimal.valueOf(1.05)); // Double precision
//
//         Stock spaxx = new Stock("SPAXX", LocalDate.now(), BigDecimal.valueOf(12), new BigDecimal("1200.23"));
//         System.out.println(spaxx.getPurchaseHistory());
//         spaxx.addPurchase(LocalDate.now(), BigDecimal.valueOf(24), new BigDecimal("1250.11"));
//         System.out.println(spaxx.getPurchaseHistory());

     }

}