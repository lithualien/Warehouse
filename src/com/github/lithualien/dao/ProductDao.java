package com.github.lithualien.dao;

import com.github.lithualien.product.Product;

import java.util.List;

/**
 * Interface to transfer data.
 *
 * @author Tomas Dominauskas
 */
public interface ProductDao<T extends Product> {
    List<T> all();
}
