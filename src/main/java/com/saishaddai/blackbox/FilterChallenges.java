package com.saishaddai.blackbox;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterChallenges {

    /**
     * The following receives a list of integers, gets the even numbers and
     * multiplies by two
     * @param list a list of numbers
     * @return a list of even numbers multiplied by two
     */
    public List<Integer> filterAndProcessList(List<Integer> list) {
        return list.stream()
                .filter(item -> item % 2 == 0)
                .map(item -> item * 2)
                .collect(Collectors.toList());
    }

    /**
     * Task
     * Write a function calculateTotalCost that takes the cart list as an
     * argument and returns the total cost of all items in the cart using the reduce function.
     */
    public Double calculateCartTotalCost(List<Item> cart) {
        return cart.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }

    /**
     * Exercise: Find the longest word in a list of strings
     */
    public String findLongestWord(List<String> words) {
        return words.stream()
                .reduce((lastWord, currentWord) -> lastWord.length() > currentWord.length() ? lastWord : currentWord)
                .orElse("");

    }

    /**
     * Exercise: calculate the factorial of a number using reduce
     */
    public int calculateFactorial(int position) {
        if(position == 0) return 1;
        List<Integer> list = IntStream.rangeClosed(1, position)
                .boxed()
                .collect(Collectors.toList());

        Optional<Integer> result = list.stream()
                .reduce((a,b) -> a * b);

        return result.orElse(0);
    }

    private static final String VOWELS = "aeiou";
    /**
     * Remove Vowels of any given string
     */
    public String removeVowels(String input) {
        return input.chars()
                .filter(character -> !VOWELS.contains(String.valueOf((char) character).toLowerCase()))
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**
     * sum even numbers from a list of integers
     */
    public int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::valueOf)
                .sum();
    }


    /**
     * Copy from Kotlin Challenges
     * Write a Java function that takes a map of strings to integers as an
     * input and returns a new map with only the entries where the value is
     * greater than 10.
     * Input: {"a" to 5, "b" to 15, "c" to 20, "d" to 5}
     * Output: {"b" to 15, "c" to 20}
     */
    public Map<String, Integer> filterMap(Map<String, Integer> input) {
        return input.keySet()
                .stream()
                .filter(key -> input.get(key) > 10)
                .collect(Collectors.toMap(String::valueOf, input::get));

    }

    public int getMin(Map<String, List<Integer>> input) {
        return  input.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList())
                .stream()
                .min(Integer::compareTo)
                .orElse(0);
    }


}
