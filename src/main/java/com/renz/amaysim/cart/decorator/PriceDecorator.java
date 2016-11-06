package com.renz.amaysim.cart.decorator;

import com.renz.amaysim.cart.service.ShoppingCart;

import java.math.BigDecimal;

/**
 * Created by renz on 11/6/16.
 */
public interface PriceDecorator extends ShoppingCartDecorator {

    BigDecimal calculateTotalPriceChange(ShoppingCart shoppingCart);
    
}
