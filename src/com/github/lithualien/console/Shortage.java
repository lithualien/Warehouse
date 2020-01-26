package com.github.lithualien.console;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.product.Product;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Class to find lacking products.
 *
 * @author Tomas Dominauskas
 */
public class Shortage {
    /**
     * Class constructor to initialize methods.
     * @param amount Scanner used in Main method to take user input.
     */
    public Shortage(Scanner amount, Dao dao) {
        lackingProducts(amount, dao);
    }

    /**
     * Receives all lacking products in the warehouse.
     * @param amount Scanner used in Main method to take user input.
     */
    private void lackingProducts(Scanner amount, Dao dao) {
        System.out.println("Enter amount: ");
        try {
            if(amount.hasNextLine()) {
                printLackingProducts(dao.getLackingProducts(amount.nextInt()));
                System.out.println("");
            }
        } catch (InputMismatchException e) {
            System.out.println("Only numbers are allowed.");
        }
    }

    /**
     * Prints out the lacking products.
     * @param products the lacking products received from DaoImpl class.
     */
    private void printLackingProducts(List<Product> products) {
        if(products.isEmpty()) {
            System.out.println("Nothing was found.");
        } else {
            for(Product product : products) {
                System.out.println(product.toString());
            }
        }
    }
}
