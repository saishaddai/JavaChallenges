package com.saishaddai.blackbox;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
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

    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    /**
     * Remove Vowels of any given string
     */
    public String removeVowels(String input) throws NullPointerException {
        if (input == null) throw new NullPointerException();
        return input.chars()
                .mapToObj(c -> (char) c) // cast to char
                .filter(character -> !VOWELS.contains(character))
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
                .min(Integer::compareTo)
                .orElse(0);
    }

    /**
     * Challenge: Write a function isValidParentheses that takes a
     * string of parentheses as input and returns true if the parentheses are balanced and false otherwise.
     * Constraints:
     * The input string only contains parentheses characters ( and ).
     * The input string is not null or empty.
     */
    public boolean isValidParentheses(String input) {
        AtomicInteger count = new AtomicInteger(0);
        AtomicBoolean isOpenParentheses = new AtomicBoolean();
        input.chars().forEach(character -> {
            switch ((char) character) {
                case '(':
                    count.addAndGet(1);
                    isOpenParentheses.getAndSet(true);
                    break;
                case ')':
                    if (count.get() == 0) {
                        isOpenParentheses.getAndSet(false);
                    } else {
                        count.addAndGet(-1);
                    }
                    break;
                default:
                    break;
            }
        });
        return isOpenParentheses.get() && count.get() == 0;
    }


}
