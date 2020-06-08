package com.github.lithualien.services;

import com.github.lithualien.dao.FruitDao;
import com.github.lithualien.product.FruitProduct;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {

    private List<FruitProduct> fruitProducts;
    private final FruitDao fruitDaoImpl;

    public FruitServiceImpl(FruitDao fruitDaoImpl) {
        this.fruitDaoImpl = fruitDaoImpl;
    }

    private void findDuplicates() {
        for(int i = 0; i < fruitProducts.size() - 1; i++) {
            if(fruitProducts.get(i).equals(fruitProducts.get(i + 1))) {
                fruitProducts.get(i).setWeight(
                        fruitProducts.get(i).getWeight() +
                                fruitProducts.get(i+1).getWeight()
                );
                fruitProducts.remove(i + 1);
                i--;
            }
        }
    }

    private void setProducts() {
        fruitProducts = fruitDaoImpl.all();
    }

    private void sortProducts() {
        Collections.sort(fruitProducts);
    }

    @Override
    public List<FruitProduct> getExpiredProducts(LocalDate expirationDate) {
        setProducts();
        sortProducts();
        findDuplicates();
        return fruitProducts
                .stream()
                .filter(e -> expirationDate.isAfter(e.getExpiration()))
                .collect(Collectors.toList());
    }

    @Override
    public List<FruitProduct> getLackingProducts(Float weight) {
        setProducts();
        sortProducts();
        findDuplicates();
        return fruitProducts
                .stream()
                .filter(e -> e.getWeight() < weight)
                .collect(Collectors.toList());
    }
}
