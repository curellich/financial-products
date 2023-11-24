package edu.undef.fie.domain;

public class InstantGift extends ProductAbstract{

    private final double fixedGift;

    public InstantGift(double price, double fixedGift) {
        super(price);
        this.fixedGift = fixedGift;
    }

    @Override
    public double pay() {
        return fixedGift;
    }
}
