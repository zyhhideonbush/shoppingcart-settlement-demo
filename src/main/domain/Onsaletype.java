package domain;


import java.util.Date;

public class Onsaletype {
    private Date date ;
    private double discount ;
    private String type ;

    public Onsaletype() {

    }

    public Onsaletype(Date date, double discount, String type) {
        this.date = date;
        this.discount = discount;
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public double getDiscount() {
        return discount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "date：" + getDate() +
                ", discount:" + getDiscount() +
                ", type='" + getType() + '\'';
    }
}
