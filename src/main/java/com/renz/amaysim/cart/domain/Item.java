package com.renz.amaysim.cart.domain;

import java.math.BigDecimal;

/**
 * Created by renz on 11/6/16.
 */
@FunctionalInterface
public interface Item {

    BigDecimal getPrice();
}
