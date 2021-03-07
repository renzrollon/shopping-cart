package com.renz.amaysim.cart.decorator;

import com.renz.amaysim.cart.domain.Item;

import java.util.List;
import java.util.Set;

/**
 * Created by renz on 11/6/16.
 */
@FunctionalInterface
public interface ShoppingCartDecorator {

    boolean isApplicable(List<Item> items, Set<String> promoCodes);
}
