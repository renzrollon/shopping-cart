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
public class UnliLargeBulkDiscountDecorator implements PriceDecorator {

    private UnliLargeBulkDiscountDecorator() {}

    private static class InstanceHolder {
        public static UnliLargeBulkDiscountDecorator INSTANCE = new UnliLargeBulkDiscountDecorator();
    }

    public static UnliLargeBulkDiscountDecorator getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static final BigDecimal UNLI_LARGE_DISCOUNT = new BigDecimal("-5.00");

    @Override
    public boolean isApplicable(List<Item> items, Set<String> promoCodes) {
        return countUnliLargeItems(items) > 3;
    }

    private int countUnliLargeItems(List<Item> items) {
        int unliLargeCount= 0;
        final Product unliLargeInstance = Product.getUnliLargeInstance();
        for(Item item : items) {
            if(item instanceof Product && unliLargeInstance.equals(item)) {
                unliLargeCount++;
            }
        }
        return unliLargeCount;
    }

    @Override
    public BigDecimal calculateTotalPriceChange(ShoppingCart shoppingCart) {
        BigDecimal unliLargeItemsPrice = new BigDecimal(countUnliLargeItems(shoppingCart.items()));
        return UNLI_LARGE_DISCOUNT.multiply(unliLargeItemsPrice);
    }
}
