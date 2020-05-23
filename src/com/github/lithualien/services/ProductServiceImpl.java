package com.github.lithualien.services;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.product.Product;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private List<Product> products;
    private final Dao dao;

    public ProductServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<Product> getLackingProducts(int number) {
        setProducts();
        sortProducts();
        findDuplicates();
        System.out.println("THIS IS WHAT I HAVE");

        return dao.all()
                .stream()
                .filter(e -> e.getQuantity() <= number)
                .collect(Collectors.toList());
    }

    /**
     * Returns expired products.
     *
     * @param expirationDate the expiration date.
     * @return expired products.
     */
    @Override
    public List<Product> getExpiredProducts(LocalDate expirationDate) {
        setProducts();
        sortProducts();
        findDuplicates();
        return products
                .stream()
                .filter(e -> expirationDate.isBefore(e.getExpiration()))
                .collect(Collectors.toList());
    }

    private void findDuplicates() {
        for(int i = 0; i < products.size() - 1; i++) {
            if(products.get(i).equals(products.get(i + 1))) {
                products.get(i).setQuantity(
                        products.get(i).getQuantity() +
                                products.get(i+1).getQuantity()
                );
                products.remove(i + 1);
                i--;
            }
        }
    }

    private void setProducts() {
        products = dao.all();
    }

    private void sortProducts() {
        products.sort(Comparator.comparing(Product::getName));
    }
}
