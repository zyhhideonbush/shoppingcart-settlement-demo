package utils;

import domain.Cartitem;
import domain.Coupon;
import domain.Onsaletype;

import java.util.ArrayList;

public class CalculationUtils {

    public static double getOriginalTotalPrice(ArrayList<Onsaletype> onsaletypes,ArrayList<Cartitem> cartItems) {
        double totalPrice = 0;
        for(int i=0; i<cartItems.size(); i++){
            Cartitem cartitem = cartItems.get(i);
            String cartType = ClassificationUtils.getTypeOfArticle(cartitem.getName());
            double discount = ClassificationUtils.getDiscountValue(cartType,onsaletypes);
            totalPrice+=cartitem.getPrice()*cartitem.getCount()*discount;
        }
        return totalPrice;
    }

    public static double getTotalPrice(Coupon coupon, double originalTotalPrice) {
        if(originalTotalPrice>=coupon.getAmount()){
            return originalTotalPrice-coupon.getCutdown();
        }
        return originalTotalPrice;
    }
}
