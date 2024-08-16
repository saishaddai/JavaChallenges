package com.saishaddai.personalchallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

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
}
