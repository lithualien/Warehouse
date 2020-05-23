package com.github.lithualien.console;

import com.github.lithualien.product.Product;
import com.github.lithualien.services.ProductService;

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
public class ExpiredProductOutput implements Output {

    private final ProductService productService;
    private final Scanner scanner;

    public ExpiredProductOutput(ProductService productService, Scanner scanner) {
        this.productService = productService;
        this.scanner = scanner;
    }

    @Override
    public void getOutput() {
        System.out.println("Enter a date:");
        try {
            if(scanner.hasNextLine()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate inputDate = LocalDate.parse(scanner.next(), formatter);
                printExpiredFood(productService.getExpiredProducts(inputDate));
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
