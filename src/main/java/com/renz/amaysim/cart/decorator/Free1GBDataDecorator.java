package com.renz.amaysim.cart.decorator;

import com.renz.amaysim.cart.domain.Item;
import com.renz.amaysim.cart.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by renz on 11/6/16.
 */
public class Free1GBDataDecorator implements ItemsDecorator {

    private Free1GBDataDecorator() {}

    private static class InstanceHolder {
        public static Free1GBDataDecorator INSTANCE = new Free1GBDataDecorator();
    }

    public static Free1GBDataDecorator getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public boolean isApplicable(List<Item> items, Set<String> promoCodes) {
        final Product unliMediumInstance = Product.getUnliMediumInstance();
        for(Item item : items) {
            if(item instanceof Product && unliMediumInstance.equals(item)) {
               return true;
            }
        }
        return false;
    }

    @Override
    public List<Item> createItemsToAdd(List<Item> currentItems) {
        final Product unliMediumInstance = Product.getUnliMediumInstance();
        List<Item> itemsToAdd = new ArrayList<>(currentItems.size());
        for(Item item : currentItems) {
            if(item instanceof Product && unliMediumInstance.equals(item)) {
                Product free1GbData = Product.get1GbDataPackInstance();
                free1GbData.setFree();
                itemsToAdd.add(free1GbData);
            }
        }
        return itemsToAdd;
    }

}
