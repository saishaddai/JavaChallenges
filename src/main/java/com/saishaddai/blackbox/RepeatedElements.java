package com.saishaddai.blackbox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Challenge:
 * Write a function findFirstDuplicate that takes a list of integers as
 * input and returns the first duplicate element in the list.
 * If no duplicates are found, return -1.
 * Example:
 * Input: [2, 1, 3, 5, 3, 2] Output: 3
 * Input: [1, 2, 3, 4, 5] Output: -1
 * Constraints:
 * The input list may contain up to 10,000 elements.
 * The elements in the list are integers between 1 and 10,000 (inclusive).
 */
public class RepeatedElements {

    public int findFirstDuplicate(List<Integer> numbers) {
        Map<Integer, Boolean> seenNumbers = new HashMap<>();
        if(null == numbers) return -1;
        for(int number: numbers) {
            if(seenNumbers.get(number) == null) {
                seenNumbers.put(number, true);
            } else {
                return number;
            }
        }
        return -1;
    }

    public int findFirstDuplicate2(List<Integer> numbers) {
        if (numbers == null) return -1;
        AtomicInteger currentRepeated = new AtomicInteger(-1);
        AtomicBoolean shouldContinue = new AtomicBoolean(true);
        Map<Integer, Boolean> seenNumbers = new HashMap<>();
        numbers.forEach(number-> {
            if(seenNumbers.get(number) == null) {
                seenNumbers.put(number, true);
            } else {
                if (shouldContinue.get()) {
                    currentRepeated.set(number);
                    shouldContinue.set(false);
                }
            }
        });
        return currentRepeated.get();
    }
}
