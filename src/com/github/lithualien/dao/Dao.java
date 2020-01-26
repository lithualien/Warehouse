package com.github.lithualien.dao;

import com.github.lithualien.product.Product;
import java.time.LocalDate;
import java.util.List;

/**
 * Interface to transfer data.
 *
 * @author Tomas Dominauskas
 */
public interface Dao {

    /**
     * Reads the csv file, sorts the list and removes duplicates.
     * @param fileLocation the location of the csv file.
     */
    void setProducts(String fileLocation);

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
