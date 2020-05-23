package com.github.lithualien.main;

import com.github.lithualien.console.ExpiredProductOutput;
import com.github.lithualien.console.Output;
import com.github.lithualien.console.ProductShortageOutput;
import com.github.lithualien.dao.DaoImpl;
import com.github.lithualien.services.ProductService;
import com.github.lithualien.services.ProductServiceImpl;

import java.util.Scanner;

/**
 * Main class of the program.
 *
 * @author Tomas Dominauskas
 */
public class Main {
    private static Scanner input;

    /**
     * The main method of the program.
     * @param args not used.
     */
    public static void main(String[] args) {
        boolean loopStatement = true;
        ProductService productService = new ProductServiceImpl(new DaoImpl());
        Output output;
        while(loopStatement) {
            input = new Scanner(System.in);
            System.out.print(
                    "1. Find lacking products.\n" +
                            "2. Find expired products.\n" +
                            "0. Exit the program.\n"
            );

            try {
                switch(Integer.parseInt(input.next())) {
                    case 1:
                        output = new ProductShortageOutput(productService, input);
                        output.getOutput();
                        break;
                    case 2:
                        output = new ExpiredProductOutput(productService, input);
                        output.getOutput();
                        break;
                    case 0:
                        loopStatement = false;
                        break;
                    default:
                        System.out.println("Please enter a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Only numbers are allowed.");
            }
        }
    }
}
