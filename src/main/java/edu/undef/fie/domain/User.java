package edu.undef.fie.domain;

import edu.undef.fie.interfaces.ProductObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User implements ProductObserver {
    private final String name;
    private double balance;
    private List<ProductAbstract> purchaseHistory;

    public User(String name, double balance, List<ProductAbstract> purchaseHistory) {
        this.name = name;
        this.balance = balance;
        this.purchaseHistory = purchaseHistory;
    }

    public void buyProduct(ProductAbstract product) {
        purchaseHistory.add(product);
        this.balance -= product.getPrice();
    }

    @Override
    public void update() {
        var productsToRemove = new ArrayList<ProductAbstract>();
        for(var product : purchaseHistory){
            double collected = collectRoyalties(product);
            this.balance += collected;
            if(collected > 0) productsToRemove.add(product);
        }

        for(var product : productsToRemove){
            purchaseHistory.remove(product);
        }

    }

    private double collectRoyalties(ProductAbstract product) {
        return product.pay();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", purchaseHistory=" + purchaseHistory +
                '}';
    }
}
