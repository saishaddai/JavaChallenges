package com.saishaddai.blackbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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


    @Test
    @Tag("task:3")
    @DisplayName("find Longest Word of an empty list must return an empty string")
    void findLongestWord_emptyList() {
        FilterChallenges ft = new FilterChallenges();
        List<String> words = List.of();
        var result = ft.findLongestWord(words);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @Tag("task:3")
    @DisplayName("find Longest Word of a valid list must return longest string")
    void findLongestWord_Valid() {
        FilterChallenges ft = new FilterChallenges();
        String expected = "lost+found";
        var words = List.of("word", "place", expected, "always" );
        var result = ft.findLongestWord(words);
        assertEquals(expected, result);
    }


    @Test
    @Tag("task:4")
    @DisplayName("calculate factorial of zero return 1")
    void calculateFactorial_zeroAsInput() {
        FilterChallenges ft = new FilterChallenges();
        var result = ft.calculateFactorial(0);
        assertEquals(1, result);
    }

    @Test
    @Tag("task:4")
    @DisplayName("calculate factorial of a couple of numbers")
    void calculateFactorial_Valid() {
        FilterChallenges ft = new FilterChallenges();
        var result = ft.calculateFactorial(5);
        assertEquals(120, result);
    }


    @Test
    @Tag("task:5")
    @DisplayName("removeVowels from an empty string must return empty string")
    void removeVowels_Empty() {
        FilterChallenges ft = new FilterChallenges();
        var result = ft.removeVowels("");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @Tag("task:5")
    @DisplayName("removeVowels from an string with no vowels must return input")
    void removeVowels_NoVowels() {
        FilterChallenges ft = new FilterChallenges();
        var input = "sdfghjk";
        var result = ft.removeVowels(input);
        assertNotNull(result);
        assertEquals(input, result);
    }

    @Test
    @Tag("task:5")
    @DisplayName("removeVowels from a valid string must return string without vowels")
    void removeVowels_valid() {
        FilterChallenges ft = new FilterChallenges();
        var input = "Elvis Presley LivEs";
        var result = ft.removeVowels(input);
        assertNotNull(result);
        assertEquals("lvs Prsly Lvs", result);
    }


    @Test
    @Tag("task:6")
    @DisplayName("sumEvenNumbers from an empty list must return zero")
    void sumEvenNumbers_emptyList() {
        FilterChallenges ft = new FilterChallenges();
        List<Integer> input = List.of();
        var result = ft.sumEvenNumbers(input);
        assertEquals(0, result);
    }

    @Test
    @Tag("task:6")
    @DisplayName("sumEvenNumbers from a list with no even numbers must return zero")
    void sumEvenNumbers_noEvens() {
        FilterChallenges ft = new FilterChallenges();
        List<Integer> input = List.of(1, 3, 5, 7, 9);
        var result = ft.sumEvenNumbers(input);
        assertEquals(0, result);
    }

    @Test
    @Tag("task:6")
    @DisplayName("sumEvenNumbers from a valid list must return the right sum")
    void sumEvenNumbers_valid() {
        FilterChallenges ft = new FilterChallenges();
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var result = ft.sumEvenNumbers(input);
        assertEquals(20, result);
    }



    @Test
    @Tag("task:7")
    @DisplayName("filter an empty map returns empty map")
    void filterMap_empty() {
        FilterChallenges ft = new FilterChallenges();
        var result  = ft.filterMap(Map.of());
        assertNotNull(result);
        assertEquals(Map.of(), result);
    }

    @Test
    @Tag("task:7")
    @DisplayName("filter map with nothing to filter returns empty map")
    void filterMap_noFilter() {
        FilterChallenges ft = new FilterChallenges();
        var input = Map.of(
                "dog", 3,
                "really", 6,
                "another", 9
        );
        var result = ft.filterMap(input);
        assertEquals(Map.of(), result);
    }

    @Test
    @Tag("task:7")
    @DisplayName("filter Map with valid and filterable map return filtered map")
    void filterMap_valid() {
        var ft = new FilterChallenges();
        var validKey1 = "KEY1";
        var validKey2 = "KEY2";
        var input = Map.of(
                "dog", 5,
                validKey1, 18,
                "really", 6,
                validKey2, 11,
                "another", 9
        );
        var result= ft.filterMap(input);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.containsKey(validKey1));
        assertTrue(result.containsKey(validKey2));

    }

}