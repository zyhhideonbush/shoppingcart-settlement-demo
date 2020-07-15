package domain;

public class Cartitem {
    private int count;
    private String name;
    private double price;

    public Cartitem() {
    }

    public Cartitem(int count, String name, double price) {
        this.count = count;
        this.name = name;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "商品名：" + getName() +
                "  数量：" + getCount() +

                "  单价：" + getPrice() ;
    }
}
