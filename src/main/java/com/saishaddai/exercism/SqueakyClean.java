package com.saishaddai.exercism;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SqueakyClean {

    static String clean(String identifier) {
        if (identifier.isEmpty()) {
            return "";
        } else {
            return sanitize(task1And2(kebabToCamel2(identifier)));
        }
    }

    private static String task1And2(String identifier) {
        return identifier.chars()
                .map(c -> c == ' ' ? '_' : (char) c)//task 1
                .map(c -> c == '0' ? 'o' : c == '1' ? 'l' : c == '3' ? 'e' : c == '4' ? 'a' : c == '7' ? 't' : (char) c)//task 3
                .filter(c -> !notLetters.contains(c))//task 4
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }


    static String kebabToCamel2(String kebabString) {
        int startPosition = kebabString.indexOf("-");
        if (startPosition < 0)
            return kebabString;
        int nextWordPosition = startPosition + 1;
        StringBuilder sb = new StringBuilder(kebabString);
        String updateString = (sb.charAt(nextWordPosition)+"").toUpperCase();
        sb.replace(startPosition, nextWordPosition + 1, updateString);
        return sb.toString();
    }

    private static String sanitize(String string) {
        return string.replaceAll("[^a-zA-Z_]", "");
    }

    static List<Character> notLetters = Arrays.asList('$', '#', '.', '¡', '!');
}
