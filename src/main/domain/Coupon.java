package domain;

public class Coupon {
    private double amount;
    private double cutdown;

    public Coupon() {

    }

    public Coupon(double amount, double cutdown) {
        this.amount = amount;
        this.cutdown = cutdown;
    }

    public double getAmount() {
        return amount;
    }

    public double getCutdown() {
        return cutdown;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "amount=" + amount +
                ", cutdown=" + cutdown +
                '}';
    }
}
