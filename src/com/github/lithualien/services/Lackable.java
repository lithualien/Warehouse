package com.github.lithualien.services;

import com.github.lithualien.product.Product;

import java.util.List;

public interface Lackable<T extends Product> {
    List<T> getLackingProducts(Float weight);
}
