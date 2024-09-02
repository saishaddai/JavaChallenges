package com.saishaddai.blackbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterChallengesTest {

    @Test
    @Tag("task:1")
    @DisplayName("filter an empty list must return an empty list")
    void filterAndProcessList_empty() {
        FilterChallenges ft = new FilterChallenges();
        var result  = ft.filterAndProcessList(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    @Tag("task:1")
    @DisplayName("filter a list with no even numbers must return an empty list")
    void filterAndProcessList_noEven() {
        FilterChallenges ft = new FilterChallenges();
        var numbers = List.of(1, 3, 5, 7, 9);
        var result  = ft.filterAndProcessList(numbers);
        assertTrue(result.isEmpty());
    }

    @Test
    @Tag("task:1")
    @DisplayName("filter an empty list must return an empty list")
    void filterAndProcessList() {
        FilterChallenges ft = new FilterChallenges();
        var numbers = List.of(1, 2, 3, 4, 5);
        var result  = ft.filterAndProcessList(numbers);
        assertFalse(result.isEmpty());
        assertEquals(4, result.get(0));
        assertEquals(8, result.get(1));
    }

    @Test
    @Tag("task:2")
    @DisplayName("calculate cart price for an empty list must return 0 (as double)")
    void calculateCartTotalCost_empty() {
        FilterChallenges ft = new FilterChallenges();
        var result  = ft.calculateCartTotalCost(List.of());
        assertEquals(0, result);
    }

    @Test
    @Tag("task:2")
    @DisplayName("calculate price where all products are free returns zero")
    void filterAndProcessList_Free() {
        FilterChallenges ft = new FilterChallenges();
        var cart = List.of(
                new Item("book", 0.0),
                new Item("pencil", 0.0)
        );
        var result  = ft.calculateCartTotalCost(cart);
        assertEquals(0, result);
    }

    @Test
    @Tag("task:2")
    @DisplayName("calculate price of valid cart returns the right sum")
    void filterAndProcessList_Valid() {
        FilterChallenges ft = new FilterChallenges();
        var cart = List.of(
                new Item("book", 13.45),
                new Item("pencil", 2.16),
                new Item("free sample", 0.0)
        );
        var result  = ft.calculateCartTotalCost(cart);
        assertEquals(15.61, result);
    }



}