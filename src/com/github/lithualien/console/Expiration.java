package com.github.lithualien.console;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.product.Product;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/**
 * Class to find expired food by given date.
 *
 * @author Tomas Dominauskas
 */
public class Expiration {

    /**
     * Class constructor to initialize methods.
     * @param date Scanner used in Main class to take user input.
     */
    public Expiration(Scanner date, Dao dao) {
        expiredProducts(date, dao);
    }

    /**
     * Receives expired food in the console.
     * @param date Scanner used in Main class to take user input.
     */
    private void expiredProducts(Scanner date, Dao dao) {
        System.out.println("Enter a date:");
        try {
            if(date.hasNextLine()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate inputDate = LocalDate.parse(date.next(), formatter);
                printExpiredFood(dao.getExpiredProducts(inputDate));
                System.out.println("");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd, e.g. 2020-01-01");
        } catch (NullPointerException e) {
            System.out.println("Nothing was found.");
        }
    }

    /**
     * Prints out the expired foods.
     * @param products the expired food received from DaoImpl class.
     */
    private void printExpiredFood(List<Product> products) {
        if(products.isEmpty()) {
            System.out.println("Nothing was found.");
        } else {
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
    }
}
