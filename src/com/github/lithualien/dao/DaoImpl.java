package com.github.lithualien.dao;

import com.github.lithualien.product.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class to transfer data.
 *
 * @author Tomas Dominauskas
 */
public class DaoImpl implements Dao {
    private List<Product> products;
    private final String COMMA_DELIMITER = ",";

    /**
     * Read the csv file contents.
     * @param fileLocation the location of CSV file.
     */
    private void readCsvFile(String fileLocation) {
        try {
            products = new BufferedReader(new FileReader(fileLocation))
                    .lines()
                    .skip(1)
                    .map(e -> getProduct(e.split(COMMA_DELIMITER)))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }
    }

    /**
     * Return the csv file line array as Product object.
     * @param product csv file line as array.
     * @return the Product object.
     */
    private Product getProduct(String[] product) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return new Product(
                product[0],
                product[1],
                Integer.parseInt(product[2]),
                LocalDate.parse(product[3], formatter)
        );
    }

    /**
     * Sorts the products list by name ascending order.
     */
    private void sortProductsList() {
        products.sort(Comparator.comparing(Product::getName));
    }

    /**
     * Removes all the duplicated products in the list.
     */
    private void removeDuplicates() {
        products.removeAll((findDuplicates()));
    }

    /**
     * Finds the duplicated products, adds the quantity of the duplicated products.
     * Returns all the duplicated products as list.
     * @return all the duplicated products.
     */
    private List<Product> findDuplicates() {
        int index = 1;
        List<Product> duplicateIndexes = new ArrayList<>();
        for(Product product : products) {
            for(int i = index; i < products.size(); i++) {
                if(!product.getName().equals(products.get(i).getName())) {
                    break;
                }

                if(!product.getCode().equals(products.get(i).getCode())) {
                    continue;
                }

                if(!product.getExpiration().equals(products.get(i).getExpiration())) {
                    continue;
                }

                product.setQuantity(product.getQuantity() + products.get(i).getQuantity());
                duplicateIndexes.add(products.get(i));
            }
            index++;
        }
        return duplicateIndexes;
    }

    /**
     * Reads the csv file, sorts the list and removes duplicates.
     * @param fileLocation the location of the csv file.
     */
    public void setProducts(String fileLocation) {
        readCsvFile(fileLocation);
        sortProductsList();
        removeDuplicates();
    }

    /**
     * Returns the products of shortage.
     * @param number the minimum number of products.
     * @return products of shortage.
     */
    public List<Product> getLackingProducts(int number) {
        return products.stream()
                .map(e -> findLackingProduct(e, number))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Finds if the warehouse is lacking of the product.
     * @param product the product to check.
     * @param number the minimum number of products in the warehouse.
     * @return the lacking product.
     */
    private Product findLackingProduct(Product product, int number) {
        if(product.getQuantity() > number) {
            return null;
        }
        return new Product(
                product.getName(),
                product.getCode(),
                product.getQuantity(),
                product.getExpiration()
        );
    }

    /**
     * Returns expired products.
     * @param expirationDate the expiration date.
     * @return expired products.
     */
    public List<Product> getExpiredProducts(LocalDate expirationDate) {
        return products.stream()
                .map(e -> findExpiredProduct(e, expirationDate))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param product the product to check.
     * @param expirationDate the date of product expiration.
     * @return the expired product.
     */
    private Product findExpiredProduct(Product product, LocalDate expirationDate) {
        if(expirationDate.isBefore(product.getExpiration())) {
            return null;
        }

        return new Product(
                product.getName(),
                product.getCode(),
                product.getQuantity(),
                product.getExpiration()
        );
    }
}
