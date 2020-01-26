package com.github.lithualien.main;

import com.github.lithualien.console.Expiration;
import com.github.lithualien.console.FileSearcher;
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
    private static Scanner input;

    /**
     * The main method of the program.
     * @param args not used.
     */
    public static void main(String[] args) {
        enterFile();
    }

    /**
     * Communication with user, allowing to communicate with console and get data.
     * @param fileName the directory of the file.
     */
    private static void options(String fileName) {
        boolean loop = true;
        Dao dao = new DaoImpl();
        dao.setProducts(fileName);
        while(loop) {
            input = new Scanner(System.in);
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

    /**
     * Searches for a user inputted file name.
     */
    private static void enterFile() {
        FileSearcher fileSearcher = new FileSearcher();
        input = new Scanner(System.in);
        String fileLocation = fileSearcher.inputFileName(input);
        if(fileLocation!= null) {
            options(fileLocation);
        }
    }
}
