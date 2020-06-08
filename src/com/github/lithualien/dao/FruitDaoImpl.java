package com.github.lithualien.dao;

import com.github.lithualien.product.FruitProduct;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to transfer data.
 *
 * @author Tomas Dominauskas
 */
public class FruitDaoImpl implements FruitDao {

    private final String FILE_PATH = "csv/sample-original.csv";

    private List<FruitProduct> products;
    private final String COMMA_DELIMITER = ",";

    /**
     * Reads the csv file, sorts the list and removes duplicates.
     */
    @Override
    public List<FruitProduct> all() {
        try {
            products = new BufferedReader(new FileReader(FILE_PATH))
                    .lines()
                    .skip(1)
                    .map(e -> createProduct(e.split(COMMA_DELIMITER)))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }


    /**
     * Return the csv file line array as Product object.
     * @param product csv file line as array.
     * @return the Product object.
     */
    private FruitProduct createProduct(String[] product) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return new FruitProduct(
                product[0],
                Long.parseLong(product[1]),
                Float.parseFloat(product[2]),
                LocalDate.parse(product[3], formatter)
        );
    }
}
