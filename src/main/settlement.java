import domain.Cartitem;
import domain.Coupon;
import domain.Onsaletype;

import utils.CalculationUtils;
import utils.FormatUtils;
import utils.PrintUtils;

import java.util.ArrayList;


public class settlement {

    public static void main(String[] args) {
        String input = "2019.11.11 | 0.7 | 电⼦ \n" +
                "\n" +
                "1 * iPad: 2399.00 \n" +
                "1 * 显示器: 1799.00 \n" +
                "12 * 啤酒: 25.00 \n" +
                "5 * ⾯包: 9.00 \n" +
                "\n" +
                "2019.11.11 \n" +
                "2019.12.12 | 1000 | 200 ";
        String[] cartData = FormatUtils.dataSplit(input,"\n\n");
        ArrayList<Onsaletype> onSaleTypes = FormatUtils.getOnSaleTypes(cartData[0]);
        ArrayList<Cartitem> cartItems = FormatUtils.getCartItems(cartData[1]);
        Coupon coupon = FormatUtils.getCouponInfo(cartData[2]);
        PrintUtils.printCartInfo(onSaleTypes,cartItems,coupon);
        double originalTotalPrice = CalculationUtils.getOriginalTotalPrice(onSaleTypes,cartItems);
        double totalPrice = CalculationUtils.getTotalPrice(coupon,originalTotalPrice);
        System.out.print("\n————————————————————————— 商品结算 —————————————————————————\n");
        System.out.println("Your total price is "+totalPrice);
    }





}
