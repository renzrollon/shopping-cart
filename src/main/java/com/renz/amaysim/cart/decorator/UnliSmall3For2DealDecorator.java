package com.renz.amaysim.cart.decorator;

import com.renz.amaysim.cart.domain.Item;
import com.renz.amaysim.cart.domain.Product;
import com.renz.amaysim.cart.service.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by renz on 11/6/16.
 */
public class UnliSmall3For2DealDecorator implements PriceDecorator {

    private UnliSmall3For2DealDecorator() {}

    private static class InstanceHolder {
        public static UnliSmall3For2DealDecorator INSTANCE = new UnliSmall3For2DealDecorator();
    }

    public static UnliSmall3For2DealDecorator getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public boolean isApplicable(List<Item> items, Set<String> promoCodes) {
        return countUnliSmallItems(items) >= 3;
    }

    private int countUnliSmallItems(List<Item> items) {
        final Product unliSmallInstance = Product.getUnliSmallInstance();
        return (int) items.stream()
                .filter(item -> item instanceof Product && unliSmallInstance.equals(item))
                .count();

    }

    @Override
    public BigDecimal calculateTotalPriceChange(ShoppingCart shoppingCart) {
        int freeSimCount = countUnliSmallItems(shoppingCart.items()) / 3;
        return Product.UNLI_SMALL_PRICE.multiply(new BigDecimal(-freeSimCount));
    }
}
