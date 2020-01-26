package com.github.lithualien.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the Product class.
 *
 * @author Tomas Dominauskas
 */
class ProductTest {
    private Product product, product1;
    private String result;
    private LocalDate date, date2;
    DateTimeFormatter formatter;

    @BeforeEach
    void setUp() {
        // Dates
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = LocalDate.parse("2019-05-23", formatter);
        date2 = LocalDate.parse("2020-01-15", formatter);

        // Products
        product = new Product("Orange", "322189", 25, date);
        product1 = new Product();

        // Strings
        result = "name='Orange', code='322189', quantity='25', expiration='2019-05-23'";
    }

    @AfterEach
    void tearDown() {
        product = null;
        product1 = null;
        result = null;
        formatter = null;
        date = null;
    }

    @Test
    void getName() {
        assertEquals("Orange", product.getName());
    }

    @Test
    void getCode() {
        assertEquals("322189", product.getCode());
    }

    @Test
    void getExpiration() {
        assertEquals(25, product.getQuantity());
    }

    @Test
    void getQuantity() {
        assertEquals(date, product.getExpiration());
    }

    @Test
    void testToString() {
        assertEquals(result, product.toString());
    }

    @Test
    void setName() {
        product1.setName("Apple");
        assertEquals("Apple", product1.getName());
    }

    @Test
    void setCode() {
        product1.setCode("43e231");
        assertEquals("43e231", product1.getCode());
    }

    @Test
    void setQuantity() {
        product1.setQuantity(44);
        assertEquals(44, product1.getQuantity());
    }

    @Test
    void setExpiration() {
        product1.setExpiration(date2);
        assertEquals(date2, product1.getExpiration());
    }
}