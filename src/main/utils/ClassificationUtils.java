package utils;


import domain.Onsaletype;

import java.util.ArrayList;

public class ClassificationUtils {

    private static final String[][] bucket = {
        {"电子","iPad","iPhone","显示器","笔记本电脑","键盘"},
        {"食品","⾯包","饼干","蛋糕","牛肉","鱼","蔬菜"},
        {"日用品","餐巾纸","收纳箱","咖啡杯","⾬伞"},
        {"酒类","啤酒","⽩酒","伏特加"}
    };

    public static String getTypeOfArticle(String articleName){
        for(int i=0; i<bucket.length; i++){
            for(int j=1; j<bucket[i].length; j++){
                if(articleName.equals(bucket[i][j])){
                    return bucket[i][1];
                }
            }
        }
        return null;
    }

    public static double getDiscountValue(String cartType, ArrayList<Onsaletype> onsaletypes) {
        for(int i=0; i<onsaletypes.size(); i++){
            Onsaletype onsaletype = onsaletypes.get(i);
            if(cartType.equals(onsaletype.getType())){
                return onsaletype.getDiscount();
            }
        }
        return 1;
    }
}
