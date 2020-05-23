package com.github.lithualien.console;

import com.github.lithualien.product.Product;
import com.github.lithualien.services.ProductService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Class to find lacking products.
 *
 * @author Tomas Dominauskas
 */
public class ProductShortageOutput implements Output {

    private final ProductService productService;
    private final Scanner scanner;

    public ProductShortageOutput(ProductService productService, Scanner scanner) {
        this.scanner = scanner;
        this.productService = productService;
    }

    @Override
    public void getOutput() {
        try {
            if(scanner.hasNextLine()) {
                printLackingProducts(productService.getLackingProducts(scanner.nextInt()));
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
