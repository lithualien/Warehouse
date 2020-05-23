package com.github.lithualien.dao;

import com.github.lithualien.product.Product;

import java.util.List;

/**
 * Interface to transfer data.
 *
 * @author Tomas Dominauskas
 */
public interface Dao {

    /**
     * Reads the csv file, sorts the list and removes duplicates.
     */
    List<Product> all();


}
