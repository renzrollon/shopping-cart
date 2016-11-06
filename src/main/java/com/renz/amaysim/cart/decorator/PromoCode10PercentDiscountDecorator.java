package com.renz.amaysim.cart.decorator;

import com.renz.amaysim.cart.domain.Item;
import com.renz.amaysim.cart.service.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by renz on 11/6/16.
 */
public class PromoCode10PercentDiscountDecorator implements PriceDecorator {

    private PromoCode10PercentDiscountDecorator() {}

    private static class InstanceHolder {
        public static PromoCode10PercentDiscountDecorator INSTANCE = new PromoCode10PercentDiscountDecorator();
    }

    public static PromoCode10PercentDiscountDecorator getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public final static String _10_PERCENT_DISCOUNT_CODE = "I<3AMAYSIM";
    public final static BigDecimal _10_PERCENT_DISCOUNT = new BigDecimal("-0.10");


    @Override
    public BigDecimal calculateTotalPriceChange(ShoppingCart shoppingCart) {
        BigDecimal totalPriceChange = new BigDecimal("0.00");
        for(Item item : shoppingCart.items()) {
            totalPriceChange = totalPriceChange.add(item.getPrice());
        }
        return totalPriceChange.multiply(_10_PERCENT_DISCOUNT);
    }

    @Override
    public boolean isApplicable(List<Item> items, Set<String> promoCodes) {
        return promoCodes.contains(_10_PERCENT_DISCOUNT_CODE);
    }
}
