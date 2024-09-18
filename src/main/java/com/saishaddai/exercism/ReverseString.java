package com.saishaddai.exercism;

import java.util.concurrent.atomic.AtomicInteger;

public class ReverseString {

    String reverse(String input) {
        final char[] reversedArray = new char[input.length()];
        AtomicInteger index = new AtomicInteger(input.length() - 1);
        input.chars()
                .forEach( c -> {
                    var position = index.get();
                    reversedArray[position] = (char) c;
                    index.set(position - 1);
                });

        return new String(reversedArray);
    }

    public String reverseNoLambda(String input) {
        char[] reversedArray = new char[input.length()];
        int index = input.length() - 1;
        for (char c : input.toCharArray()) {
            reversedArray[index--] = c;
        }
        return new String(reversedArray);
    }


}
