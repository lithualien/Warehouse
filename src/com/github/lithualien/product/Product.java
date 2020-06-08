package com.github.lithualien.product;

import java.util.Objects;

/**
 * Product class to store information about the product.
 *
 * @author Tomas Dominauskas
 */
public abstract class Product {
    protected String name;
    protected Long code;

    /**
     * Class constructor to set attributes about the product.
     * @param name the name of the product.
     * @param code the code of the product.
     */
    public Product(String name, Long code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", code='" + code + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }
}
