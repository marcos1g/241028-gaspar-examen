package org.eecomerce;

public class Main {
    public static void main(String[] args) {
        BuyerService buyerService = new BuyerService();

        buyerService.loginBuyer("Angie");
        buyerService.deleteBuyer(3);
        buyerService.createBuyer("Sofi");
        buyerService.updateBuyer(2, "Camila");
    }
}