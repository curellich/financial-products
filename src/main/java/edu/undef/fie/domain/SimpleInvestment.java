package edu.undef.fie.domain;

public class SimpleInvestment extends ProductAbstract {
    private int expirationDate;
    private double percentage;

    public SimpleInvestment(double price, int expirationDate, double percentage) {
        super(price);
        this.expirationDate = getDate() + expirationDate;
        this.percentage = percentage;
    }

    @Override
    public double pay() {
        if (this.expirationDate < getDate()) {
            return (getPrice() * percentage) + getPrice();
        }
        return 0;
    }
}
