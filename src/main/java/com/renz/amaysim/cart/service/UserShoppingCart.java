package com.renz.amaysim.cart.service;

import com.renz.amaysim.cart.decorator.ItemsDecorator;
import com.renz.amaysim.cart.decorator.PriceDecorator;
import com.renz.amaysim.cart.decorator.ShoppingCartDecorator;
import com.renz.amaysim.cart.domain.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by renz on 11/6/16.
 */
public class UserShoppingCart implements ShoppingCart {

    private String userId;
    private List<Item> items = new ArrayList<>();
    private Set<ShoppingCartDecorator> decorators = new HashSet<>(1);
    private Set<String> promoCodes = new HashSet<>();

    public UserShoppingCart(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void add(Item item, String promoCode) {
        items.add(item);
        promoCodes.add(promoCode);
    }

    private List<Item> modifyItems() {
        List<Item> itemsToAdd = new ArrayList<>();
        for(ShoppingCartDecorator decorator : decorators) {
            if(decorator instanceof ItemsDecorator && decorator.isApplicable(items, promoCodes)) {
                itemsToAdd.addAll(((ItemsDecorator) decorator).createItemsToAdd(items));
            }
        }
        return itemsToAdd;
    }

    @Override
    public BigDecimal total() {
        BigDecimal total = new BigDecimal("0.00");
        for(Item item : items) {
            total = total.add(item.getPrice());
        }

        for(ShoppingCartDecorator decorator : decorators) {
            if(decorator instanceof PriceDecorator && decorator.isApplicable(items, promoCodes)) {
                BigDecimal changeInTotal = ((PriceDecorator)decorator).calculateTotalPriceChange(this);
                total = total.add(changeInTotal);
            }
        }
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public List<Item> items() {
        List<Item> withAdditionalItems = modifyItems();
        withAdditionalItems.addAll(items);
        return Collections.unmodifiableList(withAdditionalItems);
    }

    @Override
    public void clear() {
        items.clear();
    }

    public void setPriceDecorators(Set<ShoppingCartDecorator> priceDecorators) {
        this.decorators = priceDecorators;
    }
}
