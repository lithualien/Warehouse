package com.github.lithualien.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the Product class.
 *
 * @author Tomas Dominauskas
 */
class ProductTest {
    private Product product;
    private String result;

    @BeforeEach
    void setUp() {
        product = new Product("Orange", "322189", 25, "2019-05-23");
        result = "name='Orange', code='322189', quantity='25', expiration='2019-05-23'\n";
    }

    @AfterEach
    void tearDown() {
        product = null;
        result = null;
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
        assertEquals("2019-05-23", product.getExpiration());
    }

    @Test
    void testToString() {
        assertEquals(result, product.toString());
    }
}