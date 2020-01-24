package com.github.lithualien.product;

import java.util.Date;

/**
 * Product class to store information about the product.
 *
 * @author Tomas Dominauskas
 */
public class Product {
    private String name, code, expiration;
    private int quantity;

    /**
     * Class constructor.
     */
    public Product() {}

    /**
     * Class constructor to set attributes about the product.
     * @param name the name of the product.
     * @param code the code of the product.
     * @param quantity the quantity of the product in the warehouse.
     * @param expiration the expiration date of the product.
     */
    public Product(String name, String code, int quantity, String expiration) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.expiration = expiration;
    }

    /**
     * Sets the name of the product.
     * @param name the name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the code of the product.
     * @param code the code of the product.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Sets the quantity of the product in the warehouse.
     * @param quantity the quantity of the product in the warehouse.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the expiration date of the product.
     * @param expiration the expiration date of the product.
     */
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    /**
     * Returns the name of the product.
     * @return the name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Return the code of the product.
     * @return the code of the product.
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the expiration date of the product.
     * @return the expiration date of the product.
     */
    public String getExpiration() {
        return expiration;
    }

    /**
     * Returns the quantity of the product in the warehouse.
     * @return the quantity of the product in the warehouse.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the name, code, quantity and expiration date of the product in a single string.
     * @return the name, code, quantity and expiration date of the product;
     */
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", quantity='" + quantity + '\'' +
                ", expiration='" + expiration + '\'' + "\n"; // will do something to be easily visible.
    }
}
