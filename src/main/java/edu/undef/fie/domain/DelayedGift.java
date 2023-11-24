package edu.undef.fie.domain;

public class DelayedGift extends ProductAbstract {
    private final int expirationDate;
    private final double fixedGift;

    public DelayedGift(double price, int expirationDate, double fixedGift) {
        super(price);
        this.expirationDate = getDate() + expirationDate;
        this.fixedGift = fixedGift;
    }

    @Override
    public double pay() {
        if (this.expirationDate < getDate()) {
            return fixedGift;
        }
        return 0;
    }
}
