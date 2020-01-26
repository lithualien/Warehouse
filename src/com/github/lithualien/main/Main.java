package com.github.lithualien.main;

import com.github.lithualien.console.Expiration;
import com.github.lithualien.console.Shortage;
import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;

import java.util.Scanner;

/**
 * Main class of the program.
 *
 * @author Tomas Dominauskas
 */
public class Main {

    private static Dao dao;
    /**
     * The main method of the program.
     * @param args not used.
     */
    public static void main(String[] args) {
        dao = new DaoImpl();
        test();
    }

    private static void test() {
        boolean loop = true;
        dao.setProducts("csv//sample.csv");
        while(loop) {
            Scanner input = new Scanner(System.in);
            System.out.print(
                    "1. Find lacking products.\n" +
                    "2. Find expired products.\n" +
                    "0. Exit the program.\n"
            );

            try {
                switch(Integer.parseInt(input.next())) {
                    case 1:
                        new Shortage(input, dao);
                        break;
                    case 2:
                        new Expiration(input, dao);
                        break;
                    case 0:
                        loop = false;
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
