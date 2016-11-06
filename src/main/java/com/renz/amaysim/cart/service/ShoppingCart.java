package com.renz.amaysim.cart.service;

import com.renz.amaysim.cart.domain.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by renz on 11/6/16.
 */
public interface ShoppingCart {

    void add(Item item);
    void add(Item item, String promoCode);
    BigDecimal total();
    List<Item> items();

    void clear();
}
