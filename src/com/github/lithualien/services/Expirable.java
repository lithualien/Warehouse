package com.github.lithualien.services;

import com.github.lithualien.product.Product;

import java.time.LocalDate;
import java.util.List;

public interface Expirable<T extends Product> {
    List<T> getExpiredProducts(LocalDate expirationDate);
}
