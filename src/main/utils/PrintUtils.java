package utils;

import domain.Cartitem;
import domain.Coupon;
import domain.Onsaletype;

import java.util.ArrayList;

public class PrintUtils {
    public static void printCartInfo(ArrayList<Onsaletype> onSaleTypes, ArrayList<Cartitem> cartItems, Coupon coupon) {
        if(onSaleTypes!=null){
            System.out.print("\n————————————————————————— 促销信息 —————————————————————————\n");
            for(int i=0; i<onSaleTypes.size(); i++){
                System.out.println(onSaleTypes.get(i));
            }
        }
        System.out.print("\n————————————————————————— 购物列表 —————————————————————————\n");
        for (int i=0; i<cartItems.size(); i++){
            System.out.println(cartItems.get(i));
        }
        if(coupon!=null){
            System.out.print("\n————————————————————————— 优惠券信息 ————————————————————————\n");
            System.out.print("满 "+coupon.getAmount()+" 减 "+coupon.getCutdown()+"\n");
        }
    }
}
