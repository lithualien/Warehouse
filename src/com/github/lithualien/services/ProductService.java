package com.github.lithualien.services;

import com.github.lithualien.product.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {

    /**
     * Returns the products of shortage.
     * @param number the minimum number of products.
     * @return products of shortage.
     */
    List<Product> getLackingProducts(int number);

    /**
     * Returns expired products.
     * @param expirationDate the expiration date.
     * @return expired products.
     */
    List<Product> getExpiredProducts(LocalDate expirationDate);

}
