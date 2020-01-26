package com.github.lithualien.dao;

import com.github.lithualien.product.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the DaoImpl class.
 *
 * @author Tomas Dominauskas
 */
class DaoImplTest {
    private Dao daoImpl, daoImpl2;
    private String fileLocationGood, fileLocationBad, fileLocationAllSame;
    private Product product1, product2, productAllSame;
    private LocalDate date1, date2, date3;

    @BeforeEach
    void setUp() {
        // Strings
        fileLocationGood = "csv//sample.csv";
        fileLocationBad = "csv//badsample.csv";
        fileLocationAllSame = "csv//sample-all-same.csv";

        // DaoImpl objects
        daoImpl = new DaoImpl();
        daoImpl2 = new DaoImpl();

        // DaoImpl setting values
        daoImpl.setProducts(fileLocationGood);
        daoImpl2.setProducts(fileLocationAllSame);

        // Dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date1 = LocalDate.parse("2018-07-12", formatter);
        date2 = LocalDate.parse("2019-07-03", formatter);
        date3 = LocalDate.parse("2019-12-04", formatter);

        // Products
        product1 = new Product("Oranges", "456987", 4, date3);
        product2 = new Product("Tomatoes", "659879897646897456", 164, date1);
        productAllSame = new Product("Apples", "5649", 39, date2);
    }

    @AfterEach
    void tearDown() {
        fileLocationBad = null;
        fileLocationGood = null;
        fileLocationAllSame = null;

        daoImpl = null;
        daoImpl2 = null;

        date1 = null;
        date2 = null;
        date3 = null;

        product1 = null;
        product2 = null;
        productAllSame = null;
    }

    @Test
    void setProductsExceptionHandling() {
        assertDoesNotThrow(() -> {
           daoImpl.setProducts(fileLocationBad);
        });
    }

    @Test
    void getLackingProducts() {
        assertEquals(product1.toString(), daoImpl.getLackingProducts(11).get(1).toString());
    }

    @Test
    void getExpiredProducts() {
        assertEquals(product2.toString(), daoImpl.getExpiredProducts(date1).get(4).toString());
    }

    @Test
    void getExpiredProductsWithAllSame() {
        assertEquals(productAllSame.toString(), daoImpl2.getExpiredProducts(date2).get(0).toString());
    }
}