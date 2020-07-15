package utils;

import domain.Cartitem;
import domain.Coupon;
import domain.Onsaletype;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FormatUtils {
    public static Coupon getCouponInfo(String cartDatum) {
        String couponString = cartDatum.replace(" ","").replace("\n"," ").replace("|"," ");
        String[] couponInfo = dataSplit(couponString," ");
        boolean effective = whetherEffective(couponInfo[0],couponInfo[1]);
        if(effective == false){
            return null;
        }
        double amount = Double.valueOf(couponInfo[2]);
        double cutdown = Double.valueOf(couponInfo[3]);
        Coupon coupon = new Coupon(amount,cutdown);
        return coupon;
    }

    private static boolean whetherEffective(String s1, String s2) {
        return dateFormation(s1).before(dateFormation(s2));
    }

    public static ArrayList<Cartitem> getCartItems(String cartDatum) {
        String precartDatum = cartDatum.replace(" ","").replace("*"," ").replace(":"," ");
        String[] items = dataSplit(precartDatum,"\n");
        ArrayList<Cartitem> cartitemArrayList = new ArrayList<Cartitem>();
        for(int i=0; i<items.length; i++){
            String[] item = dataSplit(items[i]," ");
            int count = Integer.valueOf(item[0]);
            String name = item[1];
            double price = Double.valueOf(item[2]);
            Cartitem cartItem = new Cartitem(count,name,price);
            cartitemArrayList.add(cartItem);
        }
        return cartitemArrayList;
    }

    public static ArrayList<Onsaletype> getOnSaleTypes(String cartDatum) {
        String[] onsales = dataSplit(cartDatum.replace(" ",""),"\n");
        ArrayList<Onsaletype> onsaletypeArrayList = new ArrayList<Onsaletype>();
        for(int i=0; i<onsales.length; i++){
            String[] onsale = dataSplit(onsales[i],"\\|");
            Date date = dateFormation(onsale[0]);
            double discount = Double.valueOf(onsale[1]);
            String type = onsale[2];
            Onsaletype onsaleType = new Onsaletype(date,discount,type);
            onsaletypeArrayList.add(onsaleType);
        }
        return onsaletypeArrayList;
    }

    private static Date dateFormation(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public static String[] dataSplit(String data,String rule){
        return data.split(rule);
    }
}
