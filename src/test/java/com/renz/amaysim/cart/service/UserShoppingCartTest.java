package com.renz.amaysim.cart.service;

import com.renz.amaysim.cart.decorator.*;
import com.renz.amaysim.cart.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by renz on 11/6/16.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class UserShoppingCartTest {

    private UserShoppingCart shoppingCart;

    private final String USER_ID = "helloWorldUser";

    @Before
    public void setup() {
        shoppingCart = new UserShoppingCart(USER_ID);
        Set<ShoppingCartDecorator> decoratorList = new HashSet<>();
        decoratorList.add(UnliSmall3For2DealDecorator.getInstance());
        decoratorList.add(UnliLargeBulkDiscountDecorator.getInstance());
        decoratorList.add(Free1GBDataDecorator.getInstance());
        decoratorList.add(PromoCode10PercentDiscountDecorator.getInstance());

        shoppingCart.setPriceDecorators(decoratorList);
    }

    @Test
    public void unliSmallTotal() {
        shoppingCart.add(Product.getUnliSmallInstance());

        BigDecimal expected = Product.UNLI_SMALL_PRICE;
        BigDecimal actual = shoppingCart.total();

        assertEquals(expected, actual);
    }

    @Test
    public void unliSmallMediumLargeAnd1GBTotal() {
        shoppingCart.add(Product.getUnliSmallInstance());
        shoppingCart.add(Product.getUnliMediumInstance());
        shoppingCart.add(Product.getUnliLargeInstance());
        shoppingCart.add(Product.get1GbDataPackInstance());


        BigDecimal expected = Product.UNLI_SMALL_PRICE
                .add(Product.UNLI_MEDIUM_PRICE)
                .add(Product.UNLI_LARGE_PRICE)
                .add(Product._1GB_DATA_PACK_PRICE);
        BigDecimal actual = shoppingCart.total();

        assertEquals(expected, actual);
    }

    @Test
    public void scenario1Total() {
        shoppingCart.add(Product.getUnliSmallInstance());
        shoppingCart.add(Product.getUnliSmallInstance());
        shoppingCart.add(Product.getUnliSmallInstance());
        shoppingCart.add(Product.getUnliLargeInstance());

        BigDecimal expected = new BigDecimal("94.70");
        BigDecimal actual = shoppingCart.total();

        assertEquals(expected, actual);
    }

    @Test
    public void scenario2Total() {
        shoppingCart.add(Product.getUnliSmallInstance());
        shoppingCart.add(Product.getUnliSmallInstance());
        shoppingCart.add(Product.getUnliLargeInstance());
        shoppingCart.add(Product.getUnliLargeInstance());
        shoppingCart.add(Product.getUnliLargeInstance());
        shoppingCart.add(Product.getUnliLargeInstance());

        BigDecimal expected = new BigDecimal("209.40");
        BigDecimal actual = shoppingCart.total();

        assertEquals(expected, actual);
    }

    @Test
    public void scenario3Total() {
        shoppingCart.add(Product.getUnliSmallInstance());
        shoppingCart.add(Product.getUnliMediumInstance());
        shoppingCart.add(Product.getUnliMediumInstance());

        BigDecimal expectedPrice = new BigDecimal("84.70");
        BigDecimal actualPrice = shoppingCart.total();

        assertEquals(expectedPrice, actualPrice);

        int expectedItemSize = 5;
        int actualItemSize = shoppingCart.items().size();
        assertEquals(expectedItemSize, actualItemSize);
    }

    @Test
    public void scenario4Total() {
        String discountCode = "I<3AMAYSIM";
        shoppingCart.add(Product.getUnliSmallInstance());
        shoppingCart.add(Product.get1GbDataPackInstance(), discountCode);

        BigDecimal expectedPrice = new BigDecimal("31.32");
        BigDecimal actualPrice = shoppingCart.total();

        assertEquals(expectedPrice, actualPrice);
    }

}
