package com.github.lithualien.console;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Class to search for a file by user input.
 *
 * @author Tomas Dominauskas
 */
public class FileSearcher {

    /**
     * Class constructor.
     */
    public FileSearcher() { }

    /**
     * Returns file directory path, if the file exists.
     * @param fileName Scanner used in Main class.
     * @return the file directory path.
     */
    public String inputFileName(Scanner fileName) {
        boolean loop = true;
        String output = null;
        System.out.print(
                "Enter file name without the extension.\n" +
                "0. To exit.\n"
        );

        while(loop) {
            String input = fileName.next();
            if(!input.equals("0"))
            {
                try {
                    String directory = "csv//", extension = ".csv";
                    new FileReader(directory + input + extension);
                    output = directory + input + extension;
                    loop = false;
                } catch (FileNotFoundException e) {
                    System.out.println("File does not exist.");
                }
            } else {
                output = null;
                loop = false;
            }
        }
        return output;
    }
}
