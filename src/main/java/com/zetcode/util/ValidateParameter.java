package com.zetcode.util;

import org.apache.commons.lang3.math.NumberUtils;

public class ValidateParameter {
    
    private static final int MAX_PRICE_CAR = 10_000_000;

    public static boolean validateName(String param) {

        return !(null == param || "".equals(param));
    }
    
    public static boolean validateId(String param) {

        return !(null == param || "".equals(param) || 
                !NumberUtils.isCreatable(param));
    }   
    
    public static boolean validatePrice(String param) {

       if (null == param || "".equals(param) || !NumberUtils.isCreatable(param)) {
           return false;
       }
       
       int price = Integer.valueOf(param);
       
       return !(price < 0 || price > MAX_PRICE_CAR);
       
    } 
}