package com.saishaddai.personalchallenges;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamsTest {

    @Test
    void filterEvens() {
        Streams streams = new Streams();
        List<Integer> result = streams.filterEvens();
        List<Integer> expected = new ArrayList<>(Arrays.asList(-4, 8, 34, 344344, 0));
        assertEquals(expected, result);
    }
}