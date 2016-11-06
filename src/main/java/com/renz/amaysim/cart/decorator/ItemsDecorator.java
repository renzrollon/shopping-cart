package com.renz.amaysim.cart.decorator;

import com.renz.amaysim.cart.domain.Item;

import java.util.List;


/**
 * Created by renz on 11/7/16.
 */
public interface ItemsDecorator extends ShoppingCartDecorator {

    List<Item> createItemsToAdd(List<Item> currentItems);
}
