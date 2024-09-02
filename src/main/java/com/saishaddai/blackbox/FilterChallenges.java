package com.saishaddai.blackbox;

import java.util.List;
import java.util.stream.Collectors;

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


}
