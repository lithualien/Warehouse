package com.github.lithualien.services;

import com.github.lithualien.product.FruitProduct;

public interface FruitService extends ProductService, Expirable<FruitProduct>,
                                        Lackable<FruitProduct> {

}
