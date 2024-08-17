package com.saishaddai.personalchallenges;

import com.saishaddai.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamsTest {

    @Test
    void test_filterEvens() {
        Streams streams = new Streams();
        List<Integer> result = streams.filterEvens();
        List<Integer> expected = new ArrayList<>(Arrays.asList(-4, 8, 34, 344344, 0));
        assertEquals(expected, result);
    }

    @Test
    void test_getMaxPrice() {
        List<Item> cart = new ArrayList<>(Arrays.asList(
                new Item("bread", 5.75),
                new Item("buns", 6.70),
                new Item("pencil", 1.89)
        ));
        Streams streams = new Streams();
        Double result = streams.getMaxPrice(cart);
        Double expected = 6.70;
        assertEquals(expected, result);
    }

    @Test
    void test_getMaxPrice_emptyCart() {
        List<Item> cart = new ArrayList<>();
        Streams streams = new Streams();
        Double result = streams.getMaxPrice(cart);
        Double expected = Streams.maxPrice;
        assertEquals(expected, result);
    }

    @Test
    void test_getMinPrice() {
        List<Item> cart = new ArrayList<>(Arrays.asList(
                new Item("bread", 5.75),
                new Item("buns", 6.70),
                new Item("pencil", 1.89)
        ));
        Streams streams = new Streams();
        Double result = streams.getMinPrice(cart);
        Double expected = 1.89;
        assertEquals(expected, result);
    }

    @Test
    void test_getMinPrice_emptyCart() {
        List<Item> cart = new ArrayList<>();
        Streams streams = new Streams();
        Double result = streams.getMinPrice(cart);
        Double expected = Streams.minPrice;
        assertEquals(expected, result);
    }


    @Test
    void test_getListWithoutMaxAndMinPrices() {
        List<Item> cart = new ArrayList<>(Arrays.asList(
                new Item("bread", 5.75),
                new Item("buns", 6.70),
                new Item("pencil", 1.89)
        ));
        Streams streams = new Streams();

        List<Item> result = streams.getListWithoutMaxAndMinPrices(cart);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(result.get(0).getName(), "bread");


    }


}