package edu.undef.fie.domain;

import edu.undef.fie.interfaces.ProductObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductAbstract {
    private static int date;
    private double price;
    private List<ProductObserver> observers;

    protected ProductAbstract(double price) {
        this.price = price;
        this.observers = new ArrayList<>();
    }

    protected static int getDate() {
        return date;
    }

    protected double getPrice() {
        return price;
    }

    public static void setDate(int date) {
        ProductAbstract.date = date;
    }

    public void updateDate() {
        date++;
        this.notifyObservers();
    }

    public void addObservers(ProductObserver obverver) {
        observers.add(obverver);
    }

    protected final void notifyObservers() {
        for (var observer : observers) {
            observer.update();
        }
    }

    public abstract double pay();
}
