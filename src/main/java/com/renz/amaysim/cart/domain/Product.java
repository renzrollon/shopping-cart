package com.renz.amaysim.cart.domain;

import java.math.BigDecimal;

/**
 * Created by renz on 11/6/16.
 */
public class Product implements Item {

    private String productCode;
    private String productName;
    private BigDecimal price;

    public final static String UNLI_SMALL_CODE = "ult_small";
    public final static String UNLI_MEDIUM_CODE = "ult_medium";
    public final static String UNLI_LARGE_CODE = "ult_large";
    public final static String _1GB_DATA_PACK_CODE = "1gb";

    public final static String UNLI_SMALL_NAME = "Unlimited 1 GB";
    public final static String UNLI_MEDIUM_NAME = "Unlimited 2 GB";
    public final static String UNLI_LARGE_NAME = "Unlimited 5 GB";
    public final static String _1GB_DATA_PACK_NAME = "1 GB Data-pack";

    public final static BigDecimal UNLI_SMALL_PRICE = new BigDecimal("24.90");
    public final static BigDecimal UNLI_MEDIUM_PRICE = new BigDecimal("29.90");
    public final static BigDecimal UNLI_LARGE_PRICE = new BigDecimal("44.90");
    public final static BigDecimal _1GB_DATA_PACK_PRICE = new BigDecimal("9.90");
    public final static BigDecimal NO_PRICE = new BigDecimal("0.00");


    public static Product getUnliSmallInstance() {
        return new Product(UNLI_SMALL_CODE, UNLI_SMALL_NAME, UNLI_SMALL_PRICE);
    }

    public static Product getUnliMediumInstance() {
        return new Product(UNLI_MEDIUM_CODE, UNLI_MEDIUM_NAME, UNLI_MEDIUM_PRICE);
    }

    public static Product getUnliLargeInstance() {
        return new Product(UNLI_LARGE_CODE, UNLI_LARGE_NAME, UNLI_LARGE_PRICE);
    }

    public static Product get1GbDataPackInstance() {
        return new Product(_1GB_DATA_PACK_CODE, _1GB_DATA_PACK_NAME, _1GB_DATA_PACK_PRICE);
    }

    public Product(String productCode, String productName, BigDecimal price) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setFree() {
        this.price = NO_PRICE;
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) {
            return true;
        } else {
            if(other instanceof Product) {
                String otherProductCode = ((Product) other).getProductCode();
                if(this.productCode.equals(otherProductCode)) {
                    return true;
                }
            }

            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.productCode.hashCode();
    }
}
