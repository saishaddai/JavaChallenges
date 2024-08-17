package com.saishaddai.personalchallenges;

import com.saishaddai.Item;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {

    public static final Double maxPrice = 1000.0;
    public static final Double minPrice = 0.0;

    private final List<Integer> numbers;
    public Streams() {
        numbers = new ArrayList<>(Arrays.asList(1, 87, -4, 7, 8, 34, 344344, -3, 0, -333));
    }

    public List<Integer> filterEvens() {
        return numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

    }


    public Double getMaxPrice(List<Item> cart) {
        Optional<Item> result = cart.stream()
                .max(Comparator.comparingDouble(Item::getPrice));
        if (result.isPresent()) {
            return result.get().getPrice();
        }
        return maxPrice;
    }

    public Double getMinPrice(List<Item> cart) {
        Optional<Item> result = cart.stream()
                .min(Comparator.comparingDouble(Item::getPrice));
        if (result.isPresent()) {
            return result.get().getPrice();
        }
        return minPrice;
    }

    public List<Item> getListWithoutMaxAndMinPrices(List<Item> cart) {
        Double maxPrice = getMaxPrice(cart);
        Double minPrice = getMinPrice(cart);

        return cart.stream()
                .filter(item -> !Objects.equals(item.getPrice(), maxPrice))
                .filter(item -> !Objects.equals(item.getPrice(), minPrice))
                .collect(Collectors.toList());

    }

}
